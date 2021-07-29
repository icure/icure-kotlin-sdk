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

import io.icure.kraken.client.models.AddressDto

import com.squareup.moshi.Json

/**
 * 
 * @param name 
 * @param addresse 
 */

data class EmployerDto (
    @Json(name = "name")
    val name: kotlin.String? = null,
    @Json(name = "addresse")
    val addresse: AddressDto? = null
)

