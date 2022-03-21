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
 * @param ready 
 * @param writeListener 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class RestV2BeSamv2ChapChapterNameParagraphNameVerseSeqAddeddocDocSeqLanguageOutputStream (

    @field:JsonProperty("ready")
    val ready: kotlin.Boolean? = null,

    @field:JsonProperty("writeListener")
    val writeListener: kotlin.Any? = null

)

