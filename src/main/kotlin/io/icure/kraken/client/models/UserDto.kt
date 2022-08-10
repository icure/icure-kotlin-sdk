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

import io.icure.kraken.client.models.AuthenticationTokenDto
import io.icure.kraken.client.models.PermissionDto
import io.icure.kraken.client.models.PropertyStubDto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * This entity is a root level object. It represents an user that can log in to the iCure platform. It is serialized in JSON and saved in the underlying icure-base CouchDB database.
 *
 * @param id the Id of the user. We encourage using either a v4 UUID or a HL7 Id.
 * @param properties Extra properties for the user. Those properties are typed (see class Property)
 * @param permissions If permission to modify patient data is granted or revoked
 * @param roles Roles specified for the user
 * @param autoDelegations Delegations that are automatically generated client side when a new database object is created by this user
 * @param applicationTokens
 * @param authenticationTokens Encrypted and time-limited Authentication tokens used for inter-applications authentication
 * @param rev the revision of the user in the database, used for conflict management / optimistic locking.
 * @param deletionDate hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called.
 * @param created
 * @param name Last name of the user. This is the official last name that should be used for official administrative purposes.
 * @param type Authorization source for user. 'Database', 'ldap' or 'token'
 * @param status State of user's activeness: 'Active', 'Disabled' or 'Registering'
 * @param login Username for this user. We encourage using an email address
 * @param passwordHash Hashed version of the password (BCrypt is used for hashing)
 * @param secret Secret token used to verify 2fa
 * @param use2fa Whether the user has activated two factors authentication
 * @param groupId id of the group (practice/hospital) the user is member of
 * @param healthcarePartyId Id of the healthcare party if the user is a healthcare party.
 * @param patientId Id of the patient if the user is a patient
 * @param deviceId Id of the device if the user is a device
 * @param createdDate the timestamp (unix epoch in ms) of creation of the user, will be filled automatically if missing. Not enforced by the application server.
 * @param termsOfUseDate the timestamp (unix epoch in ms) of the latest validation of the terms of use of the application
 * @param email email address of the user (used for token exchange or password recovery).
 * @param mobilePhone mobile phone of the user (used for token exchange or password recovery).
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto (

    /* the Id of the user. We encourage using either a v4 UUID or a HL7 Id. */
    @field:JsonProperty("id")
    val id: kotlin.String,

    /* Extra properties for the user. Those properties are typed (see class Property) */
    @field:JsonProperty("properties")
    val properties: kotlin.collections.List<PropertyStubDto> = listOf(),

    /* If permission to modify patient data is granted or revoked */
    @field:JsonProperty("permissions")
    val permissions: kotlin.collections.List<PermissionDto> = listOf(),

    /* Roles specified for the user */
    @field:JsonProperty("roles")
    val roles: kotlin.collections.List<kotlin.String> = listOf(),

    /* Delegations that are automatically generated client side when a new database object is created by this user */
    @field:JsonProperty("autoDelegations")
    val autoDelegations: kotlin.collections.Map<kotlin.String, kotlin.collections.Set<kotlin.String>> = mapOf(),

    @field:JsonProperty("applicationTokens")
    @Deprecated(message = "This property is deprecated.")
    val applicationTokens: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf(),

    /* Encrypted and time-limited Authentication tokens used for inter-applications authentication */
    @field:JsonProperty("authenticationTokens")
    val authenticationTokens: kotlin.collections.Map<kotlin.String, AuthenticationTokenDto> = mapOf(),

    /* the revision of the user in the database, used for conflict management / optimistic locking. */
    @field:JsonProperty("rev")
    val rev: kotlin.String? = null,

    /* hard delete (unix epoch in ms) timestamp of the object. Filled automatically when deletePatient is called. */
    @field:JsonProperty("deletionDate")
    val deletionDate: kotlin.Long? = null,

    @field:JsonProperty("created")
    val created: kotlin.Long? = null,

    /* Last name of the user. This is the official last name that should be used for official administrative purposes. */
    @field:JsonProperty("name")
    val name: kotlin.String? = null,

    /* Authorization source for user. 'Database', 'ldap' or 'token' */
    @field:JsonProperty("type")
    val type: UserDto.Type? = null,

    /* State of user's activeness: 'Active', 'Disabled' or 'Registering' */
    @field:JsonProperty("status")
    val status: UserDto.Status? = null,

    /* Username for this user. We encourage using an email address */
    @field:JsonProperty("login")
    val login: kotlin.String? = null,

    /* Hashed version of the password (BCrypt is used for hashing) */
    @field:JsonProperty("passwordHash")
    val passwordHash: kotlin.String? = null,

    /* Secret token used to verify 2fa */
    @field:JsonProperty("secret")
    val secret: kotlin.String? = null,

    /* Whether the user has activated two factors authentication */
    @field:JsonProperty("use2fa")
    val use2fa: kotlin.Boolean? = null,

    /* id of the group (practice/hospital) the user is member of */
    @field:JsonProperty("groupId")
    val groupId: kotlin.String? = null,

    /* Id of the healthcare party if the user is a healthcare party. */
    @field:JsonProperty("healthcarePartyId")
    val healthcarePartyId: kotlin.String? = null,

    /* Id of the patient if the user is a patient */
    @field:JsonProperty("patientId")
    val patientId: kotlin.String? = null,

    /* Id of the device if the user is a device */
    @field:JsonProperty("deviceId")
    val deviceId: kotlin.String? = null,

    /* the timestamp (unix epoch in ms) of creation of the user, will be filled automatically if missing. Not enforced by the application server. */
    @field:JsonProperty("createdDate")
    val createdDate: java.time.OffsetDateTime? = null,

    /* the timestamp (unix epoch in ms) of the latest validation of the terms of use of the application */
    @field:JsonProperty("termsOfUseDate")
    val termsOfUseDate: java.time.OffsetDateTime? = null,

    /* email address of the user (used for token exchange or password recovery). */
    @field:JsonProperty("email")
    val email: kotlin.String? = null,

    /* mobile phone of the user (used for token exchange or password recovery). */
    @field:JsonProperty("mobilePhone")
    val mobilePhone: kotlin.String? = null

) {

    /* ktlint-disable enum-entry-name-case */

    /**
     * Authorization source for user. 'Database', 'ldap' or 'token'
     *
     * Values: database,ldap,token
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty(value = "database") database("database"),
        @JsonProperty(value = "ldap") ldap("ldap"),
        @JsonProperty(value = "token") token("token");
    }

    /* ktlint-enable enum-entry-name-case */
    /* ktlint-disable enum-entry-name-case */

    /**
     * State of user's activeness: 'Active', 'Disabled' or 'Registering'
     *
     * Values: aCTIVE,dISABLED,rEGISTERING
     */
    enum class Status(val value: kotlin.String) {
        @JsonProperty(value = "ACTIVE") aCTIVE("ACTIVE"),
        @JsonProperty(value = "DISABLED") dISABLED("DISABLED"),
        @JsonProperty(value = "REGISTERING") rEGISTERING("REGISTERING");
    }

    /* ktlint-enable enum-entry-name-case */
}
