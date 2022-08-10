
# CareTeamMembershipDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **kotlin.Long** |  |  [optional]
**endDate** | **kotlin.Long** |  |  [optional]
**careTeamMemberId** | **kotlin.String** |  |  [optional]
**membershipType** | [**inline**](#MembershipTypeEnum) |  |  [optional]
**encryptedSelf** | **kotlin.String** | The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys. |  [optional]


<a name="MembershipTypeEnum"></a>
## Enum: membershipType
Name | Value
---- | -----
membershipType | doctor, mutuality, patient, specialist, other
