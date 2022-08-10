
# CareTeamMemberDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  |
**careTeamMemberType** | [**inline**](#CareTeamMemberTypeEnum) |  |  [optional]
**healthcarePartyId** | **kotlin.String** |  |  [optional]
**quality** | [**CodeStubDto**](CodeStubDto.md) |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]


<a name="CareTeamMemberTypeEnum"></a>
## Enum: careTeamMemberType
Name | Value
---- | -----
careTeamMemberType | physician, specialist, other
