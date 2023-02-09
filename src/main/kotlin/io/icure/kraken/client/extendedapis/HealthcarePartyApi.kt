package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.applyIf
import io.icure.kraken.client.crypto.Crypto
import org.taktik.icure.services.external.rest.v2.dto.HealthcarePartyDto
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.PersonNameDto
import org.taktik.icure.services.external.rest.v2.dto.embed.PersonNameUseDto
import java.security.PrivateKey
import java.security.PublicKey

suspend fun HealthcarePartyDto.addNewKeyPair(
    user: UserDto,
    crypto: Crypto,
    hcpPublicKey: PublicKey,
    hcpPrivateKey: PrivateKey? = null
) = crypto.addNewKeyPairTo(user, this.toDataOwner(), hcpPublicKey, hcpPrivateKey).let { dataOwner ->
    this.copy(
        rev = dataOwner.rev,
        publicKey = dataOwner.publicKey,
        hcPartyKeys = dataOwner.hcPartyKeys.map { it.key to it.value.toTypedArray() }.toMap(),
        aesExchangeKeys = dataOwner.aesExchangeKeys,
        transferKeys = dataOwner.transferKeys
    )
}

fun HealthcarePartyDto.initHcParty() = this
    .applyIf({ hcp -> hcp.lastName == null && hcp.hasName(PersonNameUseDto.official) }) { hcp ->
        hcp.copy(lastName = hcp.findName(PersonNameUseDto.official)!!.lastName)
    }
    .applyIf({ hcp -> hcp.firstName == null && hcp.hasName(PersonNameUseDto.official) }) { hcp ->
        hcp.copy(firstName = hcp.findName(PersonNameUseDto.official)!!.firstNames.firstOrNull())
    }
    .applyIf({ hcp -> hcp.name == null && hcp.hasName(PersonNameUseDto.official) }) { hcp ->
        hcp.copy(name = hcp.findName(PersonNameUseDto.official)!!.text)
    }
    .applyIf({ hcp -> (hcp.lastName != null || hcp.name != null) && !hcp.hasName(PersonNameUseDto.official) }) { hcp ->
        hcp.copy(
            names = hcp.names + (
                    listOf(
                        PersonNameDto(
                            lastName = hcp.lastName,
                            firstNames = listOfNotNull(hcp.firstName),
                            text = hcp.name,
                            use = PersonNameUseDto.official
                        )
                    )
                    )
        )
    }

fun HealthcarePartyDto.hasName(nameUse: PersonNameUseDto): Boolean {
    return this.names.any { it.use == nameUse }
}

fun HealthcarePartyDto.findName(nameUse: PersonNameUseDto): PersonNameDto? {
    return this.names.find { it.use == nameUse }
}

