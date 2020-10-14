# UserDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**rev** | [**kotlin.String**](.md) |  |  [optional]
**deletionDate** | [**kotlin.Long**](.md) |  |  [optional]
**created** | [**kotlin.Long**](.md) |  |  [optional]
**name** | [**kotlin.String**](.md) |  |  [optional]
**properties** | [**kotlin.Array&lt;PropertyStubDto&gt;**](PropertyStubDto.md) |  | 
**permissions** | [**kotlin.Array&lt;PermissionDto&gt;**](PermissionDto.md) |  | 
**roles** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**type** | [**inline**](#TypeEnum) |  |  [optional]
**status** | [**inline**](#StatusEnum) |  |  [optional]
**login** | [**kotlin.String**](.md) |  |  [optional]
**passwordHash** | [**kotlin.String**](.md) |  |  [optional]
**secret** | [**kotlin.String**](.md) |  |  [optional]
**use2fa** | [**kotlin.Boolean**](.md) |  |  [optional]
**groupId** | [**kotlin.String**](.md) |  |  [optional]
**healthcarePartyId** | [**kotlin.String**](.md) |  |  [optional]
**patientId** | [**kotlin.String**](.md) |  |  [optional]
**autoDelegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**createdDate** | [**kotlin.Long**](.md) |  |  [optional]
**lastLoginDate** | [**kotlin.Long**](.md) |  |  [optional]
**expirationDate** | [**kotlin.Long**](.md) |  |  [optional]
**activationToken** | [**kotlin.String**](.md) |  |  [optional]
**activationTokenExpirationDate** | [**kotlin.Long**](.md) |  |  [optional]
**passwordToken** | [**kotlin.String**](.md) |  |  [optional]
**passwordTokenExpirationDate** | [**kotlin.Long**](.md) |  |  [optional]
**termsOfUseDate** | [**kotlin.Long**](.md) |  |  [optional]
**email** | [**kotlin.String**](.md) |  |  [optional]
**applicationTokens** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 

<a name="TypeEnum"></a>
## Enum: type
Name | Value
---- | -----
type | database, ldap, token

<a name="StatusEnum"></a>
## Enum: status
Name | Value
---- | -----
status | ACTIVE, DISABLED, REGISTERING
