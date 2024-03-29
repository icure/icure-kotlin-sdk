package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.InvoiceApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.embed.InvoicingCodeDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import org.taktik.icure.services.external.rest.v2.dto.PatientDto
import io.icure.kraken.client.models.decrypted.InvoiceDto
import io.icure.kraken.client.models.filter.chain.FilterChain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun InvoiceDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
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
suspend fun InvoiceApi.createInvoice(
    user: UserDto,
    invoice: InvoiceDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
) =
    this.createInvoice(
        config.encryptInvoice(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            invoice
        )
    ).let { config.decryptInvoice(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.createInvoices(
    user: UserDto,
    invoices: List<InvoiceDto>,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
) =
    this.createInvoices(invoices.map {
        config.encryptInvoice(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it
        )
    }).map { config.decryptInvoice(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.newInvoiceDelegations(
    user: UserDto,
    invoiceId: String,
    delegationDto: List<DelegationDto>,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
    return this.newInvoiceDelegations(invoiceId, delegationDto)
        .let { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByHCPartyAndPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")

    return this.listInvoicesByHCPartyAndPatientForeignKeys(user, hcPartyId, keys.joinToString(","), config)
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByHCPartyAndPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    secretFKeys: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys)
        .map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.getInvoice(
    user: UserDto,
    invoiceId: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
    return this.getInvoice(invoiceId).let { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.modifyInvoice(
    user: UserDto,
    invoice: InvoiceDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
    return this.modifyInvoice(
        config.encryptInvoice(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            invoice
        )
    ).let { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.modifyInvoices(
    user: UserDto,
    invoices: List<InvoiceDto>,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
) =
    this.modifyInvoices(invoices.map {
        config.encryptInvoice(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it
        )
    }).map { config.decryptInvoice(user.dataOwnerId(), it) }


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.appendCodes(
    user: UserDto,
    userId: String,
    type: String,
    sentMediumType: String,
    secretFKeys: String,
    invoicingCodeDto: List<InvoicingCodeDto>,
    insuranceId: String?,
    invoiceId: String?,
    gracePeriod: Int?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.appendCodes(
        userId,
        type,
        sentMediumType,
        secretFKeys,
        invoicingCodeDto,
        insuranceId,
        invoiceId,
        gracePeriod
    ).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.filterInvoicesBy(
    user: UserDto,
    filterChainInvoice: FilterChain<org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.filterInvoicesBy(filterChainInvoice).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.findInvoicesByAuthor(
    user: UserDto,
    hcPartyId: String,
    fromDate: Long?,
    toDate: Long?,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): io.icure.kraken.client.models.decrypted.PaginatedListInvoiceDto {
    return this.findInvoicesByAuthor(hcPartyId, fromDate, toDate, startKey, startDocumentId, limit)
        .let {
            io.icure.kraken.client.models.decrypted.PaginatedListInvoiceDto(rows = it.rows.map {
                config.decryptInvoice(
                    user.dataOwnerId(),
                    it
                )
            }, pageSize = it.pageSize, totalSize = it.totalSize, nextKeyPair = it.nextKeyPair)
        }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.getInvoices(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.getInvoices(listOfIdsDto).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listAllHcpsByStatus(
    user: UserDto,
    status: String,
    listOfIdsDto: ListOfIdsDto,
    from: Long?,
    to: Long?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listAllHcpsByStatus(status, listOfIdsDto, from, to)
        .map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByContactIds(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByContactIds(listOfIdsDto).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listByHcPartyGroupId(
    user: UserDto,
    hcPartyId: String,
    groupId: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId)
        .map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    user: UserDto,
    hcPartyId: String,
    sentMediumType: String,
    invoiceType: String,
    sent: Boolean,
    from: Long?,
    to: Long?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
        hcPartyId,
        sentMediumType,
        invoiceType,
        sent,
        from,
        to
    )
        .map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByHcpartySendingModeStatusDate(
    user: UserDto,
    hcPartyId: String,
    sendingMode: String?,
    status: String?,
    from: Long?,
    to: Long?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status, from, to)
        .map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByIds(
    user: UserDto,
    invoiceIds: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByIds(invoiceIds).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByRecipientsIds(
    user: UserDto,
    recipientIds: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByRecipientsIds(recipientIds).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listInvoicesByServiceIds(
    user: UserDto,
    serviceIds: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listInvoicesByServiceIds(serviceIds).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listToInsurances(
    user: UserDto,
    userIds: String?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listToInsurances(userIds).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listToInsurancesUnsent(
    user: UserDto,
    userIds: String?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listToInsurancesUnsent(userIds).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listToPatients(
    user: UserDto,
    hcPartyId: String?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listToPatients(hcPartyId).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.listToPatientsUnsent(
    user: UserDto,
    hcPartyId: String?,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.listToPatientsUnsent(hcPartyId).map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.mergeTo(
    user: UserDto,
    invoiceId: String,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
    return this.mergeTo(invoiceId, listOfIdsDto).let { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.reassignInvoice(
    user: UserDto,
    invoiceDto: InvoiceDto,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
    return this.reassignInvoice(invoiceDto.let {
        config.encryptInvoice(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it
        )
    }).let { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.removeCodes(
    user: UserDto,
    userId: String,
    serviceId: String,
    secretFKeys: String,
    requestBody: List<String>,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): List<InvoiceDto> {
    return this.removeCodes(userId, serviceId, secretFKeys, requestBody)
        .map { config.decryptInvoice(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun InvoiceApi.validate(
    user: UserDto,
    invoiceId: String,
    scheme: String,
    forcedValue: String,
    config: CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>
): InvoiceDto {
    return this.validate(invoiceId, scheme, forcedValue).let { config.decryptInvoice(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>.encryptInvoice(
    myId: String,
    delegations: Set<String>,
    invoice: InvoiceDto
): org.taktik.icure.services.external.rest.v2.dto.InvoiceDto {
    return if (invoice.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        invoice
    } else {
        val secret = UUID.randomUUID().toString()
        invoice.copy(encryptionKeys = (delegations + myId).fold(invoice.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, invoice.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedInvoice, marshalledData) = this.marshaller(p)
        sanitizedInvoice.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<InvoiceDto, org.taktik.icure.services.external.rest.v2.dto.InvoiceDto>.decryptInvoice(
    myId: String,
    invoice: org.taktik.icure.services.external.rest.v2.dto.InvoiceDto
): InvoiceDto {
    val key = this.crypto.decryptEncryptionKeys(myId, invoice.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(invoice, decryptAES(data = Base64.getDecoder().decode(invoice.encryptedSelf), key = key))
}
