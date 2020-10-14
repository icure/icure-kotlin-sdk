# PatientDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**rev** | [**kotlin.String**](.md) |  |  [optional]
**created** | [**kotlin.Long**](.md) |  |  [optional]
**modified** | [**kotlin.Long**](.md) |  |  [optional]
**author** | [**kotlin.String**](.md) |  |  [optional]
**responsible** | [**kotlin.String**](.md) |  |  [optional]
**medicalLocationId** | [**kotlin.String**](.md) |  |  [optional]
**tags** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**codes** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**endOfLife** | [**kotlin.Long**](.md) |  |  [optional]
**deletionDate** | [**kotlin.Long**](.md) |  |  [optional]
**firstName** | [**kotlin.String**](.md) |  |  [optional]
**lastName** | [**kotlin.String**](.md) |  |  [optional]
**companyName** | [**kotlin.String**](.md) |  |  [optional]
**languages** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**addresses** | [**kotlin.Array&lt;AddressDto&gt;**](AddressDto.md) |  | 
**civility** | [**kotlin.String**](.md) |  |  [optional]
**gender** | [**inline**](#GenderEnum) |  |  [optional]
**mergeToPatientId** | [**kotlin.String**](.md) |  |  [optional]
**mergedIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**nonDuplicateIds** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**encryptedAdministrativesDocuments** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**alias** | [**kotlin.String**](.md) |  |  [optional]
**active** | [**kotlin.Boolean**](.md) |  | 
**deactivationReason** | [**inline**](#DeactivationReasonEnum) |  | 
**ssin** | [**kotlin.String**](.md) |  |  [optional]
**maidenName** | [**kotlin.String**](.md) |  |  [optional]
**spouseName** | [**kotlin.String**](.md) |  |  [optional]
**partnerName** | [**kotlin.String**](.md) |  |  [optional]
**personalStatus** | [**inline**](#PersonalStatusEnum) |  |  [optional]
**dateOfBirth** | [**kotlin.Int**](.md) |  |  [optional]
**dateOfDeath** | [**kotlin.Int**](.md) |  |  [optional]
**timestampOfLatestEidReading** | [**kotlin.Long**](.md) |  |  [optional]
**placeOfBirth** | [**kotlin.String**](.md) |  |  [optional]
**placeOfDeath** | [**kotlin.String**](.md) |  |  [optional]
**education** | [**kotlin.String**](.md) |  |  [optional]
**profession** | [**kotlin.String**](.md) |  |  [optional]
**note** | [**kotlin.String**](.md) |  |  [optional]
**administrativeNote** | [**kotlin.String**](.md) |  |  [optional]
**comment** | [**kotlin.String**](.md) |  |  [optional]
**warning** | [**kotlin.String**](.md) |  |  [optional]
**nationality** | [**kotlin.String**](.md) |  |  [optional]
**preferredUserId** | [**kotlin.String**](.md) |  |  [optional]
**picture** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md) |  |  [optional]
**externalId** | [**kotlin.String**](.md) |  |  [optional]
**insurabilities** | [**kotlin.Array&lt;InsurabilityDto&gt;**](InsurabilityDto.md) |  | 
**partnerships** | [**kotlin.Array&lt;PartnershipDto&gt;**](PartnershipDto.md) |  | 
**patientHealthCareParties** | [**kotlin.Array&lt;PatientHealthCarePartyDto&gt;**](PatientHealthCarePartyDto.md) |  | 
**financialInstitutionInformation** | [**kotlin.Array&lt;FinancialInstitutionInformationDto&gt;**](FinancialInstitutionInformationDto.md) |  | 
**medicalHouseContracts** | [**kotlin.Array&lt;MedicalHouseContractDto&gt;**](MedicalHouseContractDto.md) |  | 
**parameters** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**patientProfessions** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**fatherBirthCountry** | [**CodeStubDto**](CodeStubDto.md) |  |  [optional]
**birthCountry** | [**CodeStubDto**](CodeStubDto.md) |  |  [optional]
**nativeCountry** | [**CodeStubDto**](CodeStubDto.md) |  |  [optional]
**socialStatus** | [**CodeStubDto**](CodeStubDto.md) |  |  [optional]
**mainSourceOfIncome** | [**CodeStubDto**](CodeStubDto.md) |  |  [optional]
**schoolingInfos** | [**kotlin.Array&lt;SchoolingInfoDto&gt;**](SchoolingInfoDto.md) |  | 
**employementInfos** | [**kotlin.Array&lt;EmploymentInfoDto&gt;**](EmploymentInfoDto.md) |  | 
**properties** | [**kotlin.Array&lt;PropertyStubDto&gt;**](PropertyStubDto.md) |  | 
**hcPartyKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**privateKeyShamirPartitions** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**publicKey** | [**kotlin.String**](.md) |  |  [optional]
**secretForeignKeys** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**cryptedForeignKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**delegations** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptionKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;DelegationDto&gt;&gt;**](.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="GenderEnum"></a>
## Enum: gender
Name | Value
---- | -----
gender | M, F, I, C, Y, X, U

<a name="DeactivationReasonEnum"></a>
## Enum: deactivationReason
Name | Value
---- | -----
deactivationReason | deceased, moved, other_doctor, retired, no_contact, unknown, none

<a name="PersonalStatusEnum"></a>
## Enum: personalStatus
Name | Value
---- | -----
personalStatus | single, in_couple, married, separated, divorced, divorcing, widowed, widower, complicated, unknown, contract, other
