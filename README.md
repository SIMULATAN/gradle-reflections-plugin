# Gradle Reflections Plugin

This plugin uses [Reflections](https://github.com/ronmamo/reflections) to scan and index your project classes
at build-time, allowing run-time querying without the indexing performance hit.


<!-- TOC depthFrom:2 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [History](#history)
- [Usage](#usage)
    - [Gradle](#gradle)
    - [Java](#java)
- [Development](#development)
    - [Quickstart](#quickstart)
    - [Tests](#tests)

<!-- /TOC -->

## History
This plugin is a revival of the [gradle-reflections-plugin](https://github.com/manosbatsis/gradle-reflections-plugin) by [manosbatsis](https://github.com/manosbatsis) - consider this a rewrite / modernization.

I wanted to use the plugin in a project, but it wasn't compatible with reflections 0.10.2, so I forked it and made the necessary changes.
I hope this fork will keep you from debugging for hours to find out the version incompability like I had to.

Most of the codebase is taken from the original plugin, full credit goes to Manos Batsis for that.

Changes I made:
- Update to Gradle 8
- Update to Reflections 0.10.2
- Switch to kotlin dsl
- Rewrite gradle buildscript
- Replace lombok with manual getters and setters

## Usage

The idea is to use the plugin with Gradle to embed a pre-scanned metadata index in your jar,
then utilise the embedded index at runtime using Reflections.collect(). See the Gradle and Java sections below for examples.

### Gradle

<!-- TODO: The plugin is published in [Gradle plugin portal](https://plugins.gradle.org/plugin/io.github.manosbatsis.gradle.plugin.reflections),
so it is rather easy to use. -->
This will add the pre-scanned
metadata index in your jar as `META-INF/reflections/PROJECTNAME-reflections.xml`, with
*PROJECTNAME* substituted by your actual project name.

```gradle
plugins {
	id "com.github.simulatan.gradle-reflections-plugin" version "1.0.0"
}

classes {
    finalizedBy reflections
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.reflections:reflections:0.10.2'
	implementation 'dom4j:dom4j:2.1.4'
}
```

### Java

To utilise the pre-scanned index simply create a Reflections instance as:

```java
// Collect and merge pre-scanned Reflection xml resources
// and merge them into a Reflections instance
Reflections reflections = Reflections.collect();
// use the instance, e.g.
reflections.getSubTypesOf(Foobar.class);
```
