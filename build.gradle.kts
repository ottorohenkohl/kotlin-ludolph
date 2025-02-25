import org.jetbrains.kotlin.gradle.dsl.JvmTarget

group = "dev.rohenkohl"
version = "1.0"

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.allopen") version "2.0.21"
    kotlin("plugin.noarg") version "2.1.0"

    id("io.quarkus") version "3.17.2"
}

apply {
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.plugin.allopen")
    plugin("org.jetbrains.kotlin.plugin.noarg")

    plugin("io.quarkus")
}

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:3.17.2"))

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    implementation("io.quarkiverse.discord4j:quarkus-discord4j:0.0.1")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-container-image-docker")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-rest-client")
    implementation("io.quarkus:quarkus-rest-client-jackson")
    implementation("io.quarkus:quarkus-rest-kotlin-serialization")
    implementation("io.quarkus:quarkus-scheduler")
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

allOpen {
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("jakarta.interceptor.Interceptor")
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.ws.rs.Path")
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}