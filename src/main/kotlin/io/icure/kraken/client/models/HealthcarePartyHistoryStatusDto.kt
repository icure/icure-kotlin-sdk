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
 * The healthcare party's status history
 * @param status 
 * @param specialisationCode 
 * @param startDate 
 * @param active 
 */

data class HealthcarePartyHistoryStatusDto (
    @Json(name = "status")
    val status: HealthcarePartyHistoryStatusDto.Status,
    @Json(name = "specialisationCode")
    val specialisationCode: kotlin.String,
    @Json(name = "startDate")
    val startDate: kotlin.Long,
    @Json(name = "active")
    val active: kotlin.Boolean
) {

    /**
     * 
     * Values: trainee,withconvention,accreditated
     */
    enum class Status(val value: kotlin.String) {
        @Json(name = "trainee") trainee("trainee"),
        @Json(name = "withconvention") withconvention("withconvention"),
        @Json(name = "accreditated") accreditated("accreditated");
    }
}

