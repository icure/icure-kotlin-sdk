package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.HealthcarePartyApi
import io.icure.kraken.client.apis.MaintenanceTaskApi
import io.icure.kraken.client.apis.UserApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.LocalCrypto
import io.icure.kraken.client.crypto.maintenanceTaskCryptoConfig
import io.icure.kraken.client.crypto.toPrivateKey
import io.icure.kraken.client.crypto.toPublicKey
import io.icure.kraken.client.extendedapis.infrastructure.ExtendedTestUtils
import io.icure.kraken.client.models.decrypted.MaintenanceTaskDto
import io.icure.kraken.client.models.filter.chain.FilterChain
import io.icure.kraken.client.models.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import io.icure.kraken.client.models.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import io.icure.kraken.client.models.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import io.icure.kraken.client.models.filter.maintenancetask.MaintenanceTaskByIdsFilter
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.BasicAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.taktik.icure.constants.TypedValuesType
import org.taktik.icure.services.external.rest.v2.dto.HealthcarePartyDto
import org.taktik.icure.services.external.rest.v2.dto.PropertyStubDto
import org.taktik.icure.services.external.rest.v2.dto.PropertyTypeStubDto
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.base.IdentifierDto
import org.taktik.icure.services.external.rest.v2.dto.embed.TypedValueDto
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.time.Instant
import java.util.*

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
@ExperimentalUnsignedTypes
@FlowPreview
internal class MaintenanceTaskApiKtTest {
    private val iCureBackendUrl = System.getenv("ICURE_BE_URL") ?: "https://kraken.icure.dev"

    private val hcp1Authorization = BasicAuthProvider(System.getenv("PARENT_HCP_USERNAME"), System.getenv("PARENT_HCP_PASSWORD"))
    private val hcp2Authorization = BasicAuthProvider(System.getenv("CHILD_1_HCP_USERNAME"), System.getenv("CHILD_1_HCP_PASSWORD"))

    private val hcp1PrivKey = System.getenv("PARENT_HCP_PRIV_KEY").toPrivateKey()
    private val hcp2PrivKey = System.getenv("CHILD_1_HCP_PRIV_KEY").toPrivateKey()

    private val hcp1UserApi = UserApi(basePath = iCureBackendUrl, authProvider = hcp1Authorization)
    private val hcp1HcPartyApi = HealthcarePartyApi(basePath = iCureBackendUrl, authProvider = hcp1Authorization)
    private val hcp1MaintenanceTaskApi = MaintenanceTaskApi(basePath = iCureBackendUrl, authProvider = hcp1Authorization)

    private val hcp2UserApi = UserApi(basePath = iCureBackendUrl, authProvider = hcp2Authorization)
    private val hcp2HcPartyApi = HealthcarePartyApi(basePath = iCureBackendUrl, authProvider = hcp2Authorization)
    private val hcp2MaintenanceTaskApi = MaintenanceTaskApi(basePath = iCureBackendUrl, authProvider = hcp2Authorization)

    @Test
    fun test_CreateMaintenanceTask_Success() = runBlocking {
        // Given
        val hcp1User = hcp1UserApi.getCurrentUser()
        val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
        val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

        val hcp2User = hcp2UserApi.getCurrentUser()
        val hcp2 = hcp2HcPartyApi.getCurrentHealthcareParty()
        val hcp2cc = cryptoConfigFor(hcp2User, hcp2, hcp2Authorization, hcp2PrivKey, mapOf(rsaKeyPairFor(hcp1, hcp1PrivKey)))

        val taskToCreate = maintenanceTaskDto(delegatedTo = hcp2)

        // When
        val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, taskToCreate, hcp2.id, hcp1cc)

        // Then
        assert(createdTask.id == taskToCreate.id)
        assert(createdTask.delegations.containsKey(hcp1.id))
        assert(createdTask.delegations.containsKey(hcp2.id))
        assert(createdTask.encryptionKeys.containsKey(hcp1.id))
        assert(createdTask.encryptionKeys.containsKey(hcp2.id))

        // When
        val foundTask = hcp2MaintenanceTaskApi.getMaintenanceTask(hcp2User, createdTask.id, hcp2cc)

