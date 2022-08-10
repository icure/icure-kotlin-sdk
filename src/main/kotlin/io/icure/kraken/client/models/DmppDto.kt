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

import io.icure.kraken.client.models.ReimbursementDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param id
 * @param from
 * @param to
 * @param deliveryEnvironment
 * @param code
 * @param codeType
 * @param price
 * @param cheap
 * @param cheapest
 * @param reimbursable
 * @param reimbursements
 * @param productId
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class DmppDto (

    @field:JsonProperty("id")
    val id: kotlin.String? = null,

    @field:JsonProperty("from")
    val from: kotlin.Long? = null,

    @field:JsonProperty("to")
    val to: kotlin.Long? = null,

    @field:JsonProperty("deliveryEnvironment")
    val deliveryEnvironment: DmppDto.DeliveryEnvironment? = null,

    @field:JsonProperty("code")
    val code: kotlin.String? = null,

    @field:JsonProperty("codeType")
    val codeType: DmppDto.CodeType? = null,

    @field:JsonProperty("price")
    val price: kotlin.String? = null,

    @field:JsonProperty("cheap")
    val cheap: kotlin.Boolean? = null,

    @field:JsonProperty("cheapest")
    val cheapest: kotlin.Boolean? = null,

    @field:JsonProperty("reimbursable")
    val reimbursable: kotlin.Boolean? = null,

    @field:JsonProperty("reimbursements")
    val reimbursements: kotlin.collections.List<ReimbursementDto>? = null,

    @field:JsonProperty("productId")
    val productId: kotlin.String? = null

) {

    /* ktlint-disable enum-entry-name-case */

    /**
     *
     *
     * Values: p,a,h,r
     */
    enum class DeliveryEnvironment(val value: kotlin.String) {
        @JsonProperty(value = "P") p("P"),
        @JsonProperty(value = "A") a("A"),
        @JsonProperty(value = "H") h("H"),
        @JsonProperty(value = "R") r("R");
    }

    /* ktlint-enable enum-entry-name-case */
    /* ktlint-disable enum-entry-name-case */

    /**
     *
     *
     * Values: cNK,pSEUDO
     */
    enum class CodeType(val value: kotlin.String) {
        @JsonProperty(value = "CNK") cNK("CNK"),
        @JsonProperty(value = "PSEUDO") pSEUDO("PSEUDO");
    }

    /* ktlint-enable enum-entry-name-case */
}
