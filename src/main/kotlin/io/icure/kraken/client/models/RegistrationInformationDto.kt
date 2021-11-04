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
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param firstName 
 * @param lastName 
 * @param emailAddress 
 * @param userOptions 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class RegistrationInformationDto (

    @field:JsonProperty("firstName")
    val firstName: kotlin.String,

    @field:JsonProperty("lastName")
    val lastName: kotlin.String,

    @field:JsonProperty("emailAddress")
    val emailAddress: kotlin.String,

    @field:JsonProperty("userOptions")
    val userOptions: kotlin.String? = null

)

