plugins {
    id("com.gradle.plugin-publish") version "1.1.0"
    `java-gradle-plugin`
    `java-library`
}

group = "io.github.simulatan"
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
    website.set("https://github.com/SIMULATAN/gradle-reflections-plugin")
    vcsUrl.set("https://github.com/SIMULATAN/gradle-reflections-plugin.git")
    plugins {
        create("reflectionsPlugin") {
            id = "io.github.simulatan.gradle-reflections-plugin"
            displayName = "Reflections Plugin"
            description = "Bakes in reflection results at compile time"
            tags.set(listOf("reflections"))
            implementationClass = "com.github.simulatan.gradle.plugin.reflections.ReflectionsPlugin"
        }
    }
}
