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
 * @param paymentDate
 * @param paymentType
 * @param paid
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaymentDto (

    @field:JsonProperty("paymentDate")
    val paymentDate: kotlin.Long = 0,

    @field:JsonProperty("paymentType")
    val paymentType: PaymentDto.PaymentType? = null,

    @field:JsonProperty("paid")
    val paid: kotlin.Double? = null

) {

    /* ktlint-disable enum-entry-name-case */

    /**
     *
     *
     * Values: cash,wired,insurance,creditcard,debitcard,paypal,bitcoin,other
     */
    enum class PaymentType(val value: kotlin.String) {
        @JsonProperty(value = "cash") cash("cash"),
        @JsonProperty(value = "wired") wired("wired"),
        @JsonProperty(value = "insurance") insurance("insurance"),
        @JsonProperty(value = "creditcard") creditcard("creditcard"),
        @JsonProperty(value = "debitcard") debitcard("debitcard"),
        @JsonProperty(value = "paypal") paypal("paypal"),
        @JsonProperty(value = "bitcoin") bitcoin("bitcoin"),
        @JsonProperty(value = "other") other("other");
    }

    /* ktlint-enable enum-entry-name-case */
}
