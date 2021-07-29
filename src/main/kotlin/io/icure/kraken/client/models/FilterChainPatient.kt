/**
* iCure Cloud API Documentation
* Spring shop sample application
*
* The version of the OpenAPI document: v0.0.1
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package io.icure.kraken.client.models

import io.icure.kraken.client.models.AbstractFilterDtoPatient

import com.squareup.moshi.Json

/**
 * 
 * @param filter 
 * @param predicate 
 */

data class FilterChainPatient (
    @Json(name = "filter")
    val filter: AbstractFilterDtoPatient,
    @Json(name = "predicate")
    val predicate: kotlin.Any? = null
)

