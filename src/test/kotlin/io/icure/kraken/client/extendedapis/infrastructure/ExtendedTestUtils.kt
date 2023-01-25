package io.icure.kraken.client.extendedapis.infrastructure

import io.icure.kraken.client.apis.DeviceApi
import io.icure.kraken.client.apis.HealthcarePartyApi
import io.icure.kraken.client.apis.PatientApi
import io.icure.kraken.client.crypto.LocalCrypto
import io.icure.kraken.client.crypto.toPublicKey
import io.icure.kraken.client.extendedapis.DataOwner
import io.icure.kraken.client.extendedapis.DataOwnerResolver
import io.icure.kraken.client.extendedapis.dataOwnerId
import io.icure.kraken.client.models.UserDto
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.BasicAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import java.security.interfaces.RSAPrivateKey

@FlowPreview
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
object ExtendedTestUtils {

    fun localCrypto(basePath: String,
                    authProvider: AuthProvider,
                    privKey: RSAPrivateKey,
                    user: UserDto,
                    dataOwner: DataOwner
    ) : LocalCrypto {
        return LocalCrypto(
            dataOwnerWrapperFor(basePath, authProvider), mapOf(
                user.dataOwnerId() to listOf(privKey to dataOwner.publicKey!!.toPublicKey())
            )
        )
    }

    fun dataOwnerWrapperFor(basePath: String, authProvider: AuthProvider) : DataOwnerResolver {
        val hcPartyApi = HealthcarePartyApi(basePath = basePath, authProvider = authProvider)
        val patientApi = PatientApi(basePath = basePath, authProvider = authProvider)
        val deviceApi = DeviceApi(basePath = basePath, authProvider = authProvider)

        return DataOwnerResolver(hcPartyApi, patientApi, deviceApi)
    }
}