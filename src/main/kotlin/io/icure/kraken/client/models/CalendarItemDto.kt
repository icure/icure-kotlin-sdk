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

import io.icure.kraken.client.models.AddressDto
import io.icure.kraken.client.models.CalendarItemTagDto
import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.FlowItemDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param id 
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param title 
 * @param meetingTags 
 * @param secretForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space.
 * @param cryptedForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys.
 * @param delegations When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well
 * @param encryptionKeys When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation
 * @param rev 
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param calendarItemTypeId 
 * @param masterCalendarItemId 
 * @param patientId 
 * @param important 
 * @param homeVisit 
 * @param phoneNumber 
 * @param placeId 
 * @param address 
 * @param addressText 
 * @param startTime 
 * @param endTime 
 * @param confirmationTime 
 * @param confirmationId 
 * @param duration 
 * @param allDay 
 * @param details 
 * @param wasMigrated 
 * @param agendaId 
 * @param flowItem 
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CalendarItemDto (

    @field:JsonProperty("id")
    val id: kotlin.String,

    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @field:JsonProperty("tags")
    val tags: kotlin.collections.List<CodeStubDto> = listOf(),

    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @field:JsonProperty("codes")
    val codes: kotlin.collections.List<CodeStubDto> = listOf(),

    @field:JsonProperty("title")
    val title: kotlin.String,

    @field:JsonProperty("meetingTags")
    val meetingTags: kotlin.collections.List<CalendarItemTagDto> = listOf(),

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

    @field:JsonProperty("calendarItemTypeId")
    val calendarItemTypeId: kotlin.String? = null,

    @field:JsonProperty("masterCalendarItemId")
    val masterCalendarItemId: kotlin.String? = null,

    @field:JsonProperty("patientId")
    @Deprecated(message = "This property is deprecated.")
    val patientId: kotlin.String? = null,

    @field:JsonProperty("important")
    val important: kotlin.Boolean? = null,

    @field:JsonProperty("homeVisit")
    val homeVisit: kotlin.Boolean? = null,

    @field:JsonProperty("phoneNumber")
    val phoneNumber: kotlin.String? = null,

    @field:JsonProperty("placeId")
    val placeId: kotlin.String? = null,

    @field:JsonProperty("address")
    val address: AddressDto? = null,

    @field:JsonProperty("addressText")
    val addressText: kotlin.String? = null,

    @field:JsonProperty("startTime")
    val startTime: kotlin.Long? = null,

    @field:JsonProperty("endTime")
    val endTime: kotlin.Long? = null,

    @field:JsonProperty("confirmationTime")
    val confirmationTime: kotlin.Long? = null,

    @field:JsonProperty("confirmationId")
    val confirmationId: kotlin.String? = null,

    @field:JsonProperty("duration")
    val duration: kotlin.Long? = null,

    @field:JsonProperty("allDay")
    val allDay: kotlin.Boolean? = null,

    @field:JsonProperty("details")
    val details: kotlin.String? = null,

    @field:JsonProperty("wasMigrated")
    val wasMigrated: kotlin.Boolean? = null,

    @field:JsonProperty("agendaId")
    val agendaId: kotlin.String? = null,

    @field:JsonProperty("flowItem")
    val flowItem: FlowItemDto? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null

)

