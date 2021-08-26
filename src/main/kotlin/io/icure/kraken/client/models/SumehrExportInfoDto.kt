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

import io.icure.kraken.client.models.HealthElementDto
import io.icure.kraken.client.models.HealthcarePartyDto
import io.icure.kraken.client.models.ServiceDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param secretForeignKeys
 * @param excludedIds
 * @param comment
 * @param recipient
 * @param softwareName
 * @param softwareVersion
 * @param includeIrrelevantInformation
 * @param services
 * @param healthElements
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SumehrExportInfoDto (

    @field:JsonProperty("secretForeignKeys")
    val secretForeignKeys: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("excludedIds")
    val excludedIds: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("comment")
    val comment: kotlin.String = "",

    @field:JsonProperty("recipient")
    val recipient: HealthcarePartyDto? = null,

    @field:JsonProperty("softwareName")
    val softwareName: kotlin.String? = null,

    @field:JsonProperty("softwareVersion")
    val softwareVersion: kotlin.String? = null,

    @field:JsonProperty("includeIrrelevantInformation")
    val includeIrrelevantInformation: kotlin.Boolean? = null,

    @field:JsonProperty("services")
    val services: kotlin.collections.List<ServiceDto>? = null,

    @field:JsonProperty("healthElements")
    val healthElements: kotlin.collections.List<HealthElementDto>? = null

)

