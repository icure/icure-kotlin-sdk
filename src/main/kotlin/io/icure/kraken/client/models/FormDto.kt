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

import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param id the Id of the form. We encourage using either a v4 UUID or a HL7 Id.
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param secretForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space.
 * @param cryptedForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys.
 * @param delegations When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well
 * @param encryptionKeys When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation
 * @param rev the revision of the form in the database, used for conflict management / optimistic locking.
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param openingDate
 * @param status
 * @param version
 * @param logicalUuid
 * @param descr Name/basic description of the form
 * @param uniqueId A unique external id (from another external source).
 * @param formTemplateId Id of the form template being used to display the form
 * @param contactId Id of the contact for which the form is being used.
 * @param healthElementId The healthcare element to which this form is attached.
 * @param planOfActionId The healthcare approach to which this form is attached.
 * @param parent The parent of this form, used to determine the forms hierarchy
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class FormDto (

    /* the Id of the form. We encourage using either a v4 UUID or a HL7 Id. */
    @field:JsonProperty("id")
    val id: kotlin.String,

    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @field:JsonProperty("tags")
    val tags: kotlin.collections.List<CodeStubDto> = listOf(),

    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @field:JsonProperty("codes")
    val codes: kotlin.collections.List<CodeStubDto> = listOf(),

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

    /* the revision of the form in the database, used for conflict management / optimistic locking. */
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

    @field:JsonProperty("openingDate")
    val openingDate: kotlin.Long? = null,

    @field:JsonProperty("status")
    val status: kotlin.String? = null,

    @field:JsonProperty("version")
    val version: kotlin.Int? = null,

    @field:JsonProperty("logicalUuid")
    val logicalUuid: kotlin.String? = null,

    /* Name/basic description of the form */
    @field:JsonProperty("descr")
    val descr: kotlin.String? = null,

    /* A unique external id (from another external source). */
    @field:JsonProperty("uniqueId")
    val uniqueId: kotlin.String? = null,

    /* Id of the form template being used to display the form */
    @field:JsonProperty("formTemplateId")
    val formTemplateId: kotlin.String? = null,

    /* Id of the contact for which the form is being used. */
    @field:JsonProperty("contactId")
    val contactId: kotlin.String? = null,

    /* The healthcare element to which this form is attached. */
    @field:JsonProperty("healthElementId")
    val healthElementId: kotlin.String? = null,

    /* The healthcare approach to which this form is attached. */
    @field:JsonProperty("planOfActionId")
    val planOfActionId: kotlin.String? = null,

    /* The parent of this form, used to determine the forms hierarchy */
    @field:JsonProperty("parent")
    val parent: kotlin.String? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null

)
