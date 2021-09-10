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

import io.icure.kraken.client.models.SamTextDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param code 
 * @param name 
 * @param edqmCode 
 * @param edqmDefinition 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class PackagingTypeDto (

    @field:JsonProperty("code")
    val code: kotlin.String? = null,

    @field:JsonProperty("name")
    val name: SamTextDto? = null,

    @field:JsonProperty("edqmCode")
    val edqmCode: kotlin.String? = null,

    @field:JsonProperty("edqmDefinition")
    val edqmDefinition: kotlin.String? = null

)

