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


import com.squareup.moshi.Json

/**
 * 
 * @param regimeType 
 * @param from 
 * @param to 
 * @param feeAmount 
 */

data class CopaymentDto (
    @Json(name = "regimeType")
    val regimeType: kotlin.Int? = null,
    @Json(name = "from")
    val from: kotlin.Long? = null,
    @Json(name = "to")
    val to: kotlin.Long? = null,
    @Json(name = "feeAmount")
    val feeAmount: kotlin.String? = null
)

