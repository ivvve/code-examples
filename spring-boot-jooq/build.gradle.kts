import nu.studer.gradle.jooq.JooqEdition
import org.testcontainers.containers.MySQLContainer

plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.flywaydb.flyway") version "11.0.0"
    id("nu.studer.jooq") version "9.0"
}

group = "com.tistory.devs0n"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    jooqGenerator("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.3.0")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mysql")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

buildscript {
    dependencies {
        classpath("org.flywaydb:flyway-mysql:10.20.1") // for flyway task
        classpath("org.testcontainers:mysql:1.20.4")
        classpath("com.mysql:mysql-connector-j:9.1.0")
    }
}

jooq {
    version.set("3.19.15") // Match your jOOQ version
    edition.set(JooqEdition.OSS)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false) // Disable auto compilation
            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = "com.mysql.cj.jdbc.Driver"
//                    url = mySqlContainer.jdbcUrl // set in generateJooq task
//                    user = mySqlContainer.username // set in generateJooq task
//                    password = mySqlContainer.password // set in generateJooq task
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator" // Generate Kotlin code
                    database.apply {
                        name = "org.jooq.meta.mysql.MySQLDatabase"
//                        inputSchema = mySqlContainer.databaseName // set in generateJooq task
                        excludes = "flyway_schema_history"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "com.tistory.devs0n.jooq.models"
                        directory = "build/generated-src/jooq/main"
                    }
                }
            }
        }
    }
}
tasks.named("generateJooq") {
    lateinit var mySqlContainer: MySQLContainer<Nothing>

    doFirst {
        mySqlContainer = MySQLContainer<Nothing>("mysql:8.0").apply {
            withDatabaseName("playground")
            withUsername("root")
            withPassword("root")
            withEnv("TZ", "Asia/Seoul")
            withCommand("mysqld", "--character-set-server=utf8mb4")
            withReuse(false)
            start()
        }

        flyway.url = mySqlContainer.jdbcUrl
        flyway.user = mySqlContainer.username
        flyway.password = mySqlContainer.password
//        flyway.locations = arrayOf("classpath:db/migration") // <- cannot find the path
        flyway.locations = arrayOf("filesystem:src/main/resources/db/migration")

        val fm = tasks.named("flywayMigrate").get()
        fm.actions.forEach { it.execute(fm) }

        jooq.configurations["main"].jooqConfiguration.apply {
            jdbc.url = mySqlContainer.jdbcUrl
            jdbc.user = mySqlContainer.username
            jdbc.password = mySqlContainer.password

            generator.database.inputSchema = mySqlContainer.databaseName
        }
    }

    doLast {
        mySqlContainer.stop()
    }
}
