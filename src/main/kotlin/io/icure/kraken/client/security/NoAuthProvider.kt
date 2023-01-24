package io.icure.kraken.client.security

class NoAuthProvider : AuthProvider {
    override fun getAuthHeader() = ""
}