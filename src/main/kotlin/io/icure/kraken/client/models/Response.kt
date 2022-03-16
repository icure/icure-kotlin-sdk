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

import io.icure.kraken.client.models.RestV2BeSamv2ChapChapterNameParagraphNameVerseSeqAddeddocDocSeqLanguageLocale
import io.icure.kraken.client.models.RestV2BeSamv2ChapChapterNameParagraphNameVerseSeqAddeddocDocSeqLanguageOutputStream

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder

/**
 *
 *
 * @param status
 * @param headerNames
 * @param characterEncoding
 * @param contentType
 * @param outputStream
 * @param writer
 * @param contentLength
 * @param contentLengthLong
 * @param bufferSize
 * @param committed
 * @param locale
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class Response(

    @field:JsonProperty("status")
    val status: kotlin.Int? = null,

    @field:JsonProperty("headerNames")
    val headerNames: kotlin.collections.List<kotlin.String>? = null,

    @field:JsonProperty("characterEncoding")
    val characterEncoding: kotlin.String? = null,

    @field:JsonProperty("contentType")
    val contentType: kotlin.String? = null,

    @field:JsonProperty("outputStream")
    val outputStream: RestV2BeSamv2ChapChapterNameParagraphNameVerseSeqAddeddocDocSeqLanguageOutputStream? = null,

    @field:JsonProperty("writer")
    val writer: kotlin.Any? = null,

    @field:JsonProperty("contentLength")
    val contentLength: kotlin.Int? = null,

    @field:JsonProperty("contentLengthLong")
    val contentLengthLong: kotlin.Long? = null,

    @field:JsonProperty("bufferSize")
    val bufferSize: kotlin.Int? = null,

    @field:JsonProperty("committed")
    val committed: kotlin.Boolean? = null,

    @field:JsonProperty("locale")
    val locale: RestV2BeSamv2ChapChapterNameParagraphNameVerseSeqAddeddocDocSeqLanguageLocale? = null

)

