package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.TimeTableDto
import org.mapstruct.Mapper

@Mapper
interface TimeTableMapper {
    fun map(timeTable: TimeTableDto): org.taktik.icure.services.external.rest.v2.dto.TimeTableDto
    fun map(timeTable: org.taktik.icure.services.external.rest.v2.dto.TimeTableDto): TimeTableDto
}

object TimeTableMapperFactory {
    val instance = TimeTableMapperImpl()
}
