import com.github.jk1.license.render.CsvReportRenderer
import com.github.jk1.license.render.ReportRenderer

val reactorNettyVersion = "1.0.35"
val reactorVersion = "3.4.32"

plugins {
    id("com.icure.kotlin-library-conventions")

    alias(sdkLibs.plugins.sonarqube) apply(true)
    alias(coreLibs.plugins.licenceReport) apply(true)
    alias(coreLibs.plugins.ksp) apply(true)
    alias(coreLibs.plugins.mavenRepository) apply(true)
    alias(coreLibs.plugins.gitVersion) apply(true)
}

licenseReport {
    renderers = arrayOf<ReportRenderer>(CsvReportRenderer())
}

sonarqube {
    properties {
        property("sonar.projectKey", "icure-io_icure-kotlin-sdk")
        property("sonar.organization", "icure-io")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

val gitVersion: String? by project

group = "io.icure"
version = gitVersion ?: "0.0.1-SNAPSHOT"

kotlin {
    sourceSets {
        main {
            kotlin.srcDir("build/generated/ksp/main/kotlin")
        }
    }
}

dependencies {
    implementation(coreLibs.kmapKsp)
    ksp(group = "io.icure", name = "kmap", version = coreLibs.versions.kmap.orNull)

    implementation(project(":kraken-core:dto"))
    implementation(project(":kraken-core:domain"))
    implementation(project(":kraken-core:utils"))

    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib", version = coreLibs.versions.kotlin.orNull)

    implementation(coreLibs.kotlinxCoroutinesCore)
    implementation(coreLibs.kotlinxCoroutinesReactor)
    implementation(coreLibs.kotlinxCoroutinesReactive)

    implementation(group = "com.fasterxml.jackson.core", name = "jackson-core", version = coreLibs.versions.jackson.orNull)
    implementation(coreLibs.jacksonDatabind)
    implementation(coreLibs.jacksonKotlin)
    implementation(coreLibs.jacksonJsr310)

    implementation(coreLibs.asyncJacksonHttpClient)
    implementation(coreLibs.mapstruct)
    // implementation(group = "io.icure", name = "mapper-processor", version = "0.1.1-32d45af2a6")


    implementation(group = "javax.inject", name = "javax.inject", version = "1")
    implementation(coreLibs.caffeine)

    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.3")
    implementation(group = "ch.qos.logback", name = "logback-access", version = "1.2.3")

    //Apple Silicon Compatibility
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.72.Final:osx-aarch_64")

    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.12")
    implementation(group = "org.slf4j", name = "jul-to-slf4j", version = "1.7.12")
    implementation(group = "org.slf4j", name = "jcl-over-slf4j", version = "1.7.12")
    implementation(group = "org.slf4j", name = "log4j-over-slf4j", version = "1.7.12")

    implementation(group = "io.projectreactor", name = "reactor-core", version = reactorVersion)
    implementation(group = "io.projectreactor.netty", name = "reactor-netty", version = reactorNettyVersion)

    // Bouncy Castle
    implementation(coreLibs.bouncyCastleBcprov)
    implementation(coreLibs.bouncyCastleBcmail)

    implementation(coreLibs.jsonWebTokenApi)
    implementation(coreLibs.jsonWebTokenImpl)
    implementation(coreLibs.jsonWebTokenJackson)

    testImplementation(group = "io.kotlintest", name = "kotlintest", version = "2.0.7")
    testImplementation(coreLibs.jupiter)
    testImplementation(group = "com.willowtreeapps.assertk", name = "assertk-jvm", version = "0.24")
    testImplementation(coreLibs.kotestAssertionsCore)
    testImplementation(coreLibs.kotestRunnerJunit5)
}

//tasks.getByName("publish") {
//    dependsOn("build")
//}

// tasks.register("apiGenerate", Jar::class) {
//     inputs.files(fileTree("openApiTemplates"), File("${rootDir}/icure-openapi-spec.json"))
//         .withPropertyName("sourceFiles")
//         .withPathSensitivity(PathSensitivity.RELATIVE)
//     doLast {
//         javaexec {
//             main = "-jar"
//             args = listOf(
//                 "${rootDir}/openapi-generator-cli.jar",
//                 "generate",
//                 "-i",
//                 "${rootDir}/icure-openapi-spec.json",
//                 "-g",
//                 "kotlin",
//                 "-o",
//                 "$rootDir",
//
//                 "--model-package",
//                 "io.icure.kraken.client.models",
//                 "--api-package",
//                 "io.icure.kraken.client.apis",
//                 "--package-name",
//                 "io.icure.kraken.client",
//                 "--group-id",
//                 "io.icure",
//                 "--artifact-id",
//                 project.name,
//                 "--artifact-version",
//                 "0.0.1-SNAPSHOT",
//                 "--template-dir",
//                 "$rootDir/openApiTemplates",
//                 "--additional-properties",
//                 "useCoroutines=true,serializationLibrary=jackson"
//             )
//         }
//     }
//     dependsOn.add("download-openapi-spec") // required due to https://github.com/OpenAPITools/openapi-generator/issues/8255
//
//     finalizedBy("apply-custom-fixes", "delete-unused-filter-files", "delete-unused-tests-files")
// }

tasks.register("download-openapi-spec") {
    doLast {
        val destFile = File("${rootDir}/icure-openapi-spec.json")
        val url = "${System.getProperty("API_URL") ?: "https://kraken.icure.dev"}/v3/api-docs/v2"
        ant.invokeMethod("get", mapOf("src" to url, "dest" to destFile))
    }
}

tasks.register("apply-custom-fixes") {
    doLast {

        // Use manually added filter classes instead of the generated ones
        val replaceFilterDtos = mapOf(
            "AbstractFilterDtoInvoice" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.InvoiceDto>",
            "AbstractFilterDtoService" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.ServiceDto>",
            "AbstractFilterDtoPatient" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.PatientDto>",
            "AbstractFilterDtoHealthElement" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.HealthElementDto>",
            "AbstractFilterDtoContact" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.ContactDto>",
            "AbstractFilterDtoCode" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.CodeDto>",
            "AbstractFilterDtoHealthcareParty" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.HealthcarePartyDto>",
            "AbstractFilterDtoUser" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.UserDto>",
            "AbstractFilterDtoDevice" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.DeviceDto>",
            "AbstractFilterDtoMaintenanceTask" to "io.icure.kraken.client.models.filter.AbstractFilterDto<io.icure.kraken.client.models.MaintenanceTaskDto>",
            "FilterChainInvoice" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.InvoiceDto>",
            "FilterChainService" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.ServiceDto>",
            "FilterChainPatient" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.PatientDto>",
            "FilterChainHealthElement" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.HealthElementDto>",
            "FilterChainContact" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.ContactDto>",
            "FilterChainCode" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.CodeDto>",
            "FilterChainHealthcareParty" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.HealthcarePartyDto>",
            "FilterChainUser" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.UserDto>",
            "FilterChainDevice" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.DeviceDto>",
            "FilterChainMaintenanceTask" to "io.icure.kraken.client.models.filter.chain.FilterChain<io.icure.kraken.client.models.MaintenanceTaskDto>",

            "import io.icure.kraken.client.models.AbstractFilterDtoContact" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoCode" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoHealthElement" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoPatient" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoService" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoInvoice" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoHealthcareParty" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoUser" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoDevice" to "",
            "import io.icure.kraken.client.models.AbstractFilterDtoMaintenanceTask" to "",
            "import io.icure.kraken.client.models.FilterChainContact" to "",
            "import io.icure.kraken.client.models.FilterChainCode" to "",
            "import io.icure.kraken.client.models.FilterChainHealthElement" to "",
            "import io.icure.kraken.client.models.FilterChainPatient" to "",
            "import io.icure.kraken.client.models.FilterChainService" to "",
            "import io.icure.kraken.client.models.FilterChainInvoice" to "",
            "import io.icure.kraken.client.models.FilterChainHealthcareParty" to "",
            "import io.icure.kraken.client.models.FilterChainUser" to "",
            "import io.icure.kraken.client.models.FilterChainDevice" to "",
            "import io.icure.kraken.client.models.FilterChainMaintenanceTask" to ""
        )

        // in Folders
        val folders = listOf(
            "${rootDir}/src/main/kotlin/io/icure/kraken/client/apis",
            "${rootDir}/src/main/kotlin/io/icure/kraken/client/models",
            "${rootDir}/src/test/kotlin/io/icure/kraken/client/apis"
        )

        for (folder in folders) {
            for ((match, replace) in replaceFilterDtos) {
                ant.withGroovyBuilder {
                    "replaceregexp"(
                        "match" to "(?<!\\.)$match",
                        "replace" to replace,
                        "flags" to "g",
                        "byline" to "true"
                    ) {
                        "fileset"(
                            "dir" to File(folder),
                            "includes" to "*.kt"
                        )
                    }
                }
            }
        }
    }
}

tasks.create<Delete>("delete-unused-filter-files") {
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoInvoice.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoService.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoPatient.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoHealthElement.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoContact.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoCode.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoHealthcareParty.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoUser.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoDevice.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/AbstractFilterDtoMaintenanceTask.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainInvoice.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainService.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainPatient.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainHealthElement.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainContact.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainCode.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainHealthcareParty.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainUser.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainDevice.kt"))
    delete(File("$rootDir/src/main/kotlin/io/icure/kraken/client/models/FilterChainMaintenanceTask.kt"))
}


tasks.create<Delete>("delete-unused-tests-files") {
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/AnonymousAccessApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/ApplicationsettingsApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/AuthApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/BeefactApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/BekmehrApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/BeresultexportApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/BeresultimportApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/Besamv2ApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/EntityrefApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/TmpApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/IcureApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/MedexApiTest.kt"))
    delete(File("$rootDir/src/test/kotlin/io/icure/kraken/client/apis/PermissionApiTest.kt"))
}

// tasks.jacocoTestReport {
//     reports {
//         xml.isEnabled = true
//     }
// }

tasks.test {
    useJUnitPlatform()

    filter {
        excludeTestsMatching("io.icure.kraken.client.apis.*")
    }
}
