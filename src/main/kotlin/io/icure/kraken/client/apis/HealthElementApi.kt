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
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.FilterChainHealthElement
import io.icure.kraken.client.models.HealthElementDto
import io.icure.kraken.client.models.IcureStubDto
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
class HealthElementApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create a health element with the current user
    * Returns an instance of created health element.
    * @param healthElementDto  
    * @return HealthElementDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createHealthElement(healthElementDto: HealthElementDto) : HealthElementDto  {
        val localVariableConfig = createHealthElementRequestConfig(healthElementDto = healthElementDto)

        return request<HealthElementDto, HealthElementDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createHealthElement
    *
    * @param healthElementDto  
    * @return RequestConfig
    */
    fun createHealthElementRequestConfig(healthElementDto: HealthElementDto) : RequestConfig<HealthElementDto> {
        // val localVariableBody = healthElementDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = healthElementDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Create a batch of healthcare elements
    * Returns the created healthcare elements.
    * @param healthElementDto  
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createHealthElements(healthElementDto: kotlin.collections.List<HealthElementDto>) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = createHealthElementsRequestConfig(healthElementDto = healthElementDto)

        return request<kotlin.collections.List<HealthElementDto>, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createHealthElements
    *
    * @param healthElementDto  
    * @return RequestConfig
    */
    fun createHealthElementsRequestConfig(healthElementDto: kotlin.collections.List<HealthElementDto>) : RequestConfig<kotlin.collections.List<HealthElementDto>> {
        // val localVariableBody = healthElementDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = healthElementDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Delete health elements.
    * Response is a set containing the ID&#39;s of deleted health elements.
    * @param listOfIdsDto  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteHealthElements(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteHealthElementsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteHealthElements
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun deleteHealthElementsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Filter health elements for the current user (HcParty)
    * Returns a list of health elements along with next start keys and Document ID. If the nextStartKey is Null it means that this is the last page.
    * @param filterChainHealthElement  
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun filterHealthElementsBy(filterChainHealthElement: FilterChainHealthElement) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = filterHealthElementsByRequestConfig(filterChainHealthElement = filterChainHealthElement)

        return request<FilterChainHealthElement, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation filterHealthElementsBy
    *
    * @param filterChainHealthElement  
    * @return RequestConfig
    */
    fun filterHealthElementsByRequestConfig(filterChainHealthElement: FilterChainHealthElement) : RequestConfig<FilterChainHealthElement> {
        // val localVariableBody = filterChainHealthElement
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = filterChainHealthElement

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement/filter",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a health element
    * 
    * @param healthElementId  
    * @return HealthElementDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getHealthElement(healthElementId: kotlin.String) : HealthElementDto  {
        val localVariableConfig = getHealthElementRequestConfig(healthElementId = healthElementId)

        return request<Unit, HealthElementDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getHealthElement
    *
    * @param healthElementId  
    * @return RequestConfig
    */
    fun getHealthElementRequestConfig(healthElementId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/helement/{healthElementId}".replace("{"+"healthElementId"+"}", "${URLEncoder.encode(healthElementId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get healthElements by batch
    * Get a list of healthElement by ids/keys.
    * @param listOfIdsDto  
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getHealthElements(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = getHealthElementsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getHealthElements
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun getHealthElementsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement/byIds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List health elements found By Healthcare Party and secret foreign keyelementIds.
    * Keys hast to delimited by coma
    * @param hcPartyId  
    * @param secretFKeys  
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listHealthElementsByHCPartyAndPatientForeignKeys(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = listHealthElementsByHCPartyAndPatientForeignKeysRequestConfig(hcPartyId = hcPartyId, secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listHealthElementsByHCPartyAndPatientForeignKeys
    *
    * @param hcPartyId  
    * @param secretFKeys  
    * @return RequestConfig
    */
    fun listHealthElementsByHCPartyAndPatientForeignKeysRequestConfig(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : RequestConfig<Unit> {
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
            path = "/rest/v2/helement/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List helement stubs found By Healthcare Party and secret foreign keys.
    * Keys must be delimited by coma
    * @param hcPartyId  
    * @param secretFKeys  
    * @return kotlin.collections.List<IcureStubDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeys(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : kotlin.collections.List<IcureStubDto>  {
        val localVariableConfig = listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeysRequestConfig(hcPartyId = hcPartyId, secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<IcureStubDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeys
    *
    * @param hcPartyId  
    * @param secretFKeys  
    * @return RequestConfig
    */
    fun listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeysRequestConfig(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : RequestConfig<Unit> {
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
            path = "/rest/v2/helement/byHcPartySecretForeignKeys/delegations",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modify a health element
    * Returns the modified health element.
    * @param healthElementDto  
    * @return HealthElementDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyHealthElement(healthElementDto: HealthElementDto) : HealthElementDto  {
        val localVariableConfig = modifyHealthElementRequestConfig(healthElementDto = healthElementDto)

        return request<HealthElementDto, HealthElementDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyHealthElement
    *
    * @param healthElementDto  
    * @return RequestConfig
    */
    fun modifyHealthElementRequestConfig(healthElementDto: HealthElementDto) : RequestConfig<HealthElementDto> {
        // val localVariableBody = healthElementDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = healthElementDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/helement",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modify a batch of health elements
    * Returns the modified health elements.
    * @param healthElementDto  
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyHealthElements(healthElementDto: kotlin.collections.List<HealthElementDto>) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = modifyHealthElementsRequestConfig(healthElementDto = healthElementDto)

        return request<kotlin.collections.List<HealthElementDto>, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyHealthElements
    *
    * @param healthElementDto  
    * @return RequestConfig
    */
    fun modifyHealthElementsRequestConfig(healthElementDto: kotlin.collections.List<HealthElementDto>) : RequestConfig<kotlin.collections.List<HealthElementDto>> {
        // val localVariableBody = healthElementDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = healthElementDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/helement/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Delegates a health element to a healthcare party
    * It delegates a health element to a healthcare party (By current healthcare party). Returns the element with new delegations.
    * @param healthElementId  
    * @param delegationDto  
    * @return HealthElementDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun newHealthElementDelegations(healthElementId: kotlin.String, delegationDto: kotlin.collections.List<DelegationDto>) : HealthElementDto  {
        val localVariableConfig = newHealthElementDelegationsRequestConfig(healthElementId = healthElementId, delegationDto = delegationDto)

        return request<kotlin.collections.List<DelegationDto>, HealthElementDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation newHealthElementDelegations
    *
    * @param healthElementId  
    * @param delegationDto  
    * @return RequestConfig
    */
    fun newHealthElementDelegationsRequestConfig(healthElementId: kotlin.String, delegationDto: kotlin.collections.List<DelegationDto>) : RequestConfig<kotlin.collections.List<DelegationDto>> {
        // val localVariableBody = delegationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = delegationDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement/{healthElementId}/delegate".replace("{"+"healthElementId"+"}", "${URLEncoder.encode(healthElementId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Update delegations in healthElements.
    * Keys must be delimited by coma
    * @param icureStubDto  
    * @return kotlin.collections.List<HealthElementDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setHealthElementsDelegations(icureStubDto: kotlin.collections.List<IcureStubDto>) : kotlin.collections.List<HealthElementDto>  {
        val localVariableConfig = setHealthElementsDelegationsRequestConfig(icureStubDto = icureStubDto)

        return request<kotlin.collections.List<IcureStubDto>, kotlin.collections.List<HealthElementDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation setHealthElementsDelegations
    *
    * @param icureStubDto  
    * @return RequestConfig
    */
    fun setHealthElementsDelegationsRequestConfig(icureStubDto: kotlin.collections.List<IcureStubDto>) : RequestConfig<kotlin.collections.List<IcureStubDto>> {
        // val localVariableBody = icureStubDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = icureStubDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/helement/delegations",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
