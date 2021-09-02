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
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.KeywordDto

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
class KeywordApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create a keyword with the current user
    * Returns an instance of created keyword.
    * @param keywordDto  
    * @return KeywordDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createKeyword(keywordDto: KeywordDto) : KeywordDto  {
        val localVariableConfig = createKeywordRequestConfig(keywordDto = keywordDto)

        return request<KeywordDto, KeywordDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createKeyword
    *
    * @param keywordDto  
    * @return RequestConfig
    */
    fun createKeywordRequestConfig(keywordDto: KeywordDto) : RequestConfig<KeywordDto> {
        val localVariableBody = keywordDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v1/keyword",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Delete keywords.
    * Response is a set containing the ID&#39;s of deleted keywords.
    * @param keywordIds  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteKeywords(keywordIds: kotlin.String) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteKeywordsRequestConfig(keywordIds = keywordIds)

        return request<Unit, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteKeywords
    *
    * @param keywordIds  
    * @return RequestConfig
    */
    fun deleteKeywordsRequestConfig(keywordIds: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v1/keyword/{keywordIds}".replace("{"+"keywordIds"+"}", "$keywordIds"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get a keyword
    * 
    * @param keywordId  
    * @return KeywordDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getKeyword(keywordId: kotlin.String) : KeywordDto  {
        val localVariableConfig = getKeywordRequestConfig(keywordId = keywordId)

        return request<Unit, KeywordDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getKeyword
    *
    * @param keywordId  
    * @return RequestConfig
    */
    fun getKeywordRequestConfig(keywordId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/keyword/{keywordId}".replace("{"+"keywordId"+"}", "$keywordId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Gets all keywords
    * 
    * @return kotlin.collections.List<KeywordDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getKeywords() : kotlin.collections.List<KeywordDto>  {
        val localVariableConfig = getKeywordsRequestConfig()

        return request<Unit, kotlin.collections.List<KeywordDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getKeywords
    *
    * @return RequestConfig
    */
    fun getKeywordsRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/keyword",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get keywords by user
    * 
    * @param userId  
    * @return kotlin.collections.List<KeywordDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getKeywordsByUser(userId: kotlin.String) : kotlin.collections.List<KeywordDto>  {
        val localVariableConfig = getKeywordsByUserRequestConfig(userId = userId)

        return request<Unit, kotlin.collections.List<KeywordDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getKeywordsByUser
    *
    * @param userId  
    * @return RequestConfig
    */
    fun getKeywordsByUserRequestConfig(userId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/keyword/byUser/{userId}".replace("{"+"userId"+"}", "$userId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Modify a keyword
    * Returns the modified keyword.
    * @param keywordDto  
    * @return KeywordDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyKeyword(keywordDto: KeywordDto) : KeywordDto  {
        val localVariableConfig = modifyKeywordRequestConfig(keywordDto = keywordDto)

        return request<KeywordDto, KeywordDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyKeyword
    *
    * @param keywordDto  
    * @return RequestConfig
    */
    fun modifyKeywordRequestConfig(keywordDto: KeywordDto) : RequestConfig<KeywordDto> {
        val localVariableBody = keywordDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/keyword",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
