package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.MessageDto
import org.mapstruct.Mapper

@Mapper
interface MessageMapper {
    fun map(message: MessageDto): org.taktik.icure.services.external.rest.v2.dto.MessageDto
    fun map(message: org.taktik.icure.services.external.rest.v2.dto.MessageDto): MessageDto
}

object MessageMapperFactory {
    val instance = MessageMapperImpl()
}
