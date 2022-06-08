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

import io.icure.kraken.client.models.CodeStubDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param quantity 
 * @param administrationUnit 
 * @param unit 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AdministrationQuantity (

    @field:JsonProperty("quantity")
    val quantity: kotlin.Double? = null,

    @field:JsonProperty("administrationUnit")
    val administrationUnit: CodeStubDto? = null,

    @field:JsonProperty("unit")
    val unit: kotlin.String? = null

)

