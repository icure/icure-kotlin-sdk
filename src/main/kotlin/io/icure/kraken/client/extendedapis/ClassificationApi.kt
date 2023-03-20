package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.ClassificationApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import io.icure.kraken.client.models.decrypted.ClassificationDto
import io.icure.kraken.client.models.decrypted.PatientDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun ClassificationDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): ClassificationDto {
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
suspend fun ClassificationApi.createClassification(
    user: UserDto,
    classification: ClassificationDto,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
) =
    this.createClassification(
        config.encryptClassification(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            classification
        )
    ).let { config.decryptClassification(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ClassificationApi.getClassificationByHcPartyId(
    user: UserDto,
    ids: String,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): List<ClassificationDto> {
    return this.getClassificationByHcPartyId(ids).map { config.decryptClassification(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ClassificationApi.newClassificationDelegations(
    user: UserDto,
    classificationId: String,
    delegationDto: List<DelegationDto>,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): ClassificationDto {
    return this.newClassificationDelegations(classificationId, delegationDto)
        .let { config.decryptClassification(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ClassificationApi.findByHCPartyPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): List<ClassificationDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.findClassificationsByHCPartyPatientForeignKeys(user, hcPartyId, keys.joinToString(","), config)
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ClassificationApi.findClassificationsByHCPartyPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    secretFKeys: String,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): List<ClassificationDto> {
    return this.findClassificationsByHCPartyPatientForeignKeys(hcPartyId, secretFKeys)
        .map { config.decryptClassification(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ClassificationApi.getClassification(
    user: UserDto,
    classificationId: String,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): ClassificationDto {
    return this.getClassification(classificationId).let { config.decryptClassification(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ClassificationApi.modifyClassification(
    user: UserDto,
    classification: ClassificationDto,
    config: CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>
): ClassificationDto {
    return this.modifyClassification(
        config.encryptClassification(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            classification
        )
    ).let { config.decryptClassification(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>.encryptClassification(
    myId: String,
    delegations: Set<String>,
    classification: ClassificationDto
): org.taktik.icure.services.external.rest.v2.dto.ClassificationDto {
    return if (classification.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        classification
    } else {
        val secret = UUID.randomUUID().toString()
        classification.copy(encryptionKeys = (delegations + myId).fold(classification.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, classification.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedClassification, marshalledData) = this.marshaller(p)
        sanitizedClassification.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<ClassificationDto, org.taktik.icure.services.external.rest.v2.dto.ClassificationDto>.decryptClassification(
    myId: String,
    classification: org.taktik.icure.services.external.rest.v2.dto.ClassificationDto
): ClassificationDto {
    val key = this.crypto.decryptEncryptionKeys(myId, classification.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(
        classification,
        decryptAES(data = Base64.getDecoder().decode(classification.encryptedSelf), key = key)
    )
}


