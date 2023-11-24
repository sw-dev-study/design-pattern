plugins {
    id("java")
}

group = "edu.design.pattern"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.realityforge.org.jetbrains.annotations:org.jetbrains.annotations:1.7.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}