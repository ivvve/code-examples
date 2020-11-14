plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":common-utils"))

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
}
