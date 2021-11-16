plugins {
    kotlin("jvm") version "1.5.10"
    java
}

group = "com.tistory.devs0n"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.vladimir-bukhtoyarov:bucket4j-core:6.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.6.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
