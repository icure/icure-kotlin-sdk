/**
 * OpenAPI definition
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.apis

import io.icure.asyncjacksonhttpclient.net.web.WebClient
import io.icure.asyncjacksonhttpclient.netty.NettyWebClient
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.ReceiptDto

import kotlinx.coroutines.ExperimentalCoroutinesApi

import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class ReceiptApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
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
    suspend fun createReceipt(receiptDto: ReceiptDto) : ReceiptDto?  {
        val localVariableConfig = createReceiptRequestConfig(receiptDto = receiptDto)

        return request<ReceiptDto, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation createReceipt
    *
    * @param receiptDto  
    * @return RequestConfig
    */
    fun createReceiptRequestConfig(receiptDto: ReceiptDto) : RequestConfig<ReceiptDto> {
        val localVariableBody = receiptDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/receipt",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
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
    suspend fun createReceipt1(receiptDto: ReceiptDto) : ReceiptDto?  {
        val localVariableConfig = createReceipt1RequestConfig(receiptDto = receiptDto)

        return request<ReceiptDto, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation createReceipt1
    *
    * @param receiptDto  
    * @return RequestConfig
    */
    fun createReceipt1RequestConfig(receiptDto: ReceiptDto) : RequestConfig<ReceiptDto> {
        val localVariableBody = receiptDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/receipt",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Deletes a receipt
    * 
    * @param receiptIds  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteReceipt(receiptIds: kotlin.String) : kotlin.collections.List<DocIdentifier>?  {
        val localVariableConfig = deleteReceiptRequestConfig(receiptIds = receiptIds)

        return request<Unit, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteReceipt
    *
    * @param receiptIds  
    * @return RequestConfig
    */
    fun deleteReceiptRequestConfig(receiptIds: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v1/receipt/{receiptIds}".replace("{"+"receiptIds"+"}", "$receiptIds"),
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
    suspend fun deleteReceipts(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>?  {
        val localVariableConfig = deleteReceiptsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteReceipts
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun deleteReceiptsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
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
    suspend fun getReceipt(receiptId: kotlin.String) : ReceiptDto?  {
        val localVariableConfig = getReceiptRequestConfig(receiptId = receiptId)

        return request<Unit, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getReceipt
    *
    * @param receiptId  
    * @return RequestConfig
    */
    fun getReceiptRequestConfig(receiptId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/receipt/{receiptId}".replace("{"+"receiptId"+"}", "$receiptId"),
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
    suspend fun getReceipt1(receiptId: kotlin.String) : ReceiptDto?  {
        val localVariableConfig = getReceipt1RequestConfig(receiptId = receiptId)

        return request<Unit, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getReceipt1
    *
    * @param receiptId  
    * @return RequestConfig
    */
    fun getReceipt1RequestConfig(receiptId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/receipt/{receiptId}".replace("{"+"receiptId"+"}", "$receiptId"),
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
    suspend fun getReceiptAttachment(receiptId: kotlin.String, attachmentId: kotlin.String, enckeys: kotlin.String) : kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>?  {
        val localVariableConfig = getReceiptAttachmentRequestConfig(receiptId = receiptId, attachmentId = attachmentId, enckeys = enckeys)

        return request<Unit, kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getReceiptAttachment
    *
    * @param receiptId  
    * @param attachmentId  
    * @param enckeys  
    * @return RequestConfig
    */
    fun getReceiptAttachmentRequestConfig(receiptId: kotlin.String, attachmentId: kotlin.String, enckeys: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("enckeys", listOf(enckeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/receipt/{receiptId}/attachment/{attachmentId}".replace("{"+"receiptId"+"}", "$receiptId").replace("{"+"attachmentId"+"}", "$attachmentId"),
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
    suspend fun getReceiptAttachment1(receiptId: kotlin.String, attachmentId: kotlin.String, enckeys: kotlin.String) : kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>?  {
        val localVariableConfig = getReceiptAttachment1RequestConfig(receiptId = receiptId, attachmentId = attachmentId, enckeys = enckeys)

        return request<Unit, kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getReceiptAttachment1
    *
    * @param receiptId  
    * @param attachmentId  
    * @param enckeys  
    * @return RequestConfig
    */
    fun getReceiptAttachment1RequestConfig(receiptId: kotlin.String, attachmentId: kotlin.String, enckeys: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("enckeys", listOf(enckeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/receipt/{receiptId}/attachment/{attachmentId}".replace("{"+"receiptId"+"}", "$receiptId").replace("{"+"attachmentId"+"}", "$attachmentId"),
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
    suspend fun listByReference(ref: kotlin.String) : kotlin.collections.List<ReceiptDto>?  {
        val localVariableConfig = listByReferenceRequestConfig(ref = ref)

        return request<Unit, kotlin.collections.List<ReceiptDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation listByReference
    *
    * @param ref  
    * @return RequestConfig
    */
    fun listByReferenceRequestConfig(ref: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/receipt/byRef/{ref}".replace("{"+"ref"+"}", "$ref"),
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
    suspend fun listByReference1(ref: kotlin.String) : kotlin.collections.List<ReceiptDto>?  {
        val localVariableConfig = listByReference1RequestConfig(ref = ref)

        return request<Unit, kotlin.collections.List<ReceiptDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation listByReference1
    *
    * @param ref  
    * @return RequestConfig
    */
    fun listByReference1RequestConfig(ref: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/receipt/byref/{ref}".replace("{"+"ref"+"}", "$ref"),
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
    suspend fun modifyReceipt(receiptDto: ReceiptDto) : ReceiptDto?  {
        val localVariableConfig = modifyReceiptRequestConfig(receiptDto = receiptDto)

        return request<ReceiptDto, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation modifyReceipt
    *
    * @param receiptDto  
    * @return RequestConfig
    */
    fun modifyReceiptRequestConfig(receiptDto: ReceiptDto) : RequestConfig<ReceiptDto> {
        val localVariableBody = receiptDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/receipt",
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
    suspend fun modifyReceipt1(receiptDto: ReceiptDto) : ReceiptDto?  {
        val localVariableConfig = modifyReceipt1RequestConfig(receiptDto = receiptDto)

        return request<ReceiptDto, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation modifyReceipt1
    *
    * @param receiptDto  
    * @return RequestConfig
    */
    fun modifyReceipt1RequestConfig(receiptDto: ReceiptDto) : RequestConfig<ReceiptDto> {
        val localVariableBody = receiptDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/receipt",
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
    * @param requestBody  
    * @param enckeys  (optional)
    * @return ReceiptDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setReceiptAttachment(receiptId: kotlin.String, blobType: kotlin.String, requestBody: kotlin.collections.List<kotlin.ByteArray>, enckeys: kotlin.String?) : ReceiptDto?  {
        val localVariableConfig = setReceiptAttachmentRequestConfig(receiptId = receiptId, blobType = blobType, requestBody = requestBody, enckeys = enckeys)

        return request<kotlin.collections.List<kotlin.ByteArray>, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation setReceiptAttachment
    *
    * @param receiptId  
    * @param blobType  
    * @param requestBody  
    * @param enckeys  (optional)
    * @return RequestConfig
    */
    fun setReceiptAttachmentRequestConfig(receiptId: kotlin.String, blobType: kotlin.String, requestBody: kotlin.collections.List<kotlin.ByteArray>, enckeys: kotlin.String?) : RequestConfig<kotlin.collections.List<kotlin.ByteArray>> {
        val localVariableBody = requestBody
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (enckeys != null) {
                    put("enckeys", listOf(enckeys.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/receipt/{receiptId}/attachment/{blobType}".replace("{"+"receiptId"+"}", "$receiptId").replace("{"+"blobType"+"}", "$blobType"),
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
    suspend fun setReceiptAttachment1(receiptId: kotlin.String, blobType: kotlin.String, body: kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>, enckeys: kotlin.String?) : ReceiptDto?  {
        val localVariableConfig = setReceiptAttachment1RequestConfig(receiptId = receiptId, blobType = blobType, body = body, enckeys = enckeys)

        return request<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>, ReceiptDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation setReceiptAttachment1
    *
    * @param receiptId  
    * @param blobType  
    * @param body  
    * @param enckeys  (optional)
    * @return RequestConfig
    */
    fun setReceiptAttachment1RequestConfig(receiptId: kotlin.String, blobType: kotlin.String, body: kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>, enckeys: kotlin.String?) : RequestConfig<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (enckeys != null) {
                    put("enckeys", listOf(enckeys.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/receipt/{receiptId}/attachment/{blobType}".replace("{"+"receiptId"+"}", "$receiptId").replace("{"+"blobType"+"}", "$blobType"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
