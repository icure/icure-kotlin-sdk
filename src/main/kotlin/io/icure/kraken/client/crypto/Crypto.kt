package io.icure.kraken.client.crypto

import io.icure.kraken.client.models.DelegationDto

interface Crypto {
    suspend fun decryptEncryptionKeysDto(keys: Map<String, Set<DelegationDto>>): Set<String>
}
