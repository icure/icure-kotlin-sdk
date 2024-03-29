package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.FormApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import io.icure.kraken.client.models.decrypted.FormDto
import io.icure.kraken.client.models.decrypted.PatientDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun FormDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): FormDto {
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
suspend fun FormApi.createForm(
    user: UserDto,
    form: FormDto,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
) =
    this.createForm(
        config.encryptForm(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            form
        )
    ).let {
        config.decryptForm(user.dataOwnerId(), it)
    }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.newFormDelegations(
    user: UserDto,
    formId: String,
    delegationDto: List<DelegationDto>,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): FormDto {
    return this.newFormDelegations(formId, delegationDto).let { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.listFormsByHCPartyAndPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    healthElementId: String?,
    planOfActionId: String?,
    formTemplateId: String?,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.listFormsByHCPartyAndPatientForeignKeys(
        user,
        hcPartyId,
        keys.joinToString(","),
        healthElementId,
        planOfActionId,
        formTemplateId,
        config
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.listFormsByHCPartyAndPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    secretFKeys: String,
    healthElementId: String?,
    planOfActionId: String?,
    formTemplateId: String?,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.listFormsByHCPartyAndPatientForeignKeys(
        hcPartyId,
        secretFKeys,
        healthElementId,
        planOfActionId,
        formTemplateId
    ).map { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getForm(
    user: UserDto,
    formId: String,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): FormDto {
    return this.getForm(formId).let { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.modifyForm(
    user: UserDto,
    form: FormDto,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): FormDto {
    return this.modifyForm(
        config.encryptForm(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            form
        )
    ).let { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.modifyForms(
    user: UserDto,
    form: List<FormDto>,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.modifyForms(
        form.map {
            config.encryptForm(
                user.dataOwnerId(),
                (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
                it
            )
        }
    ).map { config.decryptForm(user.dataOwnerId(), it) }
}


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.createForms(
    user: UserDto,
    form: List<FormDto>,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.createForms(
        form.map {
            config.encryptForm(
                user.dataOwnerId(),
                (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
                it
            )
        }
    ).map { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getChildrenForms(
    user: UserDto,
    formId: String,
    hcPartyId: String,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.getChildrenForms(formId, hcPartyId).map { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getFormByLogicalUuid(
    user: UserDto,
    logicalUuid: String,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): FormDto {
    return this.getFormByLogicalUuid(logicalUuid).let { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getFormByUniqueId(
    user: UserDto,
    uniqueId: String,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): FormDto {
    return this.getFormByUniqueId(uniqueId).let { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getForms(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.getForms(listOfIdsDto).map { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getFormsByLogicalUuid(
    user: UserDto,
    logicalUuid: String,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.getFormsByLogicalUuid(logicalUuid).map { config.decryptForm(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun FormApi.getFormsByUniqueId(
    user: UserDto,
    uniqueId: String,
    config: CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>
): List<FormDto> {
    return this.getFormsByUniqueId(uniqueId).map { config.decryptForm(user.dataOwnerId(), it) }
}


suspend fun CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>.encryptForm(
    myId: String,
    delegations: Set<String>,
    form: FormDto
): org.taktik.icure.services.external.rest.v2.dto.FormDto {
    return if (form.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        form
    } else {
        val secret = UUID.randomUUID().toString()
        form.copy(encryptionKeys = (delegations + myId).fold(form.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, form.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedForm, marshalledData) = this.marshaller(p)
        sanitizedForm.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<FormDto, org.taktik.icure.services.external.rest.v2.dto.FormDto>.decryptForm(
    myId: String,
    form: org.taktik.icure.services.external.rest.v2.dto.FormDto
): FormDto {
    val key = this.crypto.decryptEncryptionKeys(myId, form.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(form, decryptAES(data = Base64.getDecoder().decode(form.encryptedSelf), key = key))
}

