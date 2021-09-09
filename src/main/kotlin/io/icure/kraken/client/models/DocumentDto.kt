/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure. This version is obsolete, please use v2.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models

import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * This entity is a root level object. It represents a Document. It is serialized in JSON and saved in the underlying CouchDB database.
 *
 * @param id The Id of the document. We encourage using either a v4 UUID or a HL7 Id.
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param otherUtis Extra Uniform Type Identifiers
 * @param secretForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space.
 * @param cryptedForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys.
 * @param delegations When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well
 * @param encryptionKeys When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation
 * @param rev The revision of the document in the database, used for conflict management / optimistic locking.
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param objectStoreReference Reference in object store
 * @param documentLocation Location of the document
 * @param documentType The type of document, ex: admission, clinical path, document report,invoice, etc.
 * @param documentStatus The status of the development of the document. Ex: Draft, finalized, reviewed, signed, etc.
 * @param externalUri When the document is stored in an external repository, this is the uri of the document in that repository
 * @param mainUti The main Uniform Type Identifier of the document (https://developer.apple.com/library/archive/documentation/FileManagement/Conceptual/understanding_utis/understand_utis_conc/understand_utis_conc.html#//apple_ref/doc/uid/TP40001319-CH202-CHDHIJDE)
 * @param name Name of the document
 * @param version The document version
 * @param storedICureDocumentId The ICureDocument (Form, Contact, ...) that has been used to generate the document
 * @param externalUuid A unique external id (from another external source).
 * @param propertySize Size of the document file
 * @param hash Hashed version of the document
 * @param openingContactId Id of the contact during which the document was created
 * @param attachmentId Id of attachment to this document
 * @param encryptedAttachment 
 * @param decryptedAttachment 
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class DocumentDto (

    /* The Id of the document. We encourage using either a v4 UUID or a HL7 Id. */
    @field:JsonProperty("id")
    val id: kotlin.String,

    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @field:JsonProperty("tags")
    val tags: kotlin.collections.List<CodeStubDto> = listOf(),

    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @field:JsonProperty("codes")
    val codes: kotlin.collections.List<CodeStubDto> = listOf(),

    /* Extra Uniform Type Identifiers */
    @field:JsonProperty("otherUtis")
    val otherUtis: kotlin.collections.List<kotlin.String> = listOf(),

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

    /* The revision of the document in the database, used for conflict management / optimistic locking. */
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

    /* Reference in object store */
    @field:JsonProperty("objectStoreReference")
    val objectStoreReference: kotlin.String? = null,

    /* Location of the document */
    @field:JsonProperty("documentLocation")
    val documentLocation: DocumentDto.DocumentLocation? = null,

    /* The type of document, ex: admission, clinical path, document report,invoice, etc. */
    @field:JsonProperty("documentType")
    val documentType: DocumentDto.DocumentType? = null,

    /* The status of the development of the document. Ex: Draft, finalized, reviewed, signed, etc. */
    @field:JsonProperty("documentStatus")
    val documentStatus: DocumentDto.DocumentStatus? = null,

    /* When the document is stored in an external repository, this is the uri of the document in that repository */
    @field:JsonProperty("externalUri")
    val externalUri: kotlin.String? = null,

    /* The main Uniform Type Identifier of the document (https://developer.apple.com/library/archive/documentation/FileManagement/Conceptual/understanding_utis/understand_utis_conc/understand_utis_conc.html#//apple_ref/doc/uid/TP40001319-CH202-CHDHIJDE) */
    @field:JsonProperty("mainUti")
    val mainUti: kotlin.String? = null,

    /* Name of the document */
    @field:JsonProperty("name")
    val name: kotlin.String? = null,

    /* The document version */
    @field:JsonProperty("version")
    val version: kotlin.String? = null,

    /* The ICureDocument (Form, Contact, ...) that has been used to generate the document */
    @field:JsonProperty("storedICureDocumentId")
    val storedICureDocumentId: kotlin.String? = null,

    /* A unique external id (from another external source). */
    @field:JsonProperty("externalUuid")
    val externalUuid: kotlin.String? = null,

    /* Size of the document file */
    @field:JsonProperty("size")
    val propertySize: kotlin.Long? = null,

    /* Hashed version of the document */
    @field:JsonProperty("hash")
    val hash: kotlin.String? = null,

    /* Id of the contact during which the document was created */
    @field:JsonProperty("openingContactId")
    val openingContactId: kotlin.String? = null,

    /* Id of attachment to this document */
    @field:JsonProperty("attachmentId")
    val attachmentId: kotlin.String? = null,

    @field:JsonProperty("encryptedAttachment")
    val encryptedAttachment: kotlin.ByteArray? = null,

    @field:JsonProperty("decryptedAttachment")
    val decryptedAttachment: kotlin.ByteArray? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null

) {

    /**
     * Location of the document
     *
     * Values: annex,body
     */
    enum class DocumentLocation(val value: kotlin.String) {
        @JsonProperty(value = "annex") annex("annex"),
        @JsonProperty(value = "body") body("body");
    }
    /**
     * The type of document, ex: admission, clinical path, document report,invoice, etc.
     *
     * Values: admission,alert,bvtSample,clinicalpath,clinicalsummary,contactreport,quote,invoice,death,discharge,dischargereport,ebirthBabyMedicalform,ebirthBabyNotification,ebirthMotherMedicalform,ebirthMotherNotification,ecareSafeConsultation,epidemiology,intervention,labrequest,labresult,medicaladvisoragreement,medicationschemeelement,note,notification,pharmaceuticalprescription,prescription,productdelivery,quickdischargereport,radiationexposuremonitoring,referral,report,request,result,sumehr,telemonitoring,template,templateAdmin,treatmentsuspension,vaccination
     */
    enum class DocumentType(val value: kotlin.String) {
        @JsonProperty(value = "admission") admission("admission"),
        @JsonProperty(value = "alert") alert("alert"),
        @JsonProperty(value = "bvt_sample") bvtSample("bvt_sample"),
        @JsonProperty(value = "clinicalpath") clinicalpath("clinicalpath"),
        @JsonProperty(value = "clinicalsummary") clinicalsummary("clinicalsummary"),
        @JsonProperty(value = "contactreport") contactreport("contactreport"),
        @JsonProperty(value = "quote") quote("quote"),
        @JsonProperty(value = "invoice") invoice("invoice"),
        @JsonProperty(value = "death") death("death"),
        @JsonProperty(value = "discharge") discharge("discharge"),
        @JsonProperty(value = "dischargereport") dischargereport("dischargereport"),
        @JsonProperty(value = "ebirth_baby_medicalform") ebirthBabyMedicalform("ebirth_baby_medicalform"),
        @JsonProperty(value = "ebirth_baby_notification") ebirthBabyNotification("ebirth_baby_notification"),
        @JsonProperty(value = "ebirth_mother_medicalform") ebirthMotherMedicalform("ebirth_mother_medicalform"),
        @JsonProperty(value = "ebirth_mother_notification") ebirthMotherNotification("ebirth_mother_notification"),
        @JsonProperty(value = "ecare_safe_consultation") ecareSafeConsultation("ecare_safe_consultation"),
        @JsonProperty(value = "epidemiology") epidemiology("epidemiology"),
        @JsonProperty(value = "intervention") intervention("intervention"),
        @JsonProperty(value = "labrequest") labrequest("labrequest"),
        @JsonProperty(value = "labresult") labresult("labresult"),
        @JsonProperty(value = "medicaladvisoragreement") medicaladvisoragreement("medicaladvisoragreement"),
        @JsonProperty(value = "medicationschemeelement") medicationschemeelement("medicationschemeelement"),
        @JsonProperty(value = "note") note("note"),
        @JsonProperty(value = "notification") notification("notification"),
        @JsonProperty(value = "pharmaceuticalprescription") pharmaceuticalprescription("pharmaceuticalprescription"),
        @JsonProperty(value = "prescription") prescription("prescription"),
        @JsonProperty(value = "productdelivery") productdelivery("productdelivery"),
        @JsonProperty(value = "quickdischargereport") quickdischargereport("quickdischargereport"),
        @JsonProperty(value = "radiationexposuremonitoring") radiationexposuremonitoring("radiationexposuremonitoring"),
        @JsonProperty(value = "referral") referral("referral"),
        @JsonProperty(value = "report") report("report"),
        @JsonProperty(value = "request") request("request"),
        @JsonProperty(value = "result") result("result"),
        @JsonProperty(value = "sumehr") sumehr("sumehr"),
        @JsonProperty(value = "telemonitoring") telemonitoring("telemonitoring"),
        @JsonProperty(value = "template") template("template"),
        @JsonProperty(value = "template_admin") templateAdmin("template_admin"),
        @JsonProperty(value = "treatmentsuspension") treatmentsuspension("treatmentsuspension"),
        @JsonProperty(value = "vaccination") vaccination("vaccination");
    }
    /**
     * The status of the development of the document. Ex: Draft, finalized, reviewed, signed, etc.
     *
     * Values: draft,finalized,pendingReview,reviewed,pendingSignature,signed,canceled,sent,delivered
     */
    enum class DocumentStatus(val value: kotlin.String) {
        @JsonProperty(value = "draft") draft("draft"),
        @JsonProperty(value = "finalized") finalized("finalized"),
        @JsonProperty(value = "pending_review") pendingReview("pending_review"),
        @JsonProperty(value = "reviewed") reviewed("reviewed"),
        @JsonProperty(value = "pending_signature") pendingSignature("pending_signature"),
        @JsonProperty(value = "signed") signed("signed"),
        @JsonProperty(value = "canceled") canceled("canceled"),
        @JsonProperty(value = "sent") sent("sent"),
        @JsonProperty(value = "delivered") delivered("delivered");
    }
}

