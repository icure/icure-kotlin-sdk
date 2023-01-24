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
import io.icure.kraken.client.models.ClassificationDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.IcureStubDto
import io.icure.kraken.client.models.ListOfIdsDto

import kotlinx.coroutines.ExperimentalCoroutinesApi

import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.flow.flowOf
import java.nio.ByteBuffer
import java.util.*
import javax.inject.Named
import kotlinx.coroutines.flow.Flow
import java.net.URLEncoder

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class ClassificationApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authProvider: AuthProvider = NoAuthProvider()) : ApiClient(basePath, webClient, authProvider) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create a classification with the current user
    * Returns an instance of created classification Template.
    * @param classificationDto  
    * @return ClassificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createClassification(classificationDto: ClassificationDto) : ClassificationDto  {
        val localVariableConfig = createClassificationRequestConfig(classificationDto = classificationDto)

        return request<ClassificationDto, ClassificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createClassification
    *
    * @param classificationDto  
    * @return RequestConfig
    */
    fun createClassificationRequestConfig(classificationDto: ClassificationDto) : RequestConfig<ClassificationDto> {
        // val localVariableBody = classificationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = classificationDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/classification",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Delete classification Templates.
    * Response is a set containing the ID&#39;s of deleted classification Templates.
    * @param listOfIdsDto  
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteClassifications(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteClassificationsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteClassifications
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun deleteClassificationsRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/classification/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List classification Templates found By Healthcare Party and secret foreign keyelementIds.
    * Keys hast to delimited by coma
    * @param hcPartyId  
    * @param secretFKeys  
    * @return kotlin.collections.List<ClassificationDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findClassificationsByHCPartyPatientForeignKeys(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : kotlin.collections.List<ClassificationDto>  {
        val localVariableConfig = findClassificationsByHCPartyPatientForeignKeysRequestConfig(hcPartyId = hcPartyId, secretFKeys = secretFKeys)

        return request<Unit, kotlin.collections.List<ClassificationDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation findClassificationsByHCPartyPatientForeignKeys
    *
    * @param hcPartyId  
    * @param secretFKeys  
    * @return RequestConfig
    */
    fun findClassificationsByHCPartyPatientForeignKeysRequestConfig(hcPartyId: kotlin.String, secretFKeys: kotlin.String) : RequestConfig<Unit> {
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
            path = "/rest/v2/classification/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a classification Template
    * 
    * @param classificationId  
    * @return ClassificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getClassification(classificationId: kotlin.String) : ClassificationDto  {
        val localVariableConfig = getClassificationRequestConfig(classificationId = classificationId)

        return request<Unit, ClassificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getClassification
    *
    * @param classificationId  
    * @return RequestConfig
    */
    fun getClassificationRequestConfig(classificationId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/classification/{classificationId}".replace("{"+"classificationId"+"}", "${URLEncoder.encode(classificationId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a list of classifications
    * Ids are seperated by a coma
    * @param ids  
    * @return kotlin.collections.List<ClassificationDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getClassificationByHcPartyId(ids: kotlin.String) : kotlin.collections.List<ClassificationDto>  {
        val localVariableConfig = getClassificationByHcPartyIdRequestConfig(ids = ids)

        return request<Unit, kotlin.collections.List<ClassificationDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getClassificationByHcPartyId
    *
    * @param ids  
    * @return RequestConfig
    */
    fun getClassificationByHcPartyIdRequestConfig(ids: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/classification/byIds/{ids}".replace("{"+"ids"+"}", "${URLEncoder.encode(ids.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modify a classification Template
    * Returns the modified classification Template.
    * @param classificationDto  
    * @return ClassificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyClassification(classificationDto: ClassificationDto) : ClassificationDto  {
        val localVariableConfig = modifyClassificationRequestConfig(classificationDto = classificationDto)

        return request<ClassificationDto, ClassificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyClassification
    *
    * @param classificationDto  
    * @return RequestConfig
    */
    fun modifyClassificationRequestConfig(classificationDto: ClassificationDto) : RequestConfig<ClassificationDto> {
        // val localVariableBody = classificationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = classificationDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/classification",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Delegates a classification to a healthcare party
    * It delegates a classification to a healthcare party (By current healthcare party). Returns the element with new delegations.
    * @param classificationId  
    * @param delegationDto  
    * @return ClassificationDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun newClassificationDelegations(classificationId: kotlin.String, delegationDto: kotlin.collections.List<DelegationDto>) : ClassificationDto  {
        val localVariableConfig = newClassificationDelegationsRequestConfig(classificationId = classificationId, delegationDto = delegationDto)

        return request<kotlin.collections.List<DelegationDto>, ClassificationDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation newClassificationDelegations
    *
    * @param classificationId  
    * @param delegationDto  
    * @return RequestConfig
    */
    fun newClassificationDelegationsRequestConfig(classificationId: kotlin.String, delegationDto: kotlin.collections.List<DelegationDto>) : RequestConfig<kotlin.collections.List<DelegationDto>> {
        // val localVariableBody = delegationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = delegationDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/classification/{classificationId}/delegate".replace("{"+"classificationId"+"}", "${URLEncoder.encode(classificationId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Update delegations in classification
    * Keys must be delimited by coma
    * @param icureStubDto  
    * @return kotlin.collections.List<IcureStubDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setClassificationsDelegations(icureStubDto: kotlin.collections.List<IcureStubDto>) : kotlin.collections.List<IcureStubDto>  {
        val localVariableConfig = setClassificationsDelegationsRequestConfig(icureStubDto = icureStubDto)

        return request<kotlin.collections.List<IcureStubDto>, kotlin.collections.List<IcureStubDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation setClassificationsDelegations
    *
    * @param icureStubDto  
    * @return RequestConfig
    */
    fun setClassificationsDelegationsRequestConfig(icureStubDto: kotlin.collections.List<IcureStubDto>) : RequestConfig<kotlin.collections.List<IcureStubDto>> {
        // val localVariableBody = icureStubDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = icureStubDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/classification/delegations",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
