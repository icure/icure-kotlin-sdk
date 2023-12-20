rootProject.name = "icure-reactive-kotlin-client"

pluginManagement {
    includeBuild("./kraken-core/build-logic")

    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://maven.taktik.be/content/groups/public") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://repo.spring.io/plugins-release") }
        maven { url = uri("https://jitpack.io") }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://maven.taktik.be/content/groups/public") }
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://repo.spring.io/plugins-release") }
    }

    versionCatalogs {
        create("coreLibs") {
            from(files("./kraken-core/libs.versions.toml"))
        }
        create("sdkLibs") {
            from(files("./libs.versions.toml"))
        }
    }
}

val sharedDeps = listOf(
    "utils",
    "domain",
    "dto",
    "dao",
    "logic",
    "jwt",
    "mapper",
    "core",
    "service"
)

include(
    sharedDeps.map { ":kraken-core:$it" }
)