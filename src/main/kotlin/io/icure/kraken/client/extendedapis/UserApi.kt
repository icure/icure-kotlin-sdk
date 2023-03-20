package io.icure.kraken.client.extendedapis

import org.taktik.icure.services.external.rest.v2.dto.UserDto

fun UserDto.dataOwnerId() =
    this.healthcarePartyId ?: this.patientId ?: this.deviceId
    ?: throw IllegalAccessException("User is not a data owner")