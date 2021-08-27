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

import io.icure.kraken.client.models.SamTextDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param from 
 * @param to 
 * @param reason 
 * @param endOfComercialization 
 * @param impact 
 * @param additionalInformation 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class CommercializationDto (

    @field:JsonProperty("from")
    val from: kotlin.Long? = null,

    @field:JsonProperty("to")
    val to: kotlin.Long? = null,

    @field:JsonProperty("reason")
    val reason: SamTextDto? = null,

    @field:JsonProperty("endOfComercialization")
    val endOfComercialization: SamTextDto? = null,

    @field:JsonProperty("impact")
    val impact: SamTextDto? = null,

    @field:JsonProperty("additionalInformation")
    val additionalInformation: SamTextDto? = null

)

