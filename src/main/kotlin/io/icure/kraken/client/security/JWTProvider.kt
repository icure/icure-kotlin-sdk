package io.icure.kraken.client.security

import io.icure.kraken.client.apis.AuthApi
import io.icure.kraken.client.models.LoginCredentials
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.impl.DefaultClaims
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
class JWTProvider(
    basePath: String,
    private val username: String,
    private val password: String,
    private val refreshPadding: Long = 30_000
) : AuthProvider {

    private val mutex = Mutex()
    private val authApi = AuthApi(basePath)
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
            refreshJWT = it.refreshToken ?: refreshJWT
        }

    private fun isJwtExpired(token: String): Boolean {
        val parts = token.split(".")
        if (parts.size != 3) return true
        return try {
            val expiration =
                (Jwts.parserBuilder().build().parse("${parts[0]}.${parts[1]}.").body as DefaultClaims).expiration
            expiration < Date(System.currentTimeMillis() + refreshPadding)
        } catch (e: Exception) {
            true
        }
    }

}