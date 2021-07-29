plugins {
    kotlin("jvm") version "1.5.10"
    id("org.openapi.generator") version "5.2.0"
    `maven-publish`
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

buildscript {
    repositories {
      mavenCentral()
    maven {
        credentials {
            username = extra["repoUsername"].toString()
            password = extra["repoPassword"].toString()
        }
        url = uri(extra["mavenRepository"].toString())
    }
    }
    dependencies {
        classpath("com.taktik.gradle:gradle-plugin-git-version:1.0.13")
    }
}

apply(plugin = "git-version")
val gitVersion: String? by project
group = "io.icure"
version = gitVersion ?: "0.0.1-SNAPSHOT"

apply(plugin = "maven-publish")

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.taktik.be/content/repositories/snapshots")
    }
}

dependencies {
    implementation("com.squareup.moshi", "moshi-kotlin", "1.12.0")
    implementation("com.squareup.moshi", "moshi-adapters", "1.12.0")
    implementation("com.squareup.okhttp3", "okhttp", "4.9.1")

    testImplementation("io.kotlintest", "kotlintest", "2.0.7")
    testImplementation("junit", "junit", "4.12")
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<PublishToMavenRepository> {
    doFirst {
        println("Artifact >>> ${project.group}:${project.name}:${project.version} <<< published to Maven repository")
    }
}

tasks.build{
    dependsOn("openApiGenerate")
    mustRunAfter("apply-custom-fixes")
}

tasks.openApiGenerate {
    apiPackage.set("io.icure.kraken.client.apis")
    modelPackage.set("io.icure.kraken.client.models")
    packageName.set("io.icure.kraken.client")
    groupId.set("io.icure")
    id.set("kraken-kotlin-client")
    version.set("0.0.1-SNAPSHOT")


    generatorName.set("kotlin")
    inputSpec.set("${buildDir}/icure-openapi-spec.json")
    outputDir.set("$rootDir")
    dependsOn.add("download-openapi-spec") // required due to https://github.com/OpenAPITools/openapi-generator/issues/8255
    finalizedBy("delete-generated-buildgradle", "apply-custom-fixes")
}


tasks.register("download-openapi-spec") {
    doLast {
        val destFile = File("${buildDir}/icure-openapi-spec.json")
        val url = "https://kraken.icure.dev/v3/api-docs"
        ant.invokeMethod("get", mapOf("src" to url, "dest" to destFile))
    }
}

tasks.create<Delete>("delete-generated-buildgradle") {
    delete(File("$rootDir/build.gradle"))
    delete(File("$rootDir/settings.gradle"))
}

tasks.register("apply-custom-fixes") {
    doLast {
        ant.withGroovyBuilder {
            "replaceregexp"(
                "match" to "org.openapitools.client.baseUrl",
                "replace" to "io.icure.kraken.client.baseUrl",
                "flags" to "g",
                "byline" to "true"
            ) {
                "fileset"("dir" to File("${rootDir}/src/main/kotlin/io/icure/kraken/client/apis"), "includes" to "*.kt")
            }
        }
        ant.withGroovyBuilder {
            "replaceregexp"("match" to "contract\\(", "replace" to "`contract`(", "flags" to "g", "byline" to "true") {
                "fileset"(
                    "dir" to File("${rootDir}/src/main/kotlin/io/icure/kraken/client/models"),
                    "includes" to "PatientDto.kt"
                )
            }
        }
        ant.withGroovyBuilder {
            "replaceregexp"(
                "match" to "package io.icure.kraken.client.infrastructure",
                "replace" to "package io.icure.kraken.client.infrastructure \n\n\nimport okhttp3.Credentials\n ",
                "flags" to "g",
                "byline" to "true"
            ) {
                "fileset"(
                    "dir" to File("${rootDir}/src/main/kotlin/io/icure/kraken/client/infrastructure"),
                    "includes" to "ApiClient.kt"
                )
            }
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("kraken-kotlin-client") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "Taktik"
            url = uri(mavenReleasesRepository)
            credentials {
                username = repoUsername
                password = repoPassword
            }
        }
    }
}
