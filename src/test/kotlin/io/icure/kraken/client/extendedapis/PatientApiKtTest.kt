package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.DeviceApi
import io.icure.kraken.client.apis.HealthcarePartyApi
import io.icure.kraken.client.apis.MaintenanceTaskApi
import io.icure.kraken.client.apis.PatientApi
import io.icure.kraken.client.apis.UserApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils
import io.icure.kraken.client.crypto.LocalCrypto
import io.icure.kraken.client.crypto.patientCryptoConfig
import io.icure.kraken.client.crypto.publicKeyAsString
import io.icure.kraken.client.crypto.toPrivateKey
import io.icure.kraken.client.crypto.toPublicKey
import io.icure.kraken.client.extendedapis.infrastructure.ExtendedTestUtils
import io.icure.kraken.client.extendedapis.mapper.PatientMapperFactory
import io.icure.kraken.client.infrastructure.ApiClient
import org.taktik.icure.services.external.rest.v2.dto.HealthcarePartyDto
import io.icure.kraken.client.models.decrypted.PatientDto
import io.icure.kraken.client.security.BasicAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.taktik.icure.constants.Users
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import org.taktik.icure.services.external.rest.v2.dto.security.AuthenticationTokenDto
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.time.Instant
import java.util.*

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
internal class PatientApiKtTest {
    private val iCureBackendUrl = System.getenv("ICURE_BE_URL") ?: "https://kraken.icure.dev"
    
    private val parentAuthorization = BasicAuthProvider(System.getenv("PARENT_HCP_USERNAME"), System.getenv("PARENT_HCP_PASSWORD"))
    private val child1Authorization = BasicAuthProvider(System.getenv("CHILD_1_HCP_USERNAME"), System.getenv("CHILD_1_HCP_PASSWORD"))
    private val child2Authorization = BasicAuthProvider(System.getenv("CHILD_2_HCP_USERNAME"), System.getenv("CHILD_2_HCP_PASSWORD"))
    
    private val parentPrivKey = System.getenv("PARENT_HCP_PRIV_KEY").toPrivateKey()
    private val child1PrivKey = System.getenv("CHILD_1_HCP_PRIV_KEY").toPrivateKey()
    private val child2PrivKey = System.getenv("CHILD_2_HCP_PRIV_KEY").toPrivateKey()

    private val userApi = UserApi(basePath = iCureBackendUrl, authProvider = parentAuthorization)
    private val hcpartyApi = HealthcarePartyApi(basePath = iCureBackendUrl, authProvider = parentAuthorization)
    private val patientApi = PatientApi(basePath = iCureBackendUrl, authProvider = parentAuthorization)
    private val maintenanceTaskApi = MaintenanceTaskApi(basePath = iCureBackendUrl, authProvider = parentAuthorization)

    private val child1UserApi = UserApi(basePath = iCureBackendUrl, authProvider = child1Authorization)
    private val child1HealthcarePartyApi = HealthcarePartyApi(basePath = iCureBackendUrl, authProvider = child1Authorization)
    private val child1DeviceApi = DeviceApi(basePath = iCureBackendUrl, authProvider = child1Authorization)
    private val child1PatientApi = PatientApi(basePath = iCureBackendUrl, authProvider = child1Authorization)

    private val child2UserApi = UserApi(basePath = iCureBackendUrl, authProvider = child2Authorization)
    private val child2HealthcarePartyApi = HealthcarePartyApi(basePath = iCureBackendUrl, authProvider = child2Authorization)
    private val child2DeviceApi = DeviceApi(basePath = iCureBackendUrl, authProvider = child2Authorization)
    private val child2PatientApi = PatientApi(basePath = iCureBackendUrl, authProvider = child2Authorization)

