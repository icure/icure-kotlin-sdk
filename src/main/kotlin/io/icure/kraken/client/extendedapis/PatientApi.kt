package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.PatientApi
import io.icure.kraken.client.models.decrypted.PatientDto
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@ExperimentalStdlibApi
suspend fun PatientApi.createPatient(crypto: Crypto, patient: PatientDto) = this.createPatient(encryptPatient(patient))?.let { decryptPatient(it) }

fun encryptPatient(patient: PatientDto): io.icure.kraken.client.models.PatientDto = PatientMapperFactory.instance.map(patient)
fun decryptPatient(patient: io.icure.kraken.client.models.PatientDto): PatientDto = PatientMapperFactory.instance.map(patient)

@Mapper
interface PatientMapper {
    fun map(patient: PatientDto): io.icure.kraken.client.models.PatientDto
    fun map(patient: io.icure.kraken.client.models.PatientDto): PatientDto
}

object PatientMapperFactory {
    val instance = Mappers.getMapper(PatientMapper::class.java)
}
