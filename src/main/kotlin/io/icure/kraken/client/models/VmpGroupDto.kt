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

import io.icure.kraken.client.models.NoGenericPrescriptionReasonDto
import io.icure.kraken.client.models.NoSwitchReasonDto
import io.icure.kraken.client.models.SamTextDto

import com.squareup.moshi.Json

/**
 * 
 * @param id 
 * @param rev 
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param from 
 * @param to 
 * @param productId 
 * @param code 
 * @param name 
 * @param noGenericPrescriptionReason 
 * @param noSwitchReason 
 */

data class VmpGroupDto (
    @Json(name = "id")
    val id: kotlin.String,
    @Json(name = "rev")
    val rev: kotlin.String? = null,
    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @Json(name = "deletionDate")
    val deletionDate: kotlin.Long? = null,
    @Json(name = "from")
    val from: kotlin.Long? = null,
    @Json(name = "to")
    val to: kotlin.Long? = null,
    @Json(name = "productId")
    val productId: kotlin.String? = null,
    @Json(name = "code")
    val code: kotlin.String? = null,
    @Json(name = "name")
    val name: SamTextDto? = null,
    @Json(name = "noGenericPrescriptionReason")
    val noGenericPrescriptionReason: NoGenericPrescriptionReasonDto? = null,
    @Json(name = "noSwitchReason")
    val noSwitchReason: NoSwitchReasonDto? = null
)

