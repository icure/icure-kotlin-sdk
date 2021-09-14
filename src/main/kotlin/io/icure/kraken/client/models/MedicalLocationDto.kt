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

import io.icure.kraken.client.models.AddressDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param id 
 * @param agendaIds 
 * @param options 
 * @param rev 
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param name 
 * @param description 
 * @param responsible 
 * @param guardPost 
 * @param cbe 
 * @param bic 
 * @param bankAccount 
 * @param nihii 
 * @param ssin 
 * @param address 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class MedicalLocationDto (

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("agendaIds")
    val agendaIds: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("options")
    val options: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    @field:JsonProperty("rev")
    val rev: kotlin.String? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    @field:JsonProperty("name")
    val name: kotlin.String? = null,

    @field:JsonProperty("description")
    val description: kotlin.String? = null,

    @field:JsonProperty("responsible")
    val responsible: kotlin.String? = null,

    @field:JsonProperty("guardPost")
    val guardPost: kotlin.Boolean? = null,

    @field:JsonProperty("cbe")
    val cbe: kotlin.String? = null,

    @field:JsonProperty("bic")
    val bic: kotlin.String? = null,

    @field:JsonProperty("bankAccount")
    val bankAccount: kotlin.String? = null,

    @field:JsonProperty("nihii")
    val nihii: kotlin.String? = null,

    @field:JsonProperty("ssin")
    val ssin: kotlin.String? = null,

    @field:JsonProperty("address")
    val address: AddressDto? = null

)

