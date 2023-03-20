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

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param from
 * @param to
 * @param ingredients
 * @param pharmaceuticalForms
 * @param routeOfAdministrations
 * @param dividable
 * @param scored
 * @param crushable
 * @param containsAlcohol
 * @param sugarFree
 * @param modifiedReleaseType
 * @param specificDrugDevice
 * @param dimensions
 * @param name
 * @param note
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AmpComponentDto (

    @field:JsonProperty("from")
    val from: Long? = null,

    @field:JsonProperty("to")
    val to: Long? = null,

    @field:JsonProperty("ingredients")
    val ingredients: List<IngredientDto>? = null,

    @field:JsonProperty("pharmaceuticalForms")
    val pharmaceuticalForms: List<PharmaceuticalFormStubDto>? = null,

    @field:JsonProperty("routeOfAdministrations")
    val routeOfAdministrations: List<RouteOfAdministrationDto>? = null,

    @field:JsonProperty("dividable")
    val dividable: String? = null,

    @field:JsonProperty("scored")
    val scored: String? = null,

    @field:JsonProperty("crushable")
    val crushable: Crushable? = null,

    @field:JsonProperty("containsAlcohol")
    val containsAlcohol: ContainsAlcohol? = null,

    @field:JsonProperty("sugarFree")
    val sugarFree: Boolean? = null,

    @field:JsonProperty("modifiedReleaseType")
    val modifiedReleaseType: Int? = null,

    @field:JsonProperty("specificDrugDevice")
    val specificDrugDevice: Int? = null,

    @field:JsonProperty("dimensions")
    val dimensions: String? = null,

    @field:JsonProperty("name")
    val name: SamTextDto? = null,

    @field:JsonProperty("note")
    val note: SamTextDto? = null

) {

    /**
     *
     *
     * Values: y,n,x
     */
    enum class Crushable(val value: String) {
        @JsonProperty(value = "Y") y("Y"),
        @JsonProperty(value = "N") n("N"),
        @JsonProperty(value = "X") x("X");
    }
    /**
     *
     *
     * Values: y,n,x
     */
    enum class ContainsAlcohol(val value: String) {
        @JsonProperty(value = "Y") y("Y"),
        @JsonProperty(value = "N") n("N"),
        @JsonProperty(value = "X") x("X");
    }
}