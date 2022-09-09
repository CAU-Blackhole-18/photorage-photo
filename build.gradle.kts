import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
  kotlin("plugin.jpa") version "1.4.32"
  kotlin("plugin.allopen") version "1.4.32"
  kotlin("kapt") version "1.7.10"
}

allOpen {
  annotation("javax.persistence.Entity")
  annotation("javax.persistence.Embeddable")
  annotation("javax.persistence.MappedSuperclass")
}

group = "cauBlackHole"

version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories { mavenCentral() }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.mapstruct:mapstruct:1.5.2.Final")
  implementation("aws.sdk.kotlin:dynamodb:0.16.0")
  implementation("com.github.derjust:spring-data-dynamodb:5.1.0")
  kapt("org.mapstruct:mapstruct-processor:1.5.2.Final")
  runtimeOnly("com.h2database:h2")
  runtimeOnly("org.springframework.boot:spring-boot-devtools")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

kapt { arguments { arg("mapstruct.defaultComponentModel", "spring") } }

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> { useJUnitPlatform() }
