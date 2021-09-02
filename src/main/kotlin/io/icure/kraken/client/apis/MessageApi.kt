/**
 * iCure Cloud API Documentation
 *
 * Spring shop sample application
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.apis

import io.icure.asyncjacksonhttpclient.net.web.WebClient
import io.icure.asyncjacksonhttpclient.netty.NettyWebClient
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.IcureStubDto
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.MessageDto
import io.icure.kraken.client.models.MessagesReadStatusUpdate
import io.icure.kraken.client.models.PaginatedListMessageDto

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
class MessageApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Creates a message
    * 
    * @param messageDto  
    * @return MessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createMessage(messageDto: MessageDto) : MessageDto  {
        val localVariableConfig = createMessageRequestConfig(messageDto = messageDto)

        return request<MessageDto, MessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation createMessage
    *
    * @param messageDto  
    * @return RequestConfig
    */
    fun createMessageRequestConfig(messageDto: MessageDto) : RequestConfig<MessageDto> {
        val localVariableBody = messageDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/message",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Deletes a message delegation
    * 
    * @param messageId  
    * @param delegateId  
    * @return MessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteDelegation(messageId: kotlin.String, delegateId: kotlin.String) : MessageDto  {
        val localVariableConfig = deleteDelegationRequestConfig(messageId = messageId, delegateId = delegateId)

        return request<Unit, MessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteDelegation
    *
    * @param messageId  
    * @param delegateId  
    * @return RequestConfig
    */
    fun deleteDelegationRequestConfig(messageId: kotlin.String, delegateId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v1/message/{messageId}/delegate/{delegateId}".replace("{"+"messageId"+"}", "$messageId").replace("{"+"delegateId"+"}", "$delegateId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Deletes multiple messages
    * 
    * @param messageIds  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteMessages(messageIds: kotlin.String) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteMessagesRequestConfig(messageIds = messageIds)

        return request<Unit, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteMessages
    *
    * @param messageIds  
    * @return RequestConfig
    */
    fun deleteMessagesRequestConfig(messageIds: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v1/message/{messageIds}".replace("{"+"messageIds"+"}", "$messageIds"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Deletes multiple messages
    * 
    * @param listOfIdsDto  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteMessagesBatch(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteMessagesBatchRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteMessagesBatch
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun deleteMessagesBatchRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/message/delete/byIds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get all messages (paginated) for current HC Party
    * 
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @return PaginatedListMessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findMessages(startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?) : PaginatedListMessageDto  {
        val localVariableConfig = findMessagesRequestConfig(startKey = startKey, startDocumentId = startDocumentId, limit = limit)

        return request<Unit, PaginatedListMessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findMessages
    *
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun findMessagesRequestConfig(startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get all messages (paginated) for current HC Party and provided from address
    * 
    * @param fromAddress  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param hcpId  (optional)
    * @return PaginatedListMessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findMessagesByFromAddress(fromAddress: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, hcpId: kotlin.String?) : PaginatedListMessageDto  {
        val localVariableConfig = findMessagesByFromAddressRequestConfig(fromAddress = fromAddress, startKey = startKey, startDocumentId = startDocumentId, limit = limit, hcpId = hcpId)

        return request<Unit, PaginatedListMessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findMessagesByFromAddress
    *
    * @param fromAddress  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param hcpId  (optional)
    * @return RequestConfig
    */
    fun findMessagesByFromAddressRequestConfig(fromAddress: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, hcpId: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (fromAddress != null) {
                    put("fromAddress", listOf(fromAddress.toString()))
                }
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (hcpId != null) {
                    put("hcpId", listOf(hcpId.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/byFromAddress",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * List messages found By Healthcare Party and secret foreign keys.
    * Keys must be delimited by coma
    * @param secretFKeys  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findMessagesByHCPartyPatientForeignKeys(secretFKeys: kotlin.String) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = findMessagesByHCPartyPatientForeignKeysRequestConfig(secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findMessagesByHCPartyPatientForeignKeys
    *
    * @param secretFKeys  
    * @return RequestConfig
    */
    fun findMessagesByHCPartyPatientForeignKeysRequestConfig(secretFKeys: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("secretFKeys", listOf(secretFKeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get all messages (paginated) for current HC Party and provided to address
    * 
    * @param toAddress  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param reverse  (optional)
    * @param hcpId  (optional)
    * @return PaginatedListMessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findMessagesByToAddress(toAddress: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, reverse: kotlin.Boolean?, hcpId: kotlin.String?) : PaginatedListMessageDto  {
        val localVariableConfig = findMessagesByToAddressRequestConfig(toAddress = toAddress, startKey = startKey, startDocumentId = startDocumentId, limit = limit, reverse = reverse, hcpId = hcpId)

        return request<Unit, PaginatedListMessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findMessagesByToAddress
    *
    * @param toAddress  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param reverse  (optional)
    * @param hcpId  (optional)
    * @return RequestConfig
    */
    fun findMessagesByToAddressRequestConfig(toAddress: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, reverse: kotlin.Boolean?, hcpId: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (toAddress != null) {
                    put("toAddress", listOf(toAddress.toString()))
                }
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (reverse != null) {
                    put("reverse", listOf(reverse.toString()))
                }
                if (hcpId != null) {
                    put("hcpId", listOf(hcpId.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/byToAddress",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get all messages (paginated) for current HC Party and provided transportGuid
    * 
    * @param transportGuid  (optional)
    * @param received  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param hcpId  (optional)
    * @return PaginatedListMessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findMessagesByTransportGuid(transportGuid: kotlin.String?, received: kotlin.Boolean?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, hcpId: kotlin.String?) : PaginatedListMessageDto  {
        val localVariableConfig = findMessagesByTransportGuidRequestConfig(transportGuid = transportGuid, received = received, startKey = startKey, startDocumentId = startDocumentId, limit = limit, hcpId = hcpId)

        return request<Unit, PaginatedListMessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findMessagesByTransportGuid
    *
    * @param transportGuid  (optional)
    * @param received  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param hcpId  (optional)
    * @return RequestConfig
    */
    fun findMessagesByTransportGuidRequestConfig(transportGuid: kotlin.String?, received: kotlin.Boolean?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, hcpId: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (transportGuid != null) {
                    put("transportGuid", listOf(transportGuid.toString()))
                }
                if (received != null) {
                    put("received", listOf(received.toString()))
                }
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (hcpId != null) {
                    put("hcpId", listOf(hcpId.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/byTransportGuid",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get all messages starting by a prefix between two date
    * 
    * @param from  (optional)
    * @param to  (optional)
    * @param transportGuid  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param hcpId  (optional)
    * @return PaginatedListMessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findMessagesByTransportGuidSentDate(from: kotlin.Long?, to: kotlin.Long?, transportGuid: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, hcpId: kotlin.String?) : PaginatedListMessageDto  {
        val localVariableConfig = findMessagesByTransportGuidSentDateRequestConfig(from = from, to = to, transportGuid = transportGuid, startKey = startKey, startDocumentId = startDocumentId, limit = limit, hcpId = hcpId)

        return request<Unit, PaginatedListMessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findMessagesByTransportGuidSentDate
    *
    * @param from  (optional)
    * @param to  (optional)
    * @param transportGuid  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param hcpId  (optional)
    * @return RequestConfig
    */
    fun findMessagesByTransportGuidSentDateRequestConfig(from: kotlin.Long?, to: kotlin.Long?, transportGuid: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, hcpId: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (from != null) {
                    put("from", listOf(from.toString()))
                }
                if (to != null) {
                    put("to", listOf(to.toString()))
                }
                if (transportGuid != null) {
                    put("transportGuid", listOf(transportGuid.toString()))
                }
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (hcpId != null) {
                    put("hcpId", listOf(hcpId.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/byTransportGuidSentDate",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get children messages of provided message
    * 
    * @param messageId  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getChildrenMessages(messageId: kotlin.String) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = getChildrenMessagesRequestConfig(messageId = messageId)

        return request<Unit, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getChildrenMessages
    *
    * @param messageId  
    * @return RequestConfig
    */
    fun getChildrenMessagesRequestConfig(messageId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/{messageId}/children".replace("{"+"messageId"+"}", "$messageId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get children messages of provided message
    * 
    * @param listOfIdsDto  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getChildrenMessagesOfList(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = getChildrenMessagesOfListRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getChildrenMessagesOfList
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun getChildrenMessagesOfListRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/message/children/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Gets a message
    * 
    * @param messageId  
    * @return MessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getMessage(messageId: kotlin.String) : MessageDto  {
        val localVariableConfig = getMessageRequestConfig(messageId = messageId)

        return request<Unit, MessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getMessage
    *
    * @param messageId  
    * @return RequestConfig
    */
    fun getMessageRequestConfig(messageId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/message/{messageId}".replace("{"+"messageId"+"}", "$messageId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get children messages of provided message
    * 
    * @param listOfIdsDto  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listMessagesByInvoiceIds(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = listMessagesByInvoiceIdsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation listMessagesByInvoiceIds
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun listMessagesByInvoiceIdsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/message/byInvoiceId",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get all messages for current HC Party and provided transportGuids
    * 
    * @param hcpId  
    * @param listOfIdsDto  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listMessagesByTransportGuids(hcpId: kotlin.String, listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = listMessagesByTransportGuidsRequestConfig(hcpId = hcpId, listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation listMessagesByTransportGuids
    *
    * @param hcpId  
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun listMessagesByTransportGuidsRequestConfig(hcpId: kotlin.String, listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("hcpId", listOf(hcpId.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/message/byTransportGuid/list",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Updates a message
    * 
    * @param messageDto  
    * @return MessageDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyMessage(messageDto: MessageDto) : MessageDto  {
        val localVariableConfig = modifyMessageRequestConfig(messageDto = messageDto)

        return request<MessageDto, MessageDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation modifyMessage
    *
    * @param messageDto  
    * @return RequestConfig
    */
    fun modifyMessageRequestConfig(messageDto: MessageDto) : RequestConfig<MessageDto> {
        val localVariableBody = messageDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/message",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Adds a delegation to a message
    * 
    * @param messageId  
    * @param delegationDto  
    * @return IcureStubDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun newMessageDelegations(messageId: kotlin.String, delegationDto: kotlin.collections.List<DelegationDto>) : IcureStubDto  {
        val localVariableConfig = newMessageDelegationsRequestConfig(messageId = messageId, delegationDto = delegationDto)

        return request<kotlin.collections.List<DelegationDto>, IcureStubDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation newMessageDelegations
    *
    * @param messageId  
    * @param delegationDto  
    * @return RequestConfig
    */
    fun newMessageDelegationsRequestConfig(messageId: kotlin.String, delegationDto: kotlin.collections.List<DelegationDto>) : RequestConfig<kotlin.collections.List<DelegationDto>> {
        val localVariableBody = delegationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/message/{messageId}/delegate".replace("{"+"messageId"+"}", "$messageId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Set read status for given list of messages
    * 
    * @param messagesReadStatusUpdate  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setMessagesReadStatus(messagesReadStatusUpdate: MessagesReadStatusUpdate) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = setMessagesReadStatusRequestConfig(messagesReadStatusUpdate = messagesReadStatusUpdate)

        return request<MessagesReadStatusUpdate, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation setMessagesReadStatus
    *
    * @param messagesReadStatusUpdate  
    * @return RequestConfig
    */
    fun setMessagesReadStatusRequestConfig(messagesReadStatusUpdate: MessagesReadStatusUpdate) : RequestConfig<MessagesReadStatusUpdate> {
        val localVariableBody = messagesReadStatusUpdate
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/message/readstatus",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Set status bits for given list of messages
    * 
    * @param status  
    * @param listOfIdsDto  
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setMessagesStatusBits(status: kotlin.Int, listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = setMessagesStatusBitsRequestConfig(status = status, listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation setMessagesStatusBits
    *
    * @param status  
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun setMessagesStatusBitsRequestConfig(status: kotlin.Int, listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/message/status/{status}".replace("{"+"status"+"}", "$status"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
