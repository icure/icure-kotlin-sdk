
# EmailOrSmsMessageDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attachments** | [**kotlin.collections.List&lt;MimeAttachmentDto&gt;**](MimeAttachmentDto.md) |  |
**destinationIsNotPatient** | **kotlin.Boolean** |  |
**sendCopyToSender** | **kotlin.Boolean** |  |
**destination** | **kotlin.String** |  |  [optional]
**destinationName** | **kotlin.String** |  |  [optional]
**senderName** | **kotlin.String** |  |  [optional]
**replyToEmail** | **kotlin.String** |  |  [optional]
**content** | **kotlin.String** |  |  [optional]
**messageId** | **kotlin.String** |  |  [optional]
**patientId** | **kotlin.String** |  |  [optional]
**senderId** | **kotlin.String** |  |  [optional]
**subject** | **kotlin.String** |  |  [optional]
**type** | [**inline**](#TypeEnum) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: type
Name | Value
---- | -----
type | EMAIL, SMS
