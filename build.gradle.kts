plugins {
    id("com.gradle.plugin-publish") version "1.1.0"
    `java-gradle-plugin`
    `java-library`
}

group = "com.github.simulatan"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.reflections:reflections:0.10.2")
    implementation("dom4j:dom4j:1.6.1")
    implementation("com.google.guava:guava:31.1-jre")
}

gradlePlugin {
    plugins {
        create("reflectionsPlugin") {
            id = "com.github.simulatan.gradle-reflections-plugin"
            implementationClass = "com.github.simulatan.gradle.plugin.reflections.ReflectionsPlugin"
        }
    }
}
