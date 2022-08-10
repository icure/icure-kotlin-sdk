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
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.PlaceDto

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
class PlaceApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Creates a place
    *
    * @param placeDto
    * @return PlaceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createPlace(placeDto: PlaceDto) : PlaceDto  {
        val localVariableConfig = createPlaceRequestConfig(placeDto = placeDto)

        return request<PlaceDto, PlaceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createPlace
    *
    * @param placeDto
    * @return RequestConfig
    */
    fun createPlaceRequestConfig(placeDto: PlaceDto) : RequestConfig<PlaceDto> {
        // val localVariableBody = placeDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = placeDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/place",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Deletes places
    *
    * @param listOfIdsDto
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deletePlaces(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deletePlacesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deletePlaces
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun deletePlacesRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/place/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets an place
    *
    * @param placeId
    * @return PlaceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getPlace(placeId: kotlin.String) : PlaceDto  {
        val localVariableConfig = getPlaceRequestConfig(placeId = placeId)

        return request<Unit, PlaceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getPlace
    *
    * @param placeId
    * @return RequestConfig
    */
    fun getPlaceRequestConfig(placeId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/place/{placeId}".replace("{"+"placeId"+"}", "${URLEncoder.encode(placeId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets all places
    *
    * @return kotlin.collections.List<PlaceDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getPlaces() : kotlin.collections.List<PlaceDto>  {
        val localVariableConfig = getPlacesRequestConfig()

        return request<Unit, kotlin.collections.List<PlaceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getPlaces
    *
    * @return RequestConfig
    */
    fun getPlacesRequestConfig() : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/place",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modifies an place
    *
    * @param placeDto
    * @return PlaceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyPlace(placeDto: PlaceDto) : PlaceDto  {
        val localVariableConfig = modifyPlaceRequestConfig(placeDto = placeDto)

        return request<PlaceDto, PlaceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyPlace
    *
    * @param placeDto
    * @return RequestConfig
    */
    fun modifyPlaceRequestConfig(placeDto: PlaceDto) : RequestConfig<PlaceDto> {
        // val localVariableBody = placeDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = placeDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/place",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
