/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure.
 *
 * The version of the OpenAPI document: v2
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.TimeTableHourDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param days 
 * @param hours 
 * @param recurrenceTypes 
 * @param homeVisit 
 * @param publicTimeTableItem 
 * @param acceptsNewPatient 
 * @param unavailable 
 * @param calendarItemTypeId 
 * @param placeId 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class TimeTableItemDto (

    @field:JsonProperty("days")
    val days: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("hours")
    val hours: kotlin.collections.List<TimeTableHourDto> = listOf(),

    @field:JsonProperty("recurrenceTypes")
    val recurrenceTypes: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("homeVisit")
    val homeVisit: kotlin.Boolean,

    @field:JsonProperty("publicTimeTableItem")
    val publicTimeTableItem: kotlin.Boolean,

    @field:JsonProperty("acceptsNewPatient")
    val acceptsNewPatient: kotlin.Boolean,

    @field:JsonProperty("unavailable")
    val unavailable: kotlin.Boolean,

    @field:JsonProperty("calendarItemTypeId")
    val calendarItemTypeId: kotlin.String? = null,

    @field:JsonProperty("placeId")
    val placeId: kotlin.String? = null

)

