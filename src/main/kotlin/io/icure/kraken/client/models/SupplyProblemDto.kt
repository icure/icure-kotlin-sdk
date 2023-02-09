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
 * @param from
 * @param to
 * @param reason
 * @param expectedEndOn
 * @param impact
 * @param additionalInformation
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SupplyProblemDto (

    @field:JsonProperty("from")
    val from: Long? = null,

    @field:JsonProperty("to")
    val to: Long? = null,

    @field:JsonProperty("reason")
    val reason: SamTextDto? = null,

    @field:JsonProperty("expectedEndOn")
    val expectedEndOn: Long? = null,

    @field:JsonProperty("impact")
    val impact: SamTextDto? = null,

    @field:JsonProperty("additionalInformation")
    val additionalInformation: SamTextDto? = null

)