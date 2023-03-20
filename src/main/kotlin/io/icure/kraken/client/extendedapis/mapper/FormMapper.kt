package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.FormDto
import org.mapstruct.Mapper

@Mapper
interface FormMapper {
    fun map(form: FormDto): org.taktik.icure.services.external.rest.v2.dto.FormDto
    fun map(form: org.taktik.icure.services.external.rest.v2.dto.FormDto): FormDto
}

object FormMapperFactory {
    val instance = FormMapperImpl()
}
