package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.PatientApi
import io.icure.kraken.client.applyIf
import io.icure.kraken.client.crypto.Crypto
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import io.icure.kraken.client.extendedapis.mapper.PatientMapperFactory
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.IdWithRevDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import io.icure.kraken.client.models.decrypted.PaginatedListPatientDto
import io.icure.kraken.client.models.decrypted.PatientDto
import io.icure.kraken.client.models.filter.chain.FilterChain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import org.taktik.icure.services.external.rest.v2.dto.embed.PersonNameDto
import org.taktik.icure.services.external.rest.v2.dto.embed.PersonNameUseDto
import java.security.PrivateKey
import java.security.PublicKey
import java.util.*

suspend fun PatientDto.addNewKeyPair(
    user: UserDto,
    crypto: Crypto,
    patPublicKey: PublicKey,
    patPrivateKey: PrivateKey? = null
) = crypto.addNewKeyPairTo(user, this.toDataOwner(), patPublicKey, patPrivateKey).let { dataOwner ->
    this.copy(
        publicKey = dataOwner.publicKey,
        hcPartyKeys = dataOwner.hcPartyKeys,
        aesExchangeKeys = dataOwner.aesExchangeKeys,
        transferKeys = dataOwner.transferKeys
    )
}

fun PatientDto.initPatient(): PatientDto {
    return this
        .applyIf({ p -> p.lastName == null && p.hasName(PersonNameUseDto.official) }) { p ->
            p.copy(lastName = p.findName(PersonNameUseDto.official)!!.lastName)
        }
        .applyIf({ p -> p.firstName == null && p.hasName(PersonNameUseDto.official) }) { p ->
            p.copy(firstName = p.findName(PersonNameUseDto.official)!!.firstNames.firstOrNull())
        }
        .applyIf({ p -> p.maidenName == null && p.hasName(PersonNameUseDto.maiden) }) { p ->
            p.copy(maidenName = p.findName(PersonNameUseDto.maiden)!!.lastName)
        }
        .applyIf({ p -> p.alias == null && p.hasName(PersonNameUseDto.nickname) }) { p ->
            p.copy(alias = p.findName(PersonNameUseDto.nickname)!!.lastName)
        }
        .applyIf({ p -> p.lastName != null && !p.hasName(PersonNameUseDto.official) }) { p ->
            p.addName(PersonNameUseDto.official, p.lastName!!, p.firstName)
        }
        .applyIf({ p -> p.maidenName != null && !p.hasName(PersonNameUseDto.maiden) }) { p ->
            p.addName(PersonNameUseDto.maiden, p.maidenName!!, p.firstName)
        }
        .applyIf({ p -> p.alias != null && !p.hasName(PersonNameUseDto.nickname) }) { p ->
            p.addName(PersonNameUseDto.nickname, p.alias!!, p.firstName)
        }
}

fun PatientDto.hasName(nameUse: PersonNameUseDto): Boolean {
    return this.names.any { it.use == nameUse }
}

fun PatientDto.findName(nameUse: PersonNameUseDto): PersonNameDto? {
    return this.names.find { it?.use == nameUse }
}

private fun PatientDto.addName(use: PersonNameUseDto, lastName: String, firstName: String?) =
    this.copy(
        names = (this.names as List<PersonNameDto>) + listOf(
            PersonNameDto(
                lastName = lastName,
                firstNames = listOfNotNull(firstName),
                use = use
            )
        )
    )


