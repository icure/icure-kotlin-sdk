val kotlinVersion = "1.4.21"
val kotlinCoroutinesVersion = "1.4.2"

plugins {
    kotlin("jvm") version "1.4.21"
}

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
    plugins {
        `maven-publish`
        id("org.openapi.generator") version "5.2.0"
    }
}

apply(plugin = "git-version")
apply(plugin = "maven-publish")
val gitVersion: String? by project

group = "io.icure"
version = gitVersion ?: "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.taktik.be/content/groups/public")
    }
}

dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib", version = kotlinVersion)
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = kotlinCoroutinesVersion)
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-reactor", version = kotlinCoroutinesVersion)
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.11.3")
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.11.3")
    implementation(group = "io.icure", name = "async-jackson-http-client", version = "bc6844fb0b")
    implementation(group = "javax.inject", name = "javax.inject", version = "1")

    testImplementation("io.kotlintest", "kotlintest", "2.0.7")
    testImplementation("junit", "junit", "4.12")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
}

tasks.publish {
    dependsOn("build")
    mustRunAfter("build")
    doFirst {
        println("Artifact >>> ${project.group}:${project.name}:${project.version} <<< published to Maven repository")
    }
}

tasks.build {
    dependsOn("openApiGenerate")
    mustRunAfter("apply-custom-fixes")
}

tasks.openApiGenerate {
    apiPackage.set("io.icure.kraken.client.apis")
    modelPackage.set("io.icure.kraken.client.models")
    packageName.set("io.icure.kraken.client")
    groupId.set("io.icure")
    id.set(rootProject.name)
    version.set("0.0.1-SNAPSHOT")
    additionalProperties.put("useCoroutines", true)
    additionalProperties.put("serializationLibrary", "jackson")
    generatorName.set("kotlin")
    templateDir.set("$rootDir/openApiTemplates")
    inputSpec.set("${rootDir}/icure-openapi-spec.json")
    outputDir.set("$rootDir")
    dependsOn.add("download-openapi-spec") // required due to https://github.com/OpenAPITools/openapi-generator/issues/8255

    finalizedBy( "apply-custom-fixes") // "contract" is not in reserved words list
}

tasks.register("download-openapi-spec") {
    doLast {
        val destFile = File("${rootDir}/icure-openapi-spec.json")
        val url = "https://kraken.icure.dev/v3/api-docs"
        ant.invokeMethod("get", mapOf("src" to url, "dest" to destFile))
    }
}

tasks.register("apply-custom-fixes") {
    doLast {
        // contract is a kotlin keyword => escape it with ``
        ant.withGroovyBuilder {
            "replaceregexp"("match" to "contract\\(", "replace" to "`contract`(", "flags" to "g", "byline" to "true") {
                "fileset"(
                    "dir" to File("${rootDir}/src/main/kotlin/io/icure/kraken/client/models"),
                    "includes" to "PatientDto.kt"
                )
            }
        }
    }
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project
publishing {
    publications {
        create<MavenPublication>(rootProject.name) {
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
