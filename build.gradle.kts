plugins {
    id("java")
    alias(libs.plugins.springBoot) apply false
    alias(libs.plugins.springDependencyManagement) apply true
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies

allprojects {
    repositories {
        mavenCentral()
    }

}


subprojects {
    apply(plugin = "java")

    /*    java {
        sourceCompatibility = JavaVersion.toVersion(17)
        targetCompatibility = JavaVersion.toVersion(17)
    }*/

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}
