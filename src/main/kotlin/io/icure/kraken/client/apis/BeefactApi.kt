/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure.
 *
 * The version of the OpenAPI document: v2
 *
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.apis

import io.icure.asyncjacksonhttpclient.net.web.WebClient
import io.icure.asyncjacksonhttpclient.netty.NettyWebClient
import io.icure.kraken.client.infrastructure.*
import io.icure.kraken.client.models.MessageWithBatch
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.MapOfIdsDto
import java.net.URLEncoder
import java.util.*
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class BeefactApi(
    basePath: String = defaultBasePath,
    webClient: WebClient = NettyWebClient(),
    authProvider: AuthProvider = NoAuthProvider()
) : ApiClient(basePath, webClient, authProvider) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
     * create batch and message
     *
     * @param insuranceId
     * @param newMessageId
     * @param numericalRef
     * @param mapOfIdsDto
     * @return MessageWithBatch
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createBatchAndMessage(
        insuranceId: String,
        newMessageId: String,
        numericalRef: Long,
        mapOfIdsDto: MapOfIdsDto
    ): MessageWithBatch {
        val localVariableConfig = createBatchAndMessageRequestConfig(
            insuranceId = insuranceId,
            newMessageId = newMessageId,
            numericalRef = numericalRef,
            mapOfIdsDto = mapOfIdsDto
        )

        return request<MapOfIdsDto, MessageWithBatch>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createBatchAndMessage
     *
     * @param insuranceId
     * @param newMessageId
     * @param numericalRef
     * @param mapOfIdsDto
     * @return RequestConfig
     */
    fun createBatchAndMessageRequestConfig(
        insuranceId: String,
        newMessageId: String,
        numericalRef: Long,
        mapOfIdsDto: MapOfIdsDto
    ): RequestConfig<MapOfIdsDto> {
        // val localVariableBody = mapOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = mapOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/be_efact/{insuranceId}/{newMessageId}/{numericalRef}".replace(
                "{" + "insuranceId" + "}",
                "${URLEncoder.encode(insuranceId.toString(), Charsets.UTF_8)}"
            ).replace("{" + "newMessageId" + "}", "${URLEncoder.encode(newMessageId.toString(), Charsets.UTF_8)}")
                .replace("{" + "numericalRef" + "}", "${URLEncoder.encode(numericalRef.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
