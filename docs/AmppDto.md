# AmppDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | [**kotlin.Long**](.md) |  |  [optional]
**to** | [**kotlin.Long**](.md) |  |  [optional]
**ctiExtended** | [**kotlin.String**](.md) |  |  [optional]
**orphan** | [**kotlin.Boolean**](.md) |  | 
**leafletLink** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**spcLink** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**rmaPatientLink** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**rmaProfessionalLink** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**parallelCircuit** | [**kotlin.Int**](.md) |  |  [optional]
**parallelDistributor** | [**kotlin.String**](.md) |  |  [optional]
**packMultiplier** | [**kotlin.Int**](.md) |  |  [optional]
**packAmount** | [**QuantityDto**](QuantityDto.md) |  |  [optional]
**packDisplayValue** | [**kotlin.String**](.md) |  |  [optional]
**status** | [**inline**](#StatusEnum) |  |  [optional]
**atcs** | [**kotlin.Array&lt;AtcDto&gt;**](AtcDto.md) |  | 
**crmLink** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**deliveryModusCode** | [**kotlin.String**](.md) |  |  [optional]
**deliveryModus** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**deliveryModusSpecification** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**distributorCompany** | [**CompanyDto**](CompanyDto.md) |  |  [optional]
**singleUse** | [**kotlin.Boolean**](.md) |  |  [optional]
**speciallyRegulated** | [**kotlin.Int**](.md) |  |  [optional]
**abbreviatedName** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**prescriptionName** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**note** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**posologyNote** | [**SamTextDto**](SamTextDto.md) |  |  [optional]
**noGenericPrescriptionReasons** | [**kotlin.Array&lt;SamTextDto&gt;**](SamTextDto.md) |  |  [optional]
**exFactoryPrice** | [**kotlin.Double**](.md) |  |  [optional]
**reimbursementCode** | [**kotlin.Int**](.md) |  |  [optional]
**definedDailyDose** | [**QuantityDto**](QuantityDto.md) |  |  [optional]
**officialExFactoryPrice** | [**kotlin.Double**](.md) |  |  [optional]
**realExFactoryPrice** | [**kotlin.Double**](.md) |  |  [optional]
**pricingInformationDecisionDate** | [**kotlin.Long**](.md) |  |  [optional]
**components** | [**kotlin.Array&lt;AmppComponentDto&gt;**](AmppComponentDto.md) |  |  [optional]
**commercializations** | [**kotlin.Array&lt;CommercializationDto&gt;**](CommercializationDto.md) |  |  [optional]
**supplyProblems** | [**kotlin.Array&lt;SupplyProblemDto&gt;**](SupplyProblemDto.md) |  |  [optional]
**dmpps** | [**kotlin.Array&lt;DmppDto&gt;**](DmppDto.md) |  | 
**vaccineIndicationCodes** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) |  |  [optional]

<a name="StatusEnum"></a>
## Enum: status
Name | Value
---- | -----
status | AUTHORIZED, SUSPENDED, REVOKED
