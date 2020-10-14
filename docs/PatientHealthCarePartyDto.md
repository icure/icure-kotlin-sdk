# PatientHealthCarePartyDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**inline**](#TypeEnum) |  |  [optional]
**referral** | [**kotlin.Boolean**](.md) |  | 
**healthcarePartyId** | [**kotlin.String**](.md) |  |  [optional]
**sendFormats** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**referralPeriods** | [**kotlin.Array&lt;ReferralPeriodDto&gt;**](ReferralPeriodDto.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="TypeEnum"></a>
## Enum: type
Name | Value
---- | -----
type | doctor, referral, medicalhouse, retirementhome, hospital, other, referringphysician
