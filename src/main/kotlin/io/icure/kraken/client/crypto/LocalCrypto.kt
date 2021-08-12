package io.icure.kraken.client.crypto

import io.icure.kraken.client.models.DelegationDto
import java.io.IOException
import java.security.*
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import javax.crypto.BadPaddingException
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException

class LocalCrypto(val rsaKeyPairs: Map<String, Pair<RSAPrivateKey, RSAPublicKey>>) : Crypto {
    override suspend fun decryptEncryptionKeysDto(keys: Map<String, Set<DelegationDto>>): Set<String> {

    }

    fun getOwnerHcPartyKey(myId: String, delegateId: String, privateKey: PrivateKey?): ByteArray? {
        val keyMap: Map<String, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey> =
            hcOwnerPartyKeysCache.get(myId,
                Callable<Map<String, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey>> {
                    val response: String = doRestGET("hcparty/$myId")
                    val hcp: HealthcarePartyDto = getGson().fromJson(response, HealthcarePartyDto::class.java)
                    val result: MutableMap<String, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey> =
                        HashMap<String, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey>()
                    for ((key, value) in hcp.getHcPartyKeys()
                        .entrySet()) {
                        result[key] = org.taktik.icure.client.ICureHelper.EncryptedCryptedKey(value.get(0), null)
                    }
                    result
                })
        var k: org.taktik.icure.client.ICureHelper.EncryptedCryptedKey? = keyMap[delegateId]
        if (k == null) {
            val delegateHcParty: HealthcarePartyDto = getHealthcarePartyHelper().get(delegateId)
            val delegatePublicKey: String = delegateHcParty.getPublicKey()
            val myPublicKey: PublicKey = RSAKeysUtils.loadMyKeyPair(myId).getPublic()

            // generate exchange key (plain)
            val exchangeAESKey: Key = CryptoUtils.generateKeyAES()

            // crypting with delegate HcParty public key
            val delegateCryptedKey: String = org.taktik.icure.client.ICureHelper.encodeHex(
                CryptoUtils.encrypt(
                    exchangeAESKey.encoded,
                    RSAKeysUtils.toPublicKey(delegatePublicKey)
                )
            ).toString()

            // crypting with my public key (i.e. owner)
            val myCryptedKey: String = org.taktik.icure.client.ICureHelper.encodeHex(
                CryptoUtils.encrypt(
                    exchangeAESKey.encoded,
                    myPublicKey
                )
            ).toString()

            // update the owner (myself) through REST
            val responseHcPartyKeysUpdate: String = doRestPUT(
                "hcparty/keys",
                Collections.singletonMap(delegateId, arrayOf(myCryptedKey, delegateCryptedKey))
            )
            // It has to be Map<String, String[]>. But weirdly gson convert it to ArrayList
            val newKeyMap: Map<String, ArrayList<String>> =
                getGson().< Map < String, ArrayList<String>>>fromJson<kotlin.collections.MutableMap<kotlin.String?, java.util.ArrayList<kotlin.String?>?>?>(responseHcPartyKeysUpdate, kotlin.collections.MutableMap::class.java)

            // update the caches, delegate and owner
            var existingKeyMapOfOwner: MutableMap<String?, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey?>? =
                hcOwnerPartyKeysCache.getIfPresent(myId)
            if (existingKeyMapOfOwner == null) {
                hcOwnerPartyKeysCache.put(
                    myId,
                    HashMap<String, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey>().also {
                        existingKeyMapOfOwner = it
                    })
            }
            existingKeyMapOfOwner!![delegateId] = org.taktik.icure.client.ICureHelper.EncryptedCryptedKey(
                newKeyMap[delegateId]!![0], null
            )
            var existingKeyMapOfDelegate: MutableMap<String?, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey?>? =
                hcDelegatePartyKeysCache.getIfPresent(delegateId)
            if (existingKeyMapOfDelegate == null) {
                hcDelegatePartyKeysCache.put(
                    delegateId,
                    HashMap<String, org.taktik.icure.client.ICureHelper.EncryptedCryptedKey>().also {
                        existingKeyMapOfDelegate = it
                    })
            }
            existingKeyMapOfDelegate!![myId] = org.taktik.icure.client.ICureHelper.EncryptedCryptedKey(
                newKeyMap[delegateId]!![1], null
            )
            k = org.taktik.icure.client.ICureHelper.EncryptedCryptedKey(myCryptedKey, exchangeAESKey.encoded)
        }
        return k.getDecrypted(privateKey)
    }
}
