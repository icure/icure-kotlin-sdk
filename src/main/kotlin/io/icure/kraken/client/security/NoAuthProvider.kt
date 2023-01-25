package io.icure.kraken.client.security

class NoAuthProvider : AuthProvider {
    override suspend fun getAuthHeader() = ""
}