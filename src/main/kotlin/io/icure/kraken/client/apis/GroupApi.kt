/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure.
 *
 * The version of the OpenAPI document: v2
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.apis

import io.icure.asyncjacksonhttpclient.net.web.WebClient
import io.icure.asyncjacksonhttpclient.netty.NettyWebClient
import io.icure.kraken.client.infrastructure.*
import io.icure.kraken.client.models.DatabaseInitialisationDto
import io.icure.kraken.client.models.GroupDatabasesInfoDto
import io.icure.kraken.client.models.GroupDto
import io.icure.kraken.client.models.IdWithRevDto
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.ListOfPropertiesDto
import io.icure.kraken.client.models.PaginatedListGroupDto
import io.icure.kraken.client.models.RegistrationInformationDto
import io.icure.kraken.client.models.RegistrationSuccessDto
import io.icure.kraken.client.models.ReplicationInfoDto

import kotlinx.coroutines.ExperimentalCoroutinesApi

import io.icure.kraken.client.infrastructure.ApiClient
import io.icure.kraken.client.infrastructure.ClientException
import io.icure.kraken.client.infrastructure.ServerException
import io.icure.kraken.client.infrastructure.MultiValueMap
import io.icure.kraken.client.infrastructure.RequestConfig
import io.icure.kraken.client.infrastructure.RequestMethod
import io.icure.kraken.client.security.AuthProvider
import io.icure.kraken.client.security.NoAuthProvider
import kotlinx.coroutines.flow.flowOf
import java.nio.ByteBuffer
import java.util.*
import javax.inject.Named
import kotlinx.coroutines.flow.Flow
import java.net.URLEncoder

