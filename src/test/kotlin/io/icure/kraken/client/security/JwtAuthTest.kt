package io.icure.kraken.client.security

import io.icure.kraken.client.apis.HealthcarePartyApi
import io.icure.kraken.client.apis.UserApi
import io.icure.kraken.client.infrastructure.TestUtils.Companion.jwtAuth
import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class JwtAuthTest {

    private val jwtProvider: JWTProvider = ".credentialsReadWrite".jwtAuth()
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private fun getCurrentUser(jwt: JWTProvider) = scope.launch {
        delay(1000)
        val userApi = UserApi(basePath = System.getProperty("API_URL"), authProvider = jwtProvider)
        userApi.getCurrentUser()
    }

    @Test
    fun canGetDataUsingTheJwt() {
        runBlocking {
            val userApi = UserApi(basePath = System.getProperty("API_URL"), authProvider = jwtProvider)
            val hcpApi = HealthcarePartyApi(basePath = System.getProperty("API_URL"), authProvider = jwtProvider)

            val currentUser = userApi.getCurrentUser()
            val currentHcp = hcpApi.getCurrentHealthcareParty()
            assert(currentHcp.id == currentUser.healthcarePartyId)
        }
    }

    @Test
    fun canGetDataUsingAnExternalJwt() {
        runBlocking {
            val jwt = jwtProvider.getAuthHeader().replace("Bearer ", "")
            val externalJWTProvider = ExternalJWTProvider(jwt)
            val userApi = UserApi(basePath = System.getProperty("API_URL"), authProvider = externalJWTProvider)
            val hcpApi = HealthcarePartyApi(basePath = System.getProperty("API_URL"), authProvider = externalJWTProvider)

            val currentUser = userApi.getCurrentUser()
            val currentHcp = hcpApi.getCurrentHealthcareParty()
            assert(currentHcp.id == currentUser.healthcarePartyId)
        }
    }

    @Test
    fun canMakeSeveralCallsWithoutTriggeringThrottling() = runBlocking {
        val newJwt = ".credentialsReadWrite".jwtAuth()
        (1 .. 10).forEach { _ ->
            getCurrentUser(newJwt)
        }
    }

}