package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.TimeTableApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.fromHexString
import io.icure.kraken.client.models.*
import io.icure.kraken.client.models.decrypted.TimeTableDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import java.util.*

suspend fun TimeTableDto.initDelegations(user: UserDto, config: CryptoConfig<TimeTableDto>): TimeTableDto {
    val delegations =  (user.autoDelegations["all"] ?: setOf()) + (user.autoDelegations["medicalInformation"] ?: setOf())
    val ek = UUID.randomUUID().toString()
    val sfk = UUID.randomUUID().toString()
    return this.copy(
        responsible = user.healthcarePartyId!!,
        author = user.id,
        delegations = (delegations + user.healthcarePartyId!!).fold(this.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    listOf(), user.healthcarePartyId, d, config.crypto.encryptKeyForHcp(user.healthcarePartyId, d, this.id, sfk),
                ),
            ))
        },
        encryptionKeys = (delegations + user.healthcarePartyId!!).fold(this.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    listOf(), user.healthcarePartyId, d, config.crypto.encryptKeyForHcp(user.healthcarePartyId, d, this.id, ek),
                ),
            ))
        },
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.createTimeTable(user: UserDto, timeTable: TimeTableDto, config: CryptoConfig<TimeTableDto>) =
    this.createTimeTable(
        config.encryptTimeTable(
            user.healthcarePartyId!!,
            (user.autoDelegations["all"] ?: setOf()) + (user.autoDelegations["medicalInformation"] ?: setOf()),
            timeTable
        )
    )?.let { config.decryptTimeTable(user.healthcarePartyId!!, it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.getTimeTable(user: UserDto, timeTableId: String, config: CryptoConfig<TimeTableDto>): TimeTableDto?  {
    return this.getTimeTable(timeTableId)?.let { config.decryptTimeTable(user.healthcarePartyId!!, it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.modifyTimeTable(user: UserDto, timeTable: TimeTableDto, config: CryptoConfig<TimeTableDto>) : TimeTableDto?  {
    return this.modifyTimeTable(
        config.encryptTimeTable(
            user.healthcarePartyId!!,
            (user.autoDelegations["all"] ?: setOf()) + (user.autoDelegations["medicalInformation"] ?: setOf()),
            timeTable
        )
    )?.let { config.decryptTimeTable(user.healthcarePartyId!!, it) }
}


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.getTimeTablesByAgendaId(user: UserDto, agendaId: String, config: CryptoConfig<TimeTableDto>) : List<TimeTableDto>?  {
    return this.getTimeTablesByAgendaId(agendaId)?.map { config.decryptTimeTable(user.healthcarePartyId!!, it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun TimeTableApi.getTimeTablesByPeriodAndAgendaId(user: UserDto, startDate: Long, endDate: Long, agendaId: String, config: CryptoConfig<TimeTableDto>) : List<TimeTableDto>?  {
    return this.getTimeTablesByPeriodAndAgendaId(startDate, endDate, agendaId)?.map { config.decryptTimeTable(user.healthcarePartyId!!, it) }
}

suspend fun CryptoConfig<TimeTableDto>.encryptTimeTable(myId: String, delegations: Set<String>, timeTable: TimeTableDto): io.icure.kraken.client.models.TimeTableDto {
    return if (timeTable.encryptionKeys.any { (_,s) -> s.isNotEmpty() }) {
        timeTable
    } else {
        val secret = UUID.randomUUID().toString()
        timeTable.copy(encryptionKeys = (delegations + myId).fold(timeTable.encryptionKeys) { m, d ->
            m + (d to setOf(DelegationDto(listOf(), myId, d, this.crypto.encryptKeyForHcp(myId, d, timeTable.id, secret))))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.let { aesKey ->
            aesKey.replace(
                "-",
                ""
            ).fromHexString()
        } ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedTimeTable, marshalledData) = this.marshaller(p)
        TimeTableMapperFactory.instance.map(sanitizedTimeTable.copy(encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))))
    }
}

suspend fun CryptoConfig<TimeTableDto>.decryptTimeTable(myId: String, timeTable: io.icure.kraken.client.models.TimeTableDto): TimeTableDto = TimeTableMapperFactory.instance.map(timeTable).let { p ->
    val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.let { aesKey ->
        aesKey.replace(
            "-",
            ""
        ).fromHexString()
    } ?: throw IllegalArgumentException("No encryption key for user")
    this.unmarshaller(p, decryptAES(data = Base64.getDecoder().decode(p.encryptedSelf), key = key))
}

@Mapper
interface TimeTableMapper {
    fun map(timeTable: TimeTableDto): io.icure.kraken.client.models.TimeTableDto
    fun map(timeTable: io.icure.kraken.client.models.TimeTableDto): TimeTableDto
}

object TimeTableMapperFactory {
    val instance = Mappers.getMapper(TimeTableMapper::class.java)
}