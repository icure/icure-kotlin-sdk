/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure. This version is obsolete, please use v2.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.ContactDto
import io.icure.kraken.client.models.PaginatedDocumentKeyIdPairObject

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


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
@KotlinBuilder
data class PaginatedListContactDto (

    @field:JsonProperty("pageSize")
    val pageSize: kotlin.Int,

    @field:JsonProperty("totalSize")
    val totalSize: kotlin.Int,

    @field:JsonProperty("rows")
    val rows: kotlin.collections.List<ContactDto> = emptyList(),

    @field:JsonProperty("nextKeyPair")
    val nextKeyPair: PaginatedDocumentKeyIdPairObject? = null

)

