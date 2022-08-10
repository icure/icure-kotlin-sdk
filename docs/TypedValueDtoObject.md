
# TypedValueDtoObject

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**inline**](#TypeEnum) |  |  [optional]
**booleanValue** | **kotlin.Boolean** |  |  [optional]
**integerValue** | **kotlin.Int** |  |  [optional]
**doubleValue** | **kotlin.Double** |  |  [optional]
**stringValue** | **kotlin.String** |  |  [optional]
**dateValue** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]


<a name="TypeEnum"></a>
## Enum: type
Name | Value
---- | -----
type | BOOLEAN, INTEGER, DOUBLE, STRING, DATE, CLOB, JSON
