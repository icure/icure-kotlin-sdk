package io.icure.kraken.client.security

interface AuthProvider {

    fun getAuthHeader(): String

}