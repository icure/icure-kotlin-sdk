package io.icure.kraken.client.infrastructure

enum class ResponseType {
    Success, Informational, Redirection, ClientError, ServerError
}

interface Response

abstract class ApiInfrastructureResponse<T>(val responseType: ResponseType) : Response {
    abstract val statusCode: Int
    abstract val headers: Map<String, List<String>>
}

class Success<T>(
    val data: T,
    override val statusCode: Int = -1,
    override val headers: Map<String, List<String>> = mapOf()
) : ApiInfrastructureResponse<T>(ResponseType.Success)

class Informational<T>(
    val statusText: String,
    override val statusCode: Int = -1,
    override val headers: Map<String, List<String>> = mapOf()
) : ApiInfrastructureResponse<T>(ResponseType.Informational)

class Redirection<T>(
    override val statusCode: Int = -1,
    override val headers: Map<String, List<String>> = mapOf()
) : ApiInfrastructureResponse<T>(ResponseType.Redirection)

class ClientError<T>(
    val message: String? = null,
    val body: Any? = null,
    override val statusCode: Int = -1,
    override val headers: Map<String, List<String>> = mapOf()
) : ApiInfrastructureResponse<T>(ResponseType.ClientError)

class ServerError<T>(
    val message: String? = null,
    val body: Any? = null,
    override val statusCode: Int = -1,
    override val headers: Map<String, List<String>>
) : ApiInfrastructureResponse<T>(ResponseType.ServerError)