package io.icure.kraken.client.infrastructure

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.json.JsonReadFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.icure.asyncjacksonhttpclient.net.params
import io.icure.asyncjacksonhttpclient.net.web.HttpMethod
import io.icure.asyncjacksonhttpclient.net.web.Request
import io.icure.asyncjacksonhttpclient.net.web.WebClient
import io.icure.asyncjacksonhttpclient.parser.toObject
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.withContext
import reactor.core.publisher.Mono
import java.io.File
import java.net.URI
import java.net.URLConnection
import java.nio.ByteBuffer
import java.time.Duration
import java.time.Instant

@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
open class ApiClient(
    val baseUrl: String,
    val httpClient: WebClient,
    val authProvider: AuthProvider = NoAuthProvider()
) {
    companion object {
        protected const val ContentType = "Content-Type"
        protected const val Accept = "Accept"
        protected const val Authorization = "Authorization"
        protected const val JsonMediaType = "application/json"

        var timeoutDuration: Duration? = null

        val objectMapper: ObjectMapper = ObjectMapper()
            .registerKotlinModule()
            .registerModule(object : SimpleModule() {
                override fun setupModule(context: SetupContext?) {
                    addDeserializer(ByteArrayWrapper::class.java, ByteArrayWrapperDeserializer())
                    addSerializer(ByteArrayWrapper::class.java, ByteArrayWrapperSerializer())
                    super.setupModule(context)
                }
            })
            .registerModule(JavaTimeModule()).apply {
                setSerializationInclusion(JsonInclude.Include.NON_NULL)
                configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true)
            }

    }

    /**
     * Guess Content-Type header from the given file (defaults to "application/octet-stream").
     *
     * @param file The given file
     * @return The guessed Content-Type
     */
    protected fun guessContentTypeFromFile(file: File): String {
        val contentType = URLConnection.guessContentTypeFromName(file.name)
        return contentType ?: "application/octet-stream"
    }

    protected suspend inline fun <reified I, reified T : Any?> request(requestConfig: RequestConfig<I>): T? {

        val uri = URI(baseUrl).resolve(requestConfig.path).params(
            requestConfig.query
        )

        // take authMethod from operation
        requestConfig.headers[Authorization] = authProvider.getAuthHeader()

        // take content-type/accept from spec or set to default (application/json) if not defined
        if (requestConfig.headers[ContentType].isNullOrEmpty()) {
            requestConfig.headers[ContentType] = JsonMediaType
        }
        if (requestConfig.headers[Accept].isNullOrEmpty()) {
            requestConfig.headers[Accept] = JsonMediaType
        }

        val request = when (requestConfig.method) {
            RequestMethod.DELETE -> httpClient.uri(uri).method(HttpMethod.DELETE, timeoutDuration)
                .addBody(requestConfig.body)

            RequestMethod.GET -> httpClient.uri(uri).method(HttpMethod.GET, timeoutDuration)
            RequestMethod.HEAD -> httpClient.uri(uri).method(HttpMethod.HEAD, timeoutDuration)
            RequestMethod.PATCH -> httpClient.uri(uri).method(HttpMethod.PATCH, timeoutDuration)
                .addBody(requestConfig.body)

            RequestMethod.PUT -> httpClient.uri(uri).method(HttpMethod.PUT, timeoutDuration)
                .addBody(requestConfig.body)

            RequestMethod.POST -> httpClient.uri(uri).method(HttpMethod.POST, timeoutDuration)
                .addBody(requestConfig.body)

            RequestMethod.OPTIONS -> httpClient.uri(uri).method(HttpMethod.OPTIONS, timeoutDuration)
        }.apply {
            requestConfig.headers.forEach { header -> header(header.key, header.value) }
        }

        return request.retrieve()
            .onStatus(400) {
                Mono.just(
                    ClientException("Client-side exception ${it.statusCode}",
                        it.statusCode,
                        details = ErrorDetails(
                            timestamp = Instant.now().toEpochMilli(),
                            status = it.statusCode,
                            error = null,
                            message = null,
                            path = null,
                            requestId = null
                        )
                            .let { error ->
                                it.responseBodyAsString().takeIf { body -> body.isNotBlank() }
                                    ?.let { body -> objectMapper.readValue(body, ErrorDetails::class.java) } ?: error
                            })
                )
            }
            .onStatus(500) {
                Mono.just(
                    ServerException("Server-side exception ${it.statusCode}",
                        it.statusCode,
                        details = ErrorDetails(
                            timestamp = Instant.now().toEpochMilli(),
                            status = it.statusCode,
                            error = null,
                            message = null,
                            path = null,
                            requestId = null
                        )
                            .let { error ->
                                it.responseBodyAsString().takeIf { body -> body.isNotBlank() }
                                    ?.let { body -> objectMapper.readValue(body, ErrorDetails::class.java) } ?: error
                            })
                )
            }
            .toFlow().let {
                when (T::class) {
                    Flow::class -> it as T
                    String::class -> it.fold(StringBuilder()) { sb, bb ->
                        sb.append(ByteArray(bb.remaining()).also { ba ->
                            bb.get(
                                ba
                            )
                        }.toString(Charsets.UTF_8))
                    }.toString() as T

                    else -> it.toObject(objectMapper, true)
                }
            }

    }

    protected suspend inline fun <reified T> Request.addBody(body: T): Request {
        return if (T::class == Flow::class) {
            this.body(body as Flow<ByteBuffer>)
        } else {
            this.body(withContext(Dispatchers.IO) { objectMapper.writeValueAsString(body) })
        }
    }
}
