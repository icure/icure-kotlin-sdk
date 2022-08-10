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
import io.icure.kraken.client.models.ByteArrayDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.DocumentTemplateDto
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
/* ktlint-enable no-wildcard-imports */

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class DocumentTemplateApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create a document template with the current user
    * Returns an instance of created document template.
    * @param documentTemplateDto
    * @return DocumentTemplateDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createDocumentTemplate(documentTemplateDto: DocumentTemplateDto) : DocumentTemplateDto  {
        val localVariableConfig = createDocumentTemplateRequestConfig(documentTemplateDto = documentTemplateDto)

        return request<DocumentTemplateDto, DocumentTemplateDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createDocumentTemplate
    *
    * @param documentTemplateDto
    * @return RequestConfig
    */
    fun createDocumentTemplateRequestConfig(documentTemplateDto: DocumentTemplateDto) : RequestConfig<DocumentTemplateDto> {
        // val localVariableBody = documentTemplateDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = documentTemplateDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/doctemplate",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Deletes document templates
    *
    * @param listOfIdsDto
    * @return kotlin.collections.List<DocIdentifier>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteDocumentTemplates(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<DocIdentifier>  {
        val localVariableConfig = deleteDocumentTemplatesRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<DocIdentifier>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteDocumentTemplates
    *
    * @param listOfIdsDto
    * @return RequestConfig
    */
    fun deleteDocumentTemplatesRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/doctemplate/delete/batch",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Download a the document template attachment
    *
    * @param documentTemplateId
    * @param attachmentId
    * @return kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getAttachmentText(documentTemplateId: kotlin.String, attachmentId: kotlin.String) : kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>  {
        val localVariableConfig = getAttachmentTextRequestConfig(documentTemplateId = documentTemplateId, attachmentId = attachmentId)

        return request<Unit, kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getAttachmentText
    *
    * @param documentTemplateId
    * @param attachmentId
    * @return RequestConfig
    */
    fun getAttachmentTextRequestConfig(documentTemplateId: kotlin.String, attachmentId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/octet-stream"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/{documentTemplateId}/attachmentText/{attachmentId}".replace("{"+"documentTemplateId"+"}", "${URLEncoder.encode(documentTemplateId.toString(), Charsets.UTF_8)}").replace("{"+"attachmentId"+"}", "${URLEncoder.encode(attachmentId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets a document template
    *
    * @param documentTemplateId
    * @return DocumentTemplateDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getDocumentTemplate(documentTemplateId: kotlin.String) : DocumentTemplateDto  {
        val localVariableConfig = getDocumentTemplateRequestConfig(documentTemplateId = documentTemplateId)

        return request<Unit, DocumentTemplateDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getDocumentTemplate
    *
    * @param documentTemplateId
    * @return RequestConfig
    */
    fun getDocumentTemplateRequestConfig(documentTemplateId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/{documentTemplateId}".replace("{"+"documentTemplateId"+"}", "${URLEncoder.encode(documentTemplateId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Download a the document template attachment
    *
    * @param documentTemplateId
    * @param attachmentId
    * @return kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getDocumentTemplateAttachment(documentTemplateId: kotlin.String, attachmentId: kotlin.String) : kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>  {
        val localVariableConfig = getDocumentTemplateAttachmentRequestConfig(documentTemplateId = documentTemplateId, attachmentId = attachmentId)

        return request<Unit, kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getDocumentTemplateAttachment
    *
    * @param documentTemplateId
    * @param attachmentId
    * @return RequestConfig
    */
    fun getDocumentTemplateAttachmentRequestConfig(documentTemplateId: kotlin.String, attachmentId: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/octet-stream"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/{documentTemplateId}/attachment/{attachmentId}".replace("{"+"documentTemplateId"+"}", "${URLEncoder.encode(documentTemplateId.toString(), Charsets.UTF_8)}").replace("{"+"attachmentId"+"}", "${URLEncoder.encode(attachmentId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets all document templates for all users
    *
    * @return kotlin.collections.List<DocumentTemplateDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listAllDocumentTemplates() : kotlin.collections.List<DocumentTemplateDto>  {
        val localVariableConfig = listAllDocumentTemplatesRequestConfig()

        return request<Unit, kotlin.collections.List<DocumentTemplateDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listAllDocumentTemplates
    *
    * @return RequestConfig
    */
    fun listAllDocumentTemplatesRequestConfig() : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/find/all",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets all document templates for current user
    *
    * @return kotlin.collections.List<DocumentTemplateDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listDocumentTemplates() : kotlin.collections.List<DocumentTemplateDto>  {
        val localVariableConfig = listDocumentTemplatesRequestConfig()

        return request<Unit, kotlin.collections.List<DocumentTemplateDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listDocumentTemplates
    *
    * @return RequestConfig
    */
    fun listDocumentTemplatesRequestConfig() : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets all document templates by Type
    *
    * @param documentTypeCode
    * @return kotlin.collections.List<DocumentTemplateDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listDocumentTemplatesByDocumentType(documentTypeCode: kotlin.String) : kotlin.collections.List<DocumentTemplateDto>  {
        val localVariableConfig = listDocumentTemplatesByDocumentTypeRequestConfig(documentTypeCode = documentTypeCode)

        return request<Unit, kotlin.collections.List<DocumentTemplateDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listDocumentTemplatesByDocumentType
    *
    * @param documentTypeCode
    * @return RequestConfig
    */
    fun listDocumentTemplatesByDocumentTypeRequestConfig(documentTypeCode: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/byDocumentType/{documentTypeCode}".replace("{"+"documentTypeCode"+"}", "${URLEncoder.encode(documentTypeCode.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets all document templates by Type For currentUser
    *
    * @param documentTypeCode
    * @return kotlin.collections.List<DocumentTemplateDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: kotlin.String) : kotlin.collections.List<DocumentTemplateDto>  {
        val localVariableConfig = listDocumentTemplatesByDocumentTypeForCurrentUserRequestConfig(documentTypeCode = documentTypeCode)

        return request<Unit, kotlin.collections.List<DocumentTemplateDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listDocumentTemplatesByDocumentTypeForCurrentUser
    *
    * @param documentTypeCode
    * @return RequestConfig
    */
    fun listDocumentTemplatesByDocumentTypeForCurrentUserRequestConfig(documentTypeCode: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/byDocumentTypeForCurrentUser/{documentTypeCode}".replace("{"+"documentTypeCode"+"}", "${URLEncoder.encode(documentTypeCode.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Gets all document templates
    *
    * @param specialityCode
    * @return kotlin.collections.List<DocumentTemplateDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listDocumentTemplatesBySpeciality(specialityCode: kotlin.String) : kotlin.collections.List<DocumentTemplateDto>  {
        val localVariableConfig = listDocumentTemplatesBySpecialityRequestConfig(specialityCode = specialityCode)

        return request<Unit, kotlin.collections.List<DocumentTemplateDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listDocumentTemplatesBySpeciality
    *
    * @param specialityCode
    * @return RequestConfig
    */
    fun listDocumentTemplatesBySpecialityRequestConfig(specialityCode: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/doctemplate/bySpecialty/{specialityCode}".replace("{"+"specialityCode"+"}", "${URLEncoder.encode(specialityCode.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Modify a document template with the current user
    * Returns an instance of created document template.
    * @param documentTemplateId
    * @param documentTemplateDto
    * @return DocumentTemplateDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyDocumentTemplate(documentTemplateId: kotlin.String, documentTemplateDto: DocumentTemplateDto) : DocumentTemplateDto  {
        val localVariableConfig = modifyDocumentTemplateRequestConfig(documentTemplateId = documentTemplateId, documentTemplateDto = documentTemplateDto)

        return request<DocumentTemplateDto, DocumentTemplateDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyDocumentTemplate
    *
    * @param documentTemplateId
    * @param documentTemplateDto
    * @return RequestConfig
    */
    fun modifyDocumentTemplateRequestConfig(documentTemplateId: kotlin.String, documentTemplateDto: DocumentTemplateDto) : RequestConfig<DocumentTemplateDto> {
        // val localVariableBody = documentTemplateDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = documentTemplateDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/doctemplate/{documentTemplateId}".replace("{"+"documentTemplateId"+"}", "${URLEncoder.encode(documentTemplateId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Creates a document&#39;s attachment
    *
    * @param documentTemplateId
    * @param ioIcureKrakenClientInfrastructureByteArrayWrapper
    * @return DocumentTemplateDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setDocumentTemplateAttachment(documentTemplateId: kotlin.String, ioIcureKrakenClientInfrastructureByteArrayWrapper: kotlin.collections.List<io.icure.kraken.client.infrastructure.ByteArrayWrapper>) : DocumentTemplateDto  {
        val localVariableConfig = setDocumentTemplateAttachmentRequestConfig(documentTemplateId = documentTemplateId, ioIcureKrakenClientInfrastructureByteArrayWrapper = ioIcureKrakenClientInfrastructureByteArrayWrapper)

        return request<kotlin.collections.List<io.icure.kraken.client.infrastructure.ByteArrayWrapper>, DocumentTemplateDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation setDocumentTemplateAttachment
    *
    * @param documentTemplateId
    * @param ioIcureKrakenClientInfrastructureByteArrayWrapper
    * @return RequestConfig
    */
    fun setDocumentTemplateAttachmentRequestConfig(documentTemplateId: kotlin.String, ioIcureKrakenClientInfrastructureByteArrayWrapper: kotlin.collections.List<io.icure.kraken.client.infrastructure.ByteArrayWrapper>) : RequestConfig<kotlin.collections.List<io.icure.kraken.client.infrastructure.ByteArrayWrapper>> {
        // val localVariableBody = ioIcureKrakenClientInfrastructureByteArrayWrapper
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/octet-stream")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = ioIcureKrakenClientInfrastructureByteArrayWrapper

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/doctemplate/{documentTemplateId}/attachment".replace("{"+"documentTemplateId"+"}", "${URLEncoder.encode(documentTemplateId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Creates a document&#39;s attachment
    *
    * @param documentTemplateId
    * @param byteArrayDto
    * @return DocumentTemplateDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setDocumentTemplateAttachmentJson(documentTemplateId: kotlin.String, byteArrayDto: ByteArrayDto) : DocumentTemplateDto  {
        val localVariableConfig = setDocumentTemplateAttachmentJsonRequestConfig(documentTemplateId = documentTemplateId, byteArrayDto = byteArrayDto)

        return request<ByteArrayDto, DocumentTemplateDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation setDocumentTemplateAttachmentJson
    *
    * @param documentTemplateId
    * @param byteArrayDto
    * @return RequestConfig
    */
    fun setDocumentTemplateAttachmentJsonRequestConfig(documentTemplateId: kotlin.String, byteArrayDto: ByteArrayDto) : RequestConfig<ByteArrayDto> {
        // val localVariableBody = byteArrayDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/octet-stream")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = byteArrayDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/doctemplate/{documentTemplateId}/attachmentJson".replace("{"+"documentTemplateId"+"}", "${URLEncoder.encode(documentTemplateId.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
