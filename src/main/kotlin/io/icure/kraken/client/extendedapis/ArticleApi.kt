package io.icure.kraken.client.extendedapis

import io.icure.kraken.client.apis.ArticleApi
import io.icure.kraken.client.crypto.CryptoConfig
import io.icure.kraken.client.crypto.CryptoUtils.decryptAES
import io.icure.kraken.client.crypto.CryptoUtils.encryptAES
import io.icure.kraken.client.crypto.keyFromHexString
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationDto
import io.icure.kraken.client.models.decrypted.ArticleDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.taktik.icure.services.external.rest.v2.dto.UserDto
import org.taktik.icure.services.external.rest.v2.dto.embed.DelegationTagDto
import java.util.*

suspend fun ArticleDto.initDelegations(
    user: UserDto,
    config: CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>
): ArticleDto {
    val delegations = (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf())
    val ek = UUID.randomUUID().toString()
    val sfk = UUID.randomUUID().toString()
    return this.copy(
        responsible = user.dataOwnerId(),
        author = user.id,
        delegations = (delegations + user.dataOwnerId()).fold(this.delegations) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    user.dataOwnerId(),
                    d,
                    config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, sfk).first,
                    emptyList()
                ),
            ))
        },
        encryptionKeys = (delegations + user.dataOwnerId()).fold(this.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    user.dataOwnerId(),
                    d,
                    config.crypto.encryptAESKeyForDataOwner(user.dataOwnerId(), d, this.id, ek).first,
                    emptyList()
                ),
            ))
        },
    )
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ArticleApi.createArticle(
    user: UserDto,
    article: ArticleDto,
    config: CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>
) =
    this.createArticle(
        config.encryptArticle(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            article
        )
    ).let { config.decryptArticle(user.dataOwnerId(), it) }

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ArticleApi.getArticle(
    user: UserDto,
    articleId: String,
    config: CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>
): ArticleDto {
    return this.getArticle(articleId).let { config.decryptArticle(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ArticleApi.getArticles(
    user: UserDto,
    config: CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>
): List<ArticleDto> {
    return this.getArticles().map { config.decryptArticle(user.dataOwnerId(), it) }
}

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
suspend fun ArticleApi.modifyArticle(
    user: UserDto,
    article: ArticleDto,
    config: CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>
): ArticleDto {
    return this.modifyArticle(
        config.encryptArticle(
            user.dataOwnerId(),
            (user.autoDelegations[DelegationTagDto.all] ?: setOf()) + (user.autoDelegations[DelegationTagDto.medicalInformation] ?: setOf()),
            article
        )
    ).let { config.decryptArticle(user.dataOwnerId(), it) }
}

suspend fun CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>.encryptArticle(
    myId: String,
    delegations: Set<String>,
    article: ArticleDto
): org.taktik.icure.services.external.rest.v2.dto.ArticleDto {
    return if (article.encryptionKeys.any { (_, s) -> s.isNotEmpty() }) {
        article
    } else {
        val secret = UUID.randomUUID().toString()
        article.copy(encryptionKeys = (delegations + myId).fold(article.encryptionKeys) { m, d ->
            m + (d to setOf(
                DelegationDto(
                    myId,
                    d,
                    this.crypto.encryptAESKeyForDataOwner(myId, d, article.id, secret).first,
                    emptyList()
                )
            ))
        })
    }.let { p ->
        val key = this.crypto.decryptEncryptionKeys(myId, p.encryptionKeys).firstOrNull()?.replace(
            "-",
            ""
        )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
        val (sanitizedArticle, marshalledData) = this.marshaller(p)
        sanitizedArticle.copy(
            encryptedSelf = Base64.getEncoder().encodeToString(encryptAES(data = marshalledData, key = key))
        )
    }
}

suspend fun CryptoConfig<ArticleDto, org.taktik.icure.services.external.rest.v2.dto.ArticleDto>.decryptArticle(
    myId: String,
    article: org.taktik.icure.services.external.rest.v2.dto.ArticleDto
): ArticleDto {
    val key = this.crypto.decryptEncryptionKeys(myId, article.encryptionKeys).firstOrNull()?.replace(
        "-",
        ""
    )?.keyFromHexString() ?: throw IllegalArgumentException("No encryption key for user")
    return this.unmarshaller(article, decryptAES(data = Base64.getDecoder().decode(article.encryptedSelf), key = key))
}


