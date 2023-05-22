package io.icure.kraken.client.security

class BasicAuthProvider(
    private val username: String? = null,
    private val password: String? = null,
    private val basicToken: String? = null
) : AuthProvider {
    override suspend fun getAuthHeader(): String = when {
        !username.isNullOrEmpty() && !password.isNullOrEmpty() -> getAuthString(username, password)
        !basicToken.isNullOrEmpty() -> when (basicToken.contains(":")) {
            true -> getAuthString(basicToken.substringBefore(":"), basicToken.substringAfter(":"))
            false -> "Basic $basicToken"
        }
        else -> throw IllegalArgumentException("BasicAuthProvider: username/password or basicToken must be provided")
    }

    companion object {
        private fun getAuthString(username: String, password: String): String =
            "Basic ${java.util.Base64.getEncoder().encodeToString("$username:$password".toByteArray())}"
    }
}
