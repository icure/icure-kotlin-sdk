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
package io.icure.kraken.client.models.decrypted

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.taktik.icure.services.external.rest.v2.dto.base.CodeStubDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.base.IdentifierDto
import org.taktik.icure.services.external.rest.v2.dto.embed.AnnotationDto
import org.taktik.icure.services.external.rest.v2.dto.embed.SecurityMetadataDto

/**
 * This entity represents a Service. A Service is created in the course a contact. Services include subjective information provided by the patient, such as complaints, reason for visit, feelings, etc. or objective information like bio-metric measures (blood pressure, temperature, heart beat, etc.), or physical exam description, diagnosis, prescription, integration of lab reports from another healthcare party, action plan, etc. Any action performed by the healthcare party which is relevant for the healthcare element of a patient is considered a service. The services can be linked to healthcare elements or other structuring elements of the medical record
 *
 * @param id The Id of the Service. We encourage using either a v4 UUID or a HL7 Id.
 * @param identifier
 * @param cryptedForeignKeys The public patient key, encrypted here for separate Crypto Actors.
 * @param delegations The delegations giving access to connected healthcare information.
 * @param encryptionKeys The contact secret encryption key used to encrypt the secured properties (like services for example), encrypted for separate Crypto Actors.
 * @param content Information contained in the service. Content is localized, using ISO language code as key
 * @param textIndexes
 * @param invoicingCodes List of invoicing codes
 * @param notes Comments - Notes recorded by a HCP about this service
 * @param qualifiedLinks Links towards related services (possibly in other contacts)
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param transactionId The transactionId is used when a single service had to be split into parts for technical reasons. Several services with the same non null transaction id form one single service
 * @param contactId Id of the contact during which the service is provided
 * @param subContactIds List of IDs of all sub-contacts that link the service to structural elements. Only used when the Service is emitted outside of its contact
 * @param plansOfActionIds List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is provided. Only used when the Service is emitted outside of its contact
 * @param healthElementsIds List of IDs of all healthcare elements for which the service is provided. Only used when the Service is emitted outside of its contact
 * @param formIds List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of its contact.
 * @param secretForeignKeys The secret patient key, encrypted in the patient document, in clear here.
 * @param label Description / Unambiguous qualification (LOINC code) of the type of information contained in the service. Could be a code to qualify temperature, complaint, diagnostic, ...
 * @param index Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
 * @param encryptedContent
 * @param valueDate The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same date
 * @param openingDate The date (YYYYMMDDhhmmss) of the start of the Service
 * @param closingDate The date (YYYYMMDDhhmmss) marking the end of the Service
 * @param formId Id of the form used during the Service
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param comment Text, comments on the Service provided
 * @param status
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ServiceDto(

    /* The Id of the Service. We encourage using either a v4 UUID or a HL7 Id. */
    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("identifier")
    val identifier: List<IdentifierDto> = emptyList(),

    /* The public patient key, encrypted here for separate Crypto Actors. */
    @field:JsonProperty("cryptedForeignKeys")
    val cryptedForeignKeys: Map<String, Set<DelegationDto>> = emptyMap(),

    /* The delegations giving access to connected healthcare information. */
    @field:JsonProperty("delegations")
    val delegations: Map<String, Set<DelegationDto>> = emptyMap(),

    /* The contact secret encryption key used to encrypt the secured properties (like services for example), encrypted for separate Crypto Actors. */
    @field:JsonProperty("encryptionKeys")
    val encryptionKeys: Map<String, Set<DelegationDto>> = emptyMap(),

    /* Information contained in the service. Content is localized, using ISO language code as key */
    @field:JsonProperty("content")
    val content: Map<String, ContentDto> = emptyMap(),

    @field:JsonProperty("textIndexes")
    val textIndexes: Map<String, String> = emptyMap(),

    /* List of invoicing codes */
    @field:JsonProperty("invoicingCodes")
    val invoicingCodes: List<String> = emptyList(),

    /* Comments - Notes recorded by a HCP about this service */
    @field:JsonProperty("notes")
    val notes: List<AnnotationDto> = emptyList(),

    /* Links towards related services (possibly in other contacts) */
    @field:JsonProperty("qualifiedLinks")
    val qualifiedLinks: Map<LinkQualification, Map<String, String>> = mapOf(),

    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @field:JsonProperty("codes")
    val codes: List<CodeStubDto> = emptyList(),

    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @field:JsonProperty("tags")
    val tags: List<CodeStubDto> = emptyList(),

    /* The transactionId is used when a single service had to be split into parts for technical reasons. Several services with the same non null transaction id form one single service */
    @field:JsonProperty("transactionId")
    val transactionId: String? = null,

    /* Id of the contact during which the service is provided */
    @field:JsonProperty("contactId")
    val contactId: String? = null,

    /* List of IDs of all sub-contacts that link the service to structural elements. Only used when the Service is emitted outside of its contact */
    @field:JsonProperty("subContactIds")
    val subContactIds: Set<String>? = null,

    /* List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is provided. Only used when the Service is emitted outside of its contact */
    @field:JsonProperty("plansOfActionIds")
    val plansOfActionIds: Set<String>? = null,

    /* List of IDs of all healthcare elements for which the service is provided. Only used when the Service is emitted outside of its contact */
    @field:JsonProperty("healthElementsIds")
    val healthElementsIds: Set<String>? = null,

    /* List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of its contact. */
    @field:JsonProperty("formIds")
    val formIds: Set<String>? = null,

    /* The secret patient key, encrypted in the patient document, in clear here. */
    @field:JsonProperty("secretForeignKeys")
    val secretForeignKeys: Set<String>? = null,

    /* Description / Unambiguous qualification (LOINC code) of the type of information contained in the service. Could be a code to qualify temperature, complaint, diagnostic, ... */
    @field:JsonProperty("label")
    val label: String? = null,

    /* Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...) */
    @field:JsonProperty("index")
    val index: Long? = null,

    @field:JsonProperty("encryptedContent")
    @Deprecated(message = "This property is deprecated.")
    val encryptedContent: String? = null,

    /* The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same date */
    @field:JsonProperty("valueDate")
    val valueDate: Long? = null,

    /* The date (YYYYMMDDhhmmss) of the start of the Service */
    @field:JsonProperty("openingDate")
    val openingDate: Long? = null,

    /* The date (YYYYMMDDhhmmss) marking the end of the Service */
    @field:JsonProperty("closingDate")
    val closingDate: Long? = null,

    /* Id of the form used during the Service */
    @field:JsonProperty("formId")
    val formId: String? = null,

    /* The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("created")
    val created: Long? = null,

    /* The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("modified")
    val modified: Long? = null,

    /* Soft delete (unix epoch in ms) timestamp of the object. */
    @field:JsonProperty("endOfLife")
    val endOfLife: Long? = null,

    /* The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("author")
    val author: String? = null,

    /* The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("responsible")
    val responsible: String? = null,

    /* The id of the medical location where this entity was created. */
    @field:JsonProperty("medicalLocationId")
    val medicalLocationId: String? = null,

    /* Text, comments on the Service provided */
    @field:JsonProperty("comment")
    val comment: String? = null,

    @field:JsonProperty("status")
    val status: Int? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: String? = null,

    @field:JsonProperty("securityMetadata")
    val securityMetadata: SecurityMetadataDto? = null

) {
    enum class LinkQualification(val value: String) {
        @JsonProperty("exact")
        exact("exact"),
        @JsonProperty("narrower")
        narrower("narrower"),
        @JsonProperty("broader")
        broader("broader"),
        @JsonProperty("approximate")
        approximate("approximate"),
        @JsonProperty("sequence")
        sequence("sequence"),
        @JsonProperty("parent")
        parent("parent"),
        @JsonProperty("child")
        child("child"),
        @JsonProperty("relatedCode")
        relatedCode("relatedCode"),
        @JsonProperty("linkedPackage")
        linkedPackage("linkedPackage"),
        @JsonProperty("relatedService")
        relatedService("relatedService"),
        @JsonProperty("inResponseTo")
        inResponseTo("inResponseTo"),
        @JsonProperty("replaces")
        replaces("replaces"),
        @JsonProperty("transforms")
        transforms("transforms"),
        @JsonProperty("transformsAndReplaces")
        transformsAndReplaces("transformsAndReplaces"),
        @JsonProperty("appendsTo")
        appendsTo("appendsTo"),
        @JsonProperty("basedOn")
        basedOn("basedOn"),
        @JsonProperty("derivedFrom")
        derivedFrom("derivedFrom"),
        @JsonProperty("device")
        device("device"),
        @JsonProperty("focus")
        focus("focus"),
        @JsonProperty("hasMember")
        hasMember("hasMember"),
        @JsonProperty("performer")
        performer("performer"),
        @JsonProperty("specimen")
        specimen("specimen"),
        @JsonProperty("resultInterpreter")
        resultInterpreter("resultInterpreter");
    }
}

