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

import io.icure.kraken.client.models.AddressDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param calendarItemTypeId 
 * @param duration 
 * @param acceptsNewPatients 
 * @param name 
 * @param color 
 * @param subjectByLanguage 
 * @param placeId 
 * @param address 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AppointmentTypeAndPlaceDto (

    @field:JsonProperty("calendarItemTypeId")
    val calendarItemTypeId: kotlin.String,

    @field:JsonProperty("duration")
    val duration: kotlin.Int = 0,

    @field:JsonProperty("acceptsNewPatients")
    val acceptsNewPatients: kotlin.Boolean,

    @field:JsonProperty("name")
    val name: kotlin.String? = null,

    @field:JsonProperty("color")
    val color: kotlin.String? = null,

    @field:JsonProperty("subjectByLanguage")
    val subjectByLanguage: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    @field:JsonProperty("placeId")
    val placeId: kotlin.String? = null,

    @field:JsonProperty("address")
    val address: AddressDto? = null

)

