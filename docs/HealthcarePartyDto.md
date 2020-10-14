# HealthcarePartyDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  | 
**rev** | [**kotlin.String**](.md) |  |  [optional]
**deletionDate** | [**kotlin.Long**](.md) |  |  [optional]
**name** | [**kotlin.String**](.md) |  |  [optional]
**lastName** | [**kotlin.String**](.md) |  |  [optional]
**firstName** | [**kotlin.String**](.md) |  |  [optional]
**gender** | [**inline**](#GenderEnum) |  |  [optional]
**civility** | [**kotlin.String**](.md) |  |  [optional]
**companyName** | [**kotlin.String**](.md) |  |  [optional]
**speciality** | [**kotlin.String**](.md) |  |  [optional]
**bankAccount** | [**kotlin.String**](.md) |  |  [optional]
**bic** | [**kotlin.String**](.md) |  |  [optional]
**proxyBankAccount** | [**kotlin.String**](.md) |  |  [optional]
**proxyBic** | [**kotlin.String**](.md) |  |  [optional]
**invoiceHeader** | [**kotlin.String**](.md) |  |  [optional]
**cbe** | [**kotlin.String**](.md) |  |  [optional]
**ehp** | [**kotlin.String**](.md) |  |  [optional]
**userId** | [**kotlin.String**](.md) |  |  [optional]
**parentId** | [**kotlin.String**](.md) |  |  [optional]
**convention** | [**kotlin.Int**](.md) |  |  [optional]
**nihii** | [**kotlin.String**](.md) |  |  [optional]
**nihiiSpecCode** | [**kotlin.String**](.md) |  |  [optional]
**ssin** | [**kotlin.String**](.md) |  |  [optional]
**addresses** | [**kotlin.Array&lt;AddressDto&gt;**](AddressDto.md) |  | 
**languages** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  | 
**picture** | [**kotlin.Array&lt;ByteArray&gt;**](ByteArray.md) |  |  [optional]
**statuses** | [**inline**](#kotlin.Array&lt;StatusesEnum&gt;) |  | 
**specialityCodes** | [**kotlin.Array&lt;CodeStubDto&gt;**](CodeStubDto.md) |  | 
**sendFormats** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**notes** | [**kotlin.String**](.md) |  |  [optional]
**financialInstitutionInformation** | [**kotlin.Array&lt;FinancialInstitutionInformationDto&gt;**](FinancialInstitutionInformationDto.md) |  | 
**billingType** | [**kotlin.String**](.md) |  |  [optional]
**type** | [**kotlin.String**](.md) |  |  [optional]
**contactPerson** | [**kotlin.String**](.md) |  |  [optional]
**contactPersonHcpId** | [**kotlin.String**](.md) |  |  [optional]
**flatRateTarifications** | [**kotlin.Array&lt;FlatRateTarificationDto&gt;**](FlatRateTarificationDto.md) |  | 
**importedData** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**options** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**hcPartyKeys** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Array&lt;kotlin.String&gt;&gt;**](.md) |  | 
**privateKeyShamirPartitions** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;**](.md) |  | 
**publicKey** | [**kotlin.String**](.md) |  |  [optional]

<a name="GenderEnum"></a>
## Enum: gender
Name | Value
---- | -----
gender | M, F, I, C, Y, X, U

<a name="kotlin.Array<StatusesEnum>"></a>
## Enum: statuses
Name | Value
---- | -----
statuses | trainee, withconvention, accreditated
