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

    implementation(libs.springWeb)
    implementation(libs.springContext)
    implementation(libs.springdocOpenapiStarterWebmvcUi)
    // Lombok dependencies removed

    testImplementation(libs.junitJupiter)
    testImplementation(libs.mockitoCore)
    testImplementation(libs.mockitoJupiter)
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}