        // Then
        assert(foundTask.id == createdTask.id)
        assert(foundTask.properties.any { it.typedValue?.stringValue == hcp2.id })
        assert(foundTask.properties.any { it.typedValue?.stringValue == hcp2.publicKey })
    }

    @Test
    fun test_ModifyMaintenanceTask_Success() = runBlocking {
        // Given
        val hcp1User = hcp1UserApi.getCurrentUser()
        val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
        val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

        val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, maintenanceTaskDto(delegatedTo = hcp1), config = hcp1cc)

        // When
        val identifierToAdd = IdentifierDto(id = "SYSTEM-TEST|VALUE-TEST", system = "SYSTEM-TEST", value = "VALUE-TEST",)
        val modifiedTask = hcp1MaintenanceTaskApi.modifyMaintenanceTask(hcp1User, createdTask.copy(
            identifier = listOf(identifierToAdd), status = MaintenanceTaskDto.Status.ongoing
        ), hcp1cc)

        // Then
        assert(modifiedTask.id == createdTask.id)
        assert(modifiedTask.identifier.contains(identifierToAdd))
        assert(modifiedTask.status == MaintenanceTaskDto.Status.ongoing)
    }

    @Test
    fun test_DeleteMaintenanceTask_Success() = runBlocking {
        // Given
        val hcp1User = hcp1UserApi.getCurrentUser()
        val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
        val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

        val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, maintenanceTaskDto(delegatedTo = hcp1), config = hcp1cc)

        // When
        val deletedTasks = hcp1MaintenanceTaskApi.deleteMaintenanceTask(createdTask.id)

        // Then
        assert(deletedTasks.size == 1)
        assert(deletedTasks.first().id == createdTask.id)

        // When
        val foundMaintenanceTaskDto = hcp2MaintenanceTaskApi.getMaintenanceTask(hcp1User, createdTask.id, hcp1cc)

        // Then
        assert(foundMaintenanceTaskDto.deletionDate != null)
    }

    @Test
    fun test_FilterMaintenanceTaskByIds_Success() = runBlocking {
        // Given
        val hcp1User = hcp1UserApi.getCurrentUser()
        val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
        val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

        val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, maintenanceTaskDto(delegatedTo = hcp1), config = hcp1cc)

        // When
        val foundTasks = hcp1MaintenanceTaskApi.filterMaintenanceTasksBy(
            hcp1User,
            FilterChain(MaintenanceTaskByIdsFilter(ids = setOf(createdTask.id))),
            config = hcp1cc).rows

        // Then
        assert(foundTasks.first() == createdTask)
    }

    @Test
    fun test_FilterMaintenanceTaskByHcpAndIdentifier_Success() = runBlocking {
        // Given
        val hcp1User = hcp1UserApi.getCurrentUser()
        val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
        val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

        val identifierUuid = UUID.randomUUID().toString()
        val taskIdentifier = IdentifierDto(id = "SYSTEM-TEST|$identifierUuid", system = "SYSTEM-TEST", value = identifierUuid)
        val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, maintenanceTaskDto(delegatedTo = hcp1)
            .copy(identifier = listOf(taskIdentifier)), config = hcp1cc)

        // When
        val foundTasks = hcp1MaintenanceTaskApi.filterMaintenanceTasksBy(
            hcp1User,
            FilterChain(MaintenanceTaskByHcPartyAndIdentifiersFilter(healthcarePartyId = hcp1.id, identifiers = listOf(taskIdentifier))),
            config = hcp1cc).rows

        // Then
        assert(foundTasks.first() == createdTask)
    }

    @Test
    fun test_FilterMaintenanceTaskAfterDate_Success() = runBlocking {
        // Given
        val hcp1User = hcp1UserApi.getCurrentUser()
        val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
        val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

        val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, maintenanceTaskDto(delegatedTo = hcp1)
            .copy(created = Instant.now().plusSeconds(60 * 5).toEpochMilli()), config = hcp1cc)

        // When
        val foundTasks = hcp1MaintenanceTaskApi.filterMaintenanceTasksBy(
            hcp1User,
            FilterChain(MaintenanceTaskAfterDateFilter(date = Instant.now().plusSeconds(60 * 4).toEpochMilli())),
            config = hcp1cc).rows

        // Then
        assert(foundTasks.first() == createdTask )
    }

    @Test
    fun test_FilterMaintenanceTaskByType_Success() = runBlocking {
            // Given
            val hcp1User = hcp1UserApi.getCurrentUser()
            val hcp1 = hcp1HcPartyApi.getCurrentHealthcareParty()
            val hcp1cc = cryptoConfigFor(hcp1User, hcp1, hcp1Authorization, hcp1PrivKey)

            val taskTypeUuid = UUID.randomUUID().toString()
            val createdTask = hcp1MaintenanceTaskApi.createMaintenanceTask(hcp1User, maintenanceTaskDto(delegatedTo = hcp1)
                .copy(taskType = taskTypeUuid), config = hcp1cc)

            // When
            val foundTasks = hcp1MaintenanceTaskApi.filterMaintenanceTasksBy(
                hcp1User,
                FilterChain(MaintenanceTaskByHcPartyAndTypeFilter(type = taskTypeUuid, healthcarePartyId = hcp1.id)),
                config = hcp1cc).rows

            // Then
            assert(foundTasks.first() == createdTask)
        }

    private fun cryptoConfigFor(user: UserDto,
                                hcp: HealthcarePartyDto,
                                authProvider: AuthProvider,
                                hcpPrivKey: RSAPrivateKey,
                                additionalRsaKeyPairs: Map<String, List<Pair<RSAPrivateKey, RSAPublicKey>>> = emptyMap()) : CryptoConfig<MaintenanceTaskDto, org.taktik.icure.services.external.rest.v2.dto.MaintenanceTaskDto> {
        return maintenanceTaskCryptoConfig(
            LocalCrypto(
                ExtendedTestUtils.dataOwnerWrapperFor(
                    iCureBackendUrl,
                    authProvider
                ), mapOf(rsaKeyPairFor(hcp, hcpPrivKey)) + additionalRsaKeyPairs
            ), user
        )
    }

    private fun rsaKeyPairFor(hcp: HealthcarePartyDto, hcpPrivKey: RSAPrivateKey): Pair<String, List<Pair<RSAPrivateKey, RSAPublicKey>>> {
        return hcp.id to listOf(hcpPrivKey to hcp.publicKey!!.toPublicKey())
    }


    private fun maintenanceTaskDto(delegatedTo: HealthcarePartyDto) = MaintenanceTaskDto(
        id = UUID.randomUUID().toString(),
        taskType = "sharing",
        status = MaintenanceTaskDto.Status.pending,
        properties = listOf(
            PropertyStubDto(
                id = "dataOwnerConcernedId",
                type = PropertyTypeStubDto(type = TypedValuesType.STRING),
                typedValue = TypedValueDto<String>(
                    type = TypedValuesType.STRING,
                    stringValue = delegatedTo.id
                )
            ),
            PropertyStubDto(
                id = "dataOwnerConcernedPubKey",
                type = PropertyTypeStubDto(type = TypedValuesType.STRING),
                typedValue = TypedValueDto<String>(
                    type = TypedValuesType.STRING,
                    stringValue = delegatedTo.publicKey
                )
            )
        )
    )

}