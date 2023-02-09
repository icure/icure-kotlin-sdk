package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.ContactDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(uses = [ServiceMapper::class], injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ContactMapper {
    fun map(contact: ContactDto): org.taktik.icure.services.external.rest.v2.dto.ContactDto
    fun map(contact: org.taktik.icure.services.external.rest.v2.dto.ContactDto): ContactDto
}

object ContactMapperFactory {
    val instance = ContactMapperImpl(
        ServiceMapperImpl(
            InstantMapperImpl(),
            ByteArrayMapperImpl()
        )
    )
}
