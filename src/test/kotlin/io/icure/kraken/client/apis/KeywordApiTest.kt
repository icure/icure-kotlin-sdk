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
import io.icure.kraken.client.models.KeywordDto
import io.icure.kraken.client.models.ListOfIdsDto
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
 * API tests for KeywordApi
 */
@ExperimentalStdlibApi
class KeywordApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("KeywordApi.json")
    }

    fun api(fileName: String) = KeywordApi(basePath = "http://127.0.0.1:16043", authHeader = fileName.basicAuth())
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
                            KeywordDto::class.java -> it to objectMapper.convertValue(body, KeywordDto::class.java)
                            KeywordApi::class.java -> it to api(credentialsFile)
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
     * Create a keyword with the current user
     *
     * Returns an instance of created keyword.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createKeywordTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "createKeyword")) {
                assert(true)
                println("Endpoint createKeyword skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createKeyword")
                val keywordDto: KeywordDto = TestUtils.getParameter<KeywordDto>(fileName, "createKeyword.keywordDto")!!.let {
                    (it as? KeywordDto)?.takeIf { TestUtils.isAutoRev(fileName, "createKeyword") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getKeyword(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? KeywordDto ?: it
                    }

                val response = api(credentialsFile).createKeyword(keywordDto)

                    val testFileName = "KeywordApi.createKeyword"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<KeywordDto>? != null) {
                            if ("KeywordDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<KeywordDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<KeywordDto>() {}
                        })
                        assertAreEquals("createKeyword", objectFromFile, response)
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
     * Delete keywords.
     *
     * Response is a set containing the ID&#39;s of deleted keywords.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteKeywordsTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "deleteKeywords")) {
                assert(true)
                println("Endpoint deleteKeywords skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteKeywords")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteKeywords.listOfIdsDto")!!.let {
                    (it as? KeywordDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteKeywords") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getKeyword(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteKeywords(listOfIdsDto)

                    val testFileName = "KeywordApi.deleteKeywords"
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
                        assertAreEquals("deleteKeywords", objectFromFile, response)
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
     * Get a keyword
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getKeywordTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "getKeyword")) {
                assert(true)
                println("Endpoint getKeyword skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getKeyword")
                val keywordId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getKeyword.keywordId")!!.let {
                    (it as? KeywordDto)?.takeIf { TestUtils.isAutoRev(fileName, "getKeyword") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getKeyword(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getKeyword(keywordId)

                    val testFileName = "KeywordApi.getKeyword"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<KeywordDto>? != null) {
                            if ("KeywordDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<KeywordDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<KeywordDto>() {}
                        })
                        assertAreEquals("getKeyword", objectFromFile, response)
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
     * Gets all keywords
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getKeywordsTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "getKeywords")) {
                assert(true)
                println("Endpoint getKeywords skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getKeywords")

                val response = api(credentialsFile).getKeywords()

                    val testFileName = "KeywordApi.getKeywords"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<KeywordDto>? != null) {
                            if ("kotlin.collections.List<KeywordDto>".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<KeywordDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<kotlin.collections.List<KeywordDto>>() {}
                        })
                        assertAreEquals("getKeywords", objectFromFile, response)
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
     * Get keywords by user
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getKeywordsByUserTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "getKeywordsByUser")) {
                assert(true)
                println("Endpoint getKeywordsByUser skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getKeywordsByUser")
                val userId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getKeywordsByUser.userId")!!.let {
                    (it as? KeywordDto)?.takeIf { TestUtils.isAutoRev(fileName, "getKeywordsByUser") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getKeyword(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getKeywordsByUser(userId)

                    val testFileName = "KeywordApi.getKeywordsByUser"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<KeywordDto>? != null) {
                            if ("kotlin.collections.List<KeywordDto>".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<KeywordDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<kotlin.collections.List<KeywordDto>>() {}
                        })
                        assertAreEquals("getKeywordsByUser", objectFromFile, response)
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
     * Modify a keyword
     *
     * Returns the modified keyword.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyKeywordTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "modifyKeyword")) {
                assert(true)
                println("Endpoint modifyKeyword skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyKeyword")
                val keywordDto: KeywordDto = TestUtils.getParameter<KeywordDto>(fileName, "modifyKeyword.keywordDto")!!.let {
                    (it as? KeywordDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyKeyword") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getKeyword(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? KeywordDto ?: it
                    }

                val response = api(credentialsFile).modifyKeyword(keywordDto)

                    val testFileName = "KeywordApi.modifyKeyword"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<KeywordDto>? != null) {
                            if ("KeywordDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<KeywordDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<KeywordDto>() {}
                        })
                        assertAreEquals("modifyKeyword", objectFromFile, response)
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
                    functionName.let { name -> listOf("create", "new").any { name.startsWith(it) } } -> listOf("id", "rev")
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
                    functionName.let { name -> listOf("create").any { name.startsWith(it) } } -> listOf("id", "rev", "created", "modified")
                    functionName.let { name -> listOf("set",  "modify").any { name.startsWith(it) } } -> listOf("rev")
                    else -> emptyList()
                }
                val diffs = filterDiffs(objectFromFile, response, response.differences(objectFromFile), toSkip)
                assertTrue(diffs.isEmpty())
            }
        }
    }
}
