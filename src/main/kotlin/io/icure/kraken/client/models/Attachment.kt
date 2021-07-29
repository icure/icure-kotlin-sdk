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
 * @param stub 
 * @param revpos 
 * @param contentType 
 * @param data 
 * @param digest 
 */

data class Attachment (
    @Json(name = "stub")
    val stub: kotlin.Boolean,
    @Json(name = "revpos")
    val revpos: kotlin.Int,
    @Json(name = "content_type")
    val contentType: kotlin.String? = null,
    @Json(name = "data")
    val data: kotlin.String? = null,
    @Json(name = "digest")
    val digest: kotlin.String? = null
)

