
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


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 *
 *
 * @param type
 * @param booleanValue
 * @param integerValue
 * @param doubleValue
 * @param stringValue
 * @param dateValue
 * @param encryptedSelf The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class TypedValueDtoObject (

    @field:JsonProperty("type")
    val type: Type? = null,

    @field:JsonProperty("booleanValue")
    val booleanValue: Boolean? = null,

    @field:JsonProperty("integerValue")
    val integerValue: Int? = null,

    @field:JsonProperty("doubleValue")
    val doubleValue: Double? = null,

    @field:JsonProperty("stringValue")
    val stringValue: String? = null,

    @field:JsonProperty("dateValue")
    val dateValue: java.time.OffsetDateTime? = null,

    /* The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. */
    @field:JsonProperty("encryptedSelf")
    val encryptedSelf: String? = null

) {

    /**
     *
     *
     * Values: bOOLEAN,iNTEGER,dOUBLE,sTRING,dATE,cLOB,jSON
     */
    enum class Type(val value: String) {
        @JsonProperty(value = "BOOLEAN") bOOLEAN("BOOLEAN"),
        @JsonProperty(value = "INTEGER") iNTEGER("INTEGER"),
        @JsonProperty(value = "DOUBLE") dOUBLE("DOUBLE"),
        @JsonProperty(value = "STRING") sTRING("STRING"),
        @JsonProperty(value = "DATE") dATE("DATE"),
        @JsonProperty(value = "CLOB") cLOB("CLOB"),
        @JsonProperty(value = "JSON") jSON("JSON");
    }
}