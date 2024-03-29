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

import org.taktik.icure.services.external.rest.v2.dto.AgendaDto
import io.icure.kraken.client.models.DocIdentifier
import org.taktik.icure.services.external.rest.v2.dto.ListOfIdsDto
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

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.api.Assertions.assertTrue
import io.icure.kraken.client.models.filter.AbstractFilterDto

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

import kotlinx.coroutines.runBlocking
import io.icure.kraken.client.infrastructure.TestUtils
import io.icure.kraken.client.infrastructure.TestUtils.Companion.basicAuth
import io.icure.kraken.client.infrastructure.differences
import kotlinx.coroutines.flow.Flow
import java.nio.ByteBuffer
import kotlin.reflect.full.callSuspendBy
import kotlin.reflect.javaType
import kotlinx.coroutines.flow.toList

/**
 * API tests for AgendaApi
 */
@ExperimentalStdlibApi
class AgendaApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("AgendaApi.json")
    }

    // http://127.0.0.1:16043
    fun api(fileName: String) = AgendaApi(basePath = java.lang.System.getProperty("API_URL"), authProvider = fileName.basicAuth())
    private val workingFolder = "/tmp/icureTests/"
    private val objectMapper = ObjectMapper()
        .registerModule(KotlinModule())
        .registerModule(object:SimpleModule() {
            override fun setupModule(context: SetupContext?) {
                addDeserializer(AbstractFilterDto::class.java, FilterDeserializer())
                addDeserializer(ByteArrayWrapper::class.java, ByteArrayWrapperDeserializer())
                addSerializer(ByteArrayWrapper::class.java, ByteArrayWrapperSerializer())
                super.setupModule(context)
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
                            AgendaDto::class.java -> it to objectMapper.convertValue(body, AgendaDto::class.java)
                            AgendaApi::class.java -> it to api(credentialsFile)
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
     * Creates a agenda
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createAgendaTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "createAgenda")) {
            assertTrue(true, "Test of createAgenda endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createAgenda")
                val agendaDto: AgendaDto = TestUtils.getParameter<AgendaDto>(fileName, "createAgenda.agendaDto")!!.let {
                    (it as? AgendaDto)?.takeIf { TestUtils.isAutoRev(fileName, "createAgenda") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAgenda(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? AgendaDto ?: it
                    }

                val response = api(credentialsFile).createAgenda(agendaDto = agendaDto)

                val testFileName = "AgendaApi.createAgenda"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AgendaDto>? != null) {
                        if ("AgendaDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<AgendaDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<AgendaDto>() {}
                    })
                    assertAreEquals("createAgenda", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    
    /**
     * Deletes agendas
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteAgendasTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "deleteAgendas")) {
            assertTrue(true, "Test of deleteAgendas endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteAgendas")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteAgendas.listOfIdsDto")!!.let {
                    (it as? AgendaDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteAgendas") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAgenda(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteAgendas(listOfIdsDto = listOfIdsDto)

                val testFileName = "AgendaApi.deleteAgendas"
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
                    assertAreEquals("deleteAgendas", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    
    /**
     * Gets an agenda
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getAgendaTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getAgenda")) {
            assertTrue(true, "Test of getAgenda endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getAgenda")
                val agendaId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getAgenda.agendaId")!!.let {
                    (it as? AgendaDto)?.takeIf { TestUtils.isAutoRev(fileName, "getAgenda") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAgenda(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getAgenda(agendaId = agendaId)

                val testFileName = "AgendaApi.getAgenda"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AgendaDto>? != null) {
                        if ("AgendaDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<AgendaDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<AgendaDto>() {}
                    })
                    assertAreEquals("getAgenda", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    
    /**
     * Gets all agendas
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getAgendasTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getAgendas")) {
            assertTrue(true, "Test of getAgendas endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getAgendas")

                val response = api(credentialsFile).getAgendas()

                val testFileName = "AgendaApi.getAgendas"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AgendaDto>? != null) {
                        if ("kotlin.collections.List<AgendaDto>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<AgendaDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlin.collections.List<AgendaDto>>() {}
                    })
                    assertAreEquals("getAgendas", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    
    /**
     * Gets all agendas for user
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getAgendasForUserTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getAgendasForUser")) {
            assertTrue(true, "Test of getAgendasForUser endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getAgendasForUser")
                val userId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getAgendasForUser.userId")!!.let {
                    (it as? AgendaDto)?.takeIf { TestUtils.isAutoRev(fileName, "getAgendasForUser") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAgenda(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getAgendasForUser(userId = userId)

                val testFileName = "AgendaApi.getAgendasForUser"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AgendaDto>? != null) {
                        if ("AgendaDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<AgendaDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<AgendaDto>() {}
                    })
                    assertAreEquals("getAgendasForUser", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    
    /**
     * Gets readable agendas for user
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getReadableAgendasForUserTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getReadableAgendasForUser")) {
            assertTrue(true, "Test of getReadableAgendasForUser endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getReadableAgendasForUser")
                val userId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getReadableAgendasForUser.userId")!!.let {
                    (it as? AgendaDto)?.takeIf { TestUtils.isAutoRev(fileName, "getReadableAgendasForUser") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAgenda(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getReadableAgendasForUser(userId = userId)

                val testFileName = "AgendaApi.getReadableAgendasForUser"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AgendaDto>? != null) {
                        if ("kotlin.collections.List<AgendaDto>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<AgendaDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlin.collections.List<AgendaDto>>() {}
                    })
                    assertAreEquals("getReadableAgendasForUser", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    
    /**
     * Modifies an agenda
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyAgendaTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "modifyAgenda")) {
            assertTrue(true, "Test of modifyAgenda endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyAgenda")
                val agendaDto: AgendaDto = TestUtils.getParameter<AgendaDto>(fileName, "modifyAgenda.agendaDto")!!.let {
                    (it as? AgendaDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyAgenda") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getAgenda(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? AgendaDto ?: it
                    }

                val response = api(credentialsFile).modifyAgenda(agendaDto = agendaDto)

                val testFileName = "AgendaApi.modifyAgenda"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<AgendaDto>? != null) {
                        if ("AgendaDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<AgendaDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<AgendaDto>() {}
                    })
                    assertAreEquals("modifyAgenda", objectFromFile, response)
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
            finally {
                TestUtils.deleteAfterElements(fileName)
                alreadyCreatedObjects.remove(fileName)
            }
        }
    }
    

    private suspend fun assertAreEquals(functionName: String, objectFromFile: Any?, response: Any) {
        when {
            objectFromFile as? Iterable<Any> != null -> {
                val toSkip : kotlin.collections.List<String> = when {
                    functionName.let { name -> listOf("listContact", "modifyContacts").any { name.startsWith(it) } } -> listOf("subContacts.[created, rev, modified]", "services.[openingDate]", "groupId", "created", "modified", "rev")
                    functionName.let { name -> listOf("getServices").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "openingDate")
                    functionName.let { name -> listOf("create", "new", "get", "list", "set").any { name.startsWith(it) } } -> listOf("rev", "created", "modified")
                    functionName.let { name -> listOf("modify", "delete", "undelete", "update").any { name.startsWith(it) } } -> listOf("rev")
                    functionName.let { name -> listOf("append").any { name.startsWith(it) } } -> listOf("id", "created", "modified")
                    functionName.let { name -> listOf("find", "filter").any { name.startsWith(it) } } -> listOf("rows.[created, rev, modified]", "created", "modified", "rev")
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
                    ?: listOf(Diff("Lists are of different sizes ${(objectFromFile as ArrayList<Any>).size} <-> ${(response as ArrayList<Any>).size}", PropertyType.ListItem, emptyList(), objectFromFile, response))
                assertTrue(diffs.isEmpty(), diffs.joinToString { it.toString() })
            }
            objectFromFile as? Flow<ByteBuffer> != null -> {
                assertTrue(objectFromFile.toList().let {
                    it.fold(0 to ByteArray(it.sumOf { it.remaining() })) { (pos, a), b ->
                        val siz = b.remaining()
                        (pos + siz) to a.also {
                            b.get(a, pos, siz)
                        }
                    }.second
                }.contentEquals(
                    (response as Flow<ByteBuffer>).toList().let {
                        it.fold(0 to ByteArray(it.sumOf { it.remaining() })) { (pos, a), b ->
                            val siz = b.remaining()
                            (pos + siz) to a.also {
                                b.get(a, pos, siz)
                            }
                        }.second
                    }
                )
                )}
            else -> {
                val toSkip : kotlin.collections.List<String> = when {
                    functionName.let { name -> listOf("modifyContact").any { name.startsWith(it) } } -> listOf("subContacts.[created, rev, modified]", "services.[openingDate]", "groupId", "created", "modified", "rev")
                    functionName.let { name -> listOf("modifyPatientReferral").any { name.startsWith(it) } } -> listOf("rev", "patientHealthCareParties.[referralPeriods]", "created", "modified")
                    functionName.let { name -> listOf("createContact").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "deletionDate", "groupId")
                    functionName.let { name -> listOf("newContactDelegations").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "groupId")
                    functionName.let { name -> listOf("create", "get", "modify", "new", "update").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "deletionDate")
                    functionName.let { name -> listOf("set", "delete", "merge").any { name.startsWith(it) } } -> listOf("rev", "created", "modified")
                    functionName.let { name -> listOf("validate").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "sentDate")
                    functionName.let { name -> listOf("reassign").any { name.startsWith(it) } } -> listOf("id", "created", "invoicingCodes.id")
                    functionName.let { name -> listOf("find").any { name.startsWith(it) } } -> listOf("rows.[created, rev, modified]")
                    else -> emptyList()
                }
                val diffs = filterDiffs(objectFromFile, response, response.differences(objectFromFile), toSkip)
                assertTrue(diffs.isEmpty(), diffs.joinToString { it.toString() })
            }
        }
    }
}
