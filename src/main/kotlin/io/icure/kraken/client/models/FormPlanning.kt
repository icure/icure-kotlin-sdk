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
 *
 *
 * @param planninfForAnyDoctor
 * @param planningForDelegate
 * @param planningForPatientDoctor
 * @param planningForMe
 * @param codedDelayInDays
 * @param repetitions
 * @param repetitionsUnit
 * @param descr
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class FormPlanning(

    @field:JsonProperty("planninfForAnyDoctor")
    val planninfForAnyDoctor: kotlin.Boolean? = null,

    @field:JsonProperty("planningForDelegate")
    val planningForDelegate: kotlin.Boolean? = null,

    @field:JsonProperty("planningForPatientDoctor")
    val planningForPatientDoctor: kotlin.Boolean? = null,

    @field:JsonProperty("planningForMe")
    val planningForMe: kotlin.Boolean? = null,

    @field:JsonProperty("codedDelayInDays")
    val codedDelayInDays: kotlin.Int? = null,

    @field:JsonProperty("repetitions")
    val repetitions: kotlin.Int? = null,

    @field:JsonProperty("repetitionsUnit")
    val repetitionsUnit: kotlin.Int? = null,

    @field:JsonProperty("descr")
    val descr: kotlin.String? = null

)
