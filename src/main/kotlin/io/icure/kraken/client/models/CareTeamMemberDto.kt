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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * List of care team members assigned for the healthcare element.
 *
 * @param id
 * @param careTeamMemberType
 * @param healthcarePartyId
 * @param quality
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CareTeamMemberDto(

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("careTeamMemberType")
    val careTeamMemberType: CareTeamMemberDto.CareTeamMemberType? = null,

    @field:JsonProperty("healthcarePartyId")
    val healthcarePartyId: kotlin.String? = null,

    @field:JsonProperty("quality")
    val quality: CodeStubDto? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: kotlin.String? = null

) {

    /* ktlint-disable enum-entry-name-case */

    /**
     *
     *
     * Values: physician,specialist,other
     */
    enum class CareTeamMemberType(val value: kotlin.String) {
        @JsonProperty(value = "physician")
        physician("physician"),

        @JsonProperty(value = "specialist")
        specialist("specialist"),

        @JsonProperty(value = "other")
        other("other");
    }

    /* ktlint-enable enum-entry-name-case */
}
