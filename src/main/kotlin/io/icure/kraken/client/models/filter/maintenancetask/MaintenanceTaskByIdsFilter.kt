/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */
package io.icure.kraken.client.models.filter.maintenancetask

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.taktik.icure.services.external.rest.v2.dto.MaintenanceTaskDto
import io.icure.kraken.client.models.filter.AbstractFilterDto

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class MaintenanceTaskByIdsFilter(
    override val desc: String? = null,
    val ids: Set<String>
) : AbstractFilterDto<MaintenanceTaskDto>
