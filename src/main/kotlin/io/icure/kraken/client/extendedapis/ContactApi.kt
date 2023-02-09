package io.icure.kraken.client.extendedapis

import com.fasterxml.jackson.databind.ObjectMapper
import io.icure.kraken.client.apis.ContactApi
import io.icure.kraken.client.crypto.Crypto
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.ContentDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.external.rest.v2.dto.IcureStubDto
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
import io.icure.kraken.client.models.decrypted.ContactDto
import io.icure.kraken.client.models.decrypted.PaginatedListContactDto
import io.icure.kraken.client.models.decrypted.PatientDto
import io.icure.kraken.client.models.decrypted.ServiceDto
import io.icure.kraken.client.models.filter.chain.FilterChain
import io.icure.kraken.client.models.filter.contact.ContactByServiceIdsFilter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun ContactDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): ContactDto {
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
suspend fun ContactApi.createContact(
    user: UserDto,
    contact: ContactDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
) =
    this.createContact(
        config.encryptContact(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            contact
        )
    ).let { config.decryptContact(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.createContact(
    user: UserDto,
    patient: PatientDto,
    contact: ContactDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): ContactDto {
    val key = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).firstOrNull()
        ?: throw IllegalArgumentException("No delegation for user")
    val delegations = (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf())
    return this.createContact(
        config.encryptContact(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            contact.initDelegations(user, config)
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
    ).let { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.modifyContact(
    user: UserDto,
    contact: ContactDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
) =
    this.modifyContact(
        config.encryptContact(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            contact
        )
    ).let { config.decryptContact(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.createContacts(
    user: UserDto,
    contactDto: List<ContactDto>,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.createContacts(contactDto.map {
        config.encryptContact(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it
        )
    }).map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.modifyContacts(
    user: UserDto,
    contactDto: List<ContactDto>,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.modifyContacts(contactDto.map {
        config.encryptContact(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            it
        )
    }).map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.deleteServices(
    user: UserDto,
    patient: PatientDto,
    services: List<ServiceDto>,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): ContactDto {
    val currentTime = System.currentTimeMillis()
    return this.createContact(
        user,
        patient,
        ContactDto(
            id = UUID.randomUUID().toString(),
            services = services.map {
                ServiceDto(
                    id = it.id,
                    created = it.created,
                    modified = currentTime,
                    endOfLife = currentTime
                )
            }),
        config
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.updateServices(
    user: UserDto,
    patient: PatientDto,
    services: List<ServiceDto>,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    val serviceIds = services.map { it.id }
    val contactIds = this.matchContactsBy(ContactByServiceIdsFilter(ids = serviceIds))

    return this.getContacts(user, ListOfIdsDto().apply { this.ids =contactIds }, config).map { contactDto ->
        val contactServiceIds = contactDto.services.map { service -> service.id }.intersect(serviceIds.toSet())
        val contactServices = services.filter { service -> service.id in contactServiceIds }
        val subContacts =
            contactDto.subContacts.filter { subContact -> subContact.services.any { serviceLink -> serviceLink.serviceId in contactServiceIds } }

        contactDto.copy(
            id = UUID.randomUUID().toString(),
            subContacts = subContacts,
            services = contactServices,
            modified = System.currentTimeMillis()
        )
    }.map { updatedContact ->
        this.createContact(user, patient, updatedContact, config)
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.filterContactsBy(
    user: UserDto,
    filterChainContact: FilterChain<org.taktik.icure.services.external.rest.v2.dto.ContactDto>,
    startKey: String?,
    startDocumentId: String?,
    limit: Int?,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): PaginatedListContactDto {
    return this.filterContactsBy(filterChainContact, startDocumentId, limit).let {
        PaginatedListContactDto(
            rows = it.rows.map { config.decryptContact(user.dataOwnerId(), it) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.getContact(
    user: UserDto,
    contactId: String,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): ContactDto {
    return this.getContact(contactId).let { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.getContacts(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.getContacts(listOfIdsDto).map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.filterServicesBy(
    user: UserDto,
    filterChainService: FilterChain<org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto>,
    startDocumentId: String?,
    limit: Int?,
    crypto: Crypto
): io.icure.kraken.client.models.decrypted.PaginatedListServiceDto {
    return this.filterServicesBy(filterChainService, startDocumentId, limit).let {
        io.icure.kraken.client.models.decrypted.PaginatedListServiceDto(rows = it.rows.let { servList ->
            crypto.decryptServices(
                user.dataOwnerId(),
                null,
                servList
            )
        }, pageSize = it.pageSize, totalSize = it.totalSize, nextKeyPair = it.nextKeyPair)
    }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.findByHCPartyFormId(
    user: UserDto,
    hcPartyId: String,
    formId: String,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.listContactsByHCPartyAndFormId(hcPartyId, formId).map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.findByHCPartyFormIds(
    user: UserDto,
    hcPartyId: String,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.listContactsByHCPartyAndFormIds(hcPartyId, listOfIdsDto)
        .map { config.decryptContact(user.dataOwnerId(), it) }

}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.findByHCPartyPatient(
    user: UserDto,
    hcPartyId: String,
    patient: PatientDto,
    planOfActionsIds: String?,
    skipClosedContacts: Boolean?,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    val keys = config.crypto.decryptEncryptionKeys(user.dataOwnerId(), patient.delegations).takeIf { it.isNotEmpty() }
        ?: throw IllegalArgumentException("No delegation for user")
    return this.listContactsByHCPartyAndPatientSecretFKeys(
        hcPartyId,
        keys.joinToString(","),
        planOfActionsIds,
        skipClosedContacts
    ).map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.findByHCPartyServiceId(
    user: UserDto,
    hcPartyId: String,
    serviceId: String,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.listContactByHCPartyServiceId(hcPartyId, serviceId)
        .map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.findContactsByExternalId(
    user: UserDto,
    externalId: String,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.listContactsByExternalId(externalId).map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.findContactsByHCPartyPatientForeignKeys(
    user: UserDto,
    hcPartyId: String,
    listOfIdsDto: ListOfIdsDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.listContactsByHCPartyAndPatientForeignKeys(hcPartyId, listOfIdsDto)
        .map { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.listContactsByOpeningDate(
    user: UserDto,
    startKey: Long,
    endKey: Long,
    hcpartyid: String,
    startDocumentId: String?,
    limit: Int?,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): PaginatedListContactDto {
    return this.findContactsByOpeningDate(startKey, endKey, hcpartyid, startDocumentId, limit).let {
        PaginatedListContactDto(
            rows = it.rows.map { config.decryptContact(user.dataOwnerId(), it) },
            pageSize = it.pageSize,
            totalSize = it.totalSize,
            nextKeyPair = it.nextKeyPair
        )
    }

}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.listServices(user: UserDto, listOfIdsDto: ListOfIdsDto, crypto: Crypto): List<ServiceDto> {
    return this.getServices(listOfIdsDto).let { crypto.decryptServices(user.dataOwnerId(), null, it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.listServicesByAssociationId(
    user: UserDto,
    associationId: String,
    crypto: Crypto
): List<ServiceDto> {
    return this.listServicesByAssociationId(associationId).let { crypto.decryptServices(user.dataOwnerId(), null, it) }
}


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.listServicesByHealthElementId(
    user: UserDto,
    healthElementId: String,
    hcPartyId: String,
    crypto: Crypto
): List<ServiceDto> {
    return this.listServicesByHealthElementId(healthElementId, hcPartyId)
        .let { crypto.decryptServices(user.dataOwnerId(), null, it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.listServicesLinkedTo(
    user: UserDto,
    listOfIdsDto: ListOfIdsDto,
    linkType: String?,
    crypto: Crypto
): List<ServiceDto> {
    return this.getServicesLinkedTo(listOfIdsDto, linkType).let { crypto.decryptServices(user.dataOwnerId(), null, it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.newContactDelegations(
    user: UserDto,
    contactId: String,
    delegationDto: DelegationDto,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): ContactDto {
    return this.newContactDelegations(contactId, delegationDto).let { config.decryptContact(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ContactApi.setContactsDelegations(
    user: UserDto,
    icureStubDto: List<IcureStubDto>,
    config: CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>
): List<ContactDto> {
    return this.setContactsDelegations(icureStubDto).map { config.decryptContact(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>.encryptContact(
    myId: String,
    delegations: Set<String>,
    contact: ContactDto
): org.taktik.icure.services.external.rest.v2.dto.ContactDto {
    return if (contact.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        contact
    } else {
        val secret = UUID.randomUUID().toString()
        contact.copy(encryptionKeys = (delegations + myId).fold(contact.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, contact.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedContact, marshalledData) = this.marshaller(p)
        sanitizedContact.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<ContactDto, org.taktik.icure.services.external.rest.v2.dto.ContactDto>.decryptContact(
    myId: String,
    contact: org.taktik.icure.services.external.rest.v2.dto.ContactDto
): ContactDto {
    val key = this.crypto.decryptEncryptionKeys(myId, contact.encryptionKeys)
        .firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(contact, decryptAES(data = Base64.getDecoder().decode(contact.encryptedSelf), key = key))
}

suspend fun Crypto.encryptServices(
    myId: String,
    delegations: Set<String>,
    contactKey: ByteArray?,
    services: List<ServiceDto>
): List<org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto> {
    val objectMapper = ObjectMapper()

    return services.map { s ->
        val key = contactKey ?: this.decryptEncryptionKeys(myId, s.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        if (s.content.all { (_, c) ->
                c.compoundValue != null && c.stringValue == null && c.documentId == null && c.measureValue == null && c.medicationValue == null &&
                        c.booleanValue == null && c.numberValue == null && c.instantValue == null && c.fuzzyDateValue == null && c.binaryValue == null
            }) {
            ServiceMapperFactory.instance.map(s).copy(content = s.content.mapValues { (_, c) ->
                ContentDto(compoundValue = c.compoundValue?.let {
                    this.encryptServices(
                        myId,
                        delegations,
                        contactKey,
                        it
                    )
                })
            })
        } else {
            ServiceMapperFactory.instance.map(
                s.copy(
                    content = mapOf(),
                    encryptedSelf = Base64.getEncoder().encodeToString(
                        encryptAES(
                            data = objectMapper.writeValueAsBytes(mapOf("content" to s.content)),
                            key = key
                        )
                    )
                )
            )
        }
    }
}

suspend fun Crypto.decryptServices(
    myId: String,
    contactKey: ByteArray?,
    services: List<org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto>
): List<ServiceDto> = services.map { s ->
    val objectMapper = ObjectMapper()

    return@map try {
        val key = contactKey ?: decryptEncryptionKeys(myId, s.encryptionKeys).firstOrNull()?.toByteArray()
        ?: throw IllegalArgumentException("No encryption key for user")

        s.encryptedSelf?.let { es ->
            ServiceMapperFactory.instance.map(s).copy(
                content = objectMapper.readValue(
                    decryptAES(data = Base64.getDecoder().decode(es), key = key),
                    ContentWrapper::class.java
                ).content
            )
        } ?: ServiceMapperFactory.instance.map(s).let { ss ->
            ss.copy(content = ss.content.mapValues { (_, c) ->
                c.copy(compoundValue = c.compoundValue?.let {
                    this.decryptServices(
                        myId,
                        contactKey,
                        it.map { ServiceMapperFactory.instance.map(it) })
                })
            })
        }
    } catch (ex: IllegalArgumentException) {
        ServiceMapperFactory.instance.map(s).let { ss ->
            ss.copy(content = ss.content.mapValues { (_, c) ->
                c.copy(compoundValue = c.compoundValue?.let {
                    this.decryptServices(
                        myId,
                        contactKey,
                        it.map { ServiceMapperFactory.instance.map(it) })
                })
            })
        }
    }
}

data class ContentWrapper(
    val content: Map<String, io.icure.kraken.client.models.decrypted.ContentDto> = mapOf()
)

@Mapper(uses = [ServiceMapper::class])
interface ContactMapper {
    fun map(contact: ContactDto): org.taktik.icure.services.external.rest.v2.dto.ContactDto
    fun map(contact: org.taktik.icure.services.external.rest.v2.dto.ContactDto): ContactDto
}

object ContactMapperFactory {
    val instance = Mappers.getMapper(ContactMapper::class.java)
}

@Mapper
interface ServiceMapper {

    fun map(service: ServiceDto): org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto
    fun map(service: org.taktik.icure.services.external.rest.v2.dto.embed.ServiceDto): ServiceDto

    fun map(content: io.icure.kraken.client.models.decrypted.ContentDto): ContentDto
    fun map(content: ContentDto): io.icure.kraken.client.models.decrypted.ContentDto

    fun mapQualifiedLinks(qualifiedLinks: Map<ServiceDto.LinkQualification, Map<String, String>>): Map<String, Map<String, String>> {
        return qualifiedLinks
            .map { (key, value) -> key.value to value }
            .toMap()
    }

    fun mapRawQualifiedLinks(qualifiedLinks: Map<String, Map<String, String>>): Map<ServiceDto.LinkQualification, Map<String, String>> {
        return qualifiedLinks
            .map { (key, value) -> ServiceDto.LinkQualification.valueOf(key) to value }
            .toMap()
    }
}

object ServiceMapperFactory {
    val instance = Mappers.getMapper(ServiceMapper::class.java)
}
