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
import io.icure.kraken.client.models.EmployerDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * 
 *
 * @param startDate 
 * @param endDate 
 * @param professionType 
 * @param employer 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class EmploymentInfoDto (

    @field:JsonProperty("startDate")
    val startDate: kotlin.Long? = null,

    @field:JsonProperty("endDate")
    val endDate: kotlin.Long? = null,

    @field:JsonProperty("professionType")
    val professionType: CodeStubDto? = null,

    @field:JsonProperty("employer")
    val employer: EmployerDto? = null

)

