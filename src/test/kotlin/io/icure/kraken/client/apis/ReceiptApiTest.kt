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
import io.icure.kraken.client.models.ReceiptDto
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

/**
 * API tests for ReceiptApi
 */
@ExperimentalStdlibApi
class ReceiptApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("ReceiptApi.json")
    }

    fun api(fileName: String) = ReceiptApi(basePath = "http://127.0.0.1:16043", authHeader = fileName.basicAuth())
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
                            ReceiptDto::class.java -> it to objectMapper.convertValue(body, ReceiptDto::class.java)
                            ReceiptApi::class.java -> it to api(credentialsFile)
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
     * Creates a receipt
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createReceiptTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "createReceipt")) {
            assert(true)
            println("Endpoint createReceipt skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createReceipt")
                val receiptDto: ReceiptDto = TestUtils.getParameter<ReceiptDto>(fileName, "createReceipt.receiptDto")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "createReceipt") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ReceiptDto ?: it
                    }

                val response = api(credentialsFile).createReceipt(receiptDto)

                val testFileName = "ReceiptApi.createReceipt"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ReceiptDto>? != null) {
                        if ("ReceiptDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<ReceiptDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<ReceiptDto>() {}
                    })
                    assertAreEquals("createReceipt", objectFromFile, response)
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
     * Deletes receipts
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteReceiptsTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "deleteReceipts")) {
            assert(true)
            println("Endpoint deleteReceipts skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteReceipts")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteReceipts.listOfIdsDto")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteReceipts") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteReceipts(listOfIdsDto)

                val testFileName = "ReceiptApi.deleteReceipts"
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
                    assertAreEquals("deleteReceipts", objectFromFile, response)
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
     * Gets a receipt
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getReceiptTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getReceipt")) {
            assert(true)
            println("Endpoint getReceipt skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getReceipt")
                val receiptId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getReceipt.receiptId")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "getReceipt") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getReceipt(receiptId)

                val testFileName = "ReceiptApi.getReceipt"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ReceiptDto>? != null) {
                        if ("ReceiptDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<ReceiptDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<ReceiptDto>() {}
                    })
                    assertAreEquals("getReceipt", objectFromFile, response)
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
     * Get an attachment
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getReceiptAttachmentTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "getReceiptAttachment")) {
            assert(true)
            println("Endpoint getReceiptAttachment skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getReceiptAttachment")
                val receiptId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getReceiptAttachment.receiptId")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "getReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val attachmentId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getReceiptAttachment.attachmentId")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "getReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val enckeys: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getReceiptAttachment.enckeys")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "getReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getReceiptAttachment(receiptId,attachmentId,enckeys)

                val testFileName = "ReceiptApi.getReceiptAttachment"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>? != null) {
                        if ("kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>() {}
                    })
                    assertAreEquals("getReceiptAttachment", objectFromFile, response)
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
     * Gets a receipt
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun listByReferenceTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "listByReference")) {
            assert(true)
            println("Endpoint listByReference skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "listByReference")
                val ref: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "listByReference.ref")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "listByReference") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).listByReference(ref)

                val testFileName = "ReceiptApi.listByReference"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ReceiptDto>? != null) {
                        if ("kotlin.collections.List<ReceiptDto>".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<ReceiptDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<kotlin.collections.List<ReceiptDto>>() {}
                    })
                    assertAreEquals("listByReference", objectFromFile, response)
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
     * Updates a receipt
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyReceiptTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "modifyReceipt")) {
            assert(true)
            println("Endpoint modifyReceipt skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyReceipt")
                val receiptDto: ReceiptDto = TestUtils.getParameter<ReceiptDto>(fileName, "modifyReceipt.receiptDto")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyReceipt") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ReceiptDto ?: it
                    }

                val response = api(credentialsFile).modifyReceipt(receiptDto)

                val testFileName = "ReceiptApi.modifyReceipt"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ReceiptDto>? != null) {
                        if ("ReceiptDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<ReceiptDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<ReceiptDto>() {}
                    })
                    assertAreEquals("modifyReceipt", objectFromFile, response)
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
     * Creates a receipt&#39;s attachment
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun setReceiptAttachmentTest(fileName: String) = runBlocking {

        if (TestUtils.skipEndpoint(fileName, "setReceiptAttachment")) {
            assert(true)
            println("Endpoint setReceiptAttachment skipped")
        } else {
            try{
                createForModification(fileName)
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "setReceiptAttachment")
                val receiptId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "setReceiptAttachment.receiptId")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "setReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val blobType: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "setReceiptAttachment.blobType")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "setReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val body: kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer> = TestUtils.getParameter<kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer>>(fileName, "setReceiptAttachment.body")!!.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "setReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlinx.coroutines.flow.Flow<java.nio.ByteBuffer> ?: it
                    }
                val enckeys: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "setReceiptAttachment.enckeys")?.let {
                    (it as? ReceiptDto)?.takeIf { TestUtils.isAutoRev(fileName, "setReceiptAttachment") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getReceipt(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).setReceiptAttachment(receiptId,blobType,body,enckeys)

                val testFileName = "ReceiptApi.setReceiptAttachment"
                val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                try {
                    val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ReceiptDto>? != null) {
                        if ("ReceiptDto".contains("String>")) {
                            object : TypeReference<List<String>>() {}
                        } else {
                            object : TypeReference<List<ReceiptDto>>() {}
                        }
                    } else if(response as? kotlin.collections.Map<String, String>? != null){
                        object : TypeReference<Map<String,String>>() {}
                    } else {
                        object : TypeReference<ReceiptDto>() {}
                    })
                    assertAreEquals("setReceiptAttachment", objectFromFile, response)
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
                    functionName.let { name -> listOf("create", "new", "get", "list", "set").any { name.startsWith(it) } } -> listOf("rev", "created", "modified")
                    functionName.let { name -> listOf("modify", "delete").any { name.startsWith(it) } } -> listOf("rev")
                    functionName.let { name -> listOf("append").any { name.startsWith(it) } } -> listOf("id", "created", "modified")
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
                    functionName.let { name -> listOf("set", "delete", "merge").any { name.startsWith(it) } } -> listOf("rev", "created", "modified")
                    functionName.let { name -> listOf("validate").any { name.startsWith(it) } } -> listOf("rev", "created", "modified", "sentDate")
                    functionName.let { name -> listOf("reassign").any { name.startsWith(it) } } -> listOf("id", "created", "invoicingCodes.id")
                    else -> emptyList()
                }
                val diffs = filterDiffs(objectFromFile, response, response.differences(objectFromFile), toSkip)
                assertTrue(diffs.isEmpty())
            }
        }
    }
}
