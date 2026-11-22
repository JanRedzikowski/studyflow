
plugins {
    kotlin("jvm") version "2.3.21"
    application
}

group = "ie.setu"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.formdev:flatlaf:3.8")
}

kotlin {
    jvmToolchain(25)
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
}
