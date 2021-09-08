/**
 * OpenAPI definition
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.MedicationSchemeExportInfoDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param patientId 
 * @param language 
 * @param info 
 * @param recipientSafe 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class InlineObject91 (

    @field:JsonProperty("patientId")
    val patientId: kotlin.String? = null,

    @field:JsonProperty("language")
    val language: kotlin.String? = null,

    @field:JsonProperty("info")
    val info: MedicationSchemeExportInfoDto? = null,

    @field:JsonProperty("recipientSafe")
    val recipientSafe: kotlin.String? = null

)

