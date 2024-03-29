package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.AccessLogApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import io.icure.kraken.client.models.decrypted.AccessLogDto
import io.icure.kraken.client.models.decrypted.PaginatedListAccessLogDto
import io.icure.kraken.client.models.decrypted.PatientDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun AccessLogDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): AccessLogDto {
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
                    emptyList(),
                ),
            ))
        },
        encryptionKeys = (delegations + user.dataOwnerId()).fold(this.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    user.dataOwnerId(),
                    d,
                    config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, ek).first,
                    emptyList(),
                ),
            ))
        },
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.createAccessLog(
    user: UserDto,
    accessLog: AccessLogDto,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
) =
    this.createAccessLog(
        config.encryptAccessLog(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            accessLog
        )
    ).let { config.decryptAccessLog(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.findAccessLogsByUserAfterDate(
    user: UserDto,
    userId: String,
    accessType: String?,
    startDate: Long?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    descending: Boolean?,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): PaginatedListAccessLogDto {
    return this.findAccessLogsByUserAfterDate(
        userId,
        accessType,
        startDate,
        startKey,
        startDocumentId,
        limit,
        descending
    ).let {
        PaginatedListAccessLogDto(
            rows = it.rows.map { a -> config.decryptAccessLog(user.dataOwnerId(), a) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.listAccessLogsByHCPartyAndPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): List<AccessLogDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.listAccessLogsByHCPartyAndPatientForeignKeys(hcPartyId, keys.joinToString(","))
        .map { config.decryptAccessLog(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.listAccessLogsByHCPartyAndPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    secretFKeys: String,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): List<AccessLogDto> {
    return this.listAccessLogsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys)
        .map { config.decryptAccessLog(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.getAccessLog(
    user: UserDto,
    accessLogId: String,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): AccessLogDto {
    return this.getAccessLog(accessLogId).let { config.decryptAccessLog(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.findAccessLogsBy(
    user: UserDto,
    fromEpoch: Long?,
    toEpoch: Long?,
    startKey: Long?,
    startDocumentId: String?,
    limit: Int?,
    descending: Boolean?,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): PaginatedListAccessLogDto {
    return this.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit, descending)
        .let { paginatedList ->
            PaginatedListAccessLogDto(
                rows = paginatedList.rows.map { config.decryptAccessLog(user.dataOwnerId(), it) },
                pageSize = paginatedList.pageSize,
                totalSize = paginatedList.totalSize,
                nextKeyPair = paginatedList.nextKeyPair
            )
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun AccessLogApi.modifyAccessLog(
    user: UserDto,
    accessLog: AccessLogDto,
    config: CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>
): AccessLogDto {
    return this.modifyAccessLog(
        config.encryptAccessLog(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            accessLog
        )
    ).let { config.decryptAccessLog(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>.encryptAccessLog(
    myId: String,
    delegations: Set<String>,
    accessLog: AccessLogDto
): org.taktik.icure.services.external.rest.v2.dto.AccessLogDto {
    return if (accessLog.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        accessLog
    } else {
        val secret = UUID.randomUUID().toString()
        accessLog.copy(encryptionKeys = (delegations + myId).fold(accessLog.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, accessLog.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedAccessLog, marshalledData) = this.marshaller(p)
        sanitizedAccessLog.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<AccessLogDto, org.taktik.icure.services.external.rest.v2.dto.AccessLogDto>.decryptAccessLog(
    myId: String,
    accessLog: org.taktik.icure.services.external.rest.v2.dto.AccessLogDto
): AccessLogDto {
    val key = this.crypto.decryptEncryptionKeys(myId, accessLog.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(
        accessLog,
        decryptAES(data = Base64.getDecoder().decode(accessLog.encryptedSelf), key = key)
    )
}


