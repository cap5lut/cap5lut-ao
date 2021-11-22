plugins {
    `java-library`
}

group = "net.cap5lut"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-all:4.1.70.Final")
    implementation("org.apache.logging.log4j:log4j-api:2.14.1")

    runtimeOnly("org.apache.logging.log4j:log4j-core:2.14.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}