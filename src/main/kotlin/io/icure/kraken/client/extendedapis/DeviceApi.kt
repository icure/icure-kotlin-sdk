package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.crypto.Crypto
import org.taktik.icure.services.external.rest.v2.dto.DeviceDto
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import java.security.PrivateKey
import java.security.PublicKey

suspend fun DeviceDto.addNewKeyPair(
    user: UserDto,
    crypto: Crypto,
    devicePublicKey: PublicKey,
    devicePrivateKey: PrivateKey? = null
) = crypto.addNewKeyPairTo(user, this.toDataOwner(), devicePublicKey, devicePrivateKey).let { dataOwner ->
    this.copy(
        publicKey = dataOwner.publicKey,
        hcPartyKeys = dataOwner.hcPartyKeys.map { it.key to it.value.toTypedArray() }.toMap(),
        aesExchangeKeys = dataOwner.aesExchangeKeys,
        transferKeys = dataOwner.transferKeys
    )
}