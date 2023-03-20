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
package io.icure.kraken.client.models.decrypted

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.icure.kraken.client.models.PaginatedDocumentKeyIdPairObject

/**
 *
 *
 * @param pageSize
 * @param totalSize
 * @param rows
 * @param nextKeyPair
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaginatedListClassificationDto(

    @field:JsonProperty("pageSize")
    val pageSize: Int,

    @field:JsonProperty("totalSize")
    val totalSize: Int,

    @field:JsonProperty("rows")
    val rows: List<ClassificationDto> = emptyList(),

    @field:JsonProperty("nextKeyPair")
    val nextKeyPair: PaginatedDocumentKeyIdPairObject? = null

)

