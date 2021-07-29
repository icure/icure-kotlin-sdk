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

import io.icure.kraken.client.models.MimeAttachmentDto

import com.squareup.moshi.Json

/**
 * 
 * @param attachments 
 * @param destinationIsNotPatient 
 * @param sendCopyToSender 
 * @param destination 
 * @param destinationName 
 * @param senderName 
 * @param replyToEmail 
 * @param content 
 * @param messageId 
 * @param patientId 
 * @param senderId 
 * @param subject 
 * @param type 
 */

data class EmailOrSmsMessageDto (
    @Json(name = "attachments")
    val attachments: kotlin.collections.List<MimeAttachmentDto>,
    @Json(name = "destinationIsNotPatient")
    val destinationIsNotPatient: kotlin.Boolean,
    @Json(name = "sendCopyToSender")
    val sendCopyToSender: kotlin.Boolean,
    @Json(name = "destination")
    val destination: kotlin.String? = null,
    @Json(name = "destinationName")
    val destinationName: kotlin.String? = null,
    @Json(name = "senderName")
    val senderName: kotlin.String? = null,
    @Json(name = "replyToEmail")
    val replyToEmail: kotlin.String? = null,
    @Json(name = "content")
    val content: kotlin.String? = null,
    @Json(name = "messageId")
    val messageId: kotlin.String? = null,
    @Json(name = "patientId")
    val patientId: kotlin.String? = null,
    @Json(name = "senderId")
    val senderId: kotlin.String? = null,
    @Json(name = "subject")
    val subject: kotlin.String? = null,
    @Json(name = "type")
    val type: EmailOrSmsMessageDto.Type? = null
) {

    /**
     * 
     * Values: eMAIL,sMS
     */
    enum class Type(val value: kotlin.String) {
        @Json(name = "EMAIL") eMAIL("EMAIL"),
        @Json(name = "SMS") sMS("SMS");
    }
}

