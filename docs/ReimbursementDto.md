# ReimbursementDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | [**kotlin.Long**](.md) |  |  [optional]
**to** | [**kotlin.Long**](.md) |  |  [optional]
**deliveryEnvironment** | [**inline**](#DeliveryEnvironmentEnum) |  |  [optional]
**code** | [**kotlin.String**](.md) |  |  [optional]
**codeType** | [**inline**](#CodeTypeEnum) |  |  [optional]
**multiple** | [**inline**](#MultipleEnum) |  |  [optional]
**temporary** | [**kotlin.Boolean**](.md) |  |  [optional]
**reference** | [**kotlin.Boolean**](.md) |  |  [optional]
**flatRateSystem** | [**kotlin.Boolean**](.md) |  |  [optional]
**reimbursementBasePrice** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**referenceBasePrice** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**copaymentSupplement** | [**java.math.BigDecimal**](java.math.BigDecimal.md) |  |  [optional]
**pricingUnit** | [**PricingDto**](PricingDto.md) |  |  [optional]
**pricingSlice** | [**PricingDto**](PricingDto.md) |  |  [optional]
**reimbursementCriterion** | [**ReimbursementCriterionDto**](ReimbursementCriterionDto.md) |  |  [optional]
**copayments** | [**kotlin.Array&lt;CopaymentDto&gt;**](CopaymentDto.md) |  |  [optional]

<a name="DeliveryEnvironmentEnum"></a>
## Enum: deliveryEnvironment
Name | Value
---- | -----
deliveryEnvironment | P, A, H, R

<a name="CodeTypeEnum"></a>
## Enum: codeType
Name | Value
---- | -----
codeType | CNK, PSEUDO

<a name="MultipleEnum"></a>
## Enum: multiple
Name | Value
---- | -----
multiple | M, V
