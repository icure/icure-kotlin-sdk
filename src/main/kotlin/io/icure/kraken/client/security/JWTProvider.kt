package io.icure.kraken.client.security

import com.fasterxml.jackson.databind.ObjectMapper
import io.icure.kraken.client.apis.AuthApi
import io.icure.kraken.client.models.LoginCredentials
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.impl.DefaultClaims
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*

@OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
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
            println(authJWT)
            println(authJWT == null || isJwtExpired(authJWT!!))
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
            val expiration = (Jwts.parserBuilder().build().parse("${parts[0]}.${parts[1]}.").body as DefaultClaims).expiration
            expiration < Date(System.currentTimeMillis())
        } catch (e: Exception) {
            true
        }
    }

}