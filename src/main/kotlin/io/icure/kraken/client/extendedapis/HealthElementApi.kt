package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.HealthElementApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.IcureStubDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import org.taktik.icure.services.external.rest.v2.dto.PatientDto
import io.icure.kraken.client.models.decrypted.HealthElementDto
import io.icure.kraken.client.models.decrypted.PaginatedListHealthElementDto
import io.icure.kraken.client.models.filter.chain.FilterChain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun HealthElementDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): HealthElementDto {
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
suspend fun HealthElementApi.createHealthElement(
    user: UserDto,
    healthElement: HealthElementDto,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
) =
    this.createHealthElement(
        config.encryptHealthElement(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            healthElement
        )
    ).let { config.decryptHealthElement(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.createHealthElements(
    user: UserDto,
    patient: io.icure.kraken.client.models.decrypted.PatientDto,
    healthElements: List<HealthElementDto>,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): List<HealthElementDto> {
    val key = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).firstOrNull()
        ?: throw IllegalArgumentException("No delegation for user")
    val delegations = (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf())
    return this.createHealthElements(
        healthElements.map {
            config.encryptHealthElement(
                user.dataOwnerId(),
                (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
                it
            ).let { ec ->
                ec.copy(
                    secretForeignKeys = setOf(key),
                    cryptedForeignKeys = (delegations + user.dataOwnerId()).fold(ec.cryptedForeignKeys) { m, d ->
                        m + (d to setOf(
                            DelegationDto(
                                user.dataOwnerId(),
                                d,
                                config.crypto.encryptValueForDataOwner(user.dataOwnerId(), d, ec.id, patient.id).first,
                                emptyList()
                            ),
                        ))
                    },
                )
            }
        }
    ).map { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.createHealthElement(
    user: UserDto,
    patient: io.icure.kraken.client.models.decrypted.PatientDto,
    healthElement: HealthElementDto,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): HealthElementDto {
    val key = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).firstOrNull()
        ?: throw IllegalArgumentException("No delegation for user")
    val delegations = (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf())
    return this.createHealthElement(
        config.encryptHealthElement(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            healthElement.initDelegations(user, config)
        ).let { ec ->
            ec.copy(
                secretForeignKeys = setOf(key),
                cryptedForeignKeys = (delegations + user.dataOwnerId()).fold(ec.cryptedForeignKeys) { m, d ->
                    m + (d to setOf(
                        DelegationDto(
                            user.dataOwnerId(),
                            d,
                            config.crypto.encryptValueForDataOwner(user.dataOwnerId(), d, ec.id, patient.id).first,
                            emptyList()
                        ),
                    ))
                },
            )
        }
    ).let { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.newHealthElementDelegations(
    user: UserDto,
    healthElementId: String,
    delegationDto: List<DelegationDto>,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): HealthElementDto {
    return this.newHealthElementDelegations(healthElementId, delegationDto)
        .let { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.listHealthElementsByHCPartyAndPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): List<HealthElementDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.listHealthElementsByHCPartyAndPatientForeignKeys(user, hcPartyId, keys.joinToString(","), config)
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.listHealthElementsByHCPartyAndPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    secretFKeys: String,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): List<HealthElementDto> {
    return this.listHealthElementsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys)
        .map { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.getHealthElement(
    user: UserDto,
    healthElementId: String,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): HealthElementDto {
    return this.getHealthElement(healthElementId).let { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.getHealthElements(
    user: UserDto,
    healthElementIds: ListOfIdsDto,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): List<HealthElementDto> {
    return this.getHealthElements(healthElementIds).map { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.modifyHealthElement(
    user: UserDto,
    healthElement: HealthElementDto,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): HealthElementDto {
    return this.modifyHealthElement(
        config.encryptHealthElement(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            healthElement
        )
    ).let { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.modifyHealthElements(
    user: UserDto,
    healthElements: List<HealthElementDto>,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): List<HealthElementDto> {
    return this.modifyHealthElements(
        healthElements.map {
            config.encryptHealthElement(
                user.dataOwnerId(),
                (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
                it
            )
        }
    ).map { config.decryptHealthElement(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.filterHealthElementsBy(
    user: UserDto,
    filterChainHealthElement: FilterChain<org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>,
    startDocumentId: String?,
    limit: Int?
): PaginatedListHealthElementDto {
    return this.filterHealthElementsBy(filterChainHealthElement, startDocumentId, limit)
        .let { paginatedListHealthElementDto ->
            PaginatedListHealthElementDto(
                rows = paginatedListHealthElementDto.rows.map { healthElementDto ->
                    config.decryptHealthElement(
                        user.dataOwnerId(),
                        healthElementDto
                    )
                },
                pageSize = paginatedListHealthElementDto.pageSize,
                totalSize = paginatedListHealthElementDto.totalSize,
                nextKeyPair = paginatedListHealthElementDto.nextKeyPair
            )
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun HealthElementApi.setHealthElementsDelegations(
    user: UserDto,
    icureStubDtos: List<IcureStubDto>,
    config: CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>
): List<HealthElementDto> {
    return this.setHealthElementsDelegations(icureStubDtos).map { config.decryptHealthElement(user.dataOwnerId(), it) }
}


suspend fun CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>.encryptHealthElement(
    myId: String,
    delegations: Set<String>,
    healthElement: HealthElementDto
): org.taktik.icure.services.external.rest.v2.dto.HealthElementDto {
    return if (healthElement.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        healthElement
    } else {
        val secret = UUID.randomUUID().toString()
        healthElement.copy(encryptionKeys = (delegations + myId).fold(healthElement.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, healthElement.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedHealthElement, marshalledData) = this.marshaller(p)
        sanitizedHealthElement.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<HealthElementDto, org.taktik.icure.services.external.rest.v2.dto.HealthElementDto>.decryptHealthElement(
    myId: String,
    healthElement: org.taktik.icure.services.external.rest.v2.dto.HealthElementDto
): HealthElementDto {
    val key = this.crypto.decryptEncryptionKeys(myId, healthElement.encryptionKeys).firstOrNull()
        ?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(
        healthElement,
        decryptAES(data = Base64.getDecoder().decode(healthElement.encryptedSelf), key = key)
    )
}
