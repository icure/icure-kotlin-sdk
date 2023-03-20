package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.TimeTableApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import io.icure.kraken.client.models.decrypted.TimeTableDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun TimeTableDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>
): TimeTableDto {
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
suspend fun TimeTableApi.createTimeTable(
    user: UserDto,
    timeTable: TimeTableDto,
    config: CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>
) =
    this.createTimeTable(
        config.encryptTimeTable(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            timeTable
        )
    ).let { config.decryptTimeTable(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.getTimeTable(
    user: UserDto,
    timeTableId: String,
    config: CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>
): TimeTableDto {
    return this.getTimeTable(timeTableId).let { config.decryptTimeTable(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.modifyTimeTable(
    user: UserDto,
    timeTable: TimeTableDto,
    config: CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>
): TimeTableDto {
    return this.modifyTimeTable(
        config.encryptTimeTable(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            timeTable
        )
    ).let { config.decryptTimeTable(user.dataOwnerId(), it) }
}


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.getTimeTablesByAgendaId(
    user: UserDto,
    agendaId: String,
    config: CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>
): List<TimeTableDto> {
    return this.getTimeTablesByAgendaId(agendaId).map { config.decryptTimeTable(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.getTimeTablesByPeriodAndAgendaId(
    user: UserDto,
    startDate: Long,
    endDate: Long,
    agendaId: String,
    config: CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>
): List<TimeTableDto> {
    return this.getTimeTablesByPeriodAndAgendaId(startDate, endDate, agendaId)
        .map { config.decryptTimeTable(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>.encryptTimeTable(
    myId: String,
    delegations: Set<String>,
    timeTable: TimeTableDto
): org.taktik.icure.services.external.rest.v2.dto.TimeTableDto {
    return if (timeTable.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        timeTable
    } else {
        val secret = UUID.randomUUID().toString()
        timeTable.copy(encryptionKeys = (delegations + myId).fold(timeTable.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, timeTable.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedTimeTable, marshalledData) = this.marshaller(p)
        sanitizedTimeTable.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<TimeTableDto, org.taktik.icure.services.external.rest.v2.dto.TimeTableDto>.decryptTimeTable(
    myId: String,
    timeTable: org.taktik.icure.services.external.rest.v2.dto.TimeTableDto
): TimeTableDto {
    val key = this.crypto.decryptEncryptionKeys(myId, timeTable.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(
        timeTable,
        decryptAES(data = Base64.getDecoder().decode(timeTable.encryptedSelf), key = key)
    )
}
