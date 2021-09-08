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
import io.icure.kraken.client.models.EntityReferenceDto

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
class EntityrefApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create an entity reference
    * 
    * @param entityReferenceDto  
    * @return EntityReferenceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createEntityReference(entityReferenceDto: EntityReferenceDto) : EntityReferenceDto  {
        val localVariableConfig = createEntityReferenceRequestConfig(entityReferenceDto = entityReferenceDto)

        return request<EntityReferenceDto, EntityReferenceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createEntityReference
    *
    * @param entityReferenceDto  
    * @return RequestConfig
    */
    fun createEntityReferenceRequestConfig(entityReferenceDto: EntityReferenceDto) : RequestConfig<EntityReferenceDto> {
        val localVariableBody = entityReferenceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/entityref",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Create an entity reference
    * 
    * @param entityReferenceDto  
    * @return EntityReferenceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createEntityReference1(entityReferenceDto: EntityReferenceDto) : EntityReferenceDto?  {
        val localVariableConfig = createEntityReference1RequestConfig(entityReferenceDto = entityReferenceDto)

        return request<EntityReferenceDto, EntityReferenceDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation createEntityReference1
    *
    * @param entityReferenceDto  
    * @return RequestConfig
    */
    fun createEntityReference1RequestConfig(entityReferenceDto: EntityReferenceDto) : RequestConfig<EntityReferenceDto> {
        val localVariableBody = entityReferenceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/entityref",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Find latest reference for a prefix 
    * 
    * @param prefix  
    * @return EntityReferenceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getLatest(prefix: kotlin.String) : EntityReferenceDto  {
        val localVariableConfig = getLatestRequestConfig(prefix = prefix)

        return request<Unit, EntityReferenceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getLatest
    *
    * @param prefix  
    * @return RequestConfig
    */
    fun getLatestRequestConfig(prefix: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/entityref/latest/{prefix}".replace("{"+"prefix"+"}", "$prefix"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Find latest reference for a prefix 
    * 
    * @param prefix  
    * @return EntityReferenceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getLatest1(prefix: kotlin.String) : EntityReferenceDto?  {
        val localVariableConfig = getLatest1RequestConfig(prefix = prefix)

        return request<Unit, EntityReferenceDto>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation getLatest1
    *
    * @param prefix  
    * @return RequestConfig
    */
    fun getLatest1RequestConfig(prefix: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/entityref/latest/{prefix}".replace("{"+"prefix"+"}", "$prefix"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
