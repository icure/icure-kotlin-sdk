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
 * @param code 
 * @param date 
 * @param userId 
 * @param userName 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CalendarItemTagDto (

    @field:JsonProperty("code")
    val code: kotlin.String? = null,

    @field:JsonProperty("date")
    val date: kotlin.Long? = null,

    @field:JsonProperty("userId")
    val userId: kotlin.String? = null,

    @field:JsonProperty("userName")
    val userName: kotlin.String? = null

)

