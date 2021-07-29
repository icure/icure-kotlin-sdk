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

import io.icure.kraken.client.models.CodeStubDto

import com.squareup.moshi.Json

/**
 * 
 * @param quantity 
 * @param administrationUnit 
 * @param unit 
 */

data class AdministrationQuantity (
    @Json(name = "quantity")
    val quantity: kotlin.Double? = null,
    @Json(name = "administrationUnit")
    val administrationUnit: CodeStubDto? = null,
    @Json(name = "unit")
    val unit: kotlin.String? = null
)

