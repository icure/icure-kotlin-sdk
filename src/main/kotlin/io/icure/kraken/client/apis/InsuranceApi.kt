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
import io.icure.kraken.client.models.InsuranceDto
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

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class InsuranceApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "http://localhost:16043")
        }
    }

    /**
    * Creates an insurance
    * 
    * @param insuranceDto  
    * @return InsuranceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createInsurance(insuranceDto: InsuranceDto) : InsuranceDto  {
        val localVariableConfig = createInsuranceRequestConfig(insuranceDto = insuranceDto)

        return request<InsuranceDto, InsuranceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createInsurance
    *
    * @param insuranceDto  
    * @return RequestConfig
    */
    fun createInsuranceRequestConfig(insuranceDto: InsuranceDto) : RequestConfig<InsuranceDto> {
        // val localVariableBody = insuranceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = insuranceDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/insurance",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Deletes an insurance
    * 
    * @param insuranceId  
    * @return DocIdentifier
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteInsurance(insuranceId: kotlin.String) : DocIdentifier  {
        val localVariableConfig = deleteInsuranceRequestConfig(insuranceId = insuranceId)

        return request<Unit, DocIdentifier>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteInsurance
    *
    * @param insuranceId  
    * @return RequestConfig
    */
    fun deleteInsuranceRequestConfig(insuranceId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v2/insurance/{insuranceId}".replace("{"+"insuranceId"+"}", "$insuranceId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets an insurance
    * 
    * @param insuranceId  
    * @return InsuranceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getInsurance(insuranceId: kotlin.String) : InsuranceDto  {
        val localVariableConfig = getInsuranceRequestConfig(insuranceId = insuranceId)

        return request<Unit, InsuranceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getInsurance
    *
    * @param insuranceId  
    * @return RequestConfig
    */
    fun getInsuranceRequestConfig(insuranceId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/insurance/{insuranceId}".replace("{"+"insuranceId"+"}", "$insuranceId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets insurances by id
    * 
    * @param listOfIdsDto  
    * @return kotlin.collections.List<InsuranceDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getInsurances(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<InsuranceDto>  {
        val localVariableConfig = getInsurancesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<InsuranceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getInsurances
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun getInsurancesRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/insurance/byIds",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets an insurance
    * 
    * @param insuranceCode  
    * @return kotlin.collections.List<InsuranceDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listInsurancesByCode(insuranceCode: kotlin.String) : kotlin.collections.List<InsuranceDto>  {
        val localVariableConfig = listInsurancesByCodeRequestConfig(insuranceCode = insuranceCode)

        return request<Unit, kotlin.collections.List<InsuranceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listInsurancesByCode
    *
    * @param insuranceCode  
    * @return RequestConfig
    */
    fun listInsurancesByCodeRequestConfig(insuranceCode: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/insurance/byCode/{insuranceCode}".replace("{"+"insuranceCode"+"}", "$insuranceCode"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets an insurance
    * 
    * @param insuranceName  
    * @return kotlin.collections.List<InsuranceDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listInsurancesByName(insuranceName: kotlin.String) : kotlin.collections.List<InsuranceDto>  {
        val localVariableConfig = listInsurancesByNameRequestConfig(insuranceName = insuranceName)

        return request<Unit, kotlin.collections.List<InsuranceDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listInsurancesByName
    *
    * @param insuranceName  
    * @return RequestConfig
    */
    fun listInsurancesByNameRequestConfig(insuranceName: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/insurance/byName/{insuranceName}".replace("{"+"insuranceName"+"}", "$insuranceName"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modifies an insurance
    * 
    * @param insuranceDto  
    * @return InsuranceDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyInsurance(insuranceDto: InsuranceDto) : InsuranceDto  {
        val localVariableConfig = modifyInsuranceRequestConfig(insuranceDto = insuranceDto)

        return request<InsuranceDto, InsuranceDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyInsurance
    *
    * @param insuranceDto  
    * @return RequestConfig
    */
    fun modifyInsuranceRequestConfig(insuranceDto: InsuranceDto) : RequestConfig<InsuranceDto> {
        // val localVariableBody = insuranceDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = insuranceDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/insurance",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
