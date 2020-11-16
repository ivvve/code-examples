plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
}

tasks {
    withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        enabled = false
    }

    withType<Jar> {
        enabled = true
    }
}
