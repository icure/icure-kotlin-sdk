package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.ReceiptApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import io.icure.kraken.client.models.decrypted.ReceiptDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.nio.ByteBuffer
import java.util.*

suspend fun ReceiptDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>
): ReceiptDto {
    val delegations = (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf())
    val ek = UUID.randomUUID().toString()
    val sfk = UUID.randomUUID().toString()
    return this.copy(
        responsible = user.dataOwnerId(),
        author = user.id,
        delegations = (delegations + user.dataOwnerId()).fold(this.delegations) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    user.dataOwnerId(),
                    d,
                    config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, sfk).first,
                    emptyList()
                ),
            ))
        },
        encryptionKeys = (delegations + user.dataOwnerId()).fold(this.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    user.dataOwnerId(),
                    d,
                    config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, ek).first,
                    emptyList()
                ),
            ))
        },
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ReceiptApi.createReceipt(
    user: UserDto,
    receipt: ReceiptDto,
    config: CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>
) =
    this.createReceipt(
        config.encryptReceipt(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            receipt
        )
    ).let { config.decryptReceipt(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ReceiptApi.getReceipt(
    user: UserDto,
    receiptId: String,
    config: CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>
): ReceiptDto {
    return this.getReceipt(receiptId).let { config.decryptReceipt(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ReceiptApi.modifyReceipt(
    user: UserDto,
    receipt: ReceiptDto,
    config: CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>
): ReceiptDto {
    return this.modifyReceipt(
        config.encryptReceipt(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            receipt
        )
    ).let { config.decryptReceipt(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ReceiptApi.listByReference(
    user: UserDto,
    ref: String,
    config: CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>
): List<ReceiptDto> {
    return this.listByReference(ref).map { config.decryptReceipt(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ReceiptApi.setReceiptAttachment(
    user: UserDto,
    receiptId: String,
    blobType: String,
    requestBody: Flow<ByteBuffer>,
    enckeys: String?,
    config: CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>
): ReceiptDto {
    return this.setReceiptAttachment(receiptId, blobType, requestBody, enckeys)
        .let { config.decryptReceipt(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>.encryptReceipt(
    myId: String,
    delegations: Set<String>,
    receipt: ReceiptDto
): org.taktik.icure.services.external.rest.v2.dto.ReceiptDto {
    return if (receipt.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        receipt
    } else {
        val secret = UUID.randomUUID().toString()
        receipt.copy(encryptionKeys = (delegations + myId).fold(receipt.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, receipt.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedReceipt, marshalledData) = this.marshaller(p)
        sanitizedReceipt.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<ReceiptDto, org.taktik.icure.services.external.rest.v2.dto.ReceiptDto>.decryptReceipt(
    myId: String,
    receipt: org.taktik.icure.services.external.rest.v2.dto.ReceiptDto
): ReceiptDto {
    val key = this.crypto.decryptEncryptionKeys(myId, receipt.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(receipt, decryptAES(data = Base64.getDecoder().decode(receipt.encryptedSelf), key = key))
}
