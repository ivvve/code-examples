plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":common-utils"))

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("com.h2database:h2")
}

tasks {
    withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        enabled = false
    }

    withType<Jar> {
        enabled = true
    }
}
