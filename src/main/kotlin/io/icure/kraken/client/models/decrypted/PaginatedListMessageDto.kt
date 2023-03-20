/**
 * iCure Cloud API Documentation
 * Spring shop sample application
 *
 * The version of the OpenAPI document: v0.0.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
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
data class PaginatedListMessageDto(

    @field:JsonProperty("pageSize")
    val pageSize: Int,

    @field:JsonProperty("totalSize")
    val totalSize: Int,

    @field:JsonProperty("rows")
    val rows: List<MessageDto> = emptyList(),

    @field:JsonProperty("nextKeyPair")
    val nextKeyPair: PaginatedDocumentKeyIdPairObject? = null

)

