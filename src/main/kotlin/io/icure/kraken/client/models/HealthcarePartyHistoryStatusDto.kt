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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The healthcare party's status history
 *
 * @param status
 * @param specialisationCode
 * @param startDate
 * @param active
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class HealthcarePartyHistoryStatusDto(

    @field:JsonProperty("status")
    val status: HealthcarePartyHistoryStatusDto.Status,

    @field:JsonProperty("specialisationCode")
    val specialisationCode: kotlin.String,

    @field:JsonProperty("startDate")
    val startDate: kotlin.Long,

    @field:JsonProperty("active")
    val active: kotlin.Boolean

) {

    /* ktlint-disable enum-entry-name-case */

    /**
     *
     *
     * Values: trainee,withconvention,accreditated
     */
    enum class Status(val value: kotlin.String) {
        @JsonProperty(value = "trainee")
        trainee("trainee"),

        @JsonProperty(value = "withconvention")
        withconvention("withconvention"),

        @JsonProperty(value = "accreditated")
        accreditated("accreditated");
    }

    /* ktlint-enable enum-entry-name-case */
}
