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

import io.icure.kraken.client.models.TimeTableHourDto

import com.squareup.moshi.Json

/**
 * 
 * @param days 
 * @param hours 
 * @param recurrenceTypes 
 * @param homeVisit 
 * @param unavailable 
 * @param calendarItemTypeId 
 * @param placeId 
 */

data class TimeTableItemDto (
    @Json(name = "days")
    val days: kotlin.collections.List<kotlin.String>,
    @Json(name = "hours")
    val hours: kotlin.collections.List<TimeTableHourDto>,
    @Json(name = "recurrenceTypes")
    val recurrenceTypes: kotlin.collections.List<kotlin.String>,
    @Json(name = "homeVisit")
    val homeVisit: kotlin.Boolean,
    @Json(name = "unavailable")
    val unavailable: kotlin.Boolean,
    @Json(name = "calendarItemTypeId")
    val calendarItemTypeId: kotlin.String? = null,
    @Json(name = "placeId")
    val placeId: kotlin.String? = null
)

