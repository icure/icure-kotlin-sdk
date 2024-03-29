package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.MessageApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import io.icure.kraken.client.models.decrypted.MessageDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.MessagesReadStatusUpdate
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun MessageDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): MessageDto {
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
suspend fun MessageApi.createMessage(
    user: UserDto,
    message: MessageDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
) =
    this.createMessage(
        config.encryptMessage(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            message
        )
    ).let { config.decryptMessage(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.getMessage(
    user: UserDto,
    messageId: String,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): MessageDto {
    return this.getMessage(messageId).let { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.modifyMessage(
    user: UserDto,
    message: MessageDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): MessageDto {
    return this.modifyMessage(
        config.encryptMessage(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            message
        )
    ).let { config.decryptMessage(user.dataOwnerId(), it) }
}


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.deleteDelegation(
    user: UserDto,
    messageId: String,
    delegateId: String,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): MessageDto {
    return this.deleteDelegation(messageId, delegateId).let { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.findMessages(
    user: UserDto,
    startKey: String?,
    startDocumentId: String?,
    limit: Int,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): io.icure.kraken.client.models.decrypted.PaginatedListMessageDto {
    return this.findMessages(startKey, startDocumentId, limit).let {
        io.icure.kraken.client.models.decrypted.PaginatedListMessageDto(
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            rows = it.rows.map { config.decryptMessage(user.dataOwnerId(), it) },
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.findMessagesByFromAddress(
    user: UserDto,
    fromAddress: String?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    hcpId: String?,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): io.icure.kraken.client.models.decrypted.PaginatedListMessageDto {
    return this.findMessagesByFromAddress(fromAddress, startKey, startDocumentId, limit, hcpId).let {
        io.icure.kraken.client.models.decrypted.PaginatedListMessageDto(
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            rows = it.rows.map { config.decryptMessage(user.dataOwnerId(), it) },
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.findMessagesByHCPartyPatientForeignKeys(
    user: UserDto,
    secretFKeys: String,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.findMessagesByHCPartyPatientForeignKeys(secretFKeys)
        .map { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.findMessagesByToAddress(
    user: UserDto,
    toAddress: String?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    reverse: Boolean?,
    hcpId: String?,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): io.icure.kraken.client.models.decrypted.PaginatedListMessageDto {
    return this.findMessagesByToAddress(toAddress, startKey, startDocumentId, limit, reverse, hcpId).let {
        io.icure.kraken.client.models.decrypted.PaginatedListMessageDto(
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            rows = it.rows.map { config.decryptMessage(user.dataOwnerId(), it) },
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.findMessagesByTransportGuid(
    user: UserDto,
    transportGuid: String?,
    received: Boolean?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    hcpId: String?,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): io.icure.kraken.client.models.decrypted.PaginatedListMessageDto {
    return this.findMessagesByTransportGuid(transportGuid, received, startKey, startDocumentId, limit, hcpId).let {
        io.icure.kraken.client.models.decrypted.PaginatedListMessageDto(
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            rows = it.rows.map { config.decryptMessage(user.dataOwnerId(), it) },
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.findMessagesByTransportGuidSentDate(
    user: UserDto,
    from: Long?,
    to: Long?,
    transportGuid: String?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    hcpId: String?,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): io.icure.kraken.client.models.decrypted.PaginatedListMessageDto {
    return this.findMessagesByTransportGuidSentDate(transportGuid, from, to, startKey, startDocumentId, limit, hcpId)
        .let {
            io.icure.kraken.client.models.decrypted.PaginatedListMessageDto(
                pageSize = it.pageSize,
                totalSize = it.totalSize,
                rows = it.rows.map { config.decryptMessage(user.dataOwnerId(), it) },
                nextKeyPair = it.nextKeyPair
            )
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.getChildrenMessages(
    user: UserDto,
    messageId: String,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.getChildrenMessages(messageId).map { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.getMessagesChildren(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.getMessagesChildren(listOfIdsDto).map { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.listMessagesByInvoices(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.listMessagesByInvoices(listOfIdsDto).map { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.listMessagesByTransportGuids(
    user: UserDto,
    hcpId: String,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.listMessagesByTransportGuids(hcpId, listOfIdsDto).map { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.setMessagesReadStatus(
    user: UserDto,
    messagesReadStatusUpdate: MessagesReadStatusUpdate,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.setMessagesReadStatus(messagesReadStatusUpdate).map { config.decryptMessage(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun MessageApi.setMessagesStatusBits(
    user: UserDto,
    status: Int,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>
): List<MessageDto> {
    return this.setMessagesStatusBits(status, listOfIdsDto).map { config.decryptMessage(user.dataOwnerId(), it) }
}


suspend fun CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>.encryptMessage(
    myId: String,
    delegations: Set<String>,
    message: MessageDto
): org.taktik.icure.services.external.rest.v2.dto.MessageDto {
    return if (message.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        message
    } else {
        val secret = UUID.randomUUID().toString()
        message.copy(encryptionKeys = (delegations + myId).fold(message.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, message.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedMessage, marshalledData) = this.marshaller(p)
        sanitizedMessage.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<MessageDto, org.taktik.icure.services.external.rest.v2.dto.MessageDto>.decryptMessage(
    myId: String,
    message: org.taktik.icure.services.external.rest.v2.dto.MessageDto
): MessageDto {
    val key = this.crypto.decryptEncryptionKeys(myId, message.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(message, decryptAES(data = Base64.getDecoder().decode(message.encryptedSelf), key = key))
}
