package io.icure.kraken.client.crypto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalUnsignedTypes
internal class CryptoUtilsTest {

    @Test
    fun generateKeyPairRSATest() {
        val kp = CryptoUtils.generateKeyPairRSA()

        val pub = kp.publicKeyAsString()
        val priv = kp.privateKeyAsString()

        assertEquals(pub.toPublicKey(), kp.public)
        assertEquals(priv.toPrivateKey(), kp.private)
    }
}
