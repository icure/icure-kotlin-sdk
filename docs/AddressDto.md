# AddressDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressType** | [**inline**](#AddressTypeEnum) |  |  [optional]
**descr** | [**kotlin.String**](.md) |  |  [optional]
**street** | [**kotlin.String**](.md) |  |  [optional]
**houseNumber** | [**kotlin.String**](.md) |  |  [optional]
**postboxNumber** | [**kotlin.String**](.md) |  |  [optional]
**postalCode** | [**kotlin.String**](.md) |  |  [optional]
**city** | [**kotlin.String**](.md) |  |  [optional]
**country** | [**kotlin.String**](.md) |  |  [optional]
**note** | [**kotlin.String**](.md) |  |  [optional]
**telecoms** | [**kotlin.Array&lt;TelecomDto&gt;**](TelecomDto.md) |  | 
**encryptedSelf** | [**kotlin.String**](.md) |  |  [optional]

<a name="AddressTypeEnum"></a>
## Enum: addressType
Name | Value
---- | -----
addressType | home, work, vacation, hospital, clinic, hq, other
