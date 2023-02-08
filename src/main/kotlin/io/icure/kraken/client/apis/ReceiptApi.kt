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
import io.icure.kraken.client.models.DocIdentifier
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.ReceiptDto
import java.net.URLEncoder
import java.util.*
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class ReceiptApi(
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
     * Creates a receipt
     *
     * @param receiptDto
     * @return ReceiptDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createReceipt(receiptDto: ReceiptDto): ReceiptDto {
        val localVariableConfig = createReceiptRequestConfig(receiptDto = receiptDto)

        return request<ReceiptDto, ReceiptDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createReceipt
     *
     * @param receiptDto
     * @return RequestConfig
     */
    fun createReceiptRequestConfig(receiptDto: ReceiptDto): RequestConfig<ReceiptDto> {
        // val localVariableBody = receiptDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = receiptDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/receipt",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Deletes receipts
     *
     * @param listOfIdsDto
     * @return kotlin.collections.List<DocIdentifier>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteReceipts(listOfIdsDto: ListOfIdsDto): List<DocIdentifier> {
        val localVariableConfig = deleteReceiptsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteReceipts
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun deleteReceiptsRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/receipt/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Gets a receipt
     *
     * @param receiptId
     * @return ReceiptDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getReceipt(receiptId: String): ReceiptDto {
        val localVariableConfig = getReceiptRequestConfig(receiptId = receiptId)

        return request<Unit, ReceiptDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getReceipt
     *
     * @param receiptId
     * @return RequestConfig
     */
    fun getReceiptRequestConfig(receiptId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/receipt/{receiptId}".replace(
                "{" + "receiptId" + "}",
                URLEncoder.encode(receiptId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get an attachment
     *
     * @param receiptId
     * @param attachmentId
     * @param enckeys
     * @return kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getReceiptAttachment(
        receiptId: String,
        attachmentId: String,
        enckeys: String
    ): kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer> {
        val localVariableConfig =
            getReceiptAttachmentRequestConfig(receiptId = receiptId, attachmentId = attachmentId, enckeys = enckeys)

        return request<Unit, kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getReceiptAttachment
     *
     * @param receiptId
     * @param attachmentId
     * @param enckeys
     * @return RequestConfig
     */
    fun getReceiptAttachmentRequestConfig(
        receiptId: String,
        attachmentId: String,
        enckeys: String
    ): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<String, List<String>>()
            .apply {
                put("enckeys", listOf(enckeys))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/octet-stream"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/receipt/{receiptId}/attachment/{attachmentId}".replace(
                "{" + "receiptId" + "}",
                URLEncoder.encode(receiptId, Charsets.UTF_8)
            ).replace("{" + "attachmentId" + "}", URLEncoder.encode(attachmentId, Charsets.UTF_8)),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Gets a receipt
     *
     * @param ref
     * @return kotlin.collections.List<ReceiptDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listByReference(ref: String): List<ReceiptDto> {
        val localVariableConfig = listByReferenceRequestConfig(ref = ref)

        return request<Unit, List<ReceiptDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation listByReference
     *
     * @param ref
     * @return RequestConfig
     */
    fun listByReferenceRequestConfig(ref: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/receipt/byRef/{ref}".replace(
                "{" + "ref" + "}",
                URLEncoder.encode(ref, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Updates a receipt
     *
     * @param receiptDto
     * @return ReceiptDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyReceipt(receiptDto: ReceiptDto): ReceiptDto {
        val localVariableConfig = modifyReceiptRequestConfig(receiptDto = receiptDto)

        return request<ReceiptDto, ReceiptDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation modifyReceipt
     *
     * @param receiptDto
     * @return RequestConfig
     */
    fun modifyReceiptRequestConfig(receiptDto: ReceiptDto): RequestConfig<ReceiptDto> {
        // val localVariableBody = receiptDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = receiptDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/receipt",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Creates a receipt&#39;s attachment
     *
     * @param receiptId
     * @param blobType
     * @param body
     * @param enckeys  (optional)
     * @return ReceiptDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setReceiptAttachment(
        receiptId: String,
        blobType: String,
        body: kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>,
        enckeys: String?
    ): ReceiptDto {
        val localVariableConfig = setReceiptAttachmentRequestConfig(
            receiptId = receiptId,
            blobType = blobType,
            body = body,
            enckeys = enckeys
        )

        return request<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>, ReceiptDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation setReceiptAttachment
     *
     * @param receiptId
     * @param blobType
     * @param body
     * @param enckeys  (optional)
     * @return RequestConfig
     */
    fun setReceiptAttachmentRequestConfig(
        receiptId: String,
        blobType: String,
        body: kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>,
        enckeys: String?
    ): RequestConfig<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>> {
        // val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf<String, List<String>>()
            .apply {
                if (enckeys != null) {
                    put("enckeys", listOf(enckeys.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> =
            mutableMapOf("Content-Type" to "application/octet-stream")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = body

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/receipt/{receiptId}/attachment/{blobType}".replace(
                "{" + "receiptId" + "}",
                URLEncoder.encode(receiptId, Charsets.UTF_8)
            ).replace("{" + "blobType" + "}", URLEncoder.encode(blobType, Charsets.UTF_8)),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
