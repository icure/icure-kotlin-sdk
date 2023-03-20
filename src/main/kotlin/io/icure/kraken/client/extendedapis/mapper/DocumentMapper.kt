package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.DocumentDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(uses = [ByteArrayMapper::class], injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface DocumentMapper {
    fun map(document: DocumentDto): org.taktik.icure.services.external.rest.v2.dto.DocumentDto
    fun map(document: org.taktik.icure.services.external.rest.v2.dto.DocumentDto): DocumentDto
}

object DocumentMapperFactory {
    val instance = DocumentMapperImpl(ByteArrayMapperImpl())
}
