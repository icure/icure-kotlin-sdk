/**
 * iCure Cloud API Documentation
 *
 * Spring shop sample application
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.IdentityDocumentReaderDto
import io.icure.kraken.client.models.InvoicingCodeDto
import io.icure.kraken.client.models.PaymentDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * This entity is a root level object. It represents an Invoice. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 *
 * @param id The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id.
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param invoicingCodes 
 * @param receipts 
 * @param options 
 * @param secretForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space.
 * @param cryptedForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys.
 * @param delegations When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well
 * @param encryptionKeys When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation
 * @param rev The revision of the invoice in the database, used for conflict management / optimistic locking.
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param invoiceDate The timestamp (unix epoch in ms) when the invoice was drafted, will be filled automatically if missing. Not enforced by the application server.
 * @param sentDate The timestamp (unix epoch in ms) when the invoice was sent, will be filled automatically if missing. Not enforced by the application server.
 * @param printedDate The timestamp (unix epoch in ms) when the invoice is printed, will be filled automatically if missing. Not enforced by the application server.
 * @param recipientType The type of user that receives the invoice, a patient or a healthcare party
 * @param recipientId Id of the recipient of the invoice. For healthcare party and insurance, patient link happens through secretForeignKeys
 * @param invoiceReference 
 * @param thirdPartyReference 
 * @param thirdPartyPaymentJustification 
 * @param thirdPartyPaymentReason 
 * @param reason 
 * @param invoiceType The format the invoice should follow based on the recipient which could be a patient, mutual fund or paying agency such as the CPAS
 * @param sentMediumType Medium of the invoice: CD ROM, Email, paper, etc.
 * @param interventionType 
 * @param groupId 
 * @param paymentType Type of payment, ex: cash, wired, insurance, debit card, etc.
 * @param paid 
 * @param payments 
 * @param gnotionNihii 
 * @param gnotionSsin 
 * @param gnotionLastName 
 * @param gnotionFirstName 
 * @param gnotionCdHcParty 
 * @param invoicePeriod 
 * @param careProviderType 
 * @param internshipNihii 
 * @param internshipSsin 
 * @param internshipLastName 
 * @param internshipFirstName 
 * @param internshipCdHcParty 
 * @param internshipCbe 
 * @param supervisorNihii 
 * @param supervisorSsin 
 * @param supervisorLastName 
 * @param supervisorFirstName 
 * @param supervisorCdHcParty 
 * @param supervisorCbe 
 * @param error 
 * @param encounterLocationName 
 * @param encounterLocationNihii 
 * @param encounterLocationNorm 
 * @param longDelayJustification 
 * @param correctiveInvoiceId 
 * @param correctedInvoiceId 
 * @param creditNote 
 * @param creditNoteRelatedInvoiceId 
 * @param idDocument 
 * @param cancelReason 
 * @param cancelDate 
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class InvoiceDto (

    /* The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id. */
    @field:JsonProperty("id")
    val id: kotlin.String,

    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @field:JsonProperty("tags")
    val tags: kotlin.collections.List<CodeStubDto> = listOf(),

    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @field:JsonProperty("codes")
    val codes: kotlin.collections.List<CodeStubDto> = listOf(),

    @field:JsonProperty("invoicingCodes")
    val invoicingCodes: kotlin.collections.List<InvoicingCodeDto> = listOf(),

    @field:JsonProperty("receipts")
    val receipts: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    @field:JsonProperty("options")
    val options: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    /* The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space. */
    @field:JsonProperty("secretForeignKeys")
    val secretForeignKeys: kotlin.collections.List<kotlin.String> = listOf(),

    /* The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys. */
    @field:JsonProperty("cryptedForeignKeys")
    val cryptedForeignKeys: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<DelegationDto>> = mapOf(),

    /* When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well */
    @field:JsonProperty("delegations")
    val delegations: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<DelegationDto>> = mapOf(),

    /* When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation */
    @field:JsonProperty("encryptionKeys")
    val encryptionKeys: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<DelegationDto>> = mapOf(),

    /* The revision of the invoice in the database, used for conflict management / optimistic locking. */
    @field:JsonProperty("rev")
    val rev: kotlin.String? = null,

    /* The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("created")
    val created: kotlin.Long? = null,

    /* The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("modified")
    val modified: kotlin.Long? = null,

    /* The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("author")
    val author: kotlin.String? = null,

    /* The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("responsible")
    val responsible: kotlin.String? = null,

    /* The id of the medical location where this entity was created. */
    @field:JsonProperty("medicalLocationId")
    val medicalLocationId: kotlin.String? = null,

    /* Soft delete (unix epoch in ms) timestamp of the object. */
    @field:JsonProperty("endOfLife")
    val endOfLife: kotlin.Long? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    /* The timestamp (unix epoch in ms) when the invoice was drafted, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("invoiceDate")
    val invoiceDate: kotlin.Long? = null,

    /* The timestamp (unix epoch in ms) when the invoice was sent, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("sentDate")
    val sentDate: kotlin.Long? = null,

    /* The timestamp (unix epoch in ms) when the invoice is printed, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("printedDate")
    val printedDate: kotlin.Long? = null,

    /* The type of user that receives the invoice, a patient or a healthcare party */
    @field:JsonProperty("recipientType")
    val recipientType: kotlin.String? = null,

    /* Id of the recipient of the invoice. For healthcare party and insurance, patient link happens through secretForeignKeys */
    @field:JsonProperty("recipientId")
    val recipientId: kotlin.String? = null,

    @field:JsonProperty("invoiceReference")
    val invoiceReference: kotlin.String? = null,

    @field:JsonProperty("thirdPartyReference")
    val thirdPartyReference: kotlin.String? = null,

    @field:JsonProperty("thirdPartyPaymentJustification")
    val thirdPartyPaymentJustification: kotlin.String? = null,

    @field:JsonProperty("thirdPartyPaymentReason")
    val thirdPartyPaymentReason: kotlin.String? = null,

    @field:JsonProperty("reason")
    val reason: kotlin.String? = null,

    /* The format the invoice should follow based on the recipient which could be a patient, mutual fund or paying agency such as the CPAS */
    @field:JsonProperty("invoiceType")
    val invoiceType: InvoiceDto.InvoiceType? = null,

    /* Medium of the invoice: CD ROM, Email, paper, etc. */
    @field:JsonProperty("sentMediumType")
    val sentMediumType: InvoiceDto.SentMediumType? = null,

    @field:JsonProperty("interventionType")
    val interventionType: InvoiceDto.InterventionType? = null,

    @field:JsonProperty("groupId")
    val groupId: kotlin.String? = null,

    /* Type of payment, ex: cash, wired, insurance, debit card, etc. */
    @field:JsonProperty("paymentType")
    val paymentType: InvoiceDto.PaymentType? = null,

    @field:JsonProperty("paid")
    val paid: kotlin.Double? = null,

    @field:JsonProperty("payments")
    val payments: kotlin.collections.List<PaymentDto>? = null,

    @field:JsonProperty("gnotionNihii")
    val gnotionNihii: kotlin.String? = null,

    @field:JsonProperty("gnotionSsin")
    val gnotionSsin: kotlin.String? = null,

    @field:JsonProperty("gnotionLastName")
    val gnotionLastName: kotlin.String? = null,

    @field:JsonProperty("gnotionFirstName")
    val gnotionFirstName: kotlin.String? = null,

    @field:JsonProperty("gnotionCdHcParty")
    val gnotionCdHcParty: kotlin.String? = null,

    @field:JsonProperty("invoicePeriod")
    val invoicePeriod: kotlin.Int? = null,

    @field:JsonProperty("careProviderType")
    val careProviderType: kotlin.String? = null,

    @field:JsonProperty("internshipNihii")
    val internshipNihii: kotlin.String? = null,

    @field:JsonProperty("internshipSsin")
    val internshipSsin: kotlin.String? = null,

    @field:JsonProperty("internshipLastName")
    val internshipLastName: kotlin.String? = null,

    @field:JsonProperty("internshipFirstName")
    val internshipFirstName: kotlin.String? = null,

    @field:JsonProperty("internshipCdHcParty")
    val internshipCdHcParty: kotlin.String? = null,

    @field:JsonProperty("internshipCbe")
    val internshipCbe: kotlin.String? = null,

    @field:JsonProperty("supervisorNihii")
    val supervisorNihii: kotlin.String? = null,

    @field:JsonProperty("supervisorSsin")
    val supervisorSsin: kotlin.String? = null,

    @field:JsonProperty("supervisorLastName")
    val supervisorLastName: kotlin.String? = null,

    @field:JsonProperty("supervisorFirstName")
    val supervisorFirstName: kotlin.String? = null,

    @field:JsonProperty("supervisorCdHcParty")
    val supervisorCdHcParty: kotlin.String? = null,

    @field:JsonProperty("supervisorCbe")
    val supervisorCbe: kotlin.String? = null,

    @field:JsonProperty("error")
    val error: kotlin.String? = null,

    @field:JsonProperty("encounterLocationName")
    val encounterLocationName: kotlin.String? = null,

    @field:JsonProperty("encounterLocationNihii")
    val encounterLocationNihii: kotlin.String? = null,

    @field:JsonProperty("encounterLocationNorm")
    val encounterLocationNorm: kotlin.Int? = null,

    @field:JsonProperty("longDelayJustification")
    val longDelayJustification: kotlin.Int? = null,

    @field:JsonProperty("correctiveInvoiceId")
    val correctiveInvoiceId: kotlin.String? = null,

    @field:JsonProperty("correctedInvoiceId")
    val correctedInvoiceId: kotlin.String? = null,

    @field:JsonProperty("creditNote")
    val creditNote: kotlin.Boolean? = null,

    @field:JsonProperty("creditNoteRelatedInvoiceId")
    val creditNoteRelatedInvoiceId: kotlin.String? = null,

    @field:JsonProperty("idDocument")
    val idDocument: IdentityDocumentReaderDto? = null,

    @field:JsonProperty("cancelReason")
    val cancelReason: kotlin.String? = null,

    @field:JsonProperty("cancelDate")
    val cancelDate: kotlin.Long? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null

) {

    /**
     * The format the invoice should follow based on the recipient which could be a patient, mutual fund or paying agency such as the CPAS
     *
     * Values: patient,mutualfund,payingagency,insurance,efact,other
     */
    enum class InvoiceType(val value: kotlin.String) {
        @JsonProperty(value = "patient") patient("patient"),
        @JsonProperty(value = "mutualfund") mutualfund("mutualfund"),
        @JsonProperty(value = "payingagency") payingagency("payingagency"),
        @JsonProperty(value = "insurance") insurance("insurance"),
        @JsonProperty(value = "efact") efact("efact"),
        @JsonProperty(value = "other") other("other");
    }
    /**
     * Medium of the invoice: CD ROM, Email, paper, etc.
     *
     * Values: cdrom,eattest,efact,email,mediprima,paper
     */
    enum class SentMediumType(val value: kotlin.String) {
        @JsonProperty(value = "cdrom") cdrom("cdrom"),
        @JsonProperty(value = "eattest") eattest("eattest"),
        @JsonProperty(value = "efact") efact("efact"),
        @JsonProperty(value = "email") email("email"),
        @JsonProperty(value = "mediprima") mediprima("mediprima"),
        @JsonProperty(value = "paper") paper("paper");
    }
    /**
     * 
     *
     * Values: total,userfees
     */
    enum class InterventionType(val value: kotlin.String) {
        @JsonProperty(value = "total") total("total"),
        @JsonProperty(value = "userfees") userfees("userfees");
    }
    /**
     * Type of payment, ex: cash, wired, insurance, debit card, etc.
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
}

