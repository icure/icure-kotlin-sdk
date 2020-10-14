# DmppDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) |  |  [optional]
**from** | [**kotlin.Long**](.md) |  |  [optional]
**to** | [**kotlin.Long**](.md) |  |  [optional]
**deliveryEnvironment** | [**inline**](#DeliveryEnvironmentEnum) |  |  [optional]
**code** | [**kotlin.String**](.md) |  |  [optional]
**codeType** | [**inline**](#CodeTypeEnum) |  |  [optional]
**price** | [**kotlin.String**](.md) |  |  [optional]
**cheap** | [**kotlin.Boolean**](.md) |  |  [optional]
**cheapest** | [**kotlin.Boolean**](.md) |  |  [optional]
**reimbursable** | [**kotlin.Boolean**](.md) |  |  [optional]
**reimbursements** | [**kotlin.Array&lt;ReimbursementDto&gt;**](ReimbursementDto.md) |  |  [optional]
**productId** | [**kotlin.String**](.md) |  |  [optional]

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
