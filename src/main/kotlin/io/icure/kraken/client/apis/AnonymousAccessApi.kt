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
import io.icure.kraken.client.models.AppointmentTypeAndPlaceDto
import io.icure.kraken.client.models.UserAndHealthcarePartyDto

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
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Get Availabilities for HCP and appointmentType
    * The start of the slot is returned in YYYYDDMMHHmmss format and only slots belonging to public time tables are returned.
    * @param groupId
    * @param userId
    * @param calendarItemTypeId
    * @param isNewPatient
    * @param startDate
    * @param endDate
    * @param hcpId
    * @param placeId  (optional)
    * @param limit  (optional)
    * @return kotlin.collections.List<kotlin.Long>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getAvailabilitiesByPeriodAndCalendarItemTypeId(groupId: kotlin.String, userId: kotlin.String, calendarItemTypeId: kotlin.String, isNewPatient: kotlin.Boolean, startDate: kotlin.Long, endDate: kotlin.Long, hcpId: kotlin.String, placeId: kotlin.String?, limit: kotlin.Int?) : kotlin.collections.List<kotlin.Long>  {
        val localVariableConfig = getAvailabilitiesByPeriodAndCalendarItemTypeIdRequestConfig(groupId = groupId, userId = userId, calendarItemTypeId = calendarItemTypeId, isNewPatient = isNewPatient, startDate = startDate, endDate = endDate, hcpId = hcpId, placeId = placeId, limit = limit)

        return request<Unit, kotlin.collections.List<kotlin.Long>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getAvailabilitiesByPeriodAndCalendarItemTypeId
    *
    * @param groupId
    * @param userId
    * @param calendarItemTypeId
    * @param isNewPatient
    * @param startDate
    * @param endDate
    * @param hcpId
    * @param placeId  (optional)
    * @param limit  (optional)
    * @return RequestConfig
    */
    fun getAvailabilitiesByPeriodAndCalendarItemTypeIdRequestConfig(groupId: kotlin.String, userId: kotlin.String, calendarItemTypeId: kotlin.String, isNewPatient: kotlin.Boolean, startDate: kotlin.Long, endDate: kotlin.Long, hcpId: kotlin.String, placeId: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("isNewPatient", listOf(isNewPatient.toString()))
                put("startDate", listOf(startDate.toString()))
                put("endDate", listOf(endDate.toString()))
                put("hcpId", listOf(hcpId.toString()))
                if (placeId != null) {
                    put("placeId", listOf(placeId.toString()))
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
            path = "/rest/v2/aa/available/inGroup/{groupId}/forUser/{userId}/type/{calendarItemTypeId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}").replace("{"+"userId"+"}", "${URLEncoder.encode(userId.toString(), Charsets.UTF_8)}").replace("{"+"calendarItemTypeId"+"}", "${URLEncoder.encode(calendarItemTypeId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List Calendar Item types for a provided group id and user id
    * Returns a list of Calendar Item types. In order to be returned, the Calendar Item Type must be linked to a time table enclosed in an Agenda for which an anonymous right has been set (a Right with read permission and null user)
    * @param groupId Healthcare parties group id
    * @param userId Healthcare party user id
    * @param startDate
    * @param endDate
    * @return kotlin.collections.List<AppointmentTypeAndPlaceDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listAppointmentTypesForUser(groupId: kotlin.String, userId: kotlin.String, startDate: kotlin.Long, endDate: kotlin.Long) : kotlin.collections.List<AppointmentTypeAndPlaceDto>  {
        val localVariableConfig = listAppointmentTypesForUserRequestConfig(groupId = groupId, userId = userId, startDate = startDate, endDate = endDate)

        return request<Unit, kotlin.collections.List<AppointmentTypeAndPlaceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listAppointmentTypesForUser
    *
    * @param groupId Healthcare parties group id
    * @param userId Healthcare party user id
    * @param startDate
    * @param endDate
    * @return RequestConfig
    */
    fun listAppointmentTypesForUserRequestConfig(groupId: kotlin.String, userId: kotlin.String, startDate: kotlin.Long, endDate: kotlin.Long) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("startDate", listOf(startDate.toString()))
                put("endDate", listOf(endDate.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/aa/appointmentType/inGroup/{groupId}/forUser/{userId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}").replace("{"+"userId"+"}", "${URLEncoder.encode(userId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List healthcare parties for a provided group id
    * Returns a list of Users/healthcare parties contained in the group owning the providing id. In order to be returned, a healthcare party needs to be linked to a user an this user must have a property &#39;org.taktik.icure.public&#39; set to a boolean true.
    * @param groupId Healthcare parties group id
    * @return kotlin.collections.List<UserAndHealthcarePartyDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listHealthcarePartiesInGroup(groupId: kotlin.String) : kotlin.collections.List<UserAndHealthcarePartyDto>  {
        val localVariableConfig = listHealthcarePartiesInGroupRequestConfig(groupId = groupId)

        return request<Unit, kotlin.collections.List<UserAndHealthcarePartyDto>>(
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
