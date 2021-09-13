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
import kotlin.reflect.full.callSuspendBy
import kotlin.reflect.javaType

/**
 * API tests for MedicalLocationApi
 */
@ExperimentalStdlibApi
class MedicalLocationApiTest() {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        @AfterAll
        fun afterAllTests(){
        TestUtils.deleteAfterElements("MedicalLocationApi.json")
        }

        @JvmStatic
        fun fileNames() = listOf("MedicalLocationApi.json")
    }

    fun api(fileName: String) = MedicalLocationApi(basePath = "https://kraken.icure.dev", authHeader = fileName.basicAuth())
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
        createForModification(fileName)
		if (TestUtils.skipEndpoint(fileName, "createMedicalLocation")) {
			assert(true)
			println("Endpoint createMedicalLocation skipped")
		} else {
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "createMedicalLocation")
        val medicalLocationDto: MedicalLocationDto = TestUtils.getParameter(fileName, "createMedicalLocation.medicalLocationDto")!!
		if (medicalLocationDto as? Collection<*> == null) {
			medicalLocationDto.also {
            if (TestUtils.isAutoRev(fileName, "createMedicalLocation") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                val rev = object: TypeReference<MedicalLocationDto>(){}.type::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = medicalLocationDto as? Collection<MedicalLocationDto> ?: emptyList<MedicalLocationDto>() as Collection<MedicalLocationDto>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "createMedicalLocation") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api(credentialsFile).createMedicalLocation(medicalLocationDto)

        val testFileName = "MedicalLocationApi.createMedicalLocation"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<MedicalLocationDto>? != null) {
                if ("MedicalLocationDto".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<MedicalLocationDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("createMedicalLocation", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }}
    
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
        createForModification(fileName)
		if (TestUtils.skipEndpoint(fileName, "deleteMedicalLocations")) {
			assert(true)
			println("Endpoint deleteMedicalLocations skipped")
		} else {
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteMedicalLocations")
        val listOfIdsDto: ListOfIdsDto = TestUtils.getParameter(fileName, "deleteMedicalLocations.listOfIdsDto")!!
		if (listOfIdsDto as? Collection<*> == null) {
			listOfIdsDto.also {
            if (TestUtils.isAutoRev(fileName, "deleteMedicalLocations") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                val rev = object: TypeReference<ListOfIdsDto>(){}.type::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = listOfIdsDto as? Collection<ListOfIdsDto> ?: emptyList<ListOfIdsDto>() as Collection<ListOfIdsDto>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "deleteMedicalLocations") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api(credentialsFile).deleteMedicalLocations(listOfIdsDto)

        val testFileName = "MedicalLocationApi.deleteMedicalLocations"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<DocIdentifier>? != null) {
                if ("kotlin.collections.List<DocIdentifier>".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<DocIdentifier>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("deleteMedicalLocations", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }}
    
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
        createForModification(fileName)
		if (TestUtils.skipEndpoint(fileName, "getMedicalLocation")) {
			assert(true)
			println("Endpoint getMedicalLocation skipped")
		} else {
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "getMedicalLocation")
        val locationId: kotlin.String = TestUtils.getParameter(fileName, "getMedicalLocation.locationId")!!
		if (locationId as? Collection<*> == null) {
			locationId.also {
            if (TestUtils.isAutoRev(fileName, "getMedicalLocation") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                val rev = object: TypeReference<kotlin.String>(){}.type::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = locationId as? Collection<kotlin.String> ?: emptyList<kotlin.String>() as Collection<kotlin.String>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "getMedicalLocation") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api(credentialsFile).getMedicalLocation(locationId)

        val testFileName = "MedicalLocationApi.getMedicalLocation"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<MedicalLocationDto>? != null) {
                if ("MedicalLocationDto".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<MedicalLocationDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("getMedicalLocation", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }}
    
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
        createForModification(fileName)
		if (TestUtils.skipEndpoint(fileName, "getMedicalLocations")) {
			assert(true)
			println("Endpoint getMedicalLocations skipped")
		} else {
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "getMedicalLocations")

        val response = api(credentialsFile).getMedicalLocations()

        val testFileName = "MedicalLocationApi.getMedicalLocations"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<MedicalLocationDto>? != null) {
                if ("kotlin.collections.List<MedicalLocationDto>".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<MedicalLocationDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("getMedicalLocations", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }}
    
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
        createForModification(fileName)
		if (TestUtils.skipEndpoint(fileName, "modifyMedicalLocation")) {
			assert(true)
			println("Endpoint modifyMedicalLocation skipped")
		} else {
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyMedicalLocation")
        val medicalLocationDto: MedicalLocationDto = TestUtils.getParameter(fileName, "modifyMedicalLocation.medicalLocationDto")!!
		if (medicalLocationDto as? Collection<*> == null) {
			medicalLocationDto.also {
            if (TestUtils.isAutoRev(fileName, "modifyMedicalLocation") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                val rev = object: TypeReference<MedicalLocationDto>(){}.type::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = medicalLocationDto as? Collection<MedicalLocationDto> ?: emptyList<MedicalLocationDto>() as Collection<MedicalLocationDto>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "modifyMedicalLocation") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api(credentialsFile).getMedicalLocation(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api(credentialsFile).modifyMedicalLocation(medicalLocationDto)

        val testFileName = "MedicalLocationApi.modifyMedicalLocation"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<MedicalLocationDto>? != null) {
                if ("MedicalLocationDto".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<MedicalLocationDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("modifyMedicalLocation", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }}
    


    private fun assertAreEquals(functionName: String, objectFromFile: Any?, response: Any) {
        if (objectFromFile as? Iterable<Any> != null) {
            val iterableResponse = (response as? Collection<Any> ?: (emptyList<Any>()))
            if (functionName.startsWith("create") || functionName.startsWith("new")) { // new
                for (fileElement in objectFromFile) {
                    fileElement::class.memberProperties.filterIsInstance<KMutableProperty<*>>().firstOrNull { it.name == "id" }?.setter?.call(fileElement, null)
                    fileElement::class.memberProperties.filterIsInstance<KMutableProperty<*>>().firstOrNull { it.name == "rev" }?.setter?.call(fileElement, null)
                }
                for (responseElement in iterableResponse) {
                    responseElement::class.memberProperties.filterIsInstance<KMutableProperty<*>>().firstOrNull { it.name == "id" }?.setter?.call(responseElement, null)
                    responseElement::class.memberProperties.filterIsInstance<KMutableProperty<*>>().firstOrNull { it.name == "rev" }?.setter?.call(responseElement, null)
                }
            } else if (functionName.startsWith("modify") || functionName.startsWith("set") || functionName.startsWith("delete")) { // + set + delete
                for (fileElement in objectFromFile) {
                    fileElement::class.memberProperties.filterIsInstance<KMutableProperty<*>>().firstOrNull { it.name == "rev" }?.setter?.call(fileElement, null)
                }
                for (responseElement in iterableResponse) {
                    responseElement::class.memberProperties.filterIsInstance<KMutableProperty<*>>().firstOrNull { it.name == "rev" }?.setter?.call(responseElement, null)
                }
            }
            val diffs = response.differences(objectFromFile)
            assertTrue(diffs.isEmpty())
        } else {
            if (functionName.startsWith("create") || functionName.startsWith("modify")) {
                assertThat(objectFromFile as Any).isEqualToIgnoringGivenProperties(response, *(response::class.memberProperties.filter { it.name == "rev" || it.name == "id" || it.name == "created"  || it.name == "modified" }.mapNotNull { it as? KProperty1<Any, Any> }.toTypedArray()))
            } else {
                assertEquals(objectFromFile, response)
            }
        }
    }

}
