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
import io.icure.kraken.client.models.AbstractFilterDtoDevice
import io.icure.kraken.client.models.DeviceDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.FilterChainDevice
import io.icure.kraken.client.models.IdWithRevDto
import io.icure.kraken.client.models.ListOfIdsDto

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
            method = RequestMethod.DELETE,
            path = "/rest/v2/device/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Filter devices for the current user (HcParty) 
    * Returns a list of devices along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.
    * @param filterChainDevice  
    * @param startKey The start key for pagination, depends on the filters used (optional)
    * @param startDocumentId A device document ID (optional)
    * @param limit Number of rows (optional)
    * @param skip Skip rows (optional)
    * @param sort Sort key (optional)
    * @param desc Descending (optional)
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun filterDevicesBy(filterChainDevice: FilterChainDevice, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, skip: kotlin.Int?, sort: kotlin.String?, desc: kotlin.Boolean?) : kotlin.String  {
        val localVariableConfig = filterDevicesByRequestConfig(filterChainDevice = filterChainDevice, startKey = startKey, startDocumentId = startDocumentId, limit = limit, skip = skip, sort = sort, desc = desc)

        return request<FilterChainDevice, kotlin.String>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation filterDevicesBy
    *
    * @param filterChainDevice  
    * @param startKey The start key for pagination, depends on the filters used (optional)
    * @param startDocumentId A device document ID (optional)
    * @param limit Number of rows (optional)
    * @param skip Skip rows (optional)
    * @param sort Sort key (optional)
    * @param desc Descending (optional)
    * @return RequestConfig
    */
    fun filterDevicesByRequestConfig(filterChainDevice: FilterChainDevice, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?, skip: kotlin.Int?, sort: kotlin.String?, desc: kotlin.Boolean?) : RequestConfig<FilterChainDevice> {
        // val localVariableBody = filterChainDevice
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (skip != null) {
                    put("skip", listOf(skip.toString()))
                }
                if (sort != null) {
                    put("sort", listOf(sort.toString()))
                }
                if (desc != null) {
                    put("desc", listOf(desc.toString()))
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
    suspend fun matchDevicesBy(abstractFilterDtoDevice: AbstractFilterDtoDevice) : kotlin.collections.List<kotlin.String>  {
        val localVariableConfig = matchDevicesByRequestConfig(abstractFilterDtoDevice = abstractFilterDtoDevice)

        return request<AbstractFilterDtoDevice, kotlin.collections.List<kotlin.String>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation matchDevicesBy
    *
    * @param abstractFilterDtoDevice  
    * @return RequestConfig
    */
    fun matchDevicesByRequestConfig(abstractFilterDtoDevice: AbstractFilterDtoDevice) : RequestConfig<AbstractFilterDtoDevice> {
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
