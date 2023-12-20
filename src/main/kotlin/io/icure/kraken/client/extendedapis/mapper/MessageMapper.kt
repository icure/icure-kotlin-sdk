package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.MessageDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface MessageMapper {

    @Mappings(
        Mapping(target = "messageAttachments", ignore = true),
    )
    fun map(message: MessageDto): org.taktik.icure.services.external.rest.v2.dto.MessageDto

    fun map(message: org.taktik.icure.services.external.rest.v2.dto.MessageDto): MessageDto
}

object MessageMapperFactory {
    val instance = MessageMapperImpl()
}
