/**
* iCure Cloud API Documentation
* Spring shop sample application
*
* The version of the OpenAPI document: v0.0.1
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package io.icure.kraken.client.apis


import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.ClientError
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.infrastructure.ServerError
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import io.icure.kraken.client.infrastructure.ResponseType
import io.icure.kraken.client.infrastructure.Success
import io.icure.kraken.client.infrastructure.toMultiValue

class PubsubApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Offer auth data on secret bucket
    * Offer auth data on previously agreed on secret bucket, data should be encrypted
    * @param bucket  
    * @param requestBody  
    * @return kotlin.collections.Map<kotlin.String, kotlin.Boolean>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun offerAuth(bucket: kotlin.String, requestBody: kotlin.collections.List<kotlin.ByteArray>) : kotlin.collections.Map<kotlin.String, kotlin.Boolean> {
        val localVariableConfig = offerAuthRequestConfig(bucket = bucket, requestBody = requestBody)

        val localVarResponse = request<kotlin.collections.List<kotlin.ByteArray>, kotlin.collections.Map<kotlin.String, kotlin.Boolean>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.Map<kotlin.String, kotlin.Boolean>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation offerAuth
    *
    * @param bucket  
    * @param requestBody  
    * @return RequestConfig
    */
    fun offerAuthRequestConfig(bucket: kotlin.String, requestBody: kotlin.collections.List<kotlin.ByteArray>) : RequestConfig<kotlin.collections.List<kotlin.ByteArray>> {
        val localVariableBody = requestBody
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/pubsub/auth/{bucket}".replace("{"+"bucket"+"}", "$bucket"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * publish data
    * Publish value with key
    * @param key  
    * @param requestBody  
    * @return kotlin.collections.Map<kotlin.String, kotlin.Boolean>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun pub(key: kotlin.String, requestBody: kotlin.collections.List<kotlin.ByteArray>) : kotlin.collections.Map<kotlin.String, kotlin.Boolean> {
        val localVariableConfig = pubRequestConfig(key = key, requestBody = requestBody)

        val localVarResponse = request<kotlin.collections.List<kotlin.ByteArray>, kotlin.collections.Map<kotlin.String, kotlin.Boolean>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.Map<kotlin.String, kotlin.Boolean>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation pub
    *
    * @param key  
    * @param requestBody  
    * @return RequestConfig
    */
    fun pubRequestConfig(key: kotlin.String, requestBody: kotlin.collections.List<kotlin.ByteArray>) : RequestConfig<kotlin.collections.List<kotlin.ByteArray>> {
        val localVariableBody = requestBody
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v1/pubsub/pub/{key}".replace("{"+"key"+"}", "$key"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Recover auth data from secret bucket
    * Recover auth data from bucket, data should be encrypted
    * @param bucket  
    * @return java.io.File
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun recoverAuth(bucket: kotlin.String) : java.io.File {
        val localVariableConfig = recoverAuthRequestConfig(bucket = bucket)

        val localVarResponse = request<Unit, java.io.File>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as java.io.File
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation recoverAuth
    *
    * @param bucket  
    * @return RequestConfig
    */
    fun recoverAuthRequestConfig(bucket: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/pubsub/auth/recover/{bucket}".replace("{"+"bucket"+"}", "$bucket"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * subscribe to data
    * Try to get published data
    * @param key  
    * @return java.io.File
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun sub(key: kotlin.String) : java.io.File {
        val localVariableConfig = subRequestConfig(key = key)

        val localVarResponse = request<Unit, java.io.File>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as java.io.File
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation sub
    *
    * @param key  
    * @return RequestConfig
    */
    fun subRequestConfig(key: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v1/pubsub/sub/{key}".replace("{"+"key"+"}", "$key"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
