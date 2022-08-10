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

/* ktlint-disable no-wildcard-imports */
import io.icure.asyncjacksonhttpclient.net.web.WebClient
import io.icure.asyncjacksonhttpclient.netty.NettyWebClient
import io.icure.kraken.client.infrastructure.*
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.KeywordDto
import io.icure.kraken.client.models.ListOfIdsDto

import kotlinx.coroutines.ExperimentalCoroutinesApi

import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import kotlinx.coroutines.flow.flowOf
import java.nio.ByteBuffer
import java.util.*
import javax.inject.Named
import kotlinx.coroutines.flow.Flow
import java.net.URLEncoder
/* ktlint-enable no-wildcard-imports */

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
        // val localVariableBody = keywordDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = keywordDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/keyword",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Delete keywords.
    * Response is a set containing the ID&#39;s of deleted keywords.
    * @param listOfIdsDto
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteKeywords(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteKeywordsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteKeywords
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun deleteKeywordsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/keyword/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/keyword/{keywordId}".replace("{"+"keywordId"+"}", "${URLEncoder.encode(keywordId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/keyword",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/keyword/byUser/{userId}".replace("{"+"userId"+"}", "${URLEncoder.encode(userId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
        // val localVariableBody = keywordDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = keywordDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/keyword",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