suspend fun PatientDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PatientDto {
    val delegates = (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf())
    val ek = UUID.randomUUID().toString()
    val sfk = UUID.randomUUID().toString()

    val (delegationsAndEncryptionKeys, dataOwner) = (delegates + user.dataOwnerId()).fold(this.delegations to null as DataOwner?) { (m, dow), d ->
        val (key, dataOwner) = config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, sfk)
        (m + (d to setOf(DelegationDto(user.dataOwnerId(), d, key, emptyList())))) to (dataOwner ?: dow)
    }.let { (delegations, dow) ->
        (delegates + user.dataOwnerId()).fold(this.encryptionKeys to dow) { (m, dow), d ->
            val (key, dataOwner) = config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, ek)
            (m + (d to setOf(DelegationDto(user.dataOwnerId(), d, key, emptyList())))) to (dataOwner ?: dow)
        }.let { (encryptionKeys, dataOwner) -> (delegations to encryptionKeys) to dataOwner }
    }

    return if (dataOwner != null && dataOwner.dataOwnerId == this.id) this.copy(
        hcPartyKeys = dataOwner.hcPartyKeys,
        rev = dataOwner.rev,
        responsible = this.responsible ?: user.dataOwnerId(),
        author = user.id,
        delegations = delegationsAndEncryptionKeys.first,
        encryptionKeys = delegationsAndEncryptionKeys.second,
    ) else this.copy(
        responsible = this.responsible ?: user.dataOwnerId(),
        author = user.id,
        delegations = delegationsAndEncryptionKeys.first,
        encryptionKeys = delegationsAndEncryptionKeys.second,
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.createPatient(
    user: UserDto,
    patient: PatientDto,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
) =
    this.createPatient(
        config.encryptPatient(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            patient.initPatient().initDelegations(user, config)
        )
    ).let { config.decryptPatient(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.modifyPatient(
    user: UserDto,
    patient: PatientDto,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
) =
    this.modifyPatient(
        config.encryptPatient(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            patient.initPatient()
        )
    ).let { config.decryptPatient(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.bulkDeletePatients(
    user: UserDto,
    patients: List<PatientDto>,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<IdWithRevDto> {
    val currentTime = System.currentTimeMillis()
    val updatedPatients = patients.map { it.copy(endOfLife = currentTime) }

    return bulkUpdatePatients(user, updatedPatients, config)
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.bulkCreatePatients(
    user: UserDto,
    patientDto: List<PatientDto>,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<IdWithRevDto> {
    return this.createPatients(patientDto.map {
        config.encryptPatient(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it.initPatient().initDelegations(user, config)
        )
    })
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.bulkUpdatePatients(
    user: UserDto,
    patientDto: List<PatientDto>,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<IdWithRevDto> {
    return this.modifyPatients(patientDto.map {
        config.encryptPatient(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it.initPatient()
        )
    })
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.filterPatientsBy(
    user: UserDto,
    filterChainPatient: FilterChain<org.taktik.icure.services.external.rest.v2.dto.PatientDto>,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    skip: Int?,
    sort: String?,
    desc: Boolean?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.filterPatientsBy(filterChainPatient, startKey, startDocumentId, limit, skip, sort, desc).let {
        PaginatedListPatientDto(
            rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.findByAccessLogUserAfterDate(
    user: UserDto,
    userId: String,
    accessType: String?,
    startDate: Long?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.findPatientsByAccessLogUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit)
        .let {
            PaginatedListPatientDto(
                rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
                pageSize = it.pageSize,
                totalSize = it.totalSize,
                nextKeyPair = it.nextKeyPair
            )
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.findByExternalId(
    user: UserDto,
    externalId: String,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PatientDto {
    return this.getPatientByExternalId(externalId).let { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.findByNameBirthSsinAuto(
    user: UserDto,
    healthcarePartyId: String?,
    filterValue: String?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    sortDirection: String?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.findPatientsByNameBirthSsinAuto(
        healthcarePartyId,
        filterValue,
        startKey,
        startDocumentId,
        limit,
        sortDirection
    ).let {
        PaginatedListPatientDto(
            rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.fuzzySearch(
    user: UserDto,
    firstName: String?,
    lastName: String?,
    dateOfBirth: Int?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<PatientDto> {
    return this.fuzzySearch(firstName, lastName, dateOfBirth).map { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.getPatient(
    user: UserDto,
    patientId: String,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PatientDto {
    return this.getPatient(patientId).let { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.getPatients(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<PatientDto> {
    return this.getPatients(listOfIdsDto).map { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.listDeletedPatients(
    user: UserDto,
    startDate: Long?,
    endDate: Long?,
    desc: Boolean?,
    startDocumentId: String?,
    limit: Int?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.findDeletedPatients(startDate, endDate, desc, startDocumentId, limit).let {
        PaginatedListPatientDto(
            rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.listDeletedPatientsByName(
    user: UserDto,
    firstName: String?,
    lastName: String?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<PatientDto> {
    return this.listDeletedPatientsByName(firstName, lastName).map { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.listOfMergesAfter(
    user: UserDto,
    date: Long,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): List<PatientDto> {
    return this.listOfMergesAfter(date).map { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.listOfPatientsModifiedAfter(
    user: UserDto,
    date: Long,
    startKey: Long?,
    startDocumentId: String?,
    limit: Int?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.findPatientsModifiedAfter(date, startKey, startDocumentId, limit).let {
        PaginatedListPatientDto(
            rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.listPatients(
    user: UserDto,
    hcPartyId: String?,
    sortField: String?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    sortDirection: String?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.findPatientsByHealthcareParty(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)
        .let {
            PaginatedListPatientDto(
                rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
                pageSize = it.pageSize,
                totalSize = it.totalSize,
                nextKeyPair = it.nextKeyPair
            )
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.listPatientsByHcParty(
    user: UserDto,
    hcPartyId: String,
    sortField: String?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    sortDirection: String?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PaginatedListPatientDto {
    return this.findPatientsByHealthcareParty(hcPartyId, sortField, startKey, startDocumentId, limit, sortDirection)
        .let {
            PaginatedListPatientDto(
                rows = it.rows.map { config.decryptPatient(user.dataOwnerId(), it) },
                pageSize = it.pageSize,
                totalSize = it.totalSize,
                nextKeyPair = it.nextKeyPair
            )
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.mergeInto(
    user: UserDto,
    toId: String,
    fromIds: String,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PatientDto {
    return this.mergeInto(toId, fromIds).let { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.modifyPatientReferral(
    user: UserDto,
    patientId: String,
    referralId: String,
    start: Long?,
    end: Long?,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PatientDto {
    return this.modifyPatientReferral(patientId, referralId, start, end)
        .let { config.decryptPatient(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun PatientApi.newPatientDelegations(
    user: UserDto,
    patientId: String,
    delegationDto: List<DelegationDto>,
    config: CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>
): PatientDto {
    return this.newPatientDelegations(patientId, delegationDto).let { config.decryptPatient(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>.encryptPatient(
    myId: String,
    delegations: Set<String>,
    patient: PatientDto
): org.taktik.icure.services.external.rest.v2.dto.PatientDto {
    return if (patient.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        patient
    } else {
        val secret = UUID.randomUUID().toString()
        val (encryptionKeys, dataOwner) = (delegations + myId).fold(patient.encryptionKeys to null as DataOwner?) { (m, dow), d ->
            val (key, dataOwner) = this.crypto.encryptAESKeyForDataOwner(myId, d, patient.id, secret)
            (m + (d to setOf(DelegationDto(myId, d, key, emptyList())))) to (dataOwner ?: dow)
        }
        if (dataOwner != null && dataOwner.dataOwnerId == patient.id) patient.copy(
            encryptionKeys = encryptionKeys,
            hcPartyKeys = dataOwner.hcPartyKeys,
            rev = dataOwner.rev
        ) else patient.copy(encryptionKeys = encryptionKeys)
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.keyFromHexString()
            ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedPatient, marshalledData) = this.marshaller(p)
        sanitizedPatient.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<PatientDto, org.taktik.icure.services.external.rest.v2.dto.PatientDto>.decryptPatient(
    myId: String,
    patient: org.taktik.icure.services.external.rest.v2.dto.PatientDto
): PatientDto {
    return try {
        val key = this.crypto.decryptEncryptionKeys(myId, patient.encryptionKeys).firstOrNull()?.keyFromHexString()
            ?: throw IllegalArgumentException("No encryption key for user")
        this.unmarshaller(patient, decryptAES(data = Base64.getDecoder().decode(patient.encryptedSelf), key = key))
    } catch (ex: IllegalArgumentException) {
        PatientMapperFactory.instance.map(patient)
    }
}
