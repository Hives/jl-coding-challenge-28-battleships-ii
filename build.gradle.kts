plugins {
    kotlin("jvm") version "1.3.72"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

val ktor_version = "1.3.2"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.20")
    testImplementation("io.mockk:mockk:1.9.3")
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}