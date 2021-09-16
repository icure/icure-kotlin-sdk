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

import io.icure.kraken.client.models.ClassificationTemplateDto
import io.icure.kraken.client.models.DelegationDto
import io.icure.kraken.client.models.DocIdentifier
import io.icure.kraken.client.models.ListOfIdsDto
import io.icure.kraken.client.models.PaginatedListClassificationTemplateDto
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
 * API tests for ClassificationTemplateApi
 */
@ExperimentalStdlibApi
class ClassificationTemplateApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        fun fileNames() = listOf("ClassificationTemplateApi.json")
    }

    fun api(fileName: String) = ClassificationTemplateApi(basePath = "http://127.0.0.1:16043", authHeader = fileName.basicAuth())
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
                            ClassificationTemplateDto::class.java -> it to objectMapper.convertValue(body, ClassificationTemplateDto::class.java)
                            ClassificationTemplateApi::class.java -> it to api(credentialsFile)
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
     * Create a classification Template with the current user
     *
     * Returns an instance of created classification Template.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun createClassificationTemplateTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "createClassificationTemplate")) {
                assert(true)
                println("Endpoint createClassificationTemplate skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createClassificationTemplate")
                val classificationTemplateDto: ClassificationTemplateDto = TestUtils.getParameter<ClassificationTemplateDto>(fileName, "createClassificationTemplate.classificationTemplateDto")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "createClassificationTemplate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ClassificationTemplateDto ?: it
                    }

                val response = api(credentialsFile).createClassificationTemplate(classificationTemplateDto)

                    val testFileName = "ClassificationTemplateApi.createClassificationTemplate"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ClassificationTemplateDto>? != null) {
                            if ("ClassificationTemplateDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<ClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<ClassificationTemplateDto>() {}
                        })
                        assertAreEquals("createClassificationTemplate", objectFromFile, response)
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
     * Delete classification Templates.
     *
     * Response is a set containing the ID&#39;s of deleted classification Templates.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun deleteClassificationTemplatesTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "deleteClassificationTemplates")) {
                assert(true)
                println("Endpoint deleteClassificationTemplates skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteClassificationTemplates")
                val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter<ListOfIdsDto>(fileName, "deleteClassificationTemplates.listOfIdsDto")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "deleteClassificationTemplates") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ListOfIdsDto ?: it
                    }

                val response = api(credentialsFile).deleteClassificationTemplates(listOfIdsDto)

                    val testFileName = "ClassificationTemplateApi.deleteClassificationTemplates"
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
                        assertAreEquals("deleteClassificationTemplates", objectFromFile, response)
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
     * List all classification templates with pagination
     *
     * Returns a list of classification templates.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun findClassificationTemplatesByTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "findClassificationTemplatesBy")) {
                assert(true)
                println("Endpoint findClassificationTemplatesBy skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "findClassificationTemplatesBy")
                val startKey: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "findClassificationTemplatesBy.startKey")?.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "findClassificationTemplatesBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val startDocumentId: kotlin.String? = TestUtils.getParameter<kotlin.String>(fileName, "findClassificationTemplatesBy.startDocumentId")?.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "findClassificationTemplatesBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val limit: kotlin.Int? = TestUtils.getParameter<kotlin.Int>(fileName, "findClassificationTemplatesBy.limit")?.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "findClassificationTemplatesBy") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.Int ?: it
                    }

                val response = api(credentialsFile).findClassificationTemplatesBy(startKey,startDocumentId,limit)

                    val testFileName = "ClassificationTemplateApi.findClassificationTemplatesBy"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<PaginatedListClassificationTemplateDto>? != null) {
                            if ("PaginatedListClassificationTemplateDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<PaginatedListClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<PaginatedListClassificationTemplateDto>() {}
                        })
                        assertAreEquals("findClassificationTemplatesBy", objectFromFile, response)
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
     * Get a classification Template
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getClassificationTemplateTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "getClassificationTemplate")) {
                assert(true)
                println("Endpoint getClassificationTemplate skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getClassificationTemplate")
                val classificationTemplateId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getClassificationTemplate.classificationTemplateId")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "getClassificationTemplate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getClassificationTemplate(classificationTemplateId)

                    val testFileName = "ClassificationTemplateApi.getClassificationTemplate"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ClassificationTemplateDto>? != null) {
                            if ("ClassificationTemplateDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<ClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<ClassificationTemplateDto>() {}
                        })
                        assertAreEquals("getClassificationTemplate", objectFromFile, response)
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
     * Get a list of classifications Templates
     *
     * Ids are seperated by a coma
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun getClassificationTemplateByIdsTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "getClassificationTemplateByIds")) {
                assert(true)
                println("Endpoint getClassificationTemplateByIds skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "getClassificationTemplateByIds")
                val ids: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "getClassificationTemplateByIds.ids")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "getClassificationTemplateByIds") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).getClassificationTemplateByIds(ids)

                    val testFileName = "ClassificationTemplateApi.getClassificationTemplateByIds"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ClassificationTemplateDto>? != null) {
                            if ("kotlin.collections.List<ClassificationTemplateDto>".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<ClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<kotlin.collections.List<ClassificationTemplateDto>>() {}
                        })
                        assertAreEquals("getClassificationTemplateByIds", objectFromFile, response)
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
     * List classification Templates found By Healthcare Party and secret foreign keyelementIds.
     *
     * Keys hast to delimited by coma
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun listClassificationTemplatesByHCPartyPatientForeignKeysTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "listClassificationTemplatesByHCPartyPatientForeignKeys")) {
                assert(true)
                println("Endpoint listClassificationTemplatesByHCPartyPatientForeignKeys skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "listClassificationTemplatesByHCPartyPatientForeignKeys")
                val hcPartyId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "listClassificationTemplatesByHCPartyPatientForeignKeys.hcPartyId")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "listClassificationTemplatesByHCPartyPatientForeignKeys") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val secretFKeys: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "listClassificationTemplatesByHCPartyPatientForeignKeys.secretFKeys")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "listClassificationTemplatesByHCPartyPatientForeignKeys") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }

                val response = api(credentialsFile).listClassificationTemplatesByHCPartyPatientForeignKeys(hcPartyId,secretFKeys)

                    val testFileName = "ClassificationTemplateApi.listClassificationTemplatesByHCPartyPatientForeignKeys"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ClassificationTemplateDto>? != null) {
                            if ("kotlin.collections.List<ClassificationTemplateDto>".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<ClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<kotlin.collections.List<ClassificationTemplateDto>>() {}
                        })
                        assertAreEquals("listClassificationTemplatesByHCPartyPatientForeignKeys", objectFromFile, response)
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
     * Modify a classification Template
     *
     * Returns the modified classification Template.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun modifyClassificationTemplateTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "modifyClassificationTemplate")) {
                assert(true)
                println("Endpoint modifyClassificationTemplate skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyClassificationTemplate")
                val classificationTemplateDto: ClassificationTemplateDto = TestUtils.getParameter<ClassificationTemplateDto>(fileName, "modifyClassificationTemplate.classificationTemplateDto")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "modifyClassificationTemplate") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? ClassificationTemplateDto ?: it
                    }

                val response = api(credentialsFile).modifyClassificationTemplate(classificationTemplateDto)

                    val testFileName = "ClassificationTemplateApi.modifyClassificationTemplate"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ClassificationTemplateDto>? != null) {
                            if ("ClassificationTemplateDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<ClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<ClassificationTemplateDto>() {}
                        })
                        assertAreEquals("modifyClassificationTemplate", objectFromFile, response)
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
     * Delegates a classification Template to a healthcare party
     *
     * It delegates a classification Template to a healthcare party (By current healthcare party). Returns the element with new delegations.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	fun newClassificationTemplateDelegationsTest(fileName: String) = runBlocking {
        try{
            createForModification(fileName)
            if (TestUtils.skipEndpoint(fileName, "newClassificationTemplateDelegations")) {
                assert(true)
                println("Endpoint newClassificationTemplateDelegations skipped")
            } else {
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "newClassificationTemplateDelegations")
                val classificationTemplateId: kotlin.String = TestUtils.getParameter<kotlin.String>(fileName, "newClassificationTemplateDelegations.classificationTemplateId")!!.let {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "newClassificationTemplateDelegations") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } as? kotlin.String ?: it
                    }
                val delegationDto: kotlin.collections.List<DelegationDto> = TestUtils.getParameter<kotlin.collections.List<DelegationDto>>(fileName, "newClassificationTemplateDelegations.delegationDto")!!.map {
                    (it as? ClassificationTemplateDto)?.takeIf { TestUtils.isAutoRev(fileName, "newClassificationTemplateDelegations") }?.let {
                    val id = it::class.memberProperties.first { it.name == "id" }
                    val currentRev = api(credentialsFile).getClassificationTemplate(id.getter.call(it) as String).rev
                    it.copy(rev = currentRev)
                    } ?: it
                    } as kotlin.collections.List<DelegationDto>

                val response = api(credentialsFile).newClassificationTemplateDelegations(classificationTemplateId,delegationDto)

                    val testFileName = "ClassificationTemplateApi.newClassificationTemplateDelegations"
                    val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
                    try {
                        val objectFromFile = (response as? Flow<ByteBuffer>)?.let { file.readAsFlow() } ?: objectMapper.readValue(file,  if (response as? List<ClassificationTemplateDto>? != null) {
                            if ("ClassificationTemplateDto".contains("String>")) {
                                object : TypeReference<List<String>>() {}
                            } else {
                                object : TypeReference<List<ClassificationTemplateDto>>() {}
                            }
                        } else if(response as? kotlin.collections.Map<String, String>? != null){
                            object : TypeReference<Map<String,String>>() {}
                        } else {
                            object : TypeReference<ClassificationTemplateDto>() {}
                        })
                        assertAreEquals("newClassificationTemplateDelegations", objectFromFile, response)
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
