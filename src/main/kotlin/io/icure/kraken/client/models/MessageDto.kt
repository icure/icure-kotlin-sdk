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

import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.MessageReadStatusDto

import com.squareup.moshi.Json

/**
 * This entity is a root level object. It represents a Message. It is serialized in JSON and saved in the underlying CouchDB database.
 * @param id The ID of the message. We encourage using either a v4 UUID or a HL7 Id.
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param recipients List of IDs of healthcare parties to whom the message is addressed
 * @param toAddresses The address of the recipient of the message. Format is of an email address with extra domains defined for mycarenet and ehealth: (efact.mycarenet.be/eattest.mycarenet.be/chapter4.mycarenet.be/ehbox.ehealth.fgov.be)
 * @param metas 
 * @param readStatus Status showing whether the message is read or not and the time of reading
 * @param invoiceIds Set of IDs for invoices in the message
 * @param unassignedResults 
 * @param assignedResults 
 * @param senderReferences 
 * @param secretForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space.
 * @param cryptedForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys.
 * @param delegations When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well
 * @param encryptionKeys When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation
 * @param rev The revision of the message in the database, used for conflict management / optimistic locking.
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param fromAddress Address of the sender of the message
 * @param fromHealthcarePartyId ID of the healthcare party sending the message
 * @param formId 
 * @param status Status of the message
 * @param recipientsType The type of user who is the recipient of this message
 * @param received The timestamp (unix epoch in ms) when the message was received
 * @param sent The timestamp (unix epoch in ms) when the message was sent
 * @param transportGuid 
 * @param remark 
 * @param conversationGuid 
 * @param subject Subject for the message
 * @param parentId ID of a parent in a message conversation
 * @param externalRef 
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

data class MessageDto (
    /* The ID of the message. We encourage using either a v4 UUID or a HL7 Id. */
    @Json(name = "id")
    val id: kotlin.String,
    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @Json(name = "tags")
    val tags: kotlin.collections.List<CodeStubDto>,
    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @Json(name = "codes")
    val codes: kotlin.collections.List<CodeStubDto>,
    /* List of IDs of healthcare parties to whom the message is addressed */
    @Json(name = "recipients")
    val recipients: kotlin.collections.List<kotlin.String>,
    /* The address of the recipient of the message. Format is of an email address with extra domains defined for mycarenet and ehealth: (efact.mycarenet.be/eattest.mycarenet.be/chapter4.mycarenet.be/ehbox.ehealth.fgov.be) */
    @Json(name = "toAddresses")
    val toAddresses: kotlin.collections.List<kotlin.String>,
    @Json(name = "metas")
    val metas: kotlin.collections.Map<kotlin.String, kotlin.String>,
    /* Status showing whether the message is read or not and the time of reading */
    @Json(name = "readStatus")
    val readStatus: kotlin.collections.Map<kotlin.String, MessageReadStatusDto>,
    /* Set of IDs for invoices in the message */
    @Json(name = "invoiceIds")
    val invoiceIds: kotlin.collections.List<kotlin.String>,
    @Json(name = "unassignedResults")
    val unassignedResults: kotlin.collections.List<kotlin.String>,
    @Json(name = "assignedResults")
    val assignedResults: kotlin.collections.Map<kotlin.String, kotlin.String>,
    @Json(name = "senderReferences")
    val senderReferences: kotlin.collections.Map<kotlin.String, kotlin.String>,
    /* The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space. */
    @Json(name = "secretForeignKeys")
    val secretForeignKeys: kotlin.collections.List<kotlin.String>,
    /* The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys. */
    @Json(name = "cryptedForeignKeys")
    val cryptedForeignKeys: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<DelegationDto>>,
    /* When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well */
    @Json(name = "delegations")
    val delegations: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<DelegationDto>>,
    /* When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation */
    @Json(name = "encryptionKeys")
    val encryptionKeys: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<DelegationDto>>,
    /* The revision of the message in the database, used for conflict management / optimistic locking. */
    @Json(name = "rev")
    val rev: kotlin.String? = null,
    /* The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "created")
    val created: kotlin.Long? = null,
    /* The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "modified")
    val modified: kotlin.Long? = null,
    /* The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "author")
    val author: kotlin.String? = null,
    /* The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "responsible")
    val responsible: kotlin.String? = null,
    /* The id of the medical location where this entity was created. */
    @Json(name = "medicalLocationId")
    val medicalLocationId: kotlin.String? = null,
    /* Soft delete (unix epoch in ms) timestamp of the object. */
    @Json(name = "endOfLife")
    val endOfLife: kotlin.Long? = null,
    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @Json(name = "deletionDate")
    val deletionDate: kotlin.Long? = null,
    /* Address of the sender of the message */
    @Json(name = "fromAddress")
    val fromAddress: kotlin.String? = null,
    /* ID of the healthcare party sending the message */
    @Json(name = "fromHealthcarePartyId")
    val fromHealthcarePartyId: kotlin.String? = null,
    @Json(name = "formId")
    val formId: kotlin.String? = null,
    /* Status of the message */
    @Json(name = "status")
    val status: kotlin.Int? = null,
    /* The type of user who is the recipient of this message */
    @Json(name = "recipientsType")
    val recipientsType: kotlin.String? = null,
    /* The timestamp (unix epoch in ms) when the message was received */
    @Json(name = "received")
    val received: kotlin.Long? = null,
    /* The timestamp (unix epoch in ms) when the message was sent */
    @Json(name = "sent")
    val sent: kotlin.Long? = null,
    @Json(name = "transportGuid")
    val transportGuid: kotlin.String? = null,
    @Json(name = "remark")
    val remark: kotlin.String? = null,
    @Json(name = "conversationGuid")
    val conversationGuid: kotlin.String? = null,
    /* Subject for the message */
    @Json(name = "subject")
    val subject: kotlin.String? = null,
    /* ID of a parent in a message conversation */
    @Json(name = "parentId")
    val parentId: kotlin.String? = null,
    @Json(name = "externalRef")
    val externalRef: kotlin.String? = null,
    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @Json(name = "encryptedSelf")
    val encryptedSelf: kotlin.String? = null
)

