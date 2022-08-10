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
import io.icure.kraken.client.models.TimeTableDto

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
class TimeTableApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Creates a timeTable
    *
    * @param timeTableDto
    * @return TimeTableDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createTimeTable(timeTableDto: TimeTableDto) : TimeTableDto  {
        val localVariableConfig = createTimeTableRequestConfig(timeTableDto = timeTableDto)

        return request<TimeTableDto, TimeTableDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createTimeTable
    *
    * @param timeTableDto
    * @return RequestConfig
    */
    fun createTimeTableRequestConfig(timeTableDto: TimeTableDto) : RequestConfig<TimeTableDto> {
        // val localVariableBody = timeTableDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = timeTableDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/timeTable",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Deletes an timeTable
    *
    * @param listOfIdsDto
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteTimeTable(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteTimeTableRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteTimeTable
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun deleteTimeTableRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/timeTable/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets a timeTable
    *
    * @param timeTableId
    * @return TimeTableDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getTimeTable(timeTableId: kotlin.String) : TimeTableDto  {
        val localVariableConfig = getTimeTableRequestConfig(timeTableId = timeTableId)

        return request<Unit, TimeTableDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getTimeTable
    *
    * @param timeTableId
    * @return RequestConfig
    */
    fun getTimeTableRequestConfig(timeTableId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/timeTable/{timeTableId}".replace("{"+"timeTableId"+"}", "${URLEncoder.encode(timeTableId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get TimeTables by AgendaId
    *
    * @param agendaId
    * @return kotlin.collections.List<TimeTableDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getTimeTablesByAgendaId(agendaId: kotlin.String) : kotlin.collections.List<TimeTableDto>  {
        val localVariableConfig = getTimeTablesByAgendaIdRequestConfig(agendaId = agendaId)

        return request<Unit, kotlin.collections.List<TimeTableDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getTimeTablesByAgendaId
    *
    * @param agendaId
    * @return RequestConfig
    */
    fun getTimeTablesByAgendaIdRequestConfig(agendaId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("agendaId", listOf(agendaId.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/timeTable/byAgendaId",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get TimeTables by Period and AgendaId
    *
    * @param startDate
    * @param endDate
    * @param agendaId
    * @return kotlin.collections.List<TimeTableDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getTimeTablesByPeriodAndAgendaId(startDate: kotlin.Long, endDate: kotlin.Long, agendaId: kotlin.String) : kotlin.collections.List<TimeTableDto>  {
        val localVariableConfig = getTimeTablesByPeriodAndAgendaIdRequestConfig(startDate = startDate, endDate = endDate, agendaId = agendaId)

        return request<Unit, kotlin.collections.List<TimeTableDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getTimeTablesByPeriodAndAgendaId
    *
    * @param startDate
    * @param endDate
    * @param agendaId
    * @return RequestConfig
    */
    fun getTimeTablesByPeriodAndAgendaIdRequestConfig(startDate: kotlin.Long, endDate: kotlin.Long, agendaId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("startDate", listOf(startDate.toString()))
                put("endDate", listOf(endDate.toString()))
                put("agendaId", listOf(agendaId.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/timeTable/byPeriodAndAgendaId",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modifies an timeTable
    *
    * @param timeTableDto
    * @return TimeTableDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyTimeTable(timeTableDto: TimeTableDto) : TimeTableDto  {
        val localVariableConfig = modifyTimeTableRequestConfig(timeTableDto = timeTableDto)

        return request<TimeTableDto, TimeTableDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyTimeTable
    *
    * @param timeTableDto
    * @return RequestConfig
    */
    fun modifyTimeTableRequestConfig(timeTableDto: TimeTableDto) : RequestConfig<TimeTableDto> {
        // val localVariableBody = timeTableDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = timeTableDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/timeTable",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
