val repoUsername: String by project
val repoPassword: String by project

plugins {
    java
    kotlin("jvm") version "1.3.72"
    `maven-publish`
}

group = "org.taktik.icure"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.taktik.be/content/repositories/snapshots")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            credentials {
                username = repoUsername
                password = repoPassword
            }
            url = uri("https://maven.taktik.be/content/repositories/snapshots")
        }
    }
}

dependencies {
    compileOnly("io.swagger.codegen.v3","swagger-codegen-generators", "1.0.19-20201014.080104-2")

    implementation("com.squareup.moshi","moshi-kotlin","1.8.0")
    implementation("com.squareup.moshi","moshi-adapters","1.8.0")
    implementation("com.squareup.okhttp3","okhttp","3.14.2")
    implementation("org.threeten","threetenbp","1.4.0")

    testImplementation("io.kotlintest","kotlintest","2.0.7")

    testImplementation("junit", "junit", "4.12")
}

task("genKraken", JavaExec::class) {
    group = "other"
    main = "io.swagger.codegen.v3.cli.SwaggerCodegen"
    classpath = sourceSets["main"].runtimeClasspath
    args = listOf("generate", "-i", "https://kraken.icure.dev/v3/api-docs","-l","kotlin-client","--additional-properties","classPrefix=Icc","skipPathPrefix=/rest/v1","-o",".")
}
