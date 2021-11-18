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
import io.icure.kraken.client.models.AgendaDto
import io.icure.kraken.client.models.UserDto

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
class AnonymousAccessApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "http://localhost:16043")
        }
    }

    /**
    * Get Availabilities for HCP and agendaId
    * 
    * @param groupId  
    * @param agendaId  
    * @param startDate  
    * @param endDate  
    * @param hcpId  
    * @param duration  
    * @param limit  (optional)
    * @return kotlin.collections.List<kotlin.Long>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getAvailabilitiesByPeriodAndAgendaId(groupId: kotlin.String, agendaId: kotlin.String, startDate: kotlin.Long, endDate: kotlin.Long, hcpId: kotlin.String, duration: kotlin.Long, limit: kotlin.Int?) : kotlin.collections.List<kotlin.Long>  {
        val localVariableConfig = getAvailabilitiesByPeriodAndAgendaIdRequestConfig(groupId = groupId, agendaId = agendaId, startDate = startDate, endDate = endDate, hcpId = hcpId, duration = duration, limit = limit)

        return request<Unit, kotlin.collections.List<kotlin.Long>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getAvailabilitiesByPeriodAndAgendaId
    *
    * @param groupId  
    * @param agendaId  
    * @param startDate  
    * @param endDate  
    * @param hcpId  
    * @param duration  
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun getAvailabilitiesByPeriodAndAgendaIdRequestConfig(groupId: kotlin.String, agendaId: kotlin.String, startDate: kotlin.Long, endDate: kotlin.Long, hcpId: kotlin.String, duration: kotlin.Long, limit: kotlin.Int?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("startDate", listOf(startDate.toString()))
                put("endDate", listOf(endDate.toString()))
                put("hcpId", listOf(hcpId.toString()))
                put("duration", listOf(duration.toString()))
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/aa/available/inGroup/{groupId}/agenda/{agendaId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}").replace("{"+"agendaId"+"}", "${URLEncoder.encode(agendaId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List healthcare parties for a provided group id
    * Returns a list of healthcare parties contained in the group owning the providing id
    * @param groupId Healthcare parties group id 
    * @param userId Healthcare party user id 
    * @return kotlin.collections.List<AgendaDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listAgendasInHealthcareParty(groupId: kotlin.String, userId: kotlin.String) : kotlin.collections.List<AgendaDto>  {
        val localVariableConfig = listAgendasInHealthcarePartyRequestConfig(groupId = groupId, userId = userId)

        return request<Unit, kotlin.collections.List<AgendaDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listAgendasInHealthcareParty
    *
    * @param groupId Healthcare parties group id 
    * @param userId Healthcare party user id 
    * @return RequestConfig
    */
    fun listAgendasInHealthcarePartyRequestConfig(groupId: kotlin.String, userId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/aa/agenda/inGroup/{groupId}/forUser/{userId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}").replace("{"+"userId"+"}", "${URLEncoder.encode(userId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List healthcare parties for a provided group id
    * Returns a list of healthcare parties contained in the group owning the providing id
    * @param groupId Healthcare parties group id 
    * @return kotlin.collections.List<UserDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listHealthcarePartiesInGroup(groupId: kotlin.String) : kotlin.collections.List<UserDto>  {
        val localVariableConfig = listHealthcarePartiesInGroupRequestConfig(groupId = groupId)

        return request<Unit, kotlin.collections.List<UserDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listHealthcarePartiesInGroup
    *
    * @param groupId Healthcare parties group id 
    * @return RequestConfig
    */
    fun listHealthcarePartiesInGroupRequestConfig(groupId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/aa/hcparty/inGroup/{groupId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
