plugins {
    id("java")
    alias(libs.plugins.springDependencyManagement)
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${libs.versions.springBoot.get()}")
    }
}

dependencies {
    implementation(project(":business"))

    implementation(libs.springDataJpa)
    implementation(libs.hibernateCore)
    implementation(libs.h2)
    implementation(libs.jakartaPersistenceApi)
    // Lombok dependencies removed
}
