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

import io.icure.kraken.client.models.AddressDto
import io.icure.kraken.client.models.CodeStubDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.EmploymentInfoDto
import io.icure.kraken.client.models.FinancialInstitutionInformationDto
import io.icure.kraken.client.models.InsurabilityDto
import io.icure.kraken.client.models.MedicalHouseContractDto
import io.icure.kraken.client.models.PartnershipDto
import io.icure.kraken.client.models.PatientHealthCarePartyDto
import io.icure.kraken.client.models.PropertyStubDto
import io.icure.kraken.client.models.SchoolingInfoDto

import com.squareup.moshi.Json

/**
 * This entity is a root level object. It represents a patient It is serialized in JSON and saved in the underlying icure-patient CouchDB database.
 * @param id the Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
 * @param created The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param modified The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param author The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param responsible The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server.
 * @param tags A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags.
 * @param codes A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes
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

data class PatientDto (
    /* the Id of the patient. We encourage using either a v4 UUID or a HL7 Id. */
    @Json(name = "id")
    val id: kotlin.String,
    /* The timestamp (unix epoch in ms) of creation of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "created")
    val created: kotlin.Long,
    /* The date (unix epoch in ms) of the latest modification of this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "modified")
    val modified: kotlin.Long,
    /* The id of the User that has created this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "author")
    val author: kotlin.String,
    /* The id of the HealthcareParty that is responsible for this entity, will be filled automatically if missing. Not enforced by the application server. */
    @Json(name = "responsible")
    val responsible: kotlin.String,
    /* A tag is an item from a codification system that qualifies an entity as being member of a certain class, whatever the value it might have taken. If the tag qualifies the content of a field, it means that whatever the content of the field, the tag will always apply. For example, the label of a field is qualified using a tag. LOINC is a codification system typically used for tags. */
    @Json(name = "tags")
    val tags: kotlin.collections.List<CodeStubDto>,
    /* A code is an item from a codification system that qualifies the content of this entity. SNOMED-CT, ICPC-2 or ICD-10 codifications systems can be used for codes */
    @Json(name = "codes")
    val codes: kotlin.collections.List<CodeStubDto>,
    /* the list of languages spoken by the patient ordered by fluency (alpha-2 code http://www.loc.gov/standards/iso639-2/ascii_8bits.html). */
    @Json(name = "languages")
    val languages: kotlin.collections.List<kotlin.String>,
    /* the list of addresses (with address type). */
    @Json(name = "addresses")
    val addresses: kotlin.collections.List<AddressDto>,
    /* The ids of the patients that have been merged inside this patient. */
    @Json(name = "mergedIds")
    val mergedIds: kotlin.collections.List<kotlin.String>,
    /* Is the patient active (boolean). */
    @Json(name = "active")
    val active: kotlin.Boolean,
    /* When not active, the reason for deactivation. */
    @Json(name = "deactivationReason")
    val deactivationReason: PatientDto.DeactivationReason,
    /* List of insurance coverages (of class Insurability, see below). */
    @Json(name = "insurabilities")
    val insurabilities: kotlin.collections.List<InsurabilityDto>,
    /* List of partners, or persons of contact (of class Partnership, see below). */
    @Json(name = "partnerships")
    val partnerships: kotlin.collections.List<PartnershipDto>,
    /* Links (usually for therapeutic reasons) between this patient and healthcare parties (of class PatientHealthcareParty). */
    @Json(name = "patientHealthCareParties")
    val patientHealthCareParties: kotlin.collections.List<PatientHealthCarePartyDto>,
    /* Financial information (Bank, bank account) used to reimburse the patient. */
    @Json(name = "financialInstitutionInformation")
    val financialInstitutionInformation: kotlin.collections.List<FinancialInstitutionInformationDto>,
    /* Contracts between the patient and the healthcare entity. */
    @Json(name = "medicalHouseContracts")
    val medicalHouseContracts: kotlin.collections.List<MedicalHouseContractDto>,
    /* Codified list of professions exercised by this patient. */
    @Json(name = "patientProfessions")
    val patientProfessions: kotlin.collections.List<CodeStubDto>,
    /* Extra parameters */
    @Json(name = "parameters")
    val parameters: kotlin.collections.Map<kotlin.String, kotlin.collections.List<kotlin.String>>,
    /* Extra properties */
    @Json(name = "properties")
    val properties: kotlin.collections.List<PropertyStubDto>,
    /* For each couple of HcParties (delegator and delegate), this map contains the exchange AES key. The delegator is always this hcp, the key of the map is the id of the delegate. The AES exchange key is encrypted using RSA twice : once using this hcp public key (index 0 in the Array) and once using the other hcp public key (index 1 in the Array). For a pair of HcParties. Each HcParty always has one AES exchange key for himself. */
    @Json(name = "hcPartyKeys")
    val hcPartyKeys: kotlin.collections.Map<kotlin.String, kotlin.collections.List<kotlin.String>>,
    /* The privateKeyShamirPartitions are used to share this hcp's private RSA key with a series of other hcParties using Shamir's algorithm. The key of the map is the hcp Id with whom this partition has been shared. The value is \"threshold⎮partition in hex\" encrypted using the the partition's holder's public RSA key */
    @Json(name = "privateKeyShamirPartitions")
    val privateKeyShamirPartitions: kotlin.collections.Map<kotlin.String, kotlin.String>,
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
    @Json(name = "nonDuplicateIds")
    @Deprecated(message = "This property is deprecated.")
    val nonDuplicateIds: kotlin.collections.List<kotlin.String>,
    @Json(name = "encryptedAdministrativesDocuments")
    @Deprecated(message = "This property is deprecated.")
    val encryptedAdministrativesDocuments: kotlin.collections.List<kotlin.String>,
    @Json(name = "schoolingInfos")
    @Deprecated(message = "This property is deprecated.")
    val schoolingInfos: kotlin.collections.List<SchoolingInfoDto>,
    @Json(name = "employementInfos")
    @Deprecated(message = "This property is deprecated.")
    val employementInfos: kotlin.collections.List<EmploymentInfoDto>,
    /* the revision of the patient in the database, used for conflict management / optimistic locking. */
    @Json(name = "rev")
    val rev: kotlin.String? = null,
    /* Soft delete (unix epoch in ms) timestamp of the object. */
    @Json(name = "endOfLife")
    val endOfLife: kotlin.Long? = null,
    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @Json(name = "deletionDate")
    val deletionDate: kotlin.Long? = null,
    /* the firstname (name) of the patient. */
    @Json(name = "firstName")
    val firstName: kotlin.String? = null,
    /* the lastname (surname) of the patient. This is the official lastname that should be used for official administrative purposes. */
    @Json(name = "lastName")
    val lastName: kotlin.String? = null,
    /* the name of the company this patient is member of. */
    @Json(name = "companyName")
    val companyName: kotlin.String? = null,
    /* Mr., Ms., Pr., Dr. ... */
    @Json(name = "civility")
    val civility: kotlin.String? = null,
    /* the gender of the patient: male, female, indeterminate, changed, changedToMale, changedToFemale, unknown */
    @Json(name = "gender")
    val gender: PatientDto.Gender? = null,
    /* the birth sex of the patient: male, female, indeterminate, unknown */
    @Json(name = "birthSex")
    val birthSex: PatientDto.BirthSex? = null,
    /* The id of the patient this patient has been merged with. */
    @Json(name = "mergeToPatientId")
    val mergeToPatientId: kotlin.String? = null,
    /* An alias of the person, nickname, ... */
    @Json(name = "alias")
    val alias: kotlin.String? = null,
    /* Social security inscription number. */
    @Json(name = "ssin")
    val ssin: kotlin.String? = null,
    /* Lastname at birth (can be different of the current name), depending on the country, must be used to design the patient . */
    @Json(name = "maidenName")
    val maidenName: kotlin.String? = null,
    /* Lastname of the spouse for a married woman, depending on the country, can be used to design the patient. */
    @Json(name = "spouseName")
    val spouseName: kotlin.String? = null,
    /* Lastname of the partner, should not be used to design the patient. */
    @Json(name = "partnerName")
    val partnerName: kotlin.String? = null,
    /* any of `single`, `in_couple`, `married`, `separated`, `divorced`, `divorcing`, `widowed`, `widower`, `complicated`, `unknown`, `contract`, `other`. */
    @Json(name = "personalStatus")
    val personalStatus: PatientDto.PersonalStatus? = null,
    /* The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD) MM and/or DD can be set to 00 if unknown (19740000 is a valid date). */
    @Json(name = "dateOfBirth")
    val dateOfBirth: kotlin.Int? = null,
    /* The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD) MM and/or DD can be set to 00 if unknown (19740000 is a valid date). */
    @Json(name = "dateOfDeath")
    val dateOfDeath: kotlin.Int? = null,
    /* Timestamp of the latest validation of the eID of the person.. */
    @Json(name = "timestampOfLatestEidReading")
    val timestampOfLatestEidReading: kotlin.Long? = null,
    /* The place of birth. */
    @Json(name = "placeOfBirth")
    val placeOfBirth: kotlin.String? = null,
    /* The place of death. */
    @Json(name = "placeOfDeath")
    val placeOfDeath: kotlin.String? = null,
    /* Is the patient deceased. */
    @Json(name = "deceased")
    val deceased: kotlin.Boolean? = null,
    /* The level of education (college degree, undergraduate, phd). */
    @Json(name = "education")
    val education: kotlin.String? = null,
    /* The current professional activity. */
    @Json(name = "profession")
    val profession: kotlin.String? = null,
    /* A text note (can be confidential, encrypted by default). */
    @Json(name = "note")
    val note: kotlin.String? = null,
    /* An administrative note, not confidential. */
    @Json(name = "administrativeNote")
    val administrativeNote: kotlin.String? = null,
    /* The nationality of the patient. */
    @Json(name = "nationality")
    val nationality: kotlin.String? = null,
    /* The race of the patient. */
    @Json(name = "race")
    val race: kotlin.String? = null,
    /* The ethnicity of the patient. */
    @Json(name = "ethnicity")
    val ethnicity: kotlin.String? = null,
    /* The id of the user that usually handles this patient. */
    @Json(name = "preferredUserId")
    val preferredUserId: kotlin.String? = null,
    /* A picture usually saved in JPEG format. */
    @Json(name = "picture")
    val picture: kotlin.collections.List<kotlin.ByteArray>? = null,
    /* An external (from another source) id with no guarantee or requirement for unicity . */
    @Json(name = "externalId")
    val externalId: kotlin.String? = null,
    /* The public key of this hcp */
    @Json(name = "publicKey")
    val publicKey: kotlin.String? = null,
    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @Json(name = "encryptedSelf")
    val encryptedSelf: kotlin.String? = null,
    /* The id of the medical location where this entity was created. */
    @Json(name = "medicalLocationId")
    val medicalLocationId: kotlin.String? = null,
    @Json(name = "comment")
    @Deprecated(message = "This property is deprecated.")
    val comment: kotlin.String? = null,
    @Json(name = "warning")
    @Deprecated(message = "This property is deprecated.")
    val warning: kotlin.String? = null,
    @Json(name = "fatherBirthCountry")
    val fatherBirthCountry: CodeStubDto? = null,
    @Json(name = "birthCountry")
    val birthCountry: CodeStubDto? = null,
    @Json(name = "nativeCountry")
    val nativeCountry: CodeStubDto? = null,
    @Json(name = "socialStatus")
    val socialStatus: CodeStubDto? = null,
    @Json(name = "mainSourceOfIncome")
    val mainSourceOfIncome: CodeStubDto? = null
) {

    /**
     * When not active, the reason for deactivation.
     * Values: deceased,moved,otherDoctor,retired,noContact,unknown,none
     */
    enum class DeactivationReason(val value: kotlin.String) {
        @Json(name = "deceased") deceased("deceased"),
        @Json(name = "moved") moved("moved"),
        @Json(name = "other_doctor") otherDoctor("other_doctor"),
        @Json(name = "retired") retired("retired"),
        @Json(name = "no_contact") noContact("no_contact"),
        @Json(name = "unknown") unknown("unknown"),
        @Json(name = "none") none("none");
    }
    /**
     * the gender of the patient: male, female, indeterminate, changed, changedToMale, changedToFemale, unknown
     * Values: m,f,i,c,y,x,u
     */
    enum class Gender(val value: kotlin.String) {
        @Json(name = "M") m("M"),
        @Json(name = "F") f("F"),
        @Json(name = "I") i("I"),
        @Json(name = "C") c("C"),
        @Json(name = "Y") y("Y"),
        @Json(name = "X") x("X"),
        @Json(name = "U") u("U");
    }
    /**
     * the birth sex of the patient: male, female, indeterminate, unknown
     * Values: m,f,i,c,y,x,u
     */
    enum class BirthSex(val value: kotlin.String) {
        @Json(name = "M") m("M"),
        @Json(name = "F") f("F"),
        @Json(name = "I") i("I"),
        @Json(name = "C") c("C"),
        @Json(name = "Y") y("Y"),
        @Json(name = "X") x("X"),
        @Json(name = "U") u("U");
    }
    /**
     * any of `single`, `in_couple`, `married`, `separated`, `divorced`, `divorcing`, `widowed`, `widower`, `complicated`, `unknown`, `contract`, `other`.
     * Values: single,inCouple,married,separated,divorced,divorcing,widowed,widower,complicated,unknown,contract,other
     */
    enum class PersonalStatus(val value: kotlin.String) {
        @Json(name = "single") single("single"),
        @Json(name = "in_couple") inCouple("in_couple"),
        @Json(name = "married") married("married"),
        @Json(name = "separated") separated("separated"),
        @Json(name = "divorced") divorced("divorced"),
        @Json(name = "divorcing") divorcing("divorcing"),
        @Json(name = "widowed") widowed("widowed"),
        @Json(name = "widower") widower("widower"),
        @Json(name = "complicated") complicated("complicated"),
        @Json(name = "unknown") unknown("unknown"),
        @Json(name = "contract") `contract`("contract"),
        @Json(name = "other") other("other");
    }
}

