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

import io.icure.kraken.client.models.HealthElementDto
import io.icure.kraken.client.models.PartnershipDto
import io.icure.kraken.client.models.PatientHealthCarePartyDto
import io.icure.kraken.client.models.ServiceDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param services 
 * @param healthElements 
 * @param partnerships 
 * @param patientHealthcareParties 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class SumehrContentDto (

    @field:JsonProperty("services")
    val services: kotlin.collections.List<ServiceDto>? = null,

    @field:JsonProperty("healthElements")
    val healthElements: kotlin.collections.List<HealthElementDto>? = null,

    @field:JsonProperty("partnerships")
    val partnerships: kotlin.collections.List<PartnershipDto>? = null,

    @field:JsonProperty("patientHealthcareParties")
    val patientHealthcareParties: kotlin.collections.List<PatientHealthCarePartyDto>? = null

)

