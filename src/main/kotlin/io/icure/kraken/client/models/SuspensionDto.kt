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


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param beginMoment
 * @param endMoment
 * @param suspensionReason
 * @param lifecycle
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SuspensionDto (

    @field:JsonProperty("beginMoment")
    val beginMoment: kotlin.Long? = null,

    @field:JsonProperty("endMoment")
    val endMoment: kotlin.Long? = null,

    @field:JsonProperty("suspensionReason")
    val suspensionReason: kotlin.String? = null,

    @field:JsonProperty("lifecycle")
    val lifecycle: kotlin.String? = null

)
