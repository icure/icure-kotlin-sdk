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
import io.icure.kraken.client.models.ContactDto
import io.icure.kraken.client.models.DocumentDto
import io.icure.kraken.client.models.FormDto
import io.icure.kraken.client.models.HealthElementDto
import io.icure.kraken.client.models.IndexingInfoDto
import io.icure.kraken.client.models.InvoiceDto
import io.icure.kraken.client.models.MessageDto
import io.icure.kraken.client.models.PatientDto
import io.icure.kraken.client.models.ReplicationInfoDto
import io.icure.kraken.client.models.ReplicatorDocument

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
class IcureApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "http://localhost:16043")
        }
    }

    /**
    * Get index info
    * 
    * @return IndexingInfoDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getIndexingInfo() : IndexingInfoDto  {
        val localVariableConfig = getIndexingInfoRequestConfig()

        return request<Unit, IndexingInfoDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getIndexingInfo
    *
    * @return RequestConfig
    */
    fun getIndexingInfoRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/icure/i",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get process info
    * 
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getProcessInfo() : kotlin.String  {
        val localVariableConfig = getProcessInfoRequestConfig()

        return request<Unit, kotlin.String>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getProcessInfo
    *
    * @return RequestConfig
    */
    fun getProcessInfoRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/icure/p",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get replication info
    * 
    * @return ReplicationInfoDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getReplicationInfo() : ReplicationInfoDto  {
        val localVariableConfig = getReplicationInfoRequestConfig()

        return request<Unit, ReplicationInfoDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getReplicationInfo
    *
    * @return RequestConfig
    */
    fun getReplicationInfoRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/icure/r",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get replication info
    * 
    * @param id  
    * @return ReplicatorDocument
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getReplicatorInfo(id: kotlin.String) : ReplicatorDocument  {
        val localVariableConfig = getReplicatorInfoRequestConfig(id = id)

        return request<Unit, ReplicatorDocument>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getReplicatorInfo
    *
    * @param id  
    * @return RequestConfig
    */
    fun getReplicatorInfoRequestConfig(id: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/icure/r/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get version
    * 
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getVersion() : kotlin.String  {
        val localVariableConfig = getVersionRequestConfig()

        return request<Unit, kotlin.String>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getVersion
    *
    * @return RequestConfig
    */
    fun getVersionRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/icure/v",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Check if a user exists
    * 
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun isReady() : kotlin.String  {
        val localVariableConfig = isReadyRequestConfig()

        return request<Unit, kotlin.String>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation isReady
    *
    * @return RequestConfig
    */
    fun isReadyRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/icure/ok",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Resolve contacts conflicts
    * 
    * @param limit  (optional)
    * @return kotlin.collections.List<ContactDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolveContactsConflicts(limit: kotlin.Int?) : kotlin.collections.List<ContactDto>  {
        val localVariableConfig = resolveContactsConflictsRequestConfig(limit = limit)

        return request<Unit, kotlin.collections.List<ContactDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolveContactsConflicts
    *
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolveContactsConflictsRequestConfig(limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/contact",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * resolve documents conflicts
    * 
    * @param ids  (optional)
    * @param limit  (optional)
    * @return kotlin.collections.List<DocumentDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolveDocumentsConflicts(ids: kotlin.String?, limit: kotlin.Int?) : kotlin.collections.List<DocumentDto>  {
        val localVariableConfig = resolveDocumentsConflictsRequestConfig(ids = ids, limit = limit)

        return request<Unit, kotlin.collections.List<DocumentDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolveDocumentsConflicts
    *
    * @param ids  (optional)
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolveDocumentsConflictsRequestConfig(ids: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (ids != null) {
                    put("ids", listOf(ids.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/document",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * resolve forms conflicts
    * 
    * @param limit  (optional)
    * @return kotlin.collections.List<FormDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolveFormsConflicts(limit: kotlin.Int?) : kotlin.collections.List<FormDto>  {
        val localVariableConfig = resolveFormsConflictsRequestConfig(limit = limit)

        return request<Unit, kotlin.collections.List<FormDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolveFormsConflicts
    *
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolveFormsConflictsRequestConfig(limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/form",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * resolve healthcare elements conflicts
    * 
    * @param limit  (optional)
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolveHealthElementsConflicts(limit: kotlin.Int?) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = resolveHealthElementsConflictsRequestConfig(limit = limit)

        return request<Unit, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolveHealthElementsConflicts
    *
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolveHealthElementsConflictsRequestConfig(limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/healthelement",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * resolve invoices conflicts
    * 
    * @param limit  (optional)
    * @return kotlin.collections.List<InvoiceDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolveInvoicesConflicts(limit: kotlin.Int?) : kotlin.collections.List<InvoiceDto>  {
        val localVariableConfig = resolveInvoicesConflictsRequestConfig(limit = limit)

        return request<Unit, kotlin.collections.List<InvoiceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolveInvoicesConflicts
    *
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolveInvoicesConflictsRequestConfig(limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/invoice",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * resolve messages conflicts
    * 
    * @param limit  (optional)
    * @return kotlin.collections.List<MessageDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolveMessagesConflicts(limit: kotlin.Int?) : kotlin.collections.List<MessageDto>  {
        val localVariableConfig = resolveMessagesConflictsRequestConfig(limit = limit)

        return request<Unit, kotlin.collections.List<MessageDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolveMessagesConflicts
    *
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolveMessagesConflictsRequestConfig(limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/message",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Resolve patients conflicts
    * 
    * @param limit  (optional)
    * @return kotlin.collections.List<PatientDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resolvePatientsConflicts(limit: kotlin.Int?) : kotlin.collections.List<PatientDto>  {
        val localVariableConfig = resolvePatientsConflictsRequestConfig(limit = limit)

        return request<Unit, kotlin.collections.List<PatientDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resolvePatientsConflicts
    *
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun resolvePatientsConflictsRequestConfig(limit: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/conflicts/patient",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Force update design doc
    * 
    * @param entityName  
    * @param warmup  (optional)
    * @return kotlin.Boolean
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun updateDesignDoc(entityName: kotlin.String, warmup: kotlin.Boolean?) : kotlin.Boolean  {
        val localVariableConfig = updateDesignDocRequestConfig(entityName = entityName, warmup = warmup)

        return request<Unit, kotlin.Boolean>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation updateDesignDoc
    *
    * @param entityName  
    * @param warmup  (optional)
    * @return RequestConfig
    */
    fun updateDesignDocRequestConfig(entityName: kotlin.String, warmup: kotlin.Boolean?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (warmup != null) {
                    put("warmup", listOf(warmup.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/icure/dd/{entityName}".replace("{"+"entityName"+"}", "$entityName"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
