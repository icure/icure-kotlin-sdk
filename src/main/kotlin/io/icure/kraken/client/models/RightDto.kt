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
 * @param read 
 * @param write 
 * @param administration 
 * @param userId 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class RightDto (

    @field:JsonProperty("read")
    val read: kotlin.Boolean = false,

    @field:JsonProperty("write")
    val write: kotlin.Boolean = false,

    @field:JsonProperty("administration")
    val administration: kotlin.Boolean = false,

    @field:JsonProperty("userId")
    val userId: kotlin.String? = null

)

