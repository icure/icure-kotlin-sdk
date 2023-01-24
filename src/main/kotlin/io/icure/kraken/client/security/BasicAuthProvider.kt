package io.icure.kraken.client.security

class BasicAuthProvider(
    val username: String,
    val password: String
) : AuthProvider {
    override fun getAuthHeader(): String = "Basic ${java.util.Base64.getEncoder().encodeToString("$username:$password".toByteArray())}"
}