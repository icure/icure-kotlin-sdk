/**
 * iCure Cloud API Documentation
 *
 * Spring shop sample application
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.SamTextDto
import io.icure.kraken.client.models.VmpGroupStubDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param id 
 * @param code 
 * @param vmpGroup 
 * @param name 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class VmpStubDto (

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("code")
    val code: kotlin.String? = null,

    @field:JsonProperty("vmpGroup")
    val vmpGroup: VmpGroupStubDto? = null,

    @field:JsonProperty("name")
    val name: SamTextDto? = null

)

