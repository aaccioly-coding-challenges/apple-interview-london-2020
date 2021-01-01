plugins {
    java
    id("com.adarshr.test-logger") version "2.1.1"
    id("me.champeau.gradle.jmh") version "0.5.2"
}

group = "com.apple"
version = "1.0-SNAPSHOT"

val junitVersion = "5.7.0"
val jmhVersion = "1.26"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.glazedlists:glazedlists:1.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    jmh("org.openjdk.jmh:jmh-core:${jmhVersion}")
    jmh("org.openjdk.jmh:jmh-generator-annprocess:${jmhVersion}")
    jmh("ch.qos.logback:logback-classic:1.2.3")
}

tasks.compileJava {
    options.release.set(11)
}
tasks.named<Test>("test") {
    useJUnitPlatform()
}


