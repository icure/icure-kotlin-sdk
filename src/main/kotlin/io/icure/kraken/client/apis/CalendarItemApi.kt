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
import io.icure.kraken.client.models.CalendarItemDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.IcureStubDto
import io.icure.kraken.client.models.ListOfIdsDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.net.URLEncoder
import java.util.*
import javax.inject.Named
/* ktlint-enable no-wildcard-imports */

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class CalendarItemApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
     * Creates a calendarItem
     *
     * @param calendarItemDto
     * @return CalendarItemDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createCalendarItem(calendarItemDto: CalendarItemDto): CalendarItemDto {
        val localVariableConfig = createCalendarItemRequestConfig(calendarItemDto = calendarItemDto)

        return request<CalendarItemDto, CalendarItemDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createCalendarItem
     *
     * @param calendarItemDto
     * @return RequestConfig
     */
    fun createCalendarItemRequestConfig(calendarItemDto: CalendarItemDto): RequestConfig<CalendarItemDto> {
        // val localVariableBody = calendarItemDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = calendarItemDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/calendarItem",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Deletes an calendarItem
     *
     * @param calendarItemIds
     * @return kotlin.collections.List<DocIdentifier>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    @Deprecated(message = "This operation is deprecated.")
    suspend fun deleteCalendarItem(calendarItemIds: kotlin.String): kotlin.collections.List<DocIdentifier> {
        @Suppress("DEPRECATION")
        val localVariableConfig = deleteCalendarItemRequestConfig(calendarItemIds = calendarItemIds)

        return request<Unit, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteCalendarItem
     *
     * @param calendarItemIds
     * @return RequestConfig
     */
    @Deprecated(message = "This operation is deprecated.")
    fun deleteCalendarItemRequestConfig(calendarItemIds: kotlin.String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/calendarItem/{calendarItemIds}".replace("{" + "calendarItemIds" + "}", "${URLEncoder.encode(calendarItemIds.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Deletes calendarItems
     *
     * @param listOfIdsDto
     * @return kotlin.collections.List<DocIdentifier>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteCalendarItems(listOfIdsDto: ListOfIdsDto): kotlin.collections.List<DocIdentifier> {
        val localVariableConfig = deleteCalendarItemsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteCalendarItems
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun deleteCalendarItemsRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/calendarItem/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Find CalendarItems by hcparty and patient
     *
     * @param hcPartyId
     * @param secretFKeys
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findCalendarItemsByHCPartyPatientForeignKeys(hcPartyId: kotlin.String, secretFKeys: kotlin.String): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = findCalendarItemsByHCPartyPatientForeignKeysRequestConfig(hcPartyId = hcPartyId, secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation findCalendarItemsByHCPartyPatientForeignKeys
     *
     * @param hcPartyId
     * @param secretFKeys
     * @return RequestConfig
     */
    fun findCalendarItemsByHCPartyPatientForeignKeysRequestConfig(hcPartyId: kotlin.String, secretFKeys: kotlin.String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("hcPartyId", listOf(hcPartyId.toString()))
                put("secretFKeys", listOf(secretFKeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/calendarItem/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Find CalendarItems by recurrenceId
     *
     * @param recurrenceId
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findCalendarItemsByRecurrenceId(recurrenceId: kotlin.String): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = findCalendarItemsByRecurrenceIdRequestConfig(recurrenceId = recurrenceId)

        return request<Unit, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation findCalendarItemsByRecurrenceId
     *
     * @param recurrenceId
     * @return RequestConfig
     */
    fun findCalendarItemsByRecurrenceIdRequestConfig(recurrenceId: kotlin.String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("recurrenceId", listOf(recurrenceId.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/calendarItem/byRecurrenceId",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Gets an calendarItem
     *
     * @param calendarItemId
     * @return CalendarItemDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getCalendarItem(calendarItemId: kotlin.String): CalendarItemDto {
        val localVariableConfig = getCalendarItemRequestConfig(calendarItemId = calendarItemId)

        return request<Unit, CalendarItemDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getCalendarItem
     *
     * @param calendarItemId
     * @return RequestConfig
     */
    fun getCalendarItemRequestConfig(calendarItemId: kotlin.String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/calendarItem/{calendarItemId}".replace("{" + "calendarItemId" + "}", "${URLEncoder.encode(calendarItemId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Gets all calendarItems
     *
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getCalendarItems(): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = getCalendarItemsRequestConfig()

        return request<Unit, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getCalendarItems
     *
     * @return RequestConfig
     */
    fun getCalendarItemsRequestConfig(): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/calendarItem",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get CalendarItems by Period and HcPartyId
     *
     * @param startDate
     * @param endDate
     * @param hcPartyId
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getCalendarItemsByPeriodAndHcPartyId(startDate: kotlin.Long, endDate: kotlin.Long, hcPartyId: kotlin.String): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = getCalendarItemsByPeriodAndHcPartyIdRequestConfig(startDate = startDate, endDate = endDate, hcPartyId = hcPartyId)

        return request<Unit, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getCalendarItemsByPeriodAndHcPartyId
     *
     * @param startDate
     * @param endDate
     * @param hcPartyId
     * @return RequestConfig
     */
    fun getCalendarItemsByPeriodAndHcPartyIdRequestConfig(startDate: kotlin.Long, endDate: kotlin.Long, hcPartyId: kotlin.String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("startDate", listOf(startDate.toString()))
                put("endDate", listOf(endDate.toString()))
                put("hcPartyId", listOf(hcPartyId.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/calendarItem/byPeriodAndHcPartyId",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get calendarItems by ids
     *
     * @param listOfIdsDto  (optional)
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getCalendarItemsWithIds(listOfIdsDto: ListOfIdsDto?): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = getCalendarItemsWithIdsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getCalendarItemsWithIds
     *
     * @param listOfIdsDto  (optional)
     * @return RequestConfig
     */
    fun getCalendarItemsWithIdsRequestConfig(listOfIdsDto: ListOfIdsDto?): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/calendarItem/byIds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get CalendarItems by Period and AgendaId
     *
     * @param startDate
     * @param endDate
     * @param agendaId
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getCalendarsByPeriodAndAgendaId(startDate: kotlin.Long, endDate: kotlin.Long, agendaId: kotlin.String): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = getCalendarsByPeriodAndAgendaIdRequestConfig(startDate = startDate, endDate = endDate, agendaId = agendaId)

        return request<Unit, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getCalendarsByPeriodAndAgendaId
     *
     * @param startDate
     * @param endDate
     * @param agendaId
     * @return RequestConfig
     */
    fun getCalendarsByPeriodAndAgendaIdRequestConfig(startDate: kotlin.Long, endDate: kotlin.Long, agendaId: kotlin.String): RequestConfig<Unit> {
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
            path = "/rest/v2/calendarItem/byPeriodAndAgendaId",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Modifies an calendarItem
     *
     * @param calendarItemDto
     * @return CalendarItemDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyCalendarItem(calendarItemDto: CalendarItemDto): CalendarItemDto {
        val localVariableConfig = modifyCalendarItemRequestConfig(calendarItemDto = calendarItemDto)

        return request<CalendarItemDto, CalendarItemDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation modifyCalendarItem
     *
     * @param calendarItemDto
     * @return RequestConfig
     */
    fun modifyCalendarItemRequestConfig(calendarItemDto: CalendarItemDto): RequestConfig<CalendarItemDto> {
        // val localVariableBody = calendarItemDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = calendarItemDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/calendarItem",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Update delegations in calendarItems
     *
     * @param icureStubDto
     * @return kotlin.collections.List<CalendarItemDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setCalendarItemsDelegations(icureStubDto: kotlin.collections.List<IcureStubDto>): kotlin.collections.List<CalendarItemDto> {
        val localVariableConfig = setCalendarItemsDelegationsRequestConfig(icureStubDto = icureStubDto)

        return request<kotlin.collections.List<IcureStubDto>, kotlin.collections.List<CalendarItemDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation setCalendarItemsDelegations
     *
     * @param icureStubDto
     * @return RequestConfig
     */
    fun setCalendarItemsDelegationsRequestConfig(icureStubDto: kotlin.collections.List<IcureStubDto>): RequestConfig<kotlin.collections.List<IcureStubDto>> {
        // val localVariableBody = icureStubDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = icureStubDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/calendarItem/delegations",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }
}
