
# DmppDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **kotlin.String** |  |  [optional]
**from** | **kotlin.Long** |  |  [optional]
**to** | **kotlin.Long** |  |  [optional]
**deliveryEnvironment** | [**inline**](#DeliveryEnvironmentEnum) |  |  [optional]
**code** | **kotlin.String** |  |  [optional]
**codeType** | [**inline**](#CodeTypeEnum) |  |  [optional]
**price** | **kotlin.String** |  |  [optional]
**cheap** | **kotlin.Boolean** |  |  [optional]
**cheapest** | **kotlin.Boolean** |  |  [optional]
**reimbursable** | **kotlin.Boolean** |  |  [optional]
**reimbursements** | [**kotlin.collections.List&lt;ReimbursementDto&gt;**](ReimbursementDto.md) |  |  [optional]
**productId** | **kotlin.String** |  |  [optional]


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



