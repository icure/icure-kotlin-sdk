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

import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.TimeTableDto
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
import io.icure.kraken.client.models.filter.AbstractFilterDto

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
import kotlinx.coroutines.flow.toList

/**
 * API tests for TimeTableApi
 */
@ExperimentalStdlibApi
class TimeTableApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("TimeTableApi.json")
    }

    // http://127.0.0.1:16043
    fun api(fileName: String) = TimeTableApi(basePath = java.lang.System.getProperty("API_URL"), authHeader = fileName.basicAuth())
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
                            TimeTableDto::class.java -> it to objectMapper.convertValue(body, TimeTableDto::class.java)
                            TimeTableApi::class.java -> it to api(credentialsFile)
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
     * Creates a timeTable
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createTimeTableTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "createTimeTable")) {
            assertTrue(true, "Test of createTimeTable endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createTimeTable")
                val timeTableDto: TimeTableDto = TestUtils.getParameter<TimeTableDto>(fileName, "createTimeTable.timeTableDto")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "createTimeTable") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? TimeTableDto ?: it
                    }

                val response = api(credentialsFile).createTimeTable(timeTableDto = timeTableDto)

                val testFileName = "TimeTableApi.createTimeTable"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<TimeTableDto>? != null) {
                        if ("TimeTableDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<TimeTableDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<TimeTableDto>() {}
                    })
                    assertAreEquals("createTimeTable", objectFromFile, response)
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
     * Deletes an timeTable
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteTimeTableTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "deleteTimeTable")) {
            assertTrue(true, "Test of deleteTimeTable endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteTimeTable")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteTimeTable.listOfIdsDto")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteTimeTable") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteTimeTable(listOfIdsDto = listOfIdsDto)

                val testFileName = "TimeTableApi.deleteTimeTable"
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
                    assertAreEquals("deleteTimeTable", objectFromFile, response)
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
     * Gets a timeTable
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getTimeTableTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getTimeTable")) {
            assertTrue(true, "Test of getTimeTable endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getTimeTable")
                val timeTableId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getTimeTable.timeTableId")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "getTimeTable") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getTimeTable(timeTableId = timeTableId)

                val testFileName = "TimeTableApi.getTimeTable"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<TimeTableDto>? != null) {
                        if ("TimeTableDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<TimeTableDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<TimeTableDto>() {}
                    })
                    assertAreEquals("getTimeTable", objectFromFile, response)
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
     * Get TimeTables by AgendaId
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getTimeTablesByAgendaIdTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getTimeTablesByAgendaId")) {
            assertTrue(true, "Test of getTimeTablesByAgendaId endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getTimeTablesByAgendaId")
                val agendaId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getTimeTablesByAgendaId.agendaId")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "getTimeTablesByAgendaId") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getTimeTablesByAgendaId(agendaId = agendaId)

                val testFileName = "TimeTableApi.getTimeTablesByAgendaId"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<TimeTableDto>? != null) {
                        if ("kotlin.collections.List<TimeTableDto>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<TimeTableDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlin.collections.List<TimeTableDto>>() {}
                    })
                    assertAreEquals("getTimeTablesByAgendaId", objectFromFile, response)
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
     * Get TimeTables by Period and AgendaId
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getTimeTablesByPeriodAndAgendaIdTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getTimeTablesByPeriodAndAgendaId")) {
            assertTrue(true, "Test of getTimeTablesByPeriodAndAgendaId endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getTimeTablesByPeriodAndAgendaId")
                val startDate: kotlin.Long = TestUtils.getParameter<kotlin.Long>(fileName, "getTimeTablesByPeriodAndAgendaId.startDate")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "getTimeTablesByPeriodAndAgendaId") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Long ?: it
                    }
                val endDate: kotlin.Long = TestUtils.getParameter<kotlin.Long>(fileName, "getTimeTablesByPeriodAndAgendaId.endDate")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "getTimeTablesByPeriodAndAgendaId") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Long ?: it
                    }
                val agendaId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getTimeTablesByPeriodAndAgendaId.agendaId")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "getTimeTablesByPeriodAndAgendaId") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getTimeTablesByPeriodAndAgendaId(startDate = startDate,endDate = endDate,agendaId = agendaId)

                val testFileName = "TimeTableApi.getTimeTablesByPeriodAndAgendaId"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<TimeTableDto>? != null) {
                        if ("kotlin.collections.List<TimeTableDto>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<TimeTableDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlin.collections.List<TimeTableDto>>() {}
                    })
                    assertAreEquals("getTimeTablesByPeriodAndAgendaId", objectFromFile, response)
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
     * Modifies an timeTable
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyTimeTableTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "modifyTimeTable")) {
            assertTrue(true, "Test of modifyTimeTable endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyTimeTable")
                val timeTableDto: TimeTableDto = TestUtils.getParameter<TimeTableDto>(fileName, "modifyTimeTable.timeTableDto")!!.let {
                    (it as? TimeTableDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyTimeTable") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getTimeTable(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? TimeTableDto ?: it
                    }

                val response = api(credentialsFile).modifyTimeTable(timeTableDto = timeTableDto)

                val testFileName = "TimeTableApi.modifyTimeTable"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<TimeTableDto>? != null) {
                        if ("TimeTableDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<TimeTableDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<TimeTableDto>() {}
                    })
                    assertAreEquals("modifyTimeTable", objectFromFile, response)
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
