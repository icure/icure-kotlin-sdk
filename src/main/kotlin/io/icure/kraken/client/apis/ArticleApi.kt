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
import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.models.ArticleDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.ListOfIdsDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.net.URLEncoder
import java.util.*
import javax.inject.Named
/* ktlint-enable no-wildcard-imports */

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class ArticleApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
     * Creates a article
     *
     * @param articleDto
     * @return ArticleDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createArticle(articleDto: ArticleDto): ArticleDto {
        val localVariableConfig = createArticleRequestConfig(articleDto = articleDto)

        return request<ArticleDto, ArticleDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createArticle
     *
     * @param articleDto
     * @return RequestConfig
     */
    fun createArticleRequestConfig(articleDto: ArticleDto): RequestConfig<ArticleDto> {
        // val localVariableBody = articleDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = articleDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/article",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Deletes articles
     *
     * @param listOfIdsDto
     * @return kotlin.collections.List<DocIdentifier>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteArticles(listOfIdsDto: ListOfIdsDto): kotlin.collections.List<DocIdentifier> {
        val localVariableConfig = deleteArticlesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteArticles
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun deleteArticlesRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/article/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Gets an article
     *
     * @param articleId
     * @return ArticleDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getArticle(articleId: kotlin.String): ArticleDto {
        val localVariableConfig = getArticleRequestConfig(articleId = articleId)

        return request<Unit, ArticleDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getArticle
     *
     * @param articleId
     * @return RequestConfig
     */
    fun getArticleRequestConfig(articleId: kotlin.String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/article/{articleId}".replace("{" + "articleId" + "}", "${URLEncoder.encode(articleId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Gets all articles
     *
     * @return kotlin.collections.List<ArticleDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getArticles(): kotlin.collections.List<ArticleDto> {
        val localVariableConfig = getArticlesRequestConfig()

        return request<Unit, kotlin.collections.List<ArticleDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getArticles
     *
     * @return RequestConfig
     */
    fun getArticlesRequestConfig(): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/article",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Modifies an article
     *
     * @param articleDto
     * @return ArticleDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyArticle(articleDto: ArticleDto): ArticleDto {
        val localVariableConfig = modifyArticleRequestConfig(articleDto = articleDto)

        return request<ArticleDto, ArticleDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation modifyArticle
     *
     * @param articleDto
     * @return RequestConfig
     */
    fun modifyArticleRequestConfig(articleDto: ArticleDto): RequestConfig<ArticleDto> {
        // val localVariableBody = articleDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = articleDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/article",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }
}
