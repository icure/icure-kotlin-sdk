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
 * @param subject 
 * @param body 
 */

data class EmailTemplateDto (
    @Json(name = "subject")
    val subject: kotlin.String? = null,
    @Json(name = "body")
    val body: kotlin.String? = null
)

