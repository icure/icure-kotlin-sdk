package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.DocumentApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import org.taktik.icure.services.external.rest.v2.dto.MessageDto
import org.taktik.icure.services.external.rest.v2.dto.PatientDto
import io.icure.kraken.client.models.decrypted.DocumentDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.nio.ByteBuffer
import java.util.*

suspend fun DocumentDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): DocumentDto {
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
suspend fun DocumentApi.createDocument(
    user: UserDto,
    document: DocumentDto,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
) =
    this.createDocument(
        config.encryptDocument(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            document.initDelegations(user, config)
        )
    ).let { config.decryptDocument(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.findDocumentsByHCPartyPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.findDocumentsByHCPartyPatientForeignKeys(user, hcPartyId, keys.joinToString(","), config)
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.listDocumentByTypeHCPartyMessage(
    user: UserDto,
    documentTypeCode: String,
    hcPartyId: String,
    message: MessageDto,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), message.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.listDocumentByTypeHCPartyMessageSecretFKeys(documentTypeCode, hcPartyId, keys.joinToString(",")).map {
        config.decryptDocument(
            user.dataOwnerId(), it
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.findDocumentsByHCPartyPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    secretFKeys: String,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    return this.listDocumentsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys)
        .map { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.listDocumentByTypeHCPartyMessageSecretFKeys(
    user: UserDto,
    documentTypeCode: String,
    hcPartyId: String,
    secretFKeys: String,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    return this.listDocumentByTypeHCPartyMessageSecretFKeys(documentTypeCode, hcPartyId, secretFKeys)
        .map { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.findWithoutDelegation(
    user: UserDto,
    limit: Int?,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    return this.findWithoutDelegation(limit).map { config.decryptDocument(user.dataOwnerId(), it) }
}


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.getDocument(
    user: UserDto,
    documentId: String,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): DocumentDto {
    return this.getDocument(documentId).let { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.modifyDocument(
    user: UserDto,
    document: DocumentDto,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): DocumentDto {
    return this.modifyDocument(
        config.encryptDocument(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            document
        )
    ).let { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.modifyDocuments(
    user: UserDto,
    documents: List<DocumentDto>,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    return this.modifyDocuments(documents.map {
        config.encryptDocument(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it
        )
    }).map { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.deleteAttachment(
    user: UserDto,
    documentId: String,
    rev: String,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): DocumentDto {
    return this.deleteAttachment(documentId, rev).let { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.setDocumentAttachment(
    user: UserDto,
    documentId: String,
    rev: String,
    utis: List<String>,
    requestBody: Flow<ByteBuffer>,
    contentLength: Long,
    enckeys: String?,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): DocumentDto {
    return this.setDocumentAttachment(documentId, rev, utis, requestBody, contentLength, enckeys)
        .let { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.getDocumentsByExternalUuid(
    user: UserDto,
    externalUuid: String,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    return this.getDocumentsByExternalUuid(externalUuid).map { config.decryptDocument(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun DocumentApi.getDocuments(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>
): List<DocumentDto> {
    return this.getDocuments(listOfIdsDto).map { config.decryptDocument(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>.encryptDocument(
    myId: String,
    delegations: Set<String>,
    document: DocumentDto
): org.taktik.icure.services.external.rest.v2.dto.DocumentDto {
    return if (document.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        document
    } else {
        val secret = UUID.randomUUID().toString()
        document.copy(encryptionKeys = (delegations + myId).fold(document.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, document.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedDocument, marshalledData) = this.marshaller(p)
        sanitizedDocument.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<DocumentDto, org.taktik.icure.services.external.rest.v2.dto.DocumentDto>.decryptDocument(
    myId: String,
    document: org.taktik.icure.services.external.rest.v2.dto.DocumentDto
): DocumentDto {
    val key = this.crypto.decryptEncryptionKeys(myId, document.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(document, decryptAES(data = Base64.getDecoder().decode(document.encryptedSelf), key = key))
}
