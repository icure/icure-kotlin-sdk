package io.icure.kraken.client.crypto

import io.icure.kraken.client.extendedapis.DataOwner
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import java.security.PrivateKey
import java.security.PublicKey
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

interface Crypto {
    suspend fun decryptEncryptionKeys(
        myId: String,
        keys: Map<String, Set<DelegationDto>>,
        specificKeyPairs: List<Pair<RSAPrivateKey, RSAPublicKey>>? = null
    ): Set<String>

    suspend fun encryptAESKeyForDataOwner(
        myId: String,
        delegateId: String,
        objectId: String,
        secret: String
    ): Pair<String, DataOwner?>

    suspend fun encryptValueForDataOwner(
        myId: String,
        delegateId: String,
        objectId: String,
        secret: String
    ): Pair<String, DataOwner?>

    suspend fun addNewKeyPairTo(
        user: UserDto,
        dataOwnerId: String,
        newPubKey: PublicKey,
        newPrivateKey: PrivateKey? = null
    ): DataOwner

    suspend fun addNewKeyPairTo(
        user: UserDto,
        dataOwner: DataOwner,
        newPubKey: PublicKey,
        newPrivateKey: PrivateKey? = null
    ): DataOwner
}
