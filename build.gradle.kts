@file:Suppress("DEPRECATION")

plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.qameta.allure") version "2.10.0"
}

allure {
	version.set("2.10.0")
	autoconfigure = true
	report.reportDir.set(file("report"))
	aspectjweaver = true
}


group = "com.EvertecTest"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17


repositories {
	mavenCentral()
}
springBoot {
	mainClass.set("com.EvertecTest.runner.Runner")
}
dependencies {

	implementation("com.github.javafaker:javafaker:1.0.2")
	testImplementation("junit:junit:4.13.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
	testImplementation("io.rest-assured:rest-assured:5.3.1")
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

tasks.test {
	useJUnit()
	finalizedBy("allureReport")
}

tasks.withType<Test> {
	delete(file("report/allureReport"))
	testLogging {
		events("passed", "skipped", "failed")
		showExceptions = true
		showCauses = true
		showStackTraces = true
		showStandardStreams = true
	}
 }

configurations.implementation {
	exclude("org.springframework.boot", "spring-boot-starter-logging")
}