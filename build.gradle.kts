import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.1.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("jvm") version "1.3.41"
    kotlin("plugin.spring") version "1.3.41"
}

group = "me.jhwang"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "Greenwich.SR2"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.springframework.cloud:spring-cloud-stream")
//    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
//    implementation("org.springframework.kafka:spring-kafka")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")
//    testImplementation("org.springframework.kafka:spring-kafka-test")

    implementation("mysql:mysql-connector-java")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
