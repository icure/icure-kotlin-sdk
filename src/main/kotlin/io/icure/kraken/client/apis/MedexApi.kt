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
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.HealthcarePartyDto
import org.taktik.icure.services.external.rest.v2.dto.PatientDto
import java.util.*
import javax.inject.Named

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class MedexApi(
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
     * Generate a Medex XML String
     *
     * @param medexInfoDto
     * @return kotlin.String
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun generateMedex(medexInfoDto: MedexInfoDto): String {
        val localVariableConfig = generateMedexRequestConfig(medexInfoDto = medexInfoDto)

        return request<MedexInfoDto, String>(
            localVariableConfig
        )!!
    }

    /**
     * To obtain the request config of the operation generateMedex
     *
     * @param medexInfoDto
     * @return RequestConfig
     */
    fun generateMedexRequestConfig(medexInfoDto: MedexInfoDto): RequestConfig<MedexInfoDto> {
        // val localVariableBody = medexInfoDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "application/xml"
        val localVariableBody = medexInfoDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/medex/generate",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}

data class MedexInfoDto(
    val beginDate: Long,
    val endDate: Long,
    val author: HealthcarePartyDto? = null,
    val patient: PatientDto? = null,
    val patientLanguage: String = "fr",
    val incapacityType: String = "incapacity", // incapacity or incapacityextension

    /*
        Possible values:
        illness
        hospitalisation
        sickness
        pregnancy
        workaccident
        occupationaldisease
     */
    val incapacityReason: String = "sickness",
    val outOfHomeAllowed: Boolean = true,

    /*
    "Optional field
    But mandatory when incapacityreason = workaccident; this field must contain the accident date.
    when incapacityreason = occupationaldisease this field must contain the request date for a dossier for occupatialdesease.
    This date must be < or =  beginmoment of the incapacity period."
     */
    val certificateDate: Long? = null,
    val contentDate: Long? = null,
    val diagnosisICPC: String? = null,
    val diagnosisICD: String? = null,
    val diagnosisDescr: String? = null
)
