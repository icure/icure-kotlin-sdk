package io.icure.kraken.client.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.icure.kraken.client.apis.AuthApi
import io.icure.kraken.client.models.LoginCredentials
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*

private data class JWTExp(
    val exp: Long
)

@OptIn(ExperimentalStdlibApi::class)
class JWTProvider(
    basePath: String,
    private val username: String,
    private val password: String
) : AuthProvider {

    private val mutex = Mutex()
    private val authApi = AuthApi(basePath)
    private val mapper = ObjectMapper()
    private var authJWT: String? = null
    private var refreshJWT: String? = null

    override suspend fun getAuthHeader(): String =
        mutex.withLock {
            if (authJWT == null || isJwtExpired(authJWT!!)) {
                refreshAuthenticationJWT()
            }
        }.let { "Bearer ${authJWT!!}" }


    private suspend fun refreshAuthenticationJWT() =
        if (refreshJWT == null || isJwtExpired(refreshJWT!!)) {
            authApi.login(LoginCredentials(username, password))
        } else {
            authApi.refresh(refreshJWT!!)
        }.let {
            authJWT = it.token!!
            refreshJWT = it.refreshToken!!
        }

    private fun isJwtExpired(token: String): Boolean {
        val parts = token.split(".")
        if (parts.size != 3) return true
        return try {
            val expiration = mapper.readValue<JWTExp>(Base64.getDecoder().decode(parts[1]).toString()).exp * 1000
            expiration < System.currentTimeMillis()
        } catch (e: Exception) {
            true
        }
    }

}