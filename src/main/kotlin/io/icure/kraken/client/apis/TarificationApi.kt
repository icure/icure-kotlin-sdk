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
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.PaginatedListTarificationDto
import io.icure.kraken.client.models.TarificationDto

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

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class TarificationApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create a Tarification
    * Type, Tarification and Version are required.
    * @param tarificationDto
    * @return TarificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createTarification(tarificationDto: TarificationDto) : TarificationDto  {
        val localVariableConfig = createTarificationRequestConfig(tarificationDto = tarificationDto)

        return request<TarificationDto, TarificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createTarification
    *
    * @param tarificationDto
    * @return RequestConfig
    */
    fun createTarificationRequestConfig(tarificationDto: TarificationDto) : RequestConfig<TarificationDto> {
        // val localVariableBody = tarificationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = tarificationDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/tarification",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Finding tarifications by tarification, type and version with pagination.
    * Returns a list of tarifications matched with given input.
    * @param region  (optional)
    * @param type  (optional)
    * @param tarification  (optional)
    * @param version  (optional)
    * @param startDocumentId A tarification document ID (optional)
    * @param startKey  (optional)
    * @param limit Number of rows (optional)
    * @return PaginatedListTarificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findTarificationsBy(region: kotlin.String?, type: kotlin.String?, tarification: kotlin.String?, version: kotlin.String?, startDocumentId: kotlin.String?, startKey: kotlin.String?, limit: kotlin.Int?) : PaginatedListTarificationDto  {
        val localVariableConfig = findTarificationsByRequestConfig(region = region, type = type, tarification = tarification, version = version, startDocumentId = startDocumentId, startKey = startKey, limit = limit)

        return request<Unit, PaginatedListTarificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation findTarificationsBy
    *
    * @param region  (optional)
    * @param type  (optional)
    * @param tarification  (optional)
    * @param version  (optional)
    * @param startDocumentId A tarification document ID (optional)
    * @param startKey  (optional)
    * @param limit Number of rows (optional)
    * @return RequestConfig
    */
    fun findTarificationsByRequestConfig(region: kotlin.String?, type: kotlin.String?, tarification: kotlin.String?, version: kotlin.String?, startDocumentId: kotlin.String?, startKey: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (region != null) {
                    put("region", listOf(region.toString()))
                }
                if (type != null) {
                    put("type", listOf(type.toString()))
                }
                if (tarification != null) {
                    put("tarification", listOf(tarification.toString()))
                }
                if (version != null) {
                    put("version", listOf(version.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/tarification",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Finding tarifications by tarification, type and version
    * Returns a list of tarifications matched with given input.
    * @param region Tarification region (optional)
    * @param type Tarification type (optional)
    * @param tarification Tarification tarification (optional)
    * @param version Tarification version (optional)
    * @return kotlin.collections.List<TarificationDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findTarificationsBy1(region: kotlin.String?, type: kotlin.String?, tarification: kotlin.String?, version: kotlin.String?) : kotlin.collections.List<TarificationDto>  {
        val localVariableConfig = findTarificationsBy1RequestConfig(region = region, type = type, tarification = tarification, version = version)

        return request<Unit, kotlin.collections.List<TarificationDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation findTarificationsBy1
    *
    * @param region Tarification region (optional)
    * @param type Tarification type (optional)
    * @param tarification Tarification tarification (optional)
    * @param version Tarification version (optional)
    * @return RequestConfig
    */
    fun findTarificationsBy1RequestConfig(region: kotlin.String?, type: kotlin.String?, tarification: kotlin.String?, version: kotlin.String?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (region != null) {
                    put("region", listOf(region.toString()))
                }
                if (type != null) {
                    put("type", listOf(type.toString()))
                }
                if (tarification != null) {
                    put("tarification", listOf(tarification.toString()))
                }
                if (version != null) {
                    put("version", listOf(version.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/tarification/byRegionTypeTarification",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Finding tarifications by tarification, type and version with pagination.
    * Returns a list of tarifications matched with given input.
    * @param region  (optional)
    * @param types  (optional)
    * @param language  (optional)
    * @param label  (optional)
    * @param startKey  (optional)
    * @param startDocumentId A tarification document ID (optional)
    * @param limit Number of rows (optional)
    * @return PaginatedListTarificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findTarificationsByLabel(region: kotlin.String?, types: kotlin.String?, language: kotlin.String?, label: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?) : PaginatedListTarificationDto  {
        val localVariableConfig = findTarificationsByLabelRequestConfig(region = region, types = types, language = language, label = label, startKey = startKey, startDocumentId = startDocumentId, limit = limit)

        return request<Unit, PaginatedListTarificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation findTarificationsByLabel
    *
    * @param region  (optional)
    * @param types  (optional)
    * @param language  (optional)
    * @param label  (optional)
    * @param startKey  (optional)
    * @param startDocumentId A tarification document ID (optional)
    * @param limit Number of rows (optional)
    * @return RequestConfig
    */
    fun findTarificationsByLabelRequestConfig(region: kotlin.String?, types: kotlin.String?, language: kotlin.String?, label: kotlin.String?, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (region != null) {
                    put("region", listOf(region.toString()))
                }
                if (types != null) {
                    put("types", listOf(types.toString()))
                }
                if (language != null) {
                    put("language", listOf(language.toString()))
                }
                if (label != null) {
                    put("label", listOf(label.toString()))
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
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/tarification/byLabel",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a tarification
    * Get a tarification based on ID or (tarification,type,version) as query strings. (tarification,type,version) is unique.
    * @param tarificationId Tarification id
    * @return TarificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getTarification(tarificationId: kotlin.String) : TarificationDto  {
        val localVariableConfig = getTarificationRequestConfig(tarificationId = tarificationId)

        return request<Unit, TarificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getTarification
    *
    * @param tarificationId Tarification id
    * @return RequestConfig
    */
    fun getTarificationRequestConfig(tarificationId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/tarification/{tarificationId}".replace("{"+"tarificationId"+"}", "${URLEncoder.encode(tarificationId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a tarification
    * Get a tarification based on ID or (tarification,type,version) as query strings. (tarification,type,version) is unique.
    * @param type Tarification type
    * @param tarification Tarification tarification
    * @param version Tarification version
    * @return TarificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getTarificationWithParts(type: kotlin.String, tarification: kotlin.String, version: kotlin.String) : TarificationDto  {
        val localVariableConfig = getTarificationWithPartsRequestConfig(type = type, tarification = tarification, version = version)

        return request<Unit, TarificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getTarificationWithParts
    *
    * @param type Tarification type
    * @param tarification Tarification tarification
    * @param version Tarification version
    * @return RequestConfig
    */
    fun getTarificationWithPartsRequestConfig(type: kotlin.String, tarification: kotlin.String, version: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/tarification/{type}/{tarification}/{version}".replace("{"+"type"+"}", "${URLEncoder.encode(type.toString(), Charsets.UTF_8)}").replace("{"+"tarification"+"}", "${URLEncoder.encode(tarification.toString(), Charsets.UTF_8)}").replace("{"+"version"+"}", "${URLEncoder.encode(version.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a list of tarifications by ids
    * Keys must be delimited by coma
    * @param listOfIdsDto
    * @return kotlin.collections.List<TarificationDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getTarifications(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<TarificationDto>  {
        val localVariableConfig = getTarificationsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<TarificationDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getTarifications
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun getTarificationsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/tarification/byIds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modify a tarification
    * Modification of (type, tarification, version) is not allowed.
    * @param tarificationDto
    * @return TarificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyTarification(tarificationDto: TarificationDto) : TarificationDto  {
        val localVariableConfig = modifyTarificationRequestConfig(tarificationDto = tarificationDto)

        return request<TarificationDto, TarificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyTarification
    *
    * @param tarificationDto
    * @return RequestConfig
    */
    fun modifyTarificationRequestConfig(tarificationDto: TarificationDto) : RequestConfig<TarificationDto> {
        // val localVariableBody = tarificationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = tarificationDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/tarification",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