@Named
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class GroupApi(basePath: kotlin.String = defaultBasePath, webClient: WebClient = NettyWebClient(), authProvider: AuthProvider = NoAuthProvider()) : ApiClient(basePath, webClient, authProvider) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("io.icure.kraken.client.baseUrl", "https://kraken.icure.dev")
        }
    }

    /**
    * Create a group
    * Create a new group and associated dbs.  The created group will be manageable by the users that belong to the same group as the one that called createGroup. Several tasks can be executed during the group creation like DB replications towards the created DBs, users creation and healthcare parties creation
    * @param id The id of the group, also used for subsequent authentication against the db (can only contain digits, letters, - and _) 
    * @param name The name of the group 
    * @param password The password of the group (can only contain digits, letters, - and _) 
    * @param databaseInitialisationDto  
    * @param server The server on which the group dbs will be created (optional)
    * @param q The number of shards for patient and healthdata dbs : 3-8 is a recommended range of value (optional)
    * @param n The number of replications for other dbs : 3 is a recommended value (optional)
    * @param superGroup Group parent (optional)
    * @return GroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun createGroup(id: kotlin.String, name: kotlin.String, password: kotlin.String, databaseInitialisationDto: DatabaseInitialisationDto, server: kotlin.String?, q: kotlin.Int?, n: kotlin.Int?, superGroup: kotlin.String?) : GroupDto  {
        val localVariableConfig = createGroupRequestConfig(id = id, name = name, password = password, databaseInitialisationDto = databaseInitialisationDto, server = server, q = q, n = n, superGroup = superGroup)

        return request<DatabaseInitialisationDto, GroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation createGroup
    *
    * @param id The id of the group, also used for subsequent authentication against the db (can only contain digits, letters, - and _) 
    * @param name The name of the group 
    * @param password The password of the group (can only contain digits, letters, - and _) 
    * @param databaseInitialisationDto  
    * @param server The server on which the group dbs will be created (optional)
    * @param q The number of shards for patient and healthdata dbs : 3-8 is a recommended range of value (optional)
    * @param n The number of replications for other dbs : 3 is a recommended value (optional)
    * @param superGroup Group parent (optional)
    * @return RequestConfig
    */
    fun createGroupRequestConfig(id: kotlin.String, name: kotlin.String, password: kotlin.String, databaseInitialisationDto: DatabaseInitialisationDto, server: kotlin.String?, q: kotlin.Int?, n: kotlin.Int?, superGroup: kotlin.String?) : RequestConfig<DatabaseInitialisationDto> {
        // val localVariableBody = databaseInitialisationDto
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("name", listOf(name.toString()))
                if (server != null) {
                    put("server", listOf(server.toString()))
                }
                if (q != null) {
                    put("q", listOf(q.toString()))
                }
                if (n != null) {
                    put("n", listOf(n.toString()))
                }
                if (superGroup != null) {
                    put("superGroup", listOf(superGroup.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = databaseInitialisationDto
        password.apply { localVariableHeaders["password"] = this.toString() }

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/group/{id}".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Delete group
    * Delete group without reset or deleteing storage
    * @param id The id of group to delete 
    * @return GroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteGroup(id: kotlin.String) : GroupDto  {
        val localVariableConfig = deleteGroupRequestConfig(id = id)

        return request<Unit, GroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation deleteGroup
    *
    * @param id The id of group to delete 
    * @return RequestConfig
    */
    fun deleteGroupRequestConfig(id: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/rest/v2/group/{id}".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Find groups by parent
    * List groups that are the children of the group with th eprovided parent id
    * @param id The id of the group 
    * @param startDocumentId A grou document ID used as a cursor for pagination (optional)
    * @param limit Number of rows (optional, default to 1000)
    * @return PaginatedListGroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findGroups(id: kotlin.String, startDocumentId: kotlin.String?, limit: kotlin.Int?) : PaginatedListGroupDto  {
        val localVariableConfig = findGroupsRequestConfig(id = id, startDocumentId = startDocumentId, limit = limit)

        return request<Unit, PaginatedListGroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation findGroups
    *
    * @param id The id of the group 
    * @param startDocumentId A grou document ID used as a cursor for pagination (optional)
    * @param limit Number of rows (optional, default to 1000)
    * @return RequestConfig
    */
    fun findGroupsRequestConfig(id: kotlin.String, startDocumentId: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/group/{id}/children".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Find groups by parent and content
    * List groups that are the children of the group with the provided parent id and that match the provided search string
    * @param id The id of the group 
    * @param searchString The string to search for in the group. Properties, name and id are scanned for the provided search string. 
    * @param startKey The start key for pagination, depends on the filters used (optional)
    * @param startDocumentId A group document ID used as a cursor for pagination (optional)
    * @param limit Number of rows (optional, default to 1000)
    * @return PaginatedListGroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findGroupsWithContent(id: kotlin.String, searchString: kotlin.String, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?) : PaginatedListGroupDto  {
        val localVariableConfig = findGroupsWithContentRequestConfig(id = id, searchString = searchString, startKey = startKey, startDocumentId = startDocumentId, limit = limit)

        return request<Unit, PaginatedListGroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation findGroupsWithContent
    *
    * @param id The id of the group 
    * @param searchString The string to search for in the group. Properties, name and id are scanned for the provided search string. 
    * @param startKey The start key for pagination, depends on the filters used (optional)
    * @param startDocumentId A group document ID used as a cursor for pagination (optional)
    * @param limit Number of rows (optional, default to 1000)
    * @return RequestConfig
    */
    fun findGroupsWithContentRequestConfig(id: kotlin.String, searchString: kotlin.String, startKey: kotlin.String?, startDocumentId: kotlin.String?, limit: kotlin.Int?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("searchString", listOf(searchString.toString()))
                if (startKey != null) {
                    put("startKey", listOf(startKey.toString()))
                }
                if (startDocumentId != null) {
                    put("startDocumentId", listOf(startDocumentId.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/group/{id}/children/search".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get a group by id
    * Get a group by id
    * @param id The id of the group 
    * @return GroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getGroup(id: kotlin.String) : GroupDto  {
        val localVariableConfig = getGroupRequestConfig(id = id)

        return request<Unit, GroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getGroup
    *
    * @param id The id of the group 
    * @return RequestConfig
    */
    fun getGroupRequestConfig(id: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/group/{id}".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Reset storage for group
    * Reset storage
    * @param listOfIdsDto  
    * @return kotlin.collections.List<GroupDatabasesInfoDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getGroupsStorageInfos(listOfIdsDto: ListOfIdsDto) : kotlin.collections.List<GroupDatabasesInfoDto>  {
        val localVariableConfig = getGroupsStorageInfosRequestConfig(listOfIdsDto = listOfIdsDto)

        return request<ListOfIdsDto, kotlin.collections.List<GroupDatabasesInfoDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getGroupsStorageInfos
    *
    * @param listOfIdsDto  
    * @return RequestConfig
    */
    fun getGroupsStorageInfosRequestConfig(listOfIdsDto: ListOfIdsDto) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/group/storage/info",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Get index info
    * 
    * @param id The id of the group 
    * @return ReplicationInfoDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getReplicationInfo1(id: kotlin.String) : ReplicationInfoDto  {
        val localVariableConfig = getReplicationInfo1RequestConfig(id = id)

        return request<Unit, ReplicationInfoDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation getReplicationInfo1
    *
    * @param id The id of the group 
    * @return RequestConfig
    */
    fun getReplicationInfo1RequestConfig(id: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/group/{id}/r".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Init design docs
    * Init design docs for provided group
    * @param id The id of the group 
    * @param clazz The class of the design doc (optional)
    * @param warmup Warmup the design doc (optional)
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun initDesignDocs(id: kotlin.String, clazz: kotlin.String?, warmup: kotlin.Boolean?) : kotlin.Any  {
        val localVariableConfig = initDesignDocsRequestConfig(id = id, clazz = clazz, warmup = warmup)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation initDesignDocs
    *
    * @param id The id of the group 
    * @param clazz The class of the design doc (optional)
    * @param warmup Warmup the design doc (optional)
    * @return RequestConfig
    */
    fun initDesignDocsRequestConfig(id: kotlin.String, clazz: kotlin.String?, warmup: kotlin.Boolean?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (clazz != null) {
                    put("clazz", listOf(clazz.toString()))
                }
                if (warmup != null) {
                    put("warmup", listOf(warmup.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/group/{id}/dd".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List apps
    * List available apps for user
    * @return kotlin.collections.List<GroupDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listApps() : kotlin.collections.List<GroupDto>  {
        val localVariableConfig = listAppsRequestConfig()

        return request<Unit, kotlin.collections.List<GroupDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listApps
    *
    * @return RequestConfig
    */
    fun listAppsRequestConfig() : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/group/apps",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * List groups
    * List existing groups
    * @return kotlin.collections.List<GroupDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun listGroups() : kotlin.collections.List<GroupDto>  {
        val localVariableConfig = listGroupsRequestConfig()

        return request<Unit, kotlin.collections.List<GroupDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation listGroups
    *
    * @return RequestConfig
    */
    fun listGroupsRequestConfig() : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/rest/v2/group",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Update group name
    * Update existing group name
    * @param id The id of the group 
    * @param name The new name for the group 
    * @return GroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyGroupName(id: kotlin.String, name: kotlin.String) : GroupDto  {
        val localVariableConfig = modifyGroupNameRequestConfig(id = id, name = name)

        return request<Unit, GroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyGroupName
    *
    * @param id The id of the group 
    * @param name The new name for the group 
    * @return RequestConfig
    */
    fun modifyGroupNameRequestConfig(id: kotlin.String, name: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/group/{id}/name/{name}".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}").replace("{"+"name"+"}", "${URLEncoder.encode(name.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Update group properties
    * Update existing group properties
    * @param id The id of the group 
    * @param listOfPropertiesDto  
    * @return GroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun modifyGroupProperties(id: kotlin.String, listOfPropertiesDto: ListOfPropertiesDto) : GroupDto  {
        val localVariableConfig = modifyGroupPropertiesRequestConfig(id = id, listOfPropertiesDto = listOfPropertiesDto)

        return request<ListOfPropertiesDto, GroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation modifyGroupProperties
    *
    * @param id The id of the group 
    * @param listOfPropertiesDto  
    * @return RequestConfig
    */
    fun modifyGroupPropertiesRequestConfig(id: kotlin.String, listOfPropertiesDto: ListOfPropertiesDto) : RequestConfig<ListOfPropertiesDto> {
        // val localVariableBody = listOfPropertiesDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfPropertiesDto

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/group/{id}/properties".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Create a group
    * Create a new group and associated dbs.  The created group will be manageable by the users that belong to the same group as the one that called createGroup. Several tasks can be executed during the group creation like DB replications towards the created DBs, users creation and healthcare parties creation
    * @param registrationInformationDto  
    * @return RegistrationSuccessDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun registerNewGroupAdministrator(registrationInformationDto: RegistrationInformationDto) : RegistrationSuccessDto  {
        val localVariableConfig = registerNewGroupAdministratorRequestConfig(registrationInformationDto = registrationInformationDto)

        return request<RegistrationInformationDto, RegistrationSuccessDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation registerNewGroupAdministrator
    *
    * @param registrationInformationDto  
    * @return RequestConfig
    */
    fun registerNewGroupAdministratorRequestConfig(registrationInformationDto: RegistrationInformationDto) : RequestConfig<RegistrationInformationDto> {
        // val localVariableBody = registrationInformationDto
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = registrationInformationDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/group/register/trial",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Reset storage for group
    * Reset storage
    * @param id The id of the group 
    * @param listOfIdsDto  
    * @param q The number of shards for patient and healthdata dbs : 3-8 is a recommended range of value (optional)
    * @param n The number of replications for dbs : 3 is a recommended value (optional)
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun resetStorage(id: kotlin.String, listOfIdsDto: ListOfIdsDto, q: kotlin.Int?, n: kotlin.Int?) : kotlin.Any  {
        val localVariableConfig = resetStorageRequestConfig(id = id, listOfIdsDto = listOfIdsDto, q = q, n = n)

        return request<ListOfIdsDto, kotlin.Any>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation resetStorage
    *
    * @param id The id of the group 
    * @param listOfIdsDto  
    * @param q The number of shards for patient and healthdata dbs : 3-8 is a recommended range of value (optional)
    * @param n The number of replications for dbs : 3 is a recommended value (optional)
    * @return RequestConfig
    */
    fun resetStorageRequestConfig(id: kotlin.String, listOfIdsDto: ListOfIdsDto, q: kotlin.Int?, n: kotlin.Int?) : RequestConfig<ListOfIdsDto> {
        // val localVariableBody = listOfIdsDto
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (q != null) {
                    put("q", listOf(q.toString()))
                }
                if (n != null) {
                    put("n", listOf(n.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/json")
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = listOfIdsDto

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/group/{id}/reset/storage".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Set group password
    * Update password for provided group
    * @param id The id of the group 
    * @param password The new password for the group (can only contain digits, letters, - and _) 
    * @return GroupDto
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun setGroupPassword(id: kotlin.String, password: kotlin.String) : GroupDto  {
        val localVariableConfig = setGroupPasswordRequestConfig(id = id, password = password)

        return request<Unit, GroupDto>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation setGroupPassword
    *
    * @param id The id of the group 
    * @param password The new password for the group (can only contain digits, letters, - and _) 
    * @return RequestConfig
    */
    fun setGroupPasswordRequestConfig(id: kotlin.String, password: kotlin.String) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null
        password.apply { localVariableHeaders["password"] = this.toString() }

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/rest/v2/group/{id}/password".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

    /**
    * Solve conflicts for group
    * Solve conflicts for group
    * @param id The id of the group 
    * @param limit Solve at most limit conflicts (optional)
    * @param warmup Warmup the design doc (optional)
    * @return kotlin.collections.List<IdWithRevDto>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun solveConflicts(id: kotlin.String, limit: kotlin.Int?, warmup: kotlin.Boolean?) : kotlin.collections.List<IdWithRevDto>  {
        val localVariableConfig = solveConflictsRequestConfig(id = id, limit = limit, warmup = warmup)

        return request<Unit, kotlin.collections.List<IdWithRevDto>>(
            localVariableConfig
        )!!
    }
    /**
    * To obtain the request config of the operation solveConflicts
    *
    * @param id The id of the group 
    * @param limit Solve at most limit conflicts (optional)
    * @param warmup Warmup the design doc (optional)
    * @return RequestConfig
    */
    fun solveConflictsRequestConfig(id: kotlin.String, limit: kotlin.Int?, warmup: kotlin.Boolean?) : RequestConfig<Unit> {
        // val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (warmup != null) {
                    put("warmup", listOf(warmup.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "*/*"
        val localVariableBody = null

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/rest/v2/group/{id}/conflicts".replace("{"+"id"+"}", "${URLEncoder.encode(id.toString(), Charsets.UTF_8)}"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody        )
    }

}
