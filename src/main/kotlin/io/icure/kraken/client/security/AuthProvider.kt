package io.icure.kraken.client.security

interface AuthProvider {

    suspend fun getAuthHeader(): String

}