/**
 * iCure Cloud API Documentation
 *
 * Spring shop sample application
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

package io.icure.kraken.client.apis;

import io.icure.kraken.client.models.ArticleDto;
import io.icure.kraken.client.models.DocIdentifier;
import assertk.Assert
import assertk.assertThat
import assertk.assertions.hasSameSizeAs
import assertk.assertions.isEqualToIgnoringGivenProperties
import java.io.*

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.json.JsonReadFeature
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.api.Assertions.assertEquals

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty1
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

/**
 * API tests for ArticleApi
 */
@ExperimentalStdlibApi
class ArticleApiTest(private val fileName: String) {

    companion object {
        private val alreadyCreatedObjects = mutableSetOf<String>()
        fun canCreateForModificationObjects(fileName: String) = alreadyCreatedObjects.add(fileName)

        @JvmStatic
        @AfterAll
        fun afterAllTests(){
        TestUtils.deleteAfterElements("ArticleApi.json")
        }

        @JvmStatic
        fun fileNames() = listOf("ArticleApi.json")
    }

    private val api = ArticleApi()
    private val workingFolder = "/tmp/icureTests/"
    private val objectMapper = ObjectMapper().registerModule(KotlinModule()).registerModule(JavaTimeModule()).apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true)
    }
    @BeforeEach
    fun createForModification(){
        if (canCreateForModificationObjects(fileName)) {
            TestUtils.getParameters<Any>(fileName, "beforeElements.bodies")?.let {bodies ->
                val credentialsFile = TestUtils.getCredentialsFile(fileName, "createDto")
                val createFunction = api::class.memberFunctions
                    .firstOrNull { it.parameters.size == 3; it.name.startsWith("create") }
                val deleteFunction = api::class.memberFunctions
                    .firstOrNull { it.parameters.size == 3 && it.name.startsWith("delete") }
                bodies.forEach {body ->
                    //deleteFunction?.call(api, body?.id)
                    createFunction!!.call(api, body)
					println("created")
                }
            }
        }
    }

    
    /**
     * Creates a article
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	suspend fun createArticleTest(fileName: String) {
		if (TestUtils.skipEndpoint(fileName, "createArticle")) {
			assert(true)
			println("Endpoint createArticle skipped")
			return
		}
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "createArticle")
        val articleDto: ArticleDto = TestUtils.getParameter(fileName, "createArticle.articleDto")!!
		if (articleDto as? Collection<*> == null) {
			articleDto.also {
            if (TestUtils.isAutoRev(fileName, "createArticle") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api.getArticle(id.getter.call(it) as String).rev
                val rev = ArticleDto::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = articleDto as? Collection<ArticleDto> ?: emptyList<ArticleDto>() as Collection<ArticleDto>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "createArticle") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api.getArticle(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api.createArticle(articleDto)

        val testFileName = "ArticleApi.createArticle"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<ArticleDto>? != null) {
                if ("ArticleDto".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<ArticleDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("createArticle", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }
    
    /**
     * Deletes an article
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	suspend fun deleteArticleTest(fileName: String) {
		if (TestUtils.skipEndpoint(fileName, "deleteArticle")) {
			assert(true)
			println("Endpoint deleteArticle skipped")
			return
		}
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "deleteArticle")
        val articleIds: kotlin.String = TestUtils.getParameter(fileName, "deleteArticle.articleIds")!!
		if (articleIds as? Collection<*> == null) {
			articleIds.also {
            if (TestUtils.isAutoRev(fileName, "deleteArticle") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api.getArticle(id.getter.call(it) as String).rev
                val rev = kotlin.String::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = articleIds as? Collection<DocIdentifier> ?: emptyList<DocIdentifier>() as Collection<DocIdentifier>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "deleteArticle") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api.getArticle(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api.deleteArticle(articleIds)

        val testFileName = "ArticleApi.deleteArticle"
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
            assertAreEquals("deleteArticle", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }
    
    /**
     * Gets an article
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	suspend fun getArticleTest(fileName: String) {
		if (TestUtils.skipEndpoint(fileName, "getArticle")) {
			assert(true)
			println("Endpoint getArticle skipped")
			return
		}
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "getArticle")
        val articleId: kotlin.String = TestUtils.getParameter(fileName, "getArticle.articleId")!!
		if (articleId as? Collection<*> == null) {
			articleId.also {
            if (TestUtils.isAutoRev(fileName, "getArticle") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api.getArticle(id.getter.call(it) as String).rev
                val rev = kotlin.String::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = articleId as? Collection<ArticleDto> ?: emptyList<ArticleDto>() as Collection<ArticleDto>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "getArticle") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api.getArticle(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api.getArticle(articleId)

        val testFileName = "ArticleApi.getArticle"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<ArticleDto>? != null) {
                if ("ArticleDto".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<ArticleDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("getArticle", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }
    
    /**
     * Gets all articles
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	suspend fun getArticlesTest(fileName: String) {
		if (TestUtils.skipEndpoint(fileName, "getArticles")) {
			assert(true)
			println("Endpoint getArticles skipped")
			return
		}
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "getArticles")

        val response = api.getArticles()

        val testFileName = "ArticleApi.getArticles"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<ArticleDto>? != null) {
                if ("kotlin.collections.List<ArticleDto>".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<ArticleDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("getArticles", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }
    
    /**
     * Modifies an article
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @ParameterizedTest
    @MethodSource("fileNames") // six numbers
	suspend fun modifyArticleTest(fileName: String) {
		if (TestUtils.skipEndpoint(fileName, "modifyArticle")) {
			assert(true)
			println("Endpoint modifyArticle skipped")
			return
		}
        val credentialsFile = TestUtils.getCredentialsFile(fileName, "modifyArticle")
        val articleDto: ArticleDto = TestUtils.getParameter(fileName, "modifyArticle.articleDto")!!
		if (articleDto as? Collection<*> == null) {
			articleDto.also {
            if (TestUtils.isAutoRev(fileName, "modifyArticle") && it != null) {
                val id = it::class.memberProperties.first { it.name == "id" }
                val currentRev = api.getArticle(id.getter.call(it) as String).rev
                val rev = ArticleDto::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                rev.setter.call(it, currentRev)
                }
			}
		} else {
			val paramAsCollection = articleDto as? Collection<ArticleDto> ?: emptyList<ArticleDto>() as Collection<ArticleDto>
			paramAsCollection.forEach {
                if (TestUtils.isAutoRev(fileName, "modifyArticle") && it != null) {
                    val id = it::class.memberProperties.first { it.name == "id" }

                    val currentRev = api.getArticle(id.getter.call(it) as String).rev
                    val rev = it::class.memberProperties.filterIsInstance<KMutableProperty<*>>().first { it.name == "rev" }
                    rev.setter.call(it, currentRev)
                }
			}
		}

        val response = api.modifyArticle(articleDto)

        val testFileName = "ArticleApi.modifyArticle"
        val file = File(workingFolder + File.separator + this::class.simpleName + File.separator + fileName, "$testFileName.json")
        try {
            val objectFromFile = objectMapper.readValue(file,  if (response as? kotlin.collections.List<ArticleDto>? != null) {
                if ("ArticleDto".contains("String>")) {
                    object : TypeReference<List<String>>() {}
                } else {
                    object : TypeReference<List<ArticleDto>>() {}
                }
            } else if(response as? kotlin.collections.Map<String, String>? != null){
                object : TypeReference<Map<String,String>>() {}
            } else {
            object : TypeReference<Void>() {}
            })
            assertAreEquals("modifyArticle", objectFromFile, response)
			println("Comparison successful")
        } catch (e:FileNotFoundException) {
            file.parentFile.mkdirs()
            file.createNewFile()
            objectMapper.writeValue(file, response)
			assert(true)
			println("File written")
        }
    }
    


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
            assertEquals(response, objectFromFile)
        } else {
            if (functionName.startsWith("create") || functionName.startsWith("modify")) {
                assertThat(objectFromFile as Any).isEqualToIgnoringGivenProperties(response, *(response::class.memberProperties.filter { it.name == "rev" || it.name == "id" || it.name == "created"  || it.name == "modified" }.mapNotNull { it as? KProperty1<Any, Any> }.toTypedArray()))
            } else {
                assertEquals(objectFromFile, response)
            }
        }
    }

}
