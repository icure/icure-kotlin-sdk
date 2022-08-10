
# InvoiceItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**codeNomenclature** | **kotlin.Long** |  |
**units** | **kotlin.Int** |  |
**reimbursedAmount** | **kotlin.Long** |  |
**patientFee** | **kotlin.Long** |  |
**doctorSupplement** | **kotlin.Long** |  |
**dateCode** | **kotlin.Long** |  |  [optional]
**relatedCode** | **kotlin.Long** |  |  [optional]
**eidItem** | [**EIDItem**](EIDItem.md) |  |  [optional]
**insuranceRef** | **kotlin.String** |  |  [optional]
**insuranceRefDate** | **kotlin.Long** |  |  [optional]
**sideCode** | [**inline**](#SideCodeEnum) |  |  [optional]
**timeOfDay** | [**inline**](#TimeOfDayEnum) |  |  [optional]
**override3rdPayerCode** | **kotlin.Int** |  |  [optional]
**gnotionNihii** | **kotlin.String** |  |  [optional]
**derogationMaxNumber** | [**inline**](#DerogationMaxNumberEnum) |  |  [optional]
**prescriberNorm** | [**inline**](#PrescriberNormEnum) |  |  [optional]
**prescriberNihii** | **kotlin.String** |  |  [optional]
**prescriptionDate** | **kotlin.Long** |  |  [optional]
**personalInterventionCoveredByThirdPartyCode** | **kotlin.Int** |  |  [optional]
**doctorIdentificationNumber** | **kotlin.String** |  |  [optional]
**invoiceRef** | **kotlin.String** |  |  [optional]
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
