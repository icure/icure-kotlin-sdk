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

import io.icure.kraken.client.models.NoGenericPrescriptionReasonDto
import io.icure.kraken.client.models.NoSwitchReasonDto
import io.icure.kraken.client.models.SamTextDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param id 
 * @param rev 
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param from 
 * @param to 
 * @param productId 
 * @param code 
 * @param name 
 * @param noGenericPrescriptionReason 
 * @param noSwitchReason 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class VmpGroupDto (

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("rev")
    val rev: kotlin.String? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    @field:JsonProperty("from")
    val from: kotlin.Long? = null,

    @field:JsonProperty("to")
    val to: kotlin.Long? = null,

    @field:JsonProperty("productId")
    val productId: kotlin.String? = null,

    @field:JsonProperty("code")
    val code: kotlin.String? = null,

    @field:JsonProperty("name")
    val name: SamTextDto? = null,

    @field:JsonProperty("noGenericPrescriptionReason")
    val noGenericPrescriptionReason: NoGenericPrescriptionReasonDto? = null,

    @field:JsonProperty("noSwitchReason")
    val noSwitchReason: NoSwitchReasonDto? = null

)

