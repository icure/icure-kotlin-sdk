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

import io.icure.kraken.client.models.AddressDto
import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.EmploymentInfoDto
import io.icure.kraken.client.models.FinancialInstitutionInformationDto
import io.icure.kraken.client.models.IdentifierDto
import io.icure.kraken.client.models.InsurabilityDto
import io.icure.kraken.client.models.MedicalHouseContractDto
import io.icure.kraken.client.models.PartnershipDto
import io.icure.kraken.client.models.PatientHealthCarePartyDto
import io.icure.kraken.client.models.PersonNameDto
import io.icure.kraken.client.models.PropertyStubDto
import io.icure.kraken.client.models.SchoolingInfoDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder


/**
 * This entity is a root level object. It represents a patient It is serialized in JSON and saved in the underlying icure-patient CouchDB database.
 *
 * @param id the Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
 * @param identifier 
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
 * @param names the list of all names of the patient, also containing the official full name information. Ordered by preference of use. First element is therefore the official name used for the patient in the application
 * @param languages the list of languages spoken by the patient ordered by fluency (alpha-2 code http://www.loc.gov/standards/iso639-2/ascii_8bits.html).
 * @param addresses the list of addresses (with address type).
 * @param mergedIds The ids of the patients that have been merged inside this patient.
 * @param active Is the patient active (boolean).
 * @param deactivationReason When not active, the reason for deactivation.
 * @param insurabilities List of insurance coverages (of class Insurability, see below).
 * @param partnerships List of partners, or persons of contact (of class Partnership, see below).
 * @param patientHealthCareParties Links (usually for therapeutic reasons) between this patient and healthcare parties (of class PatientHealthcareParty).
 * @param financialInstitutionInformation Financial information (Bank, bank account) used to reimburse the patient.
 * @param medicalHouseContracts Contracts between the patient and the healthcare entity.
 * @param patientProfessions Codified list of professions exercised by this patient.
 * @param parameters Extra parameters
 * @param properties Extra properties
 * @param hcPartyKeys For each couple of HcParties (delegator and delegate), this map contains the exchange AES key. The delegator is always this hcp, the key of the map is the id of the delegate. The AES exchange key is encrypted using RSA twice : once using this hcp public key (index 0 in the Array) and once using the other hcp public key (index 1 in the Array). For a pair of HcParties. Each HcParty always has one AES exchange key for himself.
 * @param privateKeyShamirPartitions The privateKeyShamirPartitions are used to share this hcp's private RSA key with a series of other hcParties using Shamir's algorithm. The key of the map is the hcp Id with whom this partition has been shared. The value is \"threshold⎮partition in hex\" encrypted using the the partition's holder's public RSA key
 * @param secretForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find all contacts for a specific patient. These keys are in clear. You can have several to partition the medical document space.
 * @param cryptedForeignKeys The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship). Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient. ids encrypted using the hcParty keys.
 * @param delegations When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities). He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well
 * @param encryptionKeys When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db. He/she encrypts it using his own AES exchange key and stores it as a delegation
 * @param nonDuplicateIds 
 * @param encryptedAdministrativesDocuments 
 * @param schoolingInfos 
 * @param employementInfos 
 * @param rev the revision of the patient in the database, used for conflict management / optimistic locking.
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param endOfLife Soft delete (unix epoch in ms) timestamp of the object.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param firstName the firstname (name) of the patient.
 * @param lastName the lastname (surname) of the patient. This is the official lastname that should be used for official administrative purposes.
 * @param companyName the name of the company this patient is member of.
 * @param civility Mr., Ms., Pr., Dr. ...
 * @param gender the gender of the patient: male, female, indeterminate, changed, changedToMale, changedToFemale, unknown
 * @param birthSex the birth sex of the patient: male, female, indeterminate, unknown
 * @param mergeToPatientId The id of the patient this patient has been merged with.
 * @param alias An alias of the person, nickname, ...
 * @param ssin Social security inscription number.
 * @param maidenName Lastname at birth (can be different of the current name), depending on the country, must be used to design the patient .
 * @param spouseName Lastname of the spouse for a married woman, depending on the country, can be used to design the patient.
 * @param partnerName Lastname of the partner, should not be used to design the patient.
 * @param personalStatus any of `single`, `in_couple`, `married`, `separated`, `divorced`, `divorcing`, `widowed`, `widower`, `complicated`, `unknown`, `contract`, `other`.
 * @param dateOfBirth The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD) MM and/or DD can be set to 00 if unknown (19740000 is a valid date).
 * @param dateOfDeath The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD) MM and/or DD can be set to 00 if unknown (19740000 is a valid date).
 * @param timestampOfLatestEidReading Timestamp of the latest validation of the eID of the person..
 * @param placeOfBirth The place of birth.
 * @param placeOfDeath The place of death.
 * @param deceased Is the patient deceased.
 * @param education The level of education (college degree, undergraduate, phd).
 * @param profession The current professional activity.
 * @param note A text note (can be confidential, encrypted by default).
 * @param administrativeNote An administrative note, not confidential.
 * @param nationality The nationality of the patient.
 * @param race The race of the patient.
 * @param ethnicity The ethnicity of the patient.
 * @param preferredUserId The id of the user that usually handles this patient.
 * @param picture A picture usually saved in JPEG format.
 * @param externalId An external (from another source) id with no guarantee or requirement for unicity .
 * @param publicKey The public key of this hcp
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 * @param medicalLocationId The id of the medical location where this entity was created.
 * @param comment 
 * @param warning 
 * @param fatherBirthCountry 
 * @param birthCountry 
 * @param nativeCountry 
 * @param socialStatus 
 * @param mainSourceOfIncome 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@KotlinBuilder
data class PatientDto (

    /* the Id of the patient. We encourage using either a v4 UUID or a HL7 Id. */
    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("identifier")
    val identifier: kotlin.collections.List<IdentifierDto> = listOf(),

    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @field:JsonProperty("tags")
    val tags: kotlin.collections.List<CodeStubDto> = listOf(),

    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @field:JsonProperty("codes")
    val codes: kotlin.collections.List<CodeStubDto> = listOf(),

    /* the list of all names of the patient, also containing the official full name information. Ordered by preference of use. First element is therefore the official name used for the patient in the application */
    @field:JsonProperty("names")
    val names: kotlin.collections.List<PersonNameDto> = listOf(),

    /* the list of languages spoken by the patient ordered by fluency (alpha-2 code http://www.loc.gov/standards/iso639-2/ascii_8bits.html). */
    @field:JsonProperty("languages")
    val languages: kotlin.collections.List<kotlin.String> = listOf(),

    /* the list of addresses (with address type). */
    @field:JsonProperty("addresses")
    val addresses: kotlin.collections.List<AddressDto> = listOf(),

    /* The ids of the patients that have been merged inside this patient. */
    @field:JsonProperty("mergedIds")
    val mergedIds: kotlin.collections.List<kotlin.String> = listOf(),

    /* Is the patient active (boolean). */
    @field:JsonProperty("active")
    val active: kotlin.Boolean = true,

    /* When not active, the reason for deactivation. */
    @field:JsonProperty("deactivationReason")
    val deactivationReason: PatientDto.DeactivationReason = DeactivationReason.none,

    /* List of insurance coverages (of class Insurability, see below). */
    @field:JsonProperty("insurabilities")
    val insurabilities: kotlin.collections.List<InsurabilityDto> = listOf(),

    /* List of partners, or persons of contact (of class Partnership, see below). */
    @field:JsonProperty("partnerships")
    val partnerships: kotlin.collections.List<PartnershipDto> = listOf(),

    /* Links (usually for therapeutic reasons) between this patient and healthcare parties (of class PatientHealthcareParty). */
    @field:JsonProperty("patientHealthCareParties")
    val patientHealthCareParties: kotlin.collections.List<PatientHealthCarePartyDto> = listOf(),

    /* Financial information (Bank, bank account) used to reimburse the patient. */
    @field:JsonProperty("financialInstitutionInformation")
    val financialInstitutionInformation: kotlin.collections.List<FinancialInstitutionInformationDto> = listOf(),

    /* Contracts between the patient and the healthcare entity. */
    @field:JsonProperty("medicalHouseContracts")
    val medicalHouseContracts: kotlin.collections.List<MedicalHouseContractDto> = listOf(),

    /* Codified list of professions exercised by this patient. */
    @field:JsonProperty("patientProfessions")
    val patientProfessions: kotlin.collections.List<CodeStubDto> = listOf(),

    /* Extra parameters */
    @field:JsonProperty("parameters")
    val parameters: kotlin.collections.Map<kotlin.String, kotlin.collections.List<kotlin.String>> = mapOf(),

    /* Extra properties */
    @field:JsonProperty("properties")
    val properties: kotlin.collections.List<PropertyStubDto> = listOf(),

    /* For each couple of HcParties (delegator and delegate), this map contains the exchange AES key. The delegator is always this hcp, the key of the map is the id of the delegate. The AES exchange key is encrypted using RSA twice : once using this hcp public key (index 0 in the Array) and once using the other hcp public key (index 1 in the Array). For a pair of HcParties. Each HcParty always has one AES exchange key for himself. */
    @field:JsonProperty("hcPartyKeys")
    val hcPartyKeys: kotlin.collections.Map<kotlin.String, kotlin.collections.List<kotlin.String>> = mapOf(),

    /* The privateKeyShamirPartitions are used to share this hcp's private RSA key with a series of other hcParties using Shamir's algorithm. The key of the map is the hcp Id with whom this partition has been shared. The value is \"threshold⎮partition in hex\" encrypted using the the partition's holder's public RSA key */
    @field:JsonProperty("privateKeyShamirPartitions")
    val privateKeyShamirPartitions: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

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

    @field:JsonProperty("nonDuplicateIds")
    @Deprecated(message = "This property is deprecated.")
    val nonDuplicateIds: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("encryptedAdministrativesDocuments")
    @Deprecated(message = "This property is deprecated.")
    val encryptedAdministrativesDocuments: kotlin.collections.List<kotlin.String> = listOf(),

    @field:JsonProperty("schoolingInfos")
    @Deprecated(message = "This property is deprecated.")
    val schoolingInfos: kotlin.collections.List<SchoolingInfoDto> = listOf(),

    @field:JsonProperty("employementInfos")
    @Deprecated(message = "This property is deprecated.")
    val employementInfos: kotlin.collections.List<EmploymentInfoDto> = listOf(),

    /* the revision of the patient in the database, used for conflict management / optimistic locking. */
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

    /* Soft delete (unix epoch in ms) timestamp of the object. */
    @field:JsonProperty("endOfLife")
    val endOfLife: kotlin.Long? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    /* the firstname (name) of the patient. */
    @field:JsonProperty("firstName")
    val firstName: kotlin.String? = null,

    /* the lastname (surname) of the patient. This is the official lastname that should be used for official administrative purposes. */
    @field:JsonProperty("lastName")
    val lastName: kotlin.String? = null,

    /* the name of the company this patient is member of. */
    @field:JsonProperty("companyName")
    val companyName: kotlin.String? = null,

    /* Mr., Ms., Pr., Dr. ... */
    @field:JsonProperty("civility")
    val civility: kotlin.String? = null,

    /* the gender of the patient: male, female, indeterminate, changed, changedToMale, changedToFemale, unknown */
    @field:JsonProperty("gender")
    val gender: PatientDto.Gender? = null,

    /* the birth sex of the patient: male, female, indeterminate, unknown */
    @field:JsonProperty("birthSex")
    val birthSex: PatientDto.BirthSex? = null,

    /* The id of the patient this patient has been merged with. */
    @field:JsonProperty("mergeToPatientId")
    val mergeToPatientId: kotlin.String? = null,

    /* An alias of the person, nickname, ... */
    @field:JsonProperty("alias")
    val alias: kotlin.String? = null,

    /* Social security inscription number. */
    @field:JsonProperty("ssin")
    val ssin: kotlin.String? = null,

    /* Lastname at birth (can be different of the current name), depending on the country, must be used to design the patient . */
    @field:JsonProperty("maidenName")
    val maidenName: kotlin.String? = null,

    /* Lastname of the spouse for a married woman, depending on the country, can be used to design the patient. */
    @field:JsonProperty("spouseName")
    val spouseName: kotlin.String? = null,

    /* Lastname of the partner, should not be used to design the patient. */
    @field:JsonProperty("partnerName")
    val partnerName: kotlin.String? = null,

    /* any of `single`, `in_couple`, `married`, `separated`, `divorced`, `divorcing`, `widowed`, `widower`, `complicated`, `unknown`, `contract`, `other`. */
    @field:JsonProperty("personalStatus")
    val personalStatus: PatientDto.PersonalStatus? = null,

    /* The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD) MM and/or DD can be set to 00 if unknown (19740000 is a valid date). */
    @field:JsonProperty("dateOfBirth")
    val dateOfBirth: kotlin.Int? = null,

    /* The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD) MM and/or DD can be set to 00 if unknown (19740000 is a valid date). */
    @field:JsonProperty("dateOfDeath")
    val dateOfDeath: kotlin.Int? = null,

    /* Timestamp of the latest validation of the eID of the person.. */
    @field:JsonProperty("timestampOfLatestEidReading")
    val timestampOfLatestEidReading: kotlin.Long? = null,

    /* The place of birth. */
    @field:JsonProperty("placeOfBirth")
    val placeOfBirth: kotlin.String? = null,

    /* The place of death. */
    @field:JsonProperty("placeOfDeath")
    val placeOfDeath: kotlin.String? = null,

    /* Is the patient deceased. */
    @field:JsonProperty("deceased")
    val deceased: kotlin.Boolean? = null,

    /* The level of education (college degree, undergraduate, phd). */
    @field:JsonProperty("education")
    val education: kotlin.String? = null,

    /* The current professional activity. */
    @field:JsonProperty("profession")
    val profession: kotlin.String? = null,

    /* A text note (can be confidential, encrypted by default). */
    @field:JsonProperty("note")
    val note: kotlin.String? = null,

    /* An administrative note, not confidential. */
    @field:JsonProperty("administrativeNote")
    val administrativeNote: kotlin.String? = null,

    /* The nationality of the patient. */
    @field:JsonProperty("nationality")
    val nationality: kotlin.String? = null,

    /* The race of the patient. */
    @field:JsonProperty("race")
    val race: kotlin.String? = null,

    /* The ethnicity of the patient. */
    @field:JsonProperty("ethnicity")
    val ethnicity: kotlin.String? = null,

    /* The id of the user that usually handles this patient. */
    @field:JsonProperty("preferredUserId")
    val preferredUserId: kotlin.String? = null,

    /* A picture usually saved in JPEG format. */
    @field:JsonProperty("picture")
    val picture: kotlin.ByteArray? = null,

    /* An external (from another source) id with no guarantee or requirement for unicity . */
    @field:JsonProperty("externalId")
    val externalId: kotlin.String? = null,

    /* The public key of this hcp */
    @field:JsonProperty("publicKey")
    val publicKey: kotlin.String? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null,

    /* The id of the medical location where this entity was created. */
    @field:JsonProperty("medicalLocationId")
    val medicalLocationId: kotlin.String? = null,

    @field:JsonProperty("comment")
    @Deprecated(message = "This property is deprecated.")
    val comment: kotlin.String? = null,

    @field:JsonProperty("warning")
    @Deprecated(message = "This property is deprecated.")
    val warning: kotlin.String? = null,

    @field:JsonProperty("fatherBirthCountry")
    val fatherBirthCountry: CodeStubDto? = null,

    @field:JsonProperty("birthCountry")
    val birthCountry: CodeStubDto? = null,

    @field:JsonProperty("nativeCountry")
    val nativeCountry: CodeStubDto? = null,

    @field:JsonProperty("socialStatus")
    val socialStatus: CodeStubDto? = null,

    @field:JsonProperty("mainSourceOfIncome")
    val mainSourceOfIncome: CodeStubDto? = null

) {

    /**
     * When not active, the reason for deactivation.
     *
     * Values: deceased,moved,otherDoctor,retired,noContact,unknown,none
     */
    enum class DeactivationReason(val value: kotlin.String) {
        @JsonProperty(value = "deceased") deceased("deceased"),
        @JsonProperty(value = "moved") moved("moved"),
        @JsonProperty(value = "other_doctor") otherDoctor("other_doctor"),
        @JsonProperty(value = "retired") retired("retired"),
        @JsonProperty(value = "no_contact") noContact("no_contact"),
        @JsonProperty(value = "unknown") unknown("unknown"),
        @JsonProperty(value = "none") none("none");
    }
    /**
     * the gender of the patient: male, female, indeterminate, changed, changedToMale, changedToFemale, unknown
     *
     * Values: male,female,indeterminate,changed,changedToMale,changedToFemale,unknown
     */
    enum class Gender(val value: kotlin.String) {
        @JsonProperty(value = "male") male("male"),
        @JsonProperty(value = "female") female("female"),
        @JsonProperty(value = "indeterminate") indeterminate("indeterminate"),
        @JsonProperty(value = "changed") changed("changed"),
        @JsonProperty(value = "changedToMale") changedToMale("changedToMale"),
        @JsonProperty(value = "changedToFemale") changedToFemale("changedToFemale"),
        @JsonProperty(value = "unknown") unknown("unknown");
    }
    /**
     * the birth sex of the patient: male, female, indeterminate, unknown
     *
     * Values: male,female,indeterminate,changed,changedToMale,changedToFemale,unknown
     */
    enum class BirthSex(val value: kotlin.String) {
        @JsonProperty(value = "male") male("male"),
        @JsonProperty(value = "female") female("female"),
        @JsonProperty(value = "indeterminate") indeterminate("indeterminate"),
        @JsonProperty(value = "changed") changed("changed"),
        @JsonProperty(value = "changedToMale") changedToMale("changedToMale"),
        @JsonProperty(value = "changedToFemale") changedToFemale("changedToFemale"),
        @JsonProperty(value = "unknown") unknown("unknown");
    }
    /**
     * any of `single`, `in_couple`, `married`, `separated`, `divorced`, `divorcing`, `widowed`, `widower`, `complicated`, `unknown`, `contract`, `other`.
     *
     * Values: single,inCouple,married,separated,divorced,divorcing,widowed,widower,complicated,unknown,`contract`,other,annulled,polygamous
     */
    enum class PersonalStatus(val value: kotlin.String) {
        @JsonProperty(value = "single") single("single"),
        @JsonProperty(value = "in_couple") inCouple("in_couple"),
        @JsonProperty(value = "married") married("married"),
        @JsonProperty(value = "separated") separated("separated"),
        @JsonProperty(value = "divorced") divorced("divorced"),
        @JsonProperty(value = "divorcing") divorcing("divorcing"),
        @JsonProperty(value = "widowed") widowed("widowed"),
        @JsonProperty(value = "widower") widower("widower"),
        @JsonProperty(value = "complicated") complicated("complicated"),
        @JsonProperty(value = "unknown") unknown("unknown"),
        @JsonProperty(value = "contract") `contract`("contract"),
        @JsonProperty(value = "other") other("other"),
        @JsonProperty(value = "annulled") annulled("annulled"),
        @JsonProperty(value = "polygamous") polygamous("polygamous");
    }
}

