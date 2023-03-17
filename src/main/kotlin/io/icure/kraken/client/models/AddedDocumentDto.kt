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
package io.icure.kraken.client.models


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param verseSeq
 * @param documentSeq
 * @param from
 * @param to
 * @param mimeType
 * @param addressUrl
 * @param descrNl
 * @param descrFr
 * @param localPath
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AddedDocumentDto (

    @field:JsonProperty("verseSeq")
    val verseSeq: Long,

    @field:JsonProperty("documentSeq")
    val documentSeq: Long,

    @field:JsonProperty("from")
    val from: Long? = null,

    @field:JsonProperty("to")
    val to: Long? = null,

    @field:JsonProperty("mimeType")
    val mimeType: String? = null,

    @field:JsonProperty("addressUrl")
    val addressUrl: String? = null,

    @field:JsonProperty("descrNl")
    val descrNl: String? = null,

    @field:JsonProperty("descrFr")
    val descrFr: String? = null,

    @field:JsonProperty("localPath")
    val localPath: String? = null

)