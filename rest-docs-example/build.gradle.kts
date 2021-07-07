import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
//	id("org.asciidoctor.convert") version "1.5.8"
	id("org.asciidoctor.jvm.convert") version "3.3.2" // <- See https://github.com/asciidoctor/asciidoctor-gradle-plugin/issues/600
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.spring") version "1.5.20"
}

group = "com.tistory.devs0n"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-restassured")
	testImplementation("io.rest-assured:rest-assured")
}

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	withType<Test> {
		useJUnitPlatform()
		outputs.dir(snippetsDir)
	}

	asciidoctor {
		inputs.dir(snippetsDir)
		dependsOn(test)
	}

    register<Test>("testDocument") {
    	useJUnitPlatform()
		filter {
			includeTestsMatching("*.documentation.*")
		}
	}

	register<Copy>("copyDocument") {
	    dependsOn("testDocument")

		from("build/docs/asciidoc")
		into("src/main/resources/static/docs")
	}
}
