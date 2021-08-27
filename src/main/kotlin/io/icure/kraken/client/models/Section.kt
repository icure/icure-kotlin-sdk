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


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param section 
 * @param fields 
 * @param description 
 * @param keywords 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Section (

    @field:JsonProperty("section")
    val section: kotlin.String,

    @field:JsonProperty("fields")
    val fields: kotlin.collections.List<kotlin.Any> = listOf(),

    @field:JsonProperty("description")
    val description: kotlin.String? = null,

    @field:JsonProperty("keywords")
    val keywords: kotlin.collections.List<kotlin.String>? = null

)

