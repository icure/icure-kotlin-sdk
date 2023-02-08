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
import io.icure.kraken.client.models.PaginatedListDeviceDto
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.DeviceDto
import org.taktik.icure.services.external.rest.v2.dto.IdWithRevDto
import java.net.URLEncoder
import java.util.*
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class DeviceApi(
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
     * Create a device
     * Name, last name, date of birth, and gender are required. After creation of the device and obtaining the ID, you need to create an initial delegation.
     * @param deviceDto
     * @return DeviceDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createDevice(deviceDto: DeviceDto): DeviceDto {
        val localVariableConfig = createDeviceRequestConfig(deviceDto = deviceDto)

        return request<DeviceDto, DeviceDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createDevice
     *
     * @param deviceDto
     * @return RequestConfig
     */
    fun createDeviceRequestConfig(deviceDto: DeviceDto): RequestConfig<DeviceDto> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Create a device
     * One of Name or Last name+First name, Nihii, and Public key are required.
     * @param groupId
     * @param deviceDto
     * @return DeviceDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createDeviceInGroup(groupId: String, deviceDto: DeviceDto): DeviceDto {
        val localVariableConfig = createDeviceInGroupRequestConfig(groupId = groupId, deviceDto = deviceDto)

        return request<DeviceDto, DeviceDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createDeviceInGroup
     *
     * @param groupId
     * @param deviceDto
     * @return RequestConfig
     */
    fun createDeviceInGroupRequestConfig(groupId: String, deviceDto: DeviceDto): RequestConfig<DeviceDto> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/inGroup/{groupId}".replace(
                "{" + "groupId" + "}",
                URLEncoder.encode(groupId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Create devices in bulk
     * Returns the id and _rev of created devices
     * @param deviceDto
     * @return kotlin.collections.List<IdWithRevDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createDevices(deviceDto: List<DeviceDto>): List<IdWithRevDto> {
        val localVariableConfig = createDevicesRequestConfig(deviceDto = deviceDto)

        return request<List<DeviceDto>, List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createDevices
     *
     * @param deviceDto
     * @return RequestConfig
     */
    fun createDevicesRequestConfig(deviceDto: List<DeviceDto>): RequestConfig<List<DeviceDto>> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Create devices in bulk
     * Returns the id and _rev of created devices
     * @param deviceDto
     * @return kotlin.collections.List<IdWithRevDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createDevices1(deviceDto: List<DeviceDto>): List<IdWithRevDto> {
        val localVariableConfig = createDevices1RequestConfig(deviceDto = deviceDto)

        return request<List<DeviceDto>, List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation createDevices1
     *
     * @param deviceDto
     * @return RequestConfig
     */
    fun createDevices1RequestConfig(deviceDto: List<DeviceDto>): RequestConfig<List<DeviceDto>> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/bulk",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Delete device.
     * Response contains the id/rev of deleted device.
     * @param deviceId
     * @return DocIdentifier
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteDevice(deviceId: String): DocIdentifier {
        val localVariableConfig = deleteDeviceRequestConfig(deviceId = deviceId)

        return request<Unit, DocIdentifier>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteDevice
     *
     * @param deviceId
     * @return RequestConfig
     */
    fun deleteDeviceRequestConfig(deviceId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v2/device/{deviceId}".replace(
                "{" + "deviceId" + "}",
                URLEncoder.encode(deviceId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Delete devices.
     * Response is an array containing the id/rev of deleted devices.
     * @param listOfIdsDto
     * @return kotlin.collections.List<DocIdentifier>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteDevices(listOfIdsDto: ListOfIdsDto): List<DocIdentifier> {
        val localVariableConfig = deleteDevicesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteDevices
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun deleteDevicesRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Delete a device
     * Deleting a device. Response is an array containing the id of deleted device.
     * @param groupId
     * @param deviceIds
     * @return kotlin.collections.List<DocIdentifier>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteDevicesInGroup(
        groupId: String,
        deviceIds: String
    ): List<DocIdentifier> {
        val localVariableConfig = deleteDevicesInGroupRequestConfig(groupId = groupId, deviceIds = deviceIds)

        return request<Unit, List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteDevicesInGroup
     *
     * @param groupId
     * @param deviceIds
     * @return RequestConfig
     */
    fun deleteDevicesInGroupRequestConfig(groupId: String, deviceIds: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v2/device/inGroup/{groupId}/{deviceIds}".replace(
                "{" + "groupId" + "}",
                URLEncoder.encode(groupId, Charsets.UTF_8)
            ).replace("{" + "deviceIds" + "}", URLEncoder.encode(deviceIds, Charsets.UTF_8)),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Filter devices for the current user (HcParty)
     * Returns a list of devices along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.
     * @param filterChainDevice
     * @param startDocumentId A device document ID (optional)
     * @param limit Number of rows (optional)
     * @return PaginatedListDeviceDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun filterDevicesBy(
        filterChainDevice: io.icure.kraken.client.models.filter.chain.FilterChain<DeviceDto>,
        startDocumentId: String?,
        limit: Int?
    ): PaginatedListDeviceDto {
        val localVariableConfig = filterDevicesByRequestConfig(
            filterChainDevice = filterChainDevice,
            startDocumentId = startDocumentId,
            limit = limit
        )

        return request<io.icure.kraken.client.models.filter.chain.FilterChain<DeviceDto>, PaginatedListDeviceDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation filterDevicesBy
     *
     * @param filterChainDevice
     * @param startDocumentId A device document ID (optional)
     * @param limit Number of rows (optional)
     * @return RequestConfig
     */
    fun filterDevicesByRequestConfig(
        filterChainDevice: io.icure.kraken.client.models.filter.chain.FilterChain<DeviceDto>,
        startDocumentId: String?,
        limit: Int?
    ): RequestConfig<io.icure.kraken.client.models.filter.chain.FilterChain<DeviceDto>> {
        // val localVariableBody = filterChainDevice
        val localVariableQuery: MultiValueMap = mutableMapOf<String, List<String>>()
            .apply {
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = filterChainDevice

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/filter",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get Device
     * It gets device administrative data.
     * @param deviceId
     * @return DeviceDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getDevice(deviceId: String): DeviceDto {
        val localVariableConfig = getDeviceRequestConfig(deviceId = deviceId)

        return request<Unit, DeviceDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getDevice
     *
     * @param deviceId
     * @return RequestConfig
     */
    fun getDeviceRequestConfig(deviceId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/device/{deviceId}".replace(
                "{" + "deviceId" + "}",
                URLEncoder.encode(deviceId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get the HcParty encrypted AES keys indexed by owner.
     * (key, value) of the map is as follows: (ID of the owner of the encrypted AES key, encrypted AES keys)
     * @param deviceId
     * @return kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getDeviceAesExchangeKeysForDelegate(deviceId: String): Map<String, Map<String, Map<String, String>>> {
        val localVariableConfig = getDeviceAesExchangeKeysForDelegateRequestConfig(deviceId = deviceId)

        return request<Unit, Map<String, Map<String, Map<String, String>>>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getDeviceAesExchangeKeysForDelegate
     *
     * @param deviceId
     * @return RequestConfig
     */
    fun getDeviceAesExchangeKeysForDelegateRequestConfig(deviceId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/device/{deviceId}/aesExchangeKeys".replace(
                "{" + "deviceId" + "}",
                URLEncoder.encode(deviceId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get devices by id
     * It gets device administrative data.
     * @param listOfIdsDto
     * @return kotlin.collections.List<DeviceDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getDevices(listOfIdsDto: ListOfIdsDto): List<DeviceDto> {
        val localVariableConfig = getDevicesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, List<DeviceDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getDevices
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun getDevicesRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/byIds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get devices by their IDs
     * General information about the device
     * @param groupId
     * @param listOfIdsDto  (optional)
     * @return kotlin.collections.List<DeviceDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getDevicesInGroup(
        groupId: String,
        listOfIdsDto: ListOfIdsDto?
    ): List<DeviceDto> {
        val localVariableConfig = getDevicesInGroupRequestConfig(groupId = groupId, listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, List<DeviceDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getDevicesInGroup
     *
     * @param groupId
     * @param listOfIdsDto  (optional)
     * @return RequestConfig
     */
    fun getDevicesInGroupRequestConfig(
        groupId: String,
        listOfIdsDto: ListOfIdsDto?
    ): RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/inGroup/{groupId}/byIds".replace(
                "{" + "groupId" + "}",
                URLEncoder.encode(groupId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Get ids of devices matching the provided filter for the current user (HcParty)
     *
     * @param abstractFilterDtoDevice
     * @return kotlin.collections.List<kotlin.String>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun matchDevicesBy(abstractFilterDtoDevice: io.icure.kraken.client.models.filter.AbstractFilterDto<DeviceDto>): List<String> {
        val localVariableConfig = matchDevicesByRequestConfig(abstractFilterDtoDevice = abstractFilterDtoDevice)

        return request<io.icure.kraken.client.models.filter.AbstractFilterDto<DeviceDto>, List<String>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation matchDevicesBy
     *
     * @param abstractFilterDtoDevice
     * @return RequestConfig
     */
    fun matchDevicesByRequestConfig(abstractFilterDtoDevice: io.icure.kraken.client.models.filter.AbstractFilterDto<DeviceDto>): RequestConfig<io.icure.kraken.client.models.filter.AbstractFilterDto<DeviceDto>> {
        // val localVariableBody = abstractFilterDtoDevice
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = abstractFilterDtoDevice

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/match",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Modify a Device.
     * No particular return value. It&#39;s just a message.
     * @param groupId
     * @param deviceDto
     * @return DeviceDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyDeviceInGroup(groupId: String, deviceDto: DeviceDto): DeviceDto {
        val localVariableConfig = modifyDeviceInGroupRequestConfig(groupId = groupId, deviceDto = deviceDto)

        return request<DeviceDto, DeviceDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation modifyDeviceInGroup
     *
     * @param groupId
     * @param deviceDto
     * @return RequestConfig
     */
    fun modifyDeviceInGroupRequestConfig(groupId: String, deviceDto: DeviceDto): RequestConfig<DeviceDto> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/device/inGroup/{groupId}".replace(
                "{" + "groupId" + "}",
                URLEncoder.encode(groupId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Modify a device
     * Returns the updated device
     * @param deviceDto
     * @return DeviceDto
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun updateDevice(deviceDto: DeviceDto): DeviceDto {
        val localVariableConfig = updateDeviceRequestConfig(deviceDto = deviceDto)

        return request<DeviceDto, DeviceDto>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation updateDevice
     *
     * @param deviceDto
     * @return RequestConfig
     */
    fun updateDeviceRequestConfig(deviceDto: DeviceDto): RequestConfig<DeviceDto> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/device",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Modify devices in bulk
     * Returns the id and _rev of modified devices
     * @param deviceDto
     * @return kotlin.collections.List<IdWithRevDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun updateDevices(deviceDto: List<DeviceDto>): List<IdWithRevDto> {
        val localVariableConfig = updateDevicesRequestConfig(deviceDto = deviceDto)

        return request<List<DeviceDto>, List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation updateDevices
     *
     * @param deviceDto
     * @return RequestConfig
     */
    fun updateDevicesRequestConfig(deviceDto: List<DeviceDto>): RequestConfig<List<DeviceDto>> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/device/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Modify devices in bulk
     * Returns the id and _rev of modified devices
     * @param deviceDto
     * @return kotlin.collections.List<IdWithRevDto>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun updateDevices1(deviceDto: List<DeviceDto>): List<IdWithRevDto> {
        val localVariableConfig = updateDevices1RequestConfig(deviceDto = deviceDto)

        return request<List<DeviceDto>, List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation updateDevices1
     *
     * @param deviceDto
     * @return RequestConfig
     */
    fun updateDevices1RequestConfig(deviceDto: List<DeviceDto>): RequestConfig<List<DeviceDto>> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/device/bulk",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
