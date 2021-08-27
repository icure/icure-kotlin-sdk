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
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param quantity 
 * @param administrationUnit 
 * @param unit 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class AdministrationQuantity (

    @field:JsonProperty("quantity")
    val quantity: kotlin.Double? = null,

    @field:JsonProperty("administrationUnit")
    val administrationUnit: CodeStubDto? = null,

    @field:JsonProperty("unit")
    val unit: kotlin.String? = null

)

