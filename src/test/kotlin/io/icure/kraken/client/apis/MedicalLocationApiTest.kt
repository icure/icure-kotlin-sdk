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
import io.icure.kraken.client.models.MedicalLocationDto
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
 * API tests for MedicalLocationApi
 */
@ExperimentalStdlibApi
class MedicalLocationApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("MedicalLocationApi.json")
    }

    // http://127.0.0.1:16043
    fun api(fileName: String) = MedicalLocationApi(basePath = java.lang.System.getProperty("API_URL"), authHeader = fileName.basicAuth())
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
                            MedicalLocationDto::class.java -> it to objectMapper.convertValue(body, MedicalLocationDto::class.java)
                            MedicalLocationApi::class.java -> it to api(credentialsFile)
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
     * Creates a medical location
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createMedicalLocationTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "createMedicalLocation")) {
            assertTrue(true, "Test of createMedicalLocation endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createMedicalLocation")
                val medicalLocationDto: MedicalLocationDto = TestUtils.getParameter<MedicalLocationDto>(fileName, "createMedicalLocation.medicalLocationDto")!!.let {
                    (it as? MedicalLocationDto)?.takeIf { TestUtils.isAutoRev(fileName, "createMedicalLocation") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? MedicalLocationDto ?: it
                    }

                val response = api(credentialsFile).createMedicalLocation(medicalLocationDto = medicalLocationDto)

                val testFileName = "MedicalLocationApi.createMedicalLocation"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<MedicalLocationDto>? != null) {
                        if ("MedicalLocationDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<MedicalLocationDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<MedicalLocationDto>() {}
                    })
                    assertAreEquals("createMedicalLocation", objectFromFile, response)
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
     * Deletes medical locations
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteMedicalLocationsTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "deleteMedicalLocations")) {
            assertTrue(true, "Test of deleteMedicalLocations endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteMedicalLocations")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteMedicalLocations.listOfIdsDto")!!.let {
                    (it as? MedicalLocationDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteMedicalLocations") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteMedicalLocations(listOfIdsDto = listOfIdsDto)

                val testFileName = "MedicalLocationApi.deleteMedicalLocations"
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
                    assertAreEquals("deleteMedicalLocations", objectFromFile, response)
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
     * Gets a medical location
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getMedicalLocationTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getMedicalLocation")) {
            assertTrue(true, "Test of getMedicalLocation endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getMedicalLocation")
                val locationId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getMedicalLocation.locationId")!!.let {
                    (it as? MedicalLocationDto)?.takeIf { TestUtils.isAutoRev(fileName, "getMedicalLocation") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getMedicalLocation(locationId = locationId)

                val testFileName = "MedicalLocationApi.getMedicalLocation"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<MedicalLocationDto>? != null) {
                        if ("MedicalLocationDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<MedicalLocationDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<MedicalLocationDto>() {}
                    })
                    assertAreEquals("getMedicalLocation", objectFromFile, response)
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
     * Gets all medical locations
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getMedicalLocationsTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getMedicalLocations")) {
            assertTrue(true, "Test of getMedicalLocations endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getMedicalLocations")

                val response = api(credentialsFile).getMedicalLocations()

                val testFileName = "MedicalLocationApi.getMedicalLocations"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<MedicalLocationDto>? != null) {
                        if ("kotlin.collections.List<MedicalLocationDto>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<MedicalLocationDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlin.collections.List<MedicalLocationDto>>() {}
                    })
                    assertAreEquals("getMedicalLocations", objectFromFile, response)
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
     * Modifies a medical location
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyMedicalLocationTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "modifyMedicalLocation")) {
            assertTrue(true, "Test of modifyMedicalLocation endpoint has been skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyMedicalLocation")
                val medicalLocationDto: MedicalLocationDto = TestUtils.getParameter<MedicalLocationDto>(fileName, "modifyMedicalLocation.medicalLocationDto")!!.let {
                    (it as? MedicalLocationDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyMedicalLocation") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? MedicalLocationDto ?: it
                    }

                val response = api(credentialsFile).modifyMedicalLocation(medicalLocationDto = medicalLocationDto)

                val testFileName = "MedicalLocationApi.modifyMedicalLocation"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<MedicalLocationDto>? != null) {
                        if ("MedicalLocationDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<MedicalLocationDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<MedicalLocationDto>() {}
                    })
                    assertAreEquals("modifyMedicalLocation", objectFromFile, response)
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
                    functionName.let { name -> listOf("modify", "delete", "undelete").any { name.startsWith(it) } } -> listOf("rev")
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
                    functionName.let { name -> listOf("create", "get", "modify", "new").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "deletionDate")
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
