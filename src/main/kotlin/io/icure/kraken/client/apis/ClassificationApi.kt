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
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import io.icure.kraken.client.models.DocIdentifier
import org.taktik.icure.services.external.rest.v2.dto.IcureStubDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.ClassificationDto
import java.net.URLEncoder
import java.util.*
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class ClassificationApi(
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
    suspend fun createClassification(classificationDto: ClassificationDto): ClassificationDto {
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
    fun createClassificationRequestConfig(classificationDto: ClassificationDto): RequestConfig<ClassificationDto> {
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
            body = localVariableBody
        )
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
    suspend fun deleteClassifications(listOfIdsDto: ListOfIdsDto): List<DocIdentifier> {
        val localVariableConfig = deleteClassificationsRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, List<DocIdentifier>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation deleteClassifications
     *
     * @param listOfIdsDto
     * @return RequestConfig
     */
    fun deleteClassificationsRequestConfig(listOfIdsDto: ListOfIdsDto): RequestConfig<ListOfIdsDto> {
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
            body = localVariableBody
        )
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
    suspend fun findClassificationsByHCPartyPatientForeignKeys(
        hcPartyId: String,
        secretFKeys: String
    ): List<ClassificationDto> {
        val localVariableConfig = findClassificationsByHCPartyPatientForeignKeysRequestConfig(
            hcPartyId = hcPartyId,
            secretFKeys = secretFKeys
        )

        return request<Unit, List<ClassificationDto>>(
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
    fun findClassificationsByHCPartyPatientForeignKeysRequestConfig(
        hcPartyId: String,
        secretFKeys: String
    ): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<String, List<String>>()
            .apply {
                put("hcPartyId", listOf(hcPartyId))
                put("secretFKeys", listOf(secretFKeys))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/classification/byHcPartySecretForeignKeys",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
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
    suspend fun getClassification(classificationId: String): ClassificationDto {
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
    fun getClassificationRequestConfig(classificationId: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/classification/{classificationId}".replace(
                "{" + "classificationId" + "}",
                URLEncoder.encode(classificationId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
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
    suspend fun getClassificationByHcPartyId(ids: String): List<ClassificationDto> {
        val localVariableConfig = getClassificationByHcPartyIdRequestConfig(ids = ids)

        return request<Unit, List<ClassificationDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation getClassificationByHcPartyId
     *
     * @param ids
     * @return RequestConfig
     */
    fun getClassificationByHcPartyIdRequestConfig(ids: String): RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/classification/byIds/{ids}".replace(
                "{" + "ids" + "}",
                URLEncoder.encode(ids, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
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
    suspend fun modifyClassification(classificationDto: ClassificationDto): ClassificationDto {
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
    fun modifyClassificationRequestConfig(classificationDto: ClassificationDto): RequestConfig<ClassificationDto> {
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
            body = localVariableBody
        )
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
    suspend fun newClassificationDelegations(
        classificationId: String,
        delegationDto: List<DelegationDto>
    ): ClassificationDto {
        val localVariableConfig = newClassificationDelegationsRequestConfig(
            classificationId = classificationId,
            delegationDto = delegationDto
        )

        return request<List<DelegationDto>, ClassificationDto>(
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
    fun newClassificationDelegationsRequestConfig(
        classificationId: String,
        delegationDto: List<DelegationDto>
    ): RequestConfig<List<DelegationDto>> {
        // val localVariableBody = delegationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = delegationDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/classification/{classificationId}/delegate".replace(
                "{" + "classificationId" + "}",
                URLEncoder.encode(classificationId, Charsets.UTF_8)
            ),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
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
    suspend fun setClassificationsDelegations(icureStubDto: List<IcureStubDto>): List<IcureStubDto> {
        val localVariableConfig = setClassificationsDelegationsRequestConfig(icureStubDto = icureStubDto)

        return request<List<IcureStubDto>, List<IcureStubDto>>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation setClassificationsDelegations
     *
     * @param icureStubDto
     * @return RequestConfig
     */
    fun setClassificationsDelegationsRequestConfig(icureStubDto: List<IcureStubDto>): RequestConfig<List<IcureStubDto>> {
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
            body = localVariableBody
        )
    }

}
