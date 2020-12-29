plugins {
    java
    id("com.adarshr.test-logger") version "2.1.1"
}

group = "com.apple"
version = "1.0-SNAPSHOT"

val junitVersion = "5.7.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.glazedlists:glazedlists:1.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.compileJava {
    options.release.set(11)
}
tasks.named<Test>("test") {
    useJUnitPlatform()
}


