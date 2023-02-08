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
import org.taktik.icure.services.external.rest.v2.dto.KeywordDto
import java.net.URLEncoder
import java.util.*
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class KeywordApi(
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
    suspend fun createKeyword(keywordDto: KeywordDto): KeywordDto {
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
    fun createKeywordRequestConfig(keywordDto: KeywordDto): RequestConfig<KeywordDto> {
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
            body = localVariableBody
        )
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
    suspend fun deleteKeywords(listOfIdsDto: ListOfIdsDto): List<DocIdentifier> {
        val localVariableConfig = deleteKeywordsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteKeywords
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun deleteKeywordsRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
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
    suspend fun getKeyword(keywordId: String): KeywordDto {
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
    fun getKeywordRequestConfig(keywordId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/keyword/{keywordId}".replace(
                "{" + "keywordId" + "}",
                URLEncoder.encode(keywordId, Charsets.UTF_8)
            ),
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
    suspend fun getKeywords(): List<KeywordDto> {
        val localVariableConfig = getKeywordsRequestConfig()

        return request<Unit, List<KeywordDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getKeywords
     *
     * @return RequestConfig
     */
    fun getKeywordsRequestConfig(): RequestConfig<Unit> {
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
    suspend fun getKeywordsByUser(userId: String): List<KeywordDto> {
        val localVariableConfig = getKeywordsByUserRequestConfig(userId = userId)

        return request<Unit, List<KeywordDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getKeywordsByUser
     *
     * @param userId
     * @return RequestConfig
     */
    fun getKeywordsByUserRequestConfig(userId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/keyword/byUser/{userId}".replace(
                "{" + "userId" + "}",
                URLEncoder.encode(userId, Charsets.UTF_8)
            ),
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
    suspend fun modifyKeyword(keywordDto: KeywordDto): KeywordDto {
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
    fun modifyKeywordRequestConfig(keywordDto: KeywordDto): RequestConfig<KeywordDto> {
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
            body = localVariableBody
        )
    }

}
