package io.icure.kraken.client.crypto

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.openssl.EncryptionException
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.ByteBuffer
import java.security.*
import java.security.cert.Certificate
import java.security.cert.X509Certificate
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object CryptoUtils {
    init {
        Security.addProvider(BouncyCastleProvider())
    }

    const val IV_BYTE_LENGTH = 16
    val random: SecureRandom = SecureRandom.getInstance("SHA1PRNG")

    fun encrypt(data: ByteArray, publicKey: Key): ByteArray {
        val cipher: Cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding", "BC")
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        return cipher.doFinal(data)
    }

    fun decrypt(data: ByteArray, privateKey: Key): ByteArray {
        val cipher: Cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding", "BC")
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        return cipher.doFinal(data)
    }

    fun encryptAES(data: ByteArray, key: ByteArray): ByteArray {
        val iv = generateIV(IV_BYTE_LENGTH)
        val cipherData = encryptAES(data, key, iv)
        return iv + cipherData
    }

    fun decryptAESWithAnyKey(data: ByteArray, enckeys: List<String>) =
        enckeys.fold(null) { decrypted: ByteArray?, key: String ->  decrypted ?: try { decryptAES(data, ByteBuffer.wrap(ByteArray(16)).also {
            val uuid: UUID = UUID.fromString(key)
            it.putLong(uuid.mostSignificantBits)
            it.putLong(uuid.leastSignificantBits)
        }.array()) } catch (e:Exception) { null } } ?: throw BadPaddingException("Invalid keys")

    fun encryptAESWithAnyKey(data: ByteArray, key: String) = encryptAES(data, ByteBuffer.wrap(ByteArray(16)).also {
        val uuid: UUID = UUID.fromString(key)
        it.putLong(uuid.mostSignificantBits)
        it.putLong(uuid.leastSignificantBits)
    }.array())

    fun decryptAES(data: ByteArray, key: ByteArray): ByteArray {
        val iv: ByteArray = Arrays.copyOf(data, IV_BYTE_LENGTH)
        val encData: ByteArray = Arrays.copyOfRange(data, IV_BYTE_LENGTH, data.size)
        return decryptAES(encData, key, iv)
    }

    fun encryptAES(data: ByteArray, key: ByteArray, iv: ByteArray): ByteArray {
        val cipher: Cipher =
            Cipher.getInstance("AES/CBC/PKCS7Padding") // js WebCrypto uses PKCS7 as mentioned in the standard.
        val ivSpec = IvParameterSpec(iv)
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), ivSpec)
        return cipher.doFinal(data)
    }

    fun decryptAES(data: ByteArray, key: ByteArray, iv: ByteArray): ByteArray {
        val cipher: Cipher =
            Cipher.getInstance("AES/CBC/PKCS7Padding") // js WebCrypto uses PKCS7 as mentioned in the standard.
        val ivSpec = IvParameterSpec(iv)
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), ivSpec)
        return cipher.doFinal(data)
    }

    fun generateKeyAES(): Key {
        val aesKeyGenerator: KeyGenerator = KeyGenerator.getInstance("AES", "BC")
        aesKeyGenerator.init(256)
        return aesKeyGenerator.generateKey()
    }

    fun generateIV(ivSize: Int): ByteArray {
        val ivBytes = ByteArray(ivSize)
        random.nextBytes(ivBytes)
        return ivBytes
    }

    fun storePkcs12(
        masterCertificate: X509Certificate,
        hcPartyCertificate: X509Certificate,
        hcPartyPrivateKey: PrivateKey,
        hcPartyId: String,
        password: String
    ) {
        //
        // Chain of Trust
        //
        val chain = arrayOfNulls<Certificate>(2)
        chain[1] = masterCertificate
        chain[0] = hcPartyCertificate

        //
        // Storing in PKCS #12 format
        //
        val store: KeyStore = KeyStore.getInstance("PKCS12", "BC")
        store.load(null, null)
        store.setKeyEntry(hcPartyId, hcPartyPrivateKey, null, chain)
        val fos = FileOutputStream("ICure-keystore-$hcPartyId.p12")
        store.store(fos, password.toCharArray())
    }

    fun loadPkcs12(hcPartyId: String, password: String): KeyStore {
        val store: KeyStore = KeyStore.getInstance("PKCS12", "BC")
        val pkcs12File = File("ICure-keystore-$hcPartyId.p12")
        try {
            FileInputStream(pkcs12File).use { fis ->
                store.load(fis, password.toCharArray())
                return store
            }
        } catch (e: Exception) {
            throw EncryptionException(e.message, e)
        }
    }
}
