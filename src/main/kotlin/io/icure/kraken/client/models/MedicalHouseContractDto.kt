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
 * Contracts between the patient and the healthcare entity.
 *
 * @param kine
 * @param gp
 * @param ptd
 * @param nurse
 * @param noKine
 * @param noGp
 * @param noNurse
 * @param forcedSuspension
 * @param options
 * @param receipts
 * @param contractId
 * @param validFrom
 * @param validTo
 * @param mmNihii
 * @param hcpId
 * @param changeType
 * @param parentContractId
 * @param changedBy
 * @param startOfContract
 * @param startOfCoverage
 * @param endOfContract
 * @param endOfCoverage
 * @param unsubscriptionReasonId
 * @param ptdStart
 * @param ptdEnd
 * @param ptdLastInvoiced
 * @param startOfSuspension
 * @param endOfSuspension
 * @param suspensionReason
 * @param suspensionSource
 * @param signatureType
 * @param status
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class MedicalHouseContractDto (

    @field:JsonProperty("kine")
    val kine: kotlin.Boolean = false,

    @field:JsonProperty("gp")
    val gp: kotlin.Boolean = false,

    @field:JsonProperty("ptd")
    val ptd: kotlin.Boolean = false,

    @field:JsonProperty("nurse")
    val nurse: kotlin.Boolean = false,

    @field:JsonProperty("noKine")
    val noKine: kotlin.Boolean = false,

    @field:JsonProperty("noGp")
    val noGp: kotlin.Boolean = false,

    @field:JsonProperty("noNurse")
    val noNurse: kotlin.Boolean = false,

    @field:JsonProperty("forcedSuspension")
    val forcedSuspension: kotlin.Boolean = false,

    @field:JsonProperty("options")
    val options: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    @field:JsonProperty("receipts")
    val receipts: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    @field:JsonProperty("contractId")
    val contractId: kotlin.String? = null,

    @field:JsonProperty("validFrom")
    val validFrom: kotlin.Long? = null,

    @field:JsonProperty("validTo")
    val validTo: kotlin.Long? = null,

    @field:JsonProperty("mmNihii")
    val mmNihii: kotlin.String? = null,

    @field:JsonProperty("hcpId")
    val hcpId: kotlin.String? = null,

    @field:JsonProperty("changeType")
    val changeType: MedicalHouseContractDto.ChangeType? = null,

    @field:JsonProperty("parentContractId")
    val parentContractId: kotlin.String? = null,

    @field:JsonProperty("changedBy")
    val changedBy: kotlin.String? = null,

    @field:JsonProperty("startOfContract")
    val startOfContract: kotlin.Long? = null,

    @field:JsonProperty("startOfCoverage")
    val startOfCoverage: kotlin.Long? = null,

    @field:JsonProperty("endOfContract")
    val endOfContract: kotlin.Long? = null,

    @field:JsonProperty("endOfCoverage")
    val endOfCoverage: kotlin.Long? = null,

    @field:JsonProperty("unsubscriptionReasonId")
    val unsubscriptionReasonId: kotlin.Int? = null,

    @field:JsonProperty("ptdStart")
    val ptdStart: kotlin.Long? = null,

    @field:JsonProperty("ptdEnd")
    val ptdEnd: kotlin.Long? = null,

    @field:JsonProperty("ptdLastInvoiced")
    val ptdLastInvoiced: kotlin.Long? = null,

    @field:JsonProperty("startOfSuspension")
    val startOfSuspension: kotlin.Long? = null,

    @field:JsonProperty("endOfSuspension")
    val endOfSuspension: kotlin.Long? = null,

    @field:JsonProperty("suspensionReason")
    val suspensionReason: MedicalHouseContractDto.SuspensionReason? = null,

    @field:JsonProperty("suspensionSource")
    val suspensionSource: kotlin.String? = null,

    @field:JsonProperty("signatureType")
    val signatureType: MedicalHouseContractDto.SignatureType? = null,

    @field:JsonProperty("status")
    val status: kotlin.Int? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null

) {

    /**
     *
     *
     * Values: inscriptionStart,inscriptionEnd,suspension,coverageChange
     */
    enum class ChangeType(val value: kotlin.String) {
        @JsonProperty(value = "inscriptionStart") inscriptionStart("inscriptionStart"),
        @JsonProperty(value = "inscriptionEnd") inscriptionEnd("inscriptionEnd"),
        @JsonProperty(value = "suspension") suspension("suspension"),
        @JsonProperty(value = "coverageChange") coverageChange("coverageChange");
    }
    /**
     *
     *
     * Values: notInsured,noReasonGiven,isHospitalized,outsideOfCountry,changeOfMutuality
     */
    enum class SuspensionReason(val value: kotlin.String) {
        @JsonProperty(value = "notInsured") notInsured("notInsured"),
        @JsonProperty(value = "noReasonGiven") noReasonGiven("noReasonGiven"),
        @JsonProperty(value = "isHospitalized") isHospitalized("isHospitalized"),
        @JsonProperty(value = "outsideOfCountry") outsideOfCountry("outsideOfCountry"),
        @JsonProperty(value = "changeOfMutuality") changeOfMutuality("changeOfMutuality");
    }
    /**
     *
     *
     * Values: holderEid,holderPaper,legalrepresentativeEid,legalrepresentativePaper
     */
    enum class SignatureType(val value: kotlin.String) {
        @JsonProperty(value = "holderEid") holderEid("holderEid"),
        @JsonProperty(value = "holderPaper") holderPaper("holderPaper"),
        @JsonProperty(value = "legalrepresentativeEid") legalrepresentativeEid("legalrepresentativeEid"),
        @JsonProperty(value = "legalrepresentativePaper") legalrepresentativePaper("legalrepresentativePaper");
    }
}
