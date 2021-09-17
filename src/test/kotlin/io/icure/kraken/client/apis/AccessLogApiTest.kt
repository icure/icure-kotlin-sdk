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

import io.icure.kraken.client.models.AccessLogDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.PaginatedListAccessLogDto
import assertk.assertThat
import assertk.assertions.isEqualToIgnoringGivenProperties
import java.io.*

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.json.JsonReadFeature
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.icure.kraken.client.infrastructure.*

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty1
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

import kotlinx.coroutines.runBlocking
import io.icure.kraken.client.infrastructure.TestUtils
import io.icure.kraken.client.infrastructure.TestUtils.Companion.basicAuth
import io.icure.kraken.client.infrastructure.differences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.fold
import java.nio.ByteBuffer
import kotlin.reflect.full.callSuspendBy
import kotlin.reflect.javaType
import kotlinx.coroutines.flow.flow

/**
 * API tests for AccessLogApi
 */
@ExperimentalStdlibApi
class AccessLogApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("AccessLogApi.json")
    }

    fun api(fileName: String) = AccessLogApi(basePath = "http://127.0.0.1:16043", authHeader = fileName.basicAuth())
    private val workingFolder = "/tmp/icureTests/"
    private val objectMapper = ObjectMapper()
        .registerModule(KotlinModule())
        .registerModule(object:SimpleModule() {
            override fun setupModule(context: SetupContext?) {
                super.setupModule(context)
                addDeserializer(ByteArrayWrapper::class.java, ByteArrayWrapperDeserializer())
                addSerializer(ByteArrayWrapper::class.java, ByteArrayWrapperSerializer())
            }
        })
        .registerModule(JavaTimeModule())
        .apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true)
        configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
    }

    suspend fun createForModification(fileName: String){
        if (canCreateForModificationObjects(fileName)) {
            TestUtils.getParameters<Any>(fileName, "beforeElements.bodies")?.let {bodies ->
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createDto")
                val createFunction = api(credentialsFile)::class.memberFunctions
                    .firstOrNull { it.parameters.size == 3; it.name.startsWith("create") }
                val deleteFunction = api(credentialsFile)::class.memberFunctions
                    .firstOrNull { it.parameters.size == 3 && it.name.startsWith("delete") }
                bodies.forEach {body ->
                    //deleteFunction?.call(api, body?.id)
                    val parameters = createFunction!!.parameters.mapNotNull {
                        when(it.type.javaType) {
                            AccessLogDto::class.java -> it to objectMapper.convertValue(body, AccessLogDto::class.java)
                            AccessLogApi::class.java -> it to api(credentialsFile)
                            else -> null
                        }
                    }.toMap()

                    createFunction.callSuspendBy(parameters)
                    println("created")
                }
            }
        }
    }

    
    /**
     * Creates an access log
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createAccessLogTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "createAccessLog")) {
                assert(true)
                println("Endpoint createAccessLog skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createAccessLog")
                val accessLogDto: AccessLogDto = TestUtils.getParameter<AccessLogDto>(fileName, "createAccessLog.accessLogDto")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "createAccessLog") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? AccessLogDto ?: it
                    }

                val response = api(credentialsFile).createAccessLog(accessLogDto)

                    val testFileName = "AccessLogApi.createAccessLog"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AccessLogDto>? != null) {
                            if ("AccessLogDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<AccessLogDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<AccessLogDto>() {}
                        })
                        assertAreEquals("createAccessLog", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    
    /**
     * Deletes an access log
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteAccessLogsTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "deleteAccessLogs")) {
                assert(true)
                println("Endpoint deleteAccessLogs skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteAccessLogs")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteAccessLogs.listOfIdsDto")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteAccessLogs") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteAccessLogs(listOfIdsDto)

                    val testFileName = "AccessLogApi.deleteAccessLogs"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<DocIdentifier>? != null) {
                            if ("kotlin.collections.List<DocIdentifier>".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<DocIdentifier>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<kotlin.collections.List<DocIdentifier>>() {}
                        })
                        assertAreEquals("deleteAccessLogs", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    
    /**
     * Get Paginated List of Access logs
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun findAccessLogsByTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "findAccessLogsBy")) {
                assert(true)
                println("Endpoint findAccessLogsBy skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "findAccessLogsBy")
                val fromEpoch: kotlin.Long? = TestUtils.getParameter<kotlin.Long>(fileName, "findAccessLogsBy.fromEpoch")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Long ?: it
                    }
                val toEpoch: kotlin.Long? = TestUtils.getParameter<kotlin.Long>(fileName, "findAccessLogsBy.toEpoch")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Long ?: it
                    }
                val startKey: kotlin.Long? = TestUtils.getParameter<kotlin.Long>(fileName, "findAccessLogsBy.startKey")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Long ?: it
                    }
                val startDocumentId: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "findAccessLogsBy.startDocumentId")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val limit: kotlin.Int? = TestUtils.getParameter<kotlin.Int>(fileName, "findAccessLogsBy.limit")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Int ?: it
                    }
                val descending: kotlin.Boolean? = TestUtils.getParameter<kotlin.Boolean>(fileName, "findAccessLogsBy.descending")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Boolean ?: it
                    }

                val response = api(credentialsFile).findAccessLogsBy(fromEpoch,toEpoch,startKey,startDocumentId,limit,descending)

                    val testFileName = "AccessLogApi.findAccessLogsBy"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<PaginatedListAccessLogDto>? != null) {
                            if ("PaginatedListAccessLogDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<PaginatedListAccessLogDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<PaginatedListAccessLogDto>() {}
                        })
                        assertAreEquals("findAccessLogsBy", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    
    /**
     * Get Paginated List of Access logs by user after date
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun findAccessLogsByUserAfterDateTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "findAccessLogsByUserAfterDate")) {
                assert(true)
                println("Endpoint findAccessLogsByUserAfterDate skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "findAccessLogsByUserAfterDate")
                val userId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "findAccessLogsByUserAfterDate.userId")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val accessType: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "findAccessLogsByUserAfterDate.accessType")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val startDate: kotlin.Long? = TestUtils.getParameter<kotlin.Long>(fileName, "findAccessLogsByUserAfterDate.startDate")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Long ?: it
                    }
                val startKey: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "findAccessLogsByUserAfterDate.startKey")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val startDocumentId: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "findAccessLogsByUserAfterDate.startDocumentId")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val limit: kotlin.Int? = TestUtils.getParameter<kotlin.Int>(fileName, "findAccessLogsByUserAfterDate.limit")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Int ?: it
                    }
                val descending: kotlin.Boolean? = TestUtils.getParameter<kotlin.Boolean>(fileName, "findAccessLogsByUserAfterDate.descending")?.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "findAccessLogsByUserAfterDate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Boolean ?: it
                    }

                val response = api(credentialsFile).findAccessLogsByUserAfterDate(userId,accessType,startDate,startKey,startDocumentId,limit,descending)

                    val testFileName = "AccessLogApi.findAccessLogsByUserAfterDate"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<PaginatedListAccessLogDto>? != null) {
                            if ("PaginatedListAccessLogDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<PaginatedListAccessLogDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<PaginatedListAccessLogDto>() {}
                        })
                        assertAreEquals("findAccessLogsByUserAfterDate", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    
    /**
     * Gets an access log
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getAccessLogTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "getAccessLog")) {
                assert(true)
                println("Endpoint getAccessLog skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getAccessLog")
                val accessLogId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getAccessLog.accessLogId")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "getAccessLog") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getAccessLog(accessLogId)

                    val testFileName = "AccessLogApi.getAccessLog"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AccessLogDto>? != null) {
                            if ("AccessLogDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<AccessLogDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<AccessLogDto>() {}
                        })
                        assertAreEquals("getAccessLog", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    
    /**
     * List access logs found By Healthcare Party and secret foreign keyelementIds.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun listAccessLogsByHCPartyAndPatientForeignKeysTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "listAccessLogsByHCPartyAndPatientForeignKeys")) {
                assert(true)
                println("Endpoint listAccessLogsByHCPartyAndPatientForeignKeys skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "listAccessLogsByHCPartyAndPatientForeignKeys")
                val hcPartyId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "listAccessLogsByHCPartyAndPatientForeignKeys.hcPartyId")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "listAccessLogsByHCPartyAndPatientForeignKeys") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val secretFKeys: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "listAccessLogsByHCPartyAndPatientForeignKeys.secretFKeys")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "listAccessLogsByHCPartyAndPatientForeignKeys") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).listAccessLogsByHCPartyAndPatientForeignKeys(hcPartyId,secretFKeys)

                    val testFileName = "AccessLogApi.listAccessLogsByHCPartyAndPatientForeignKeys"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AccessLogDto>? != null) {
                            if ("kotlin.collections.List<AccessLogDto>".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<AccessLogDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<kotlin.collections.List<AccessLogDto>>() {}
                        })
                        assertAreEquals("listAccessLogsByHCPartyAndPatientForeignKeys", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    
    /**
     * Modifies an access log
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyAccessLogTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "modifyAccessLog")) {
                assert(true)
                println("Endpoint modifyAccessLog skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyAccessLog")
                val accessLogDto: AccessLogDto = TestUtils.getParameter<AccessLogDto>(fileName, "modifyAccessLog.accessLogDto")!!.let {
                    (it as? AccessLogDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyAccessLog") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAccessLog(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? AccessLogDto ?: it
                    }

                val response = api(credentialsFile).modifyAccessLog(accessLogDto)

                    val testFileName = "AccessLogApi.modifyAccessLog"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AccessLogDto>? != null) {
                            if ("AccessLogDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<AccessLogDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<AccessLogDto>() {}
                        })
                        assertAreEquals("modifyAccessLog", objectFromFile, response)
                        println("Comparison successful")
                    }
                    catch (e: Exception) {
                        when (e) {
                            is FileNotFoundException, is java.nio.file.NoSuchFileException -> {
                                file.parentFile.mkdirs()
                                file.createNewFile()
                                (response as? Flow<ByteBuffer>)
                                    ?.let { it.writeToFile(file) }
                                    ?: objectMapper.writeValue(file, response)
                                assert(true)
                                println("File written")
                            }
                        }
                    }
            }
        }
        finally {
            TestUtils.deleteAfterElements(fileName)
            alreadyCreatedObjects.remove(fileName)
        }
    }
    

    private suspend fun assertAreEquals(functionName: String, objectFromFile: Any?, response: Any) {
        when {
            objectFromFile as? Iterable<Any> != null -> {
                val toSkip : kotlin.collections.List<String> = when {
                    functionName.let { name -> listOf("create", "new", "get").any { name.startsWith(it) } } -> listOf("rev", "created", "modified")
                    functionName.let { name -> listOf("modify", "set", "delete", "list").any { name.startsWith(it) } } -> listOf("rev")
                    else -> emptyList()
                }

                val diffs = objectFromFile
                    .takeUnless { (it as ArrayList<Any>).size != (response as ArrayList<Any>).size }
                    ?.let { objectFromFile
                        .zip(response as Iterable<Any>)
                        .map { pair -> filterDiffs(pair.first, pair.second, pair.first.differences(pair.second), toSkip) }
                        .flatten()
                        .toList()
                    }
                    ?: listOf(Diff("Lists are of different sizes ${(objectFromFile as ArrayList<Any>).size} <-> ${(response as ArrayList<Any>).size}", PropertyType.ListItem, listOf(), objectFromFile, response))

                assertTrue(diffs.isEmpty())
            }
            objectFromFile as? Flow<ByteBuffer> != null -> {
                objectFromFile.fold(ByteBuffer.allocate(0)) { acc, bb ->
                    ByteBuffer.allocate(bb.limit() + acc.limit()).apply { this.put(acc); this.put(bb) }
                }.let { buf -> ByteArray(buf.remaining()).also { buf.get(it) }}.contentEquals(
                    (response as Flow<ByteBuffer>).fold(ByteBuffer.allocate(0)) { acc, bb ->
                        ByteBuffer.allocate(bb.limit() + acc.limit()).apply { this.put(acc); this.put(bb) }
                    }.let { buf -> ByteArray(buf.remaining()).also { buf.get(it) }}
                )
            }
            else -> {
                val toSkip : kotlin.collections.List<String> = when {
                    functionName.let { name -> listOf("create", "get", "modify", "new").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "deletionDate")
                    functionName.let { name -> listOf("set").any { name.startsWith(it) } } -> listOf("rev")
                    else -> emptyList()
                }
                val diffs = filterDiffs(objectFromFile, response, response.differences(objectFromFile), toSkip)
                assertTrue(diffs.isEmpty())
            }
        }
    }
}
