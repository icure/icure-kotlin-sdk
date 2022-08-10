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

import io.icure.kraken.client.models.DeviceDto
import io.icure.kraken.client.models.DocIdentifier

import io.icure.kraken.client.models.IdWithRevDto
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.PaginatedListDeviceDto

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
class DeviceApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
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
    suspend fun createDevice(deviceDto: DeviceDto) : DeviceDto  {
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
    fun createDeviceRequestConfig(deviceDto: DeviceDto) : RequestConfig<DeviceDto> {
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
            body = localVariableBody        )
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
    suspend fun createDeviceInGroup(groupId: kotlin.String, deviceDto: DeviceDto) : DeviceDto  {
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
    fun createDeviceInGroupRequestConfig(groupId: kotlin.String, deviceDto: DeviceDto) : RequestConfig<DeviceDto> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/inGroup/{groupId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun createDevices(deviceDto: kotlin.collections.List<DeviceDto>) : kotlin.collections.List<IdWithRevDto>  {
        val localVariableConfig = createDevicesRequestConfig(deviceDto = deviceDto)

        return request<kotlin.collections.List<DeviceDto>, kotlin.collections.List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createDevices
    *
    * @param deviceDto
    * @return RequestConfig
    */
    fun createDevicesRequestConfig(deviceDto: kotlin.collections.List<DeviceDto>) : RequestConfig<kotlin.collections.List<DeviceDto>> {
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
            body = localVariableBody        )
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
    suspend fun createDevices1(deviceDto: kotlin.collections.List<DeviceDto>) : kotlin.collections.List<IdWithRevDto>  {
        val localVariableConfig = createDevices1RequestConfig(deviceDto = deviceDto)

        return request<kotlin.collections.List<DeviceDto>, kotlin.collections.List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createDevices1
    *
    * @param deviceDto
    * @return RequestConfig
    */
    fun createDevices1RequestConfig(deviceDto: kotlin.collections.List<DeviceDto>) : RequestConfig<kotlin.collections.List<DeviceDto>> {
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
            body = localVariableBody        )
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
    suspend fun deleteDevice(deviceId: kotlin.String) : DocIdentifier  {
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
    fun deleteDeviceRequestConfig(deviceId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v2/device/{deviceId}".replace("{"+"deviceId"+"}", "${URLEncoder.encode(deviceId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun deleteDevices(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteDevicesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteDevices
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun deleteDevicesRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
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
            body = localVariableBody        )
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
    suspend fun deleteDevicesInGroup(groupId: kotlin.String, deviceIds: kotlin.String) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteDevicesInGroupRequestConfig(groupId = groupId, deviceIds = deviceIds)

        return request<Unit, kotlin.collections.List<DocIdentifier>>(
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
    fun deleteDevicesInGroupRequestConfig(groupId: kotlin.String, deviceIds: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v2/device/inGroup/{groupId}/{deviceIds}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}").replace("{"+"deviceIds"+"}", "${URLEncoder.encode(deviceIds.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun filterDevicesBy(filterChainDevice: io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.DeviceDto>, startDocumentId: kotlin.String?, limit: kotlin.Int?) : PaginatedListDeviceDto  {
        val localVariableConfig = filterDevicesByRequestConfig(filterChainDevice = filterChainDevice, startDocumentId = startDocumentId, limit = limit)

        return request<io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.DeviceDto>, PaginatedListDeviceDto>(
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
    fun filterDevicesByRequestConfig(filterChainDevice: io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.DeviceDto>, startDocumentId: kotlin.String?, limit: kotlin.Int?) : RequestConfig<io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.DeviceDto>> {
        // val localVariableBody = filterChainDevice
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
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
            body = localVariableBody        )
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
    suspend fun getDevice(deviceId: kotlin.String) : DeviceDto  {
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
    fun getDeviceRequestConfig(deviceId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/device/{deviceId}".replace("{"+"deviceId"+"}", "${URLEncoder.encode(deviceId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun getDeviceAesExchangeKeysForDelegate(deviceId: kotlin.String) : kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>>  {
        val localVariableConfig = getDeviceAesExchangeKeysForDelegateRequestConfig(deviceId = deviceId)

        return request<Unit, kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.collections.Map<kotlin.String, kotlin.String>>>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getDeviceAesExchangeKeysForDelegate
    *
    * @param deviceId
    * @return RequestConfig
    */
    fun getDeviceAesExchangeKeysForDelegateRequestConfig(deviceId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/device/{deviceId}/aesExchangeKeys".replace("{"+"deviceId"+"}", "${URLEncoder.encode(deviceId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun getDevices(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DeviceDto>  {
        val localVariableConfig = getDevicesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DeviceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getDevices
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun getDevicesRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
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
            body = localVariableBody        )
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
    suspend fun getDevicesInGroup(groupId: kotlin.String, listOfIdsDto: ListOfIdsDto?) : kotlin.collections.List<DeviceDto>  {
        val localVariableConfig = getDevicesInGroupRequestConfig(groupId = groupId, listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DeviceDto>>(
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
    fun getDevicesInGroupRequestConfig(groupId: kotlin.String, listOfIdsDto: ListOfIdsDto?) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/device/inGroup/{groupId}/byIds".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun matchDevicesBy(abstractFilterDtoDevice: io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.DeviceDto>) : kotlin.collections.List<kotlin.String>  {
        val localVariableConfig = matchDevicesByRequestConfig(abstractFilterDtoDevice = abstractFilterDtoDevice)

        return request<io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.DeviceDto>, kotlin.collections.List<kotlin.String>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation matchDevicesBy
    *
    * @param abstractFilterDtoDevice
    * @return RequestConfig
    */
    fun matchDevicesByRequestConfig(abstractFilterDtoDevice: io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.DeviceDto>) : RequestConfig<io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.DeviceDto>> {
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
            body = localVariableBody        )
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
    suspend fun modifyDeviceInGroup(groupId: kotlin.String, deviceDto: DeviceDto) : DeviceDto  {
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
    fun modifyDeviceInGroupRequestConfig(groupId: kotlin.String, deviceDto: DeviceDto) : RequestConfig<DeviceDto> {
        // val localVariableBody = deviceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = deviceDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/device/inGroup/{groupId}".replace("{"+"groupId"+"}", "${URLEncoder.encode(groupId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
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
    suspend fun updateDevice(deviceDto: DeviceDto) : DeviceDto  {
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
    fun updateDeviceRequestConfig(deviceDto: DeviceDto) : RequestConfig<DeviceDto> {
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
            body = localVariableBody        )
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
    suspend fun updateDevices(deviceDto: kotlin.collections.List<DeviceDto>) : kotlin.collections.List<IdWithRevDto>  {
        val localVariableConfig = updateDevicesRequestConfig(deviceDto = deviceDto)

        return request<kotlin.collections.List<DeviceDto>, kotlin.collections.List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation updateDevices
    *
    * @param deviceDto
    * @return RequestConfig
    */
    fun updateDevicesRequestConfig(deviceDto: kotlin.collections.List<DeviceDto>) : RequestConfig<kotlin.collections.List<DeviceDto>> {
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
            body = localVariableBody        )
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
    suspend fun updateDevices1(deviceDto: kotlin.collections.List<DeviceDto>) : kotlin.collections.List<IdWithRevDto>  {
        val localVariableConfig = updateDevices1RequestConfig(deviceDto = deviceDto)

        return request<kotlin.collections.List<DeviceDto>, kotlin.collections.List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation updateDevices1
    *
    * @param deviceDto
    * @return RequestConfig
    */
    fun updateDevices1RequestConfig(deviceDto: kotlin.collections.List<DeviceDto>) : RequestConfig<kotlin.collections.List<DeviceDto>> {
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
            body = localVariableBody        )
    }

}
