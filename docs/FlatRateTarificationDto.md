
# FlatRateTarificationDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**valorisations** | [**kotlin.collections.List&lt;ValorisationDto&gt;**](ValorisationDto.md) |  | 
**code** | **kotlin.String** |  |  [optional]
**flatRateType** | [**inline**](#FlatRateTypeEnum) |  |  [optional]
**label** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]


<a name="FlatRateTypeEnum"></a>
## Enum: flatRateType
Name | Value
---- | -----
flatRateType | physician, physiotherapist, nurse, ptd