    @org.junit.jupiter.api.Test
    @FlowPreview
    @ExperimentalUnsignedTypes
    fun createPatientWithCustomCryptoConfig() = runBlocking {
        // Before
        val user = userApi.getCurrentUser()
        val hcp = hcpartyApi.getCurrentHealthcareParty()
        val cc = customPatientCryptoConfig(ExtendedTestUtils.localCrypto(iCureBackendUrl,
            parentAuthorization, parentPrivKey, user, hcp.toDataOwner()))

        // When
        val p1 = try { patientApi.createPatient(user, PatientDto(id = UUID.randomUUID().toString(), firstName = "John", lastName = "Doe", note = "To be encrypted"), cc) } catch(e:Exception) { throw IllegalStateException(e) }

        // Then
        Assertions.assertNotNull(p1, "Patient should not be null")
        Assertions.assertEquals(p1.lastName, "Doe", "Patient name should not be null")
        Assertions.assertEquals(p1.firstName, "John", "Patient firstName should not be null")

        val encryptedP1 = patientApi.getPatient(p1.id)
        Assertions.assertNull(encryptedP1.lastName, "Patient lastName should be null in db")
        Assertions.assertNull(encryptedP1.firstName, "Patient firstName should be null in db")
        Assertions.assertNotNull(encryptedP1.encryptionKeys, "Patient encryptionKeys should be not null in db")
        Assertions.assertNotNull(encryptedP1.encryptedSelf, "Patient encryptedSelf should be not null in db")

        val p2 = try { patientApi.getPatient(user, p1.id, cc) } catch(e:Exception) { throw IllegalStateException(e) }
        Assertions.assertEquals(p2.note, "To be encrypted")
        Assertions.assertEquals(p2.firstName, "John")
        Assertions.assertEquals(p2.lastName, "Doe")
    }
    @FlowPreview
    @org.junit.jupiter.api.Test
    @ExperimentalUnsignedTypes
    fun createPatientWithDefaultCryptoConfig() = runBlocking {
        // Before
        val user = userApi.getCurrentUser()
        val hcp = hcpartyApi.getCurrentHealthcareParty()

        val cc = patientCryptoConfig(ExtendedTestUtils.localCrypto(iCureBackendUrl,
            parentAuthorization, parentPrivKey, user, hcp.toDataOwner()))

        // When
        val p1 = try { patientApi.createPatient(user, PatientDto(id = UUID.randomUUID().toString(), firstName = "John", lastName = "Doe", note = "To be encrypted"), cc) } catch(e:Exception) { throw IllegalStateException(e) }

        // Then
        Assertions.assertNotNull(p1, "Patient should not be null")
        Assertions.assertEquals(p1.note, "To be encrypted", "Patient note should not be null")
        Assertions.assertNull(patientApi.getPatient(p1.id).note, "Patient note should be null in db")

        val p2 = try { patientApi.getPatient(user, p1.id, cc) } catch(e:Exception) { throw IllegalStateException(e) }
        Assertions.assertEquals(p2.note, "To be encrypted")
        Assertions.assertEquals(p2.firstName, "John")
        Assertions.assertEquals(p2.lastName, "Doe")
    }


    @FlowPreview
    @org.junit.jupiter.api.Test
    @ExperimentalUnsignedTypes
    fun createPatientWithDefaultCryptoConfigHcpWithParent() = runBlocking {
        val parent = userApi.getCurrentUser()
        val parentHcp = hcpartyApi.getCurrentHealthcareParty()

        // Before
        val user1 = child1UserApi.getCurrentUser()
        val hcp1 = child1HealthcarePartyApi.getCurrentHealthcareParty()

        val user2 = child2UserApi.getCurrentUser()
        val hcp2 = child2HealthcarePartyApi.getCurrentHealthcareParty()

        Assertions.assertNotNull(hcp1.parentId, "Hcp must have a parent for this test")
        Assertions.assertNotNull(hcp2.parentId, "Hcp must have a parent for this test")
        
        val cc1 = patientCryptoConfig(LocalCrypto(
            DataOwnerResolver(child1HealthcarePartyApi, child1PatientApi, child1DeviceApi), mapOf(
                parent.healthcarePartyId!! to listOf(parentPrivKey to parentHcp.publicKey!!.toPublicKey()),
                user1.healthcarePartyId!! to listOf(child1PrivKey to hcp1.publicKey!!.toPublicKey())
            )
        ))

        val cc2 = patientCryptoConfig(LocalCrypto(
            DataOwnerResolver(child2HealthcarePartyApi, child2PatientApi, child2DeviceApi), mapOf(
                parent.healthcarePartyId!! to listOf(parentPrivKey to parentHcp.publicKey!!.toPublicKey()),
                user2.healthcarePartyId!! to listOf(child2PrivKey to hcp2.publicKey!!.toPublicKey())
            )
        ))

        // When
        val p1 = try { child1PatientApi.createPatient(user1, PatientDto(id = UUID.randomUUID().toString(), firstName = "John", lastName = "Doe", note = "To be encrypted"), cc1) } catch(e:Exception) { throw IllegalStateException(e) }
        val p2 = try { child2PatientApi.getPatient(user2, p1.id, cc2) } catch(e:Exception) { throw IllegalStateException(e) }

        // Then
        Assertions.assertNotNull(p1, "Patient should not be null")
        Assertions.assertEquals(p1.note, p2.note)
    }

