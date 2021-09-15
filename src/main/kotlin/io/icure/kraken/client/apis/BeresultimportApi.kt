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
import io.icure.kraken.client.models.ContactDto
import io.icure.kraken.client.models.ResultInfoDto

import kotlinx.coroutines.ExperimentalCoroutinesApi

import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class BeresultimportApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authHeader: String? = null) : ApiClient(basePath, webClient, authHeader) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "http://localhost:16043")
        }
    }

    /**
    * Can we handle this document
    * 
    * @param id  
    * @param enckeys  
    * @return kotlin.Boolean
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun canHandle(id: kotlin.String, enckeys: kotlin.String) : kotlin.Boolean  {
        val localVariableConfig = canHandleRequestConfig(id = id, enckeys = enckeys)

        return request<Unit, kotlin.Boolean>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation canHandle
    *
    * @param id  
    * @param enckeys  
    * @return RequestConfig
    */
    fun canHandleRequestConfig(id: kotlin.String, enckeys: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("enckeys", listOf(enckeys.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"


        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/be_result_import/canhandle/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * import document
    * 
    * @param documentId  
    * @param hcpId  
    * @param language  
    * @param protocolIds  
    * @param formIds  
    * @param planOfActionId  
    * @param enckeys  
    * @param ctc  
    * @return ContactDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun doImport(documentId: kotlin.String, hcpId: kotlin.String, language: kotlin.String, protocolIds: kotlin.String, formIds: kotlin.String, planOfActionId: kotlin.String, enckeys: kotlin.String, ctc: ContactDto) : ContactDto  {
        val localVariableConfig = doImportRequestConfig(documentId = documentId, hcpId = hcpId, language = language, protocolIds = protocolIds, formIds = formIds, planOfActionId = planOfActionId, enckeys = enckeys, ctc = ctc)

        return request<Unit, ContactDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation doImport
    *
    * @param documentId  
    * @param hcpId  
    * @param language  
    * @param protocolIds  
    * @param formIds  
    * @param planOfActionId  
    * @param enckeys  
    * @param ctc  
    * @return RequestConfig
    */
    fun doImportRequestConfig(documentId: kotlin.String, hcpId: kotlin.String, language: kotlin.String, protocolIds: kotlin.String, formIds: kotlin.String, planOfActionId: kotlin.String, enckeys: kotlin.String, ctc: ContactDto) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("protocolIds", listOf(protocolIds.toString()))
                put("formIds", listOf(formIds.toString()))
                put("planOfActionId", listOf(planOfActionId.toString()))
                put("enckeys", listOf(enckeys.toString()))
                put("ctc", listOf(ctc.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"


        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/be_result_import/import/{documentId}/{hcpId}/{language}".replace("{"+"documentId"+"}", "$documentId").replace("{"+"hcpId"+"}", "$hcpId").replace("{"+"language"+"}", "$language"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Extract general infos from document
    * 
    * @param id  
    * @param language  
    * @param enckeys  
    * @param full  (optional)
    * @return kotlin.collections.List<ResultInfoDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getInfos(id: kotlin.String, language: kotlin.String, enckeys: kotlin.String, full: kotlin.Boolean?) : kotlin.collections.List<ResultInfoDto>  {
        val localVariableConfig = getInfosRequestConfig(id = id, language = language, enckeys = enckeys, full = full)

        return request<Unit, kotlin.collections.List<ResultInfoDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getInfos
    *
    * @param id  
    * @param language  
    * @param enckeys  
    * @param full  (optional)
    * @return RequestConfig
    */
    fun getInfosRequestConfig(id: kotlin.String, language: kotlin.String, enckeys: kotlin.String, full: kotlin.Boolean?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("language", listOf(language.toString()))
                put("enckeys", listOf(enckeys.toString()))
                if (full != null) {
                    put("full", listOf(full.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"


        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/be_result_import/infos/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
