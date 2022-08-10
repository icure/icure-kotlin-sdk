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
package io.icure.kraken.client.models.decrypted

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.icure.kraken.client.models.MeasureDto
import io.icure.kraken.client.models.MedicationDto
import io.icure.kraken.client.models.TimeSeriesDto

/**
 * Information contained in the service. Content is localized, using ISO language code as key
 *
 * @param stringValue
 * @param numberValue
 * @param booleanValue
 * @param instantValue
 * @param fuzzyDateValue Value as date. The format could have a all three (day, month and year) or values on any of these three, whatever is known.
 * @param binaryValue
 * @param documentId Linked document.
 * @param measureValue
 * @param medicationValue
 * @param timeSeries
 * @param compoundValue
 * @param ratio
 * @param range
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContentDto(

    @field:JsonProperty("stringValue")
    val stringValue: kotlin.String? = null,

    @field:JsonProperty("numberValue")
    val numberValue: kotlin.Double? = null,

    @field:JsonProperty("booleanValue")
    val booleanValue: kotlin.Boolean? = null,

    @field:JsonProperty("instantValue")
    val instantValue: java.time.OffsetDateTime? = null,

    /* Value as date. The format could have a all three (day, month and year) or values on any of these three, whatever is known. */
    @field:JsonProperty("fuzzyDateValue")
    val fuzzyDateValue: kotlin.Long? = null,

    @field:JsonProperty("binaryValue")
    val binaryValue: io.icure.kraken.client.infrastructure.ByteArrayWrapper? = null,

    /* Id of the document in which the content is being filled. */
    @field:JsonProperty("documentId")
    val documentId: kotlin.String? = null,

    @field:JsonProperty("measureValue")
    val measureValue: MeasureDto? = null,

    @field:JsonProperty("medicationValue")
    val medicationValue: MedicationDto? = null,

    @field:JsonProperty("timeSeries")
    val timeSeries: TimeSeriesDto? = null,

    @field:JsonProperty("compoundValue")
    val compoundValue: kotlin.collections.List<ServiceDto>? = null,

    @field:JsonProperty("ratio")
    val ratio: kotlin.collections.List<MeasureDto>? = null,

    @field:JsonProperty("range")
    val range: kotlin.collections.List<MeasureDto>? = null

)