    @ExperimentalUnsignedTypes
    @FlowPreview
    @org.junit.jupiter.api.Test
    fun createPatientWithNewHcpHavingMultipleKeys() = runBlocking {
        // Before
        val parentUser = userApi.getCurrentUser()
        val parent = hcpartyApi.getCurrentHealthcareParty()
        val parentLocalCrypto = LocalCrypto(
            ExtendedTestUtils.dataOwnerWrapperFor(iCureBackendUrl, parentAuthorization), mapOf(
                parent.id to listOf(parentPrivKey to parent.publicKey!!.toPublicKey()),
            ),
            maintenanceTaskApi
        )

        val newHcpKp1 = CryptoUtils.generateKeyPairRSA()
        val newHcpKp2 = CryptoUtils.generateKeyPairRSA()
        val newHcp = hcpartyApi.createHealthcareParty(
            HealthcarePartyDto(
                id = UUID.randomUUID().toString(),
                firstName = "Jimmy",
                lastName = "Materazzi",
                parentId = parent.id
            )
                .initHcParty()
                .addNewKeyPair(parentUser, parentLocalCrypto, newHcpKp1.public)
                .addNewKeyPair(parentUser, parentLocalCrypto, newHcpKp2.public, newHcpKp2.private)
        )
        val newUser = userApi.createUser(
            UserDto(
                id = UUID.randomUUID().toString(),
                login = "jimmy-${System.currentTimeMillis()}",
                type = Users.Type.database,
                status = Users.Status.ACTIVE,
                name = "${newHcp.firstName} ${newHcp.lastName}",
                authenticationTokens = mapOf("test" to AuthenticationTokenDto("test", Instant.now().toEpochMilli(), 24 * 3600 * 365)),
                healthcarePartyId = newHcp.id,
                autoDelegations = mapOf(DelegationTagDto.all to setOf(parent.id))
            )
        )

        delay(3000) // User not active yet when trying to create data afterwards

        val newUserPatientApi = PatientApi(basePath = iCureBackendUrl, authProvider = BasicAuthProvider(newUser.login!!, "test"))
        val newUserHcpApi = HealthcarePartyApi(basePath = iCureBackendUrl, authProvider =BasicAuthProvider(newUser.login!!, "test"))
        val cc1 = patientCryptoConfig(LocalCrypto(
            ExtendedTestUtils.dataOwnerWrapperFor(
                iCureBackendUrl,
                BasicAuthProvider(newUser.login!!, "test")
            ), mapOf(
                parent.id to listOf(parentPrivKey to parent.publicKey!!.toPublicKey()),
                newUser.dataOwnerId() to listOf(newHcpKp1.private as RSAPrivateKey to newHcpKp1.public as RSAPublicKey)
            )
        ))
        val cc2 = patientCryptoConfig(LocalCrypto(
            ExtendedTestUtils.dataOwnerWrapperFor(
                iCureBackendUrl,
                BasicAuthProvider(newUser.login!!, "test")
            ), mapOf(
                parent.id to listOf(parentPrivKey to parent.publicKey!!.toPublicKey()),
                newUser.dataOwnerId() to listOf(newHcpKp2.private as RSAPrivateKey to newHcpKp2.public as RSAPublicKey)
            )
        ))

        // When
        val p1 = try { newUserPatientApi.createPatient(newUser, PatientDto(id = UUID.randomUUID().toString(), firstName = "John", lastName = "Doe", note = "To be encrypted"), cc1) } catch(e:Exception) { throw IllegalStateException(e) }

        // Then
        Assertions.assertNotNull(p1, "Patient should not be null")
        Assertions.assertEquals(p1.note, "To be encrypted", "Patient note should not be null")
        Assertions.assertNull(newUserPatientApi.getPatient(p1.id).note, "Patient note should be null in db")

        val p2 = try { newUserPatientApi.getPatient(newUser, p1.id, cc2) } catch(e:Exception) { throw IllegalStateException(e) }
        Assertions.assertEquals(p2.note, "To be encrypted")
        Assertions.assertEquals(p2.firstName, "John")
        Assertions.assertEquals(p2.lastName, "Doe")

        val newHcpUpdated = newUserHcpApi.getCurrentHealthcareParty()
        Assertions.assertTrue(newHcpUpdated.aesExchangeKeys.isNotEmpty())
        Assertions.assertEquals(newHcpUpdated.aesExchangeKeys.keys.size, 2)

        Assertions.assertEquals(newHcpUpdated.aesExchangeKeys[newHcpKp1.publicKeyAsString()]!![newHcpUpdated.id]!!.size, 1)
        Assertions.assertTrue(newHcpUpdated.aesExchangeKeys[newHcpKp1.publicKeyAsString()]!![newHcpUpdated.id]!!.containsKey(newHcpKp1.publicKeyAsString().takeLast(12)))

        Assertions.assertEquals(newHcpUpdated.aesExchangeKeys[newHcpKp1.publicKeyAsString()]!![parent.id]!!.size, 2)
        Assertions.assertTrue(newHcpUpdated.aesExchangeKeys[newHcpKp1.publicKeyAsString()]!![parent.id]!!.containsKey(newHcpKp1.publicKeyAsString().takeLast(12)))
        Assertions.assertTrue(newHcpUpdated.aesExchangeKeys[newHcpKp1.publicKeyAsString()]!![parent.id]!!.containsKey(parent.publicKey!!.takeLast(12)))

        Assertions.assertEquals(newHcpUpdated.aesExchangeKeys[newHcpKp2.publicKeyAsString()]!![newHcpUpdated.id]!!.size, 2)
        Assertions.assertTrue(newHcpUpdated.aesExchangeKeys[newHcpKp2.publicKeyAsString()]!![newHcpUpdated.id]!!.containsKey(newHcpKp1.publicKeyAsString().takeLast(12)))
        Assertions.assertTrue(newHcpUpdated.aesExchangeKeys[newHcpKp2.publicKeyAsString()]!![newHcpUpdated.id]!!.containsKey(newHcpKp2.publicKeyAsString().takeLast(12)))

        Assertions.assertTrue(newHcpUpdated.hcPartyKeys.isEmpty())
    }

    @ExperimentalUnsignedTypes
    @FlowPreview
    private fun customPatientCryptoConfig(crypto: LocalCrypto) =
        CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>(
            crypto = crypto,
            marshaller = { p -> PatientMapperFactory.instance.map(p)
                .copy(
                    lastName = null,
                    firstName = null
                ) to ApiClient.objectMapper.writeValueAsBytes(mapOf("lastName" to p.lastName, "firstName" to p.firstName))
            },
            unmarshaller = { p, c ->
                PatientMapperFactory.instance.map(
                    p.copy(
                        lastName = ApiClient.objectMapper.readTree(c).get("lastName")?.textValue(),
                        firstName = ApiClient.objectMapper.readTree(c).get("firstName")?.textValue()
                    )
                )
            }
        )

    @org.junit.jupiter.api.Test
    fun encryptPatient() {
    }

    @org.junit.jupiter.api.Test
    fun decryptPatient() {
    }
}
