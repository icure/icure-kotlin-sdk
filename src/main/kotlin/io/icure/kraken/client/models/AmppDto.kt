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

import io.icure.kraken.client.models.AmppComponentDto
import io.icure.kraken.client.models.AtcDto
import io.icure.kraken.client.models.CommercializationDto
import io.icure.kraken.client.models.CompanyDto
import io.icure.kraken.client.models.DmppDto
import io.icure.kraken.client.models.QuantityDto
import io.icure.kraken.client.models.SamTextDto
import io.icure.kraken.client.models.SupplyProblemDto

import com.squareup.moshi.Json

/**
 * 
 * @param orphan 
 * @param atcs 
 * @param dmpps 
 * @param from 
 * @param to 
 * @param index 
 * @param ctiExtended 
 * @param leafletLink 
 * @param spcLink 
 * @param rmaPatientLink 
 * @param rmaProfessionalLink 
 * @param parallelCircuit 
 * @param parallelDistributor 
 * @param packMultiplier 
 * @param packAmount 
 * @param packDisplayValue 
 * @param status 
 * @param crmLink 
 * @param deliveryModusCode 
 * @param deliveryModus 
 * @param deliveryModusSpecification 
 * @param dhpcLink 
 * @param distributorCompany 
 * @param singleUse 
 * @param speciallyRegulated 
 * @param abbreviatedName 
 * @param prescriptionName 
 * @param note 
 * @param posologyNote 
 * @param noGenericPrescriptionReasons 
 * @param exFactoryPrice 
 * @param reimbursementCode 
 * @param definedDailyDose 
 * @param officialExFactoryPrice 
 * @param realExFactoryPrice 
 * @param pricingInformationDecisionDate 
 * @param components 
 * @param commercializations 
 * @param supplyProblems 
 * @param vaccineIndicationCodes 
 */

data class AmppDto (
    @Json(name = "orphan")
    val orphan: kotlin.Boolean,
    @Json(name = "atcs")
    val atcs: kotlin.collections.List<AtcDto>,
    @Json(name = "dmpps")
    val dmpps: kotlin.collections.List<DmppDto>,
    @Json(name = "from")
    val from: kotlin.Long? = null,
    @Json(name = "to")
    val to: kotlin.Long? = null,
    @Json(name = "index")
    val index: kotlin.Double? = null,
    @Json(name = "ctiExtended")
    val ctiExtended: kotlin.String? = null,
    @Json(name = "leafletLink")
    val leafletLink: SamTextDto? = null,
    @Json(name = "spcLink")
    val spcLink: SamTextDto? = null,
    @Json(name = "rmaPatientLink")
    val rmaPatientLink: SamTextDto? = null,
    @Json(name = "rmaProfessionalLink")
    val rmaProfessionalLink: SamTextDto? = null,
    @Json(name = "parallelCircuit")
    val parallelCircuit: kotlin.Int? = null,
    @Json(name = "parallelDistributor")
    val parallelDistributor: kotlin.String? = null,
    @Json(name = "packMultiplier")
    val packMultiplier: kotlin.Int? = null,
    @Json(name = "packAmount")
    val packAmount: QuantityDto? = null,
    @Json(name = "packDisplayValue")
    val packDisplayValue: kotlin.String? = null,
    @Json(name = "status")
    val status: AmppDto.Status? = null,
    @Json(name = "crmLink")
    val crmLink: SamTextDto? = null,
    @Json(name = "deliveryModusCode")
    val deliveryModusCode: kotlin.String? = null,
    @Json(name = "deliveryModus")
    val deliveryModus: SamTextDto? = null,
    @Json(name = "deliveryModusSpecification")
    val deliveryModusSpecification: SamTextDto? = null,
    @Json(name = "dhpcLink")
    val dhpcLink: SamTextDto? = null,
    @Json(name = "distributorCompany")
    val distributorCompany: CompanyDto? = null,
    @Json(name = "singleUse")
    val singleUse: kotlin.Boolean? = null,
    @Json(name = "speciallyRegulated")
    val speciallyRegulated: kotlin.Int? = null,
    @Json(name = "abbreviatedName")
    val abbreviatedName: SamTextDto? = null,
    @Json(name = "prescriptionName")
    val prescriptionName: SamTextDto? = null,
    @Json(name = "note")
    val note: SamTextDto? = null,
    @Json(name = "posologyNote")
    val posologyNote: SamTextDto? = null,
    @Json(name = "noGenericPrescriptionReasons")
    val noGenericPrescriptionReasons: kotlin.collections.List<SamTextDto>? = null,
    @Json(name = "exFactoryPrice")
    val exFactoryPrice: kotlin.Double? = null,
    @Json(name = "reimbursementCode")
    val reimbursementCode: kotlin.Int? = null,
    @Json(name = "definedDailyDose")
    val definedDailyDose: QuantityDto? = null,
    @Json(name = "officialExFactoryPrice")
    val officialExFactoryPrice: kotlin.Double? = null,
    @Json(name = "realExFactoryPrice")
    val realExFactoryPrice: kotlin.Double? = null,
    @Json(name = "pricingInformationDecisionDate")
    val pricingInformationDecisionDate: kotlin.Long? = null,
    @Json(name = "components")
    val components: kotlin.collections.List<AmppComponentDto>? = null,
    @Json(name = "commercializations")
    val commercializations: kotlin.collections.List<CommercializationDto>? = null,
    @Json(name = "supplyProblems")
    val supplyProblems: kotlin.collections.List<SupplyProblemDto>? = null,
    @Json(name = "vaccineIndicationCodes")
    val vaccineIndicationCodes: kotlin.collections.List<kotlin.String>? = null
) {

    /**
     * 
     * Values: aUTHORIZED,sUSPENDED,rEVOKED
     */
    enum class Status(val value: kotlin.String) {
        @Json(name = "AUTHORIZED") aUTHORIZED("AUTHORIZED"),
        @Json(name = "SUSPENDED") sUSPENDED("SUSPENDED"),
        @Json(name = "REVOKED") rEVOKED("REVOKED");
    }
}

