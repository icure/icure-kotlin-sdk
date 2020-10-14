# EmailOrSmsMessageDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attachments** | [**kotlin.Array&lt;MimeAttachmentDto&gt;**](MimeAttachmentDto.md) |  | 
**destination** | [**kotlin.String**](.md) |  |  [optional]
**destinationIsNotPatient** | [**kotlin.Boolean**](.md) |  | 
**destinationName** | [**kotlin.String**](.md) |  |  [optional]
**sendCopyToSender** | [**kotlin.Boolean**](.md) |  | 
**senderName** | [**kotlin.String**](.md) |  |  [optional]
**replyToEmail** | [**kotlin.String**](.md) |  |  [optional]
**content** | [**kotlin.String**](.md) |  |  [optional]
**messageId** | [**kotlin.String**](.md) |  |  [optional]
**patientId** | [**kotlin.String**](.md) |  |  [optional]
**senderId** | [**kotlin.String**](.md) |  |  [optional]
**subject** | [**kotlin.String**](.md) |  |  [optional]
**type** | [**inline**](#TypeEnum) |  |  [optional]

<a name="TypeEnum"></a>
## Enum: type
Name | Value
---- | -----
type | EMAIL, SMS
