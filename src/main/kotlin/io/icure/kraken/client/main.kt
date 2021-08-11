package io.icure.kraken.client

import io.icure.kraken.client.apis.UserApi
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalStdlibApi::class, kotlinx.coroutines.ExperimentalCoroutinesApi::class)
fun main(args: Array<String>) {
    runBlocking {
        val user = UserApi(authHeader = "Basic YWJkZW1vOmtuYWxvdQ==").getCurrentUser()
        println(user?.name)
        println(user?.createdDate)
    }
}