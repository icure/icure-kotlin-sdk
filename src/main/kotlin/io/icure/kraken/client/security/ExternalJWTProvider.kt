package io.icure.kraken.client.security

class ExternalJWTProvider(
    private val jwt: String
) : AuthProvider {
    override suspend fun getAuthHeader() = "Bearer $jwt"

}