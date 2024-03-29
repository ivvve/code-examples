import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.spring") version "1.5.20"
}

group = "com.tistory.devs0n"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2020.0.3"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("javax.xml.bind:jaxb-api")

    // Web
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // DB
    runtimeOnly("mysql:mysql-connector-java")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    // Security
//    implementation("org.springframework.security:spring-security-crypto")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    // Cloud
//    implementation("org.springframework.cloud:spring-cloud-starter-config")
//    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
//    implementation("org.springframework.cloud:spring-cloud-starter-bus-amqp")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("org.springframework.cloud:spring-cloud-starter-zipkin:2.2.8.RELEASE")
    implementation("io.micrometer:micrometer-registry-prometheus")

    // Monitor
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Dev
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
