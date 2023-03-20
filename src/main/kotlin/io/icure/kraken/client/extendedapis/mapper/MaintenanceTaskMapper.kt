package io.icure.kraken.client.extendedapis.mapper

import io.icure.kraken.client.models.decrypted.MaintenanceTaskDto
import org.mapstruct.Mapper

@Mapper
interface MaintenanceTaskMapper {
    fun map(maintenanceTask: MaintenanceTaskDto): org.taktik.icure.services.external.rest.v2.dto.MaintenanceTaskDto
    fun map(maintenanceTask: org.taktik.icure.services.external.rest.v2.dto.MaintenanceTaskDto): MaintenanceTaskDto
}

object MaintenanceTaskMapperFactory {
    val instance = MaintenanceTaskMapperImpl()
}
