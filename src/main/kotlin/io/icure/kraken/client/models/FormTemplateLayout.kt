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

import io.icure.kraken.client.models.Section

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param form 
 * @param sections 
 * @param description 
 * @param keywords 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class FormTemplateLayout (

    @field:JsonProperty("form")
    val form: kotlin.String,

    @field:JsonProperty("sections")
    val sections: kotlin.collections.List<Section> = listOf(),

    @field:JsonProperty("description")
    val description: kotlin.String? = null,

    @field:JsonProperty("keywords")
    val keywords: kotlin.collections.List<kotlin.String>? = null

)

