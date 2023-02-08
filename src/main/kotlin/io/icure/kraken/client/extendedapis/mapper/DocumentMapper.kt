package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.DocumentDto
import org.mapstruct.Mapper

@Mapper
interface DocumentMapper {
    fun map(document: DocumentDto): org.taktik.icure.services.external.rest.v2.dto.DocumentDto
    fun map(document: org.taktik.icure.services.external.rest.v2.dto.DocumentDto): DocumentDto
}

object DocumentMapperFactory {
    val instance = DocumentMapperImpl()
}
