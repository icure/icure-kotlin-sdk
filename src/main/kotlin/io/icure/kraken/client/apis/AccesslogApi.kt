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
import io.icure.kraken.client.models.AccessLogDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.PaginatedListAccessLogDto

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
class AccesslogApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Creates an access log
    * 
    * @param accessLogDto  
    * @return AccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createAccessLog(accessLogDto: AccessLogDto) : AccessLogDto?  {
        val localVariableConfig = createAccessLogRequestConfig(accessLogDto = accessLogDto)

        return request<AccessLogDto, AccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation createAccessLog
    *
    * @param accessLogDto  
    * @return RequestConfig
    */
    fun createAccessLogRequestConfig(accessLogDto: AccessLogDto) : RequestConfig<AccessLogDto> {
        val localVariableBody = accessLogDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/accesslog",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Create an access log
    * 
    * @param accessLogDto  
    * @return AccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createAccessLog1(accessLogDto: AccessLogDto) : AccessLogDto?  {
        val localVariableConfig = createAccessLog1RequestConfig(accessLogDto = accessLogDto)

        return request<AccessLogDto, AccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation createAccessLog1
    *
    * @param accessLogDto  
    * @return RequestConfig
    */
    fun createAccessLog1RequestConfig(accessLogDto: AccessLogDto) : RequestConfig<AccessLogDto> {
        val localVariableBody = accessLogDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/accesslog",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Delete access logs by batch
    * 
    * @param accessLogIds  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteAccessLog(accessLogIds: kotlin.String) : kotlin.collections.List<DocIdentifier>?  {
        val localVariableConfig = deleteAccessLogRequestConfig(accessLogIds = accessLogIds)

        return request<Unit, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteAccessLog
    *
    * @param accessLogIds  
    * @return RequestConfig
    */
    fun deleteAccessLogRequestConfig(accessLogIds: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v1/accesslog/{accessLogIds}".replace("{"+"accessLogIds"+"}", "$accessLogIds"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Deletes an access log
    * 
    * @param listOfIdsDto  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteAccessLogs(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>?  {
        val localVariableConfig = deleteAccessLogsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation deleteAccessLogs
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun deleteAccessLogsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/accesslog/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get Paginated List of Access logs
    * 
    * @param fromEpoch  (optional)
    * @param toEpoch  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param descending  (optional)
    * @return PaginatedListAccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findAccessLogsBy(fromEpoch: kotlin.Long?, toEpoch: kotlin.Long?, startKey: kotlin.Long?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : PaginatedListAccessLogDto?  {
        val localVariableConfig = findAccessLogsByRequestConfig(fromEpoch = fromEpoch, toEpoch = toEpoch, startKey = startKey, startDocumentId = startDocumentId, limit = limit, descending = descending)

        return request<Unit, PaginatedListAccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findAccessLogsBy
    *
    * @param fromEpoch  (optional)
    * @param toEpoch  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param descending  (optional)
    * @return RequestConfig
    */
    fun findAccessLogsByRequestConfig(fromEpoch: kotlin.Long?, toEpoch: kotlin.Long?, startKey: kotlin.Long?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (fromEpoch != null) {
                    put("fromEpoch", listOf(fromEpoch.toString()))
                }
                if (toEpoch != null) {
                    put("toEpoch", listOf(toEpoch.toString()))
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
                if (descending != null) {
                    put("descending", listOf(descending.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/accesslog",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * List access logs found by Healthcare Party and secret foreign keyelementIds.
    * 
    * @param hcPartyId  
    * @param secretFKeys  
    * @return kotlin.collections.List<AccessLogDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findAccessLogsByHCPartyPatientForeignKeys(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : kotlin.collections.List<AccessLogDto>?  {
        val localVariableConfig = findAccessLogsByHCPartyPatientForeignKeysRequestConfig(hcPartyId = hcPartyId, secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<AccessLogDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findAccessLogsByHCPartyPatientForeignKeys
    *
    * @param hcPartyId  
    * @param secretFKeys  
    * @return RequestConfig
    */
    fun findAccessLogsByHCPartyPatientForeignKeysRequestConfig(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("hcPartyId", listOf(hcPartyId.toString()))
                put("secretFKeys", listOf(secretFKeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/accesslog/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get Paginated List of Access logs by user after date
    * 
    * @param userId A User ID 
    * @param accessType The type of access (COMPUTER or USER) (optional)
    * @param startDate The start search epoch (optional)
    * @param startKey The start key for pagination (optional)
    * @param startDocumentId A patient document ID (optional)
    * @param limit Number of rows (optional)
    * @param descending Descending order (optional)
    * @return PaginatedListAccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findAccessLogsByUserAfterDate(userId: kotlin.String, accessType: kotlin.String?, startDate: kotlin.Long?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : PaginatedListAccessLogDto?  {
        val localVariableConfig = findAccessLogsByUserAfterDateRequestConfig(userId = userId, accessType = accessType, startDate = startDate, startKey = startKey, startDocumentId = startDocumentId, limit = limit, descending = descending)

        return request<Unit, PaginatedListAccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findAccessLogsByUserAfterDate
    *
    * @param userId A User ID 
    * @param accessType The type of access (COMPUTER or USER) (optional)
    * @param startDate The start search epoch (optional)
    * @param startKey The start key for pagination (optional)
    * @param startDocumentId A patient document ID (optional)
    * @param limit Number of rows (optional)
    * @param descending Descending order (optional)
    * @return RequestConfig
    */
    fun findAccessLogsByUserAfterDateRequestConfig(userId: kotlin.String, accessType: kotlin.String?, startDate: kotlin.Long?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("userId", listOf(userId.toString()))
                if (accessType != null) {
                    put("accessType", listOf(accessType.toString()))
                }
                if (startDate != null) {
                    put("startDate", listOf(startDate.toString()))
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
                if (descending != null) {
                    put("descending", listOf(descending.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/accesslog/byUser",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get paginated list of Access Logs
    * 
    * @param userId A User ID 
    * @param accessType The type of access (COMPUTER or USER) (optional)
    * @param startDate The start search epoch (optional)
    * @param startKey The start key for pagination (optional)
    * @param startDocumentId A patient document ID (optional)
    * @param limit Number of rows (optional)
    * @param descending Descending order (optional)
    * @return PaginatedListAccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findByUserAfterDate(userId: kotlin.String, accessType: kotlin.String?, startDate: kotlin.Long?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : PaginatedListAccessLogDto?  {
        val localVariableConfig = findByUserAfterDateRequestConfig(userId = userId, accessType = accessType, startDate = startDate, startKey = startKey, startDocumentId = startDocumentId, limit = limit, descending = descending)

        return request<Unit, PaginatedListAccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation findByUserAfterDate
    *
    * @param userId A User ID 
    * @param accessType The type of access (COMPUTER or USER) (optional)
    * @param startDate The start search epoch (optional)
    * @param startKey The start key for pagination (optional)
    * @param startDocumentId A patient document ID (optional)
    * @param limit Number of rows (optional)
    * @param descending Descending order (optional)
    * @return RequestConfig
    */
    fun findByUserAfterDateRequestConfig(userId: kotlin.String, accessType: kotlin.String?, startDate: kotlin.Long?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("userId", listOf(userId.toString()))
                if (accessType != null) {
                    put("accessType", listOf(accessType.toString()))
                }
                if (startDate != null) {
                    put("startDate", listOf(startDate.toString()))
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
                if (descending != null) {
                    put("descending", listOf(descending.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/accesslog/byUser",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Gets an access log
    * 
    * @param accessLogId  
    * @return AccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getAccessLog(accessLogId: kotlin.String) : AccessLogDto?  {
        val localVariableConfig = getAccessLogRequestConfig(accessLogId = accessLogId)

        return request<Unit, AccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getAccessLog
    *
    * @param accessLogId  
    * @return RequestConfig
    */
    fun getAccessLogRequestConfig(accessLogId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/accesslog/{accessLogId}".replace("{"+"accessLogId"+"}", "$accessLogId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get an access log
    * 
    * @param accessLogId  
    * @return AccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getAccessLog1(accessLogId: kotlin.String) : AccessLogDto?  {
        val localVariableConfig = getAccessLog1RequestConfig(accessLogId = accessLogId)

        return request<Unit, AccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getAccessLog1
    *
    * @param accessLogId  
    * @return RequestConfig
    */
    fun getAccessLog1RequestConfig(accessLogId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/accesslog/{accessLogId}".replace("{"+"accessLogId"+"}", "$accessLogId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get paginated list of Access Logs
    * 
    * @param fromEpoch  (optional)
    * @param toEpoch  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param descending  (optional)
    * @return PaginatedListAccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listAccessLogs(fromEpoch: kotlin.Long?, toEpoch: kotlin.Long?, startKey: kotlin.Long?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : PaginatedListAccessLogDto?  {
        val localVariableConfig = listAccessLogsRequestConfig(fromEpoch = fromEpoch, toEpoch = toEpoch, startKey = startKey, startDocumentId = startDocumentId, limit = limit, descending = descending)

        return request<Unit, PaginatedListAccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation listAccessLogs
    *
    * @param fromEpoch  (optional)
    * @param toEpoch  (optional)
    * @param startKey  (optional)
    * @param startDocumentId  (optional)
    * @param limit  (optional)
    * @param descending  (optional)
    * @return RequestConfig
    */
    fun listAccessLogsRequestConfig(fromEpoch: kotlin.Long?, toEpoch: kotlin.Long?, startKey: kotlin.Long?, startDocumentId: kotlin.String?, limit: kotlin.Int?, descending: kotlin.Boolean?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (fromEpoch != null) {
                    put("fromEpoch", listOf(fromEpoch.toString()))
                }
                if (toEpoch != null) {
                    put("toEpoch", listOf(toEpoch.toString()))
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
                if (descending != null) {
                    put("descending", listOf(descending.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/accesslog",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * List access logs found By Healthcare Party and secret foreign keyelementIds.
    * 
    * @param hcPartyId  
    * @param secretFKeys  
    * @return kotlin.collections.List<AccessLogDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listAccessLogsByHCPartyAndPatientForeignKeys(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : kotlin.collections.List<AccessLogDto>?  {
        val localVariableConfig = listAccessLogsByHCPartyAndPatientForeignKeysRequestConfig(hcPartyId = hcPartyId, secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<AccessLogDto>>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation listAccessLogsByHCPartyAndPatientForeignKeys
    *
    * @param hcPartyId  
    * @param secretFKeys  
    * @return RequestConfig
    */
    fun listAccessLogsByHCPartyAndPatientForeignKeysRequestConfig(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("hcPartyId", listOf(hcPartyId.toString()))
                put("secretFKeys", listOf(secretFKeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/accesslog/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Modifies an access log
    * 
    * @param accessLogDto  
    * @return AccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyAccessLog(accessLogDto: AccessLogDto) : AccessLogDto?  {
        val localVariableConfig = modifyAccessLogRequestConfig(accessLogDto = accessLogDto)

        return request<AccessLogDto, AccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation modifyAccessLog
    *
    * @param accessLogDto  
    * @return RequestConfig
    */
    fun modifyAccessLogRequestConfig(accessLogDto: AccessLogDto) : RequestConfig<AccessLogDto> {
        val localVariableBody = accessLogDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/accesslog",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Modifies an access log
    * 
    * @param accessLogDto  
    * @return AccessLogDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyAccessLog1(accessLogDto: AccessLogDto) : AccessLogDto?  {
        val localVariableConfig = modifyAccessLog1RequestConfig(accessLogDto = accessLogDto)

        return request<AccessLogDto, AccessLogDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation modifyAccessLog1
    *
    * @param accessLogDto  
    * @return RequestConfig
    */
    fun modifyAccessLog1RequestConfig(accessLogDto: AccessLogDto) : RequestConfig<AccessLogDto> {
        val localVariableBody = accessLogDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/accesslog",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
