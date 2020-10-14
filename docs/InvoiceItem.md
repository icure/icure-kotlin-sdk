# InvoiceItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dateCode** | [**kotlin.Long**](.md) |  |  [optional]
**codeNomenclature** | [**kotlin.Long**](.md) |  | 
**relatedCode** | [**kotlin.Long**](.md) |  |  [optional]
**eidItem** | [**EIDItem**](EIDItem.md) |  |  [optional]
**insuranceRef** | [**kotlin.String**](.md) |  |  [optional]
**insuranceRefDate** | [**kotlin.Long**](.md) |  |  [optional]
**units** | [**kotlin.Int**](.md) |  | 
**reimbursedAmount** | [**kotlin.Long**](.md) |  | 
**patientFee** | [**kotlin.Long**](.md) |  | 
**doctorSupplement** | [**kotlin.Long**](.md) |  | 
**sideCode** | [**inline**](#SideCodeEnum) |  |  [optional]
**timeOfDay** | [**inline**](#TimeOfDayEnum) |  |  [optional]
**override3rdPayerCode** | [**kotlin.Int**](.md) |  |  [optional]
**gnotionNihii** | [**kotlin.String**](.md) |  |  [optional]
**derogationMaxNumber** | [**inline**](#DerogationMaxNumberEnum) |  |  [optional]
**prescriberNorm** | [**inline**](#PrescriberNormEnum) |  |  [optional]
**prescriberNihii** | [**kotlin.String**](.md) |  |  [optional]
**personalInterventionCoveredByThirdPartyCode** | [**kotlin.Int**](.md) |  |  [optional]
**doctorIdentificationNumber** | [**kotlin.String**](.md) |  |  [optional]
**invoiceRef** | [**kotlin.String**](.md) |  |  [optional]
**percentNorm** | [**inline**](#PercentNormEnum) |  |  [optional]

<a name="SideCodeEnum"></a>
## Enum: sideCode
Name | Value
---- | -----
sideCode | None, Left, Right

<a name="TimeOfDayEnum"></a>
## Enum: timeOfDay
Name | Value
---- | -----
timeOfDay | Other, Night, Weekend, Bankholiday, Urgent

<a name="DerogationMaxNumberEnum"></a>
## Enum: derogationMaxNumber
Name | Value
---- | -----
derogationMaxNumber | Other, DerogationMaxNumber, OtherPrescription, SecondPrestationOfDay, ThirdAndNextPrestationOfDay

<a name="PrescriberNormEnum"></a>
## Enum: prescriberNorm
Name | Value
---- | -----
prescriberNorm | None, OnePrescriber, SelfPrescriber, AddedCode, ManyPrescribers

<a name="PercentNormEnum"></a>
## Enum: percentNorm
Name | Value
---- | -----
percentNorm | None, SurgicalAid1, SurgicalAid2, ReducedFee, Ah1n1, HalfPriceSecondAct, InvoiceException, ForInformation
