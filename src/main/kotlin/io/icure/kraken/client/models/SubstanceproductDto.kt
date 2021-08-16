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

import io.icure.kraken.client.models.CodeStubDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param intendedcds 
 * @param deliveredcds 
 * @param intendedname 
 * @param deliveredname 
 * @param productId 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SubstanceproductDto (

    @field:JsonProperty("intendedcds")
    val intendedcds: kotlin.collections.List<CodeStubDto> = listOf(),

    @field:JsonProperty("deliveredcds")
    val deliveredcds: kotlin.collections.List<CodeStubDto> = listOf(),

    @field:JsonProperty("intendedname")
    val intendedname: kotlin.String? = null,

    @field:JsonProperty("deliveredname")
    val deliveredname: kotlin.String? = null,

    @field:JsonProperty("productId")
    val productId: kotlin.String? = null

)

