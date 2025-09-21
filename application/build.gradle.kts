plugins {
    id("java")
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDependencyManagement)
}

dependencies {
    implementation(project(":business"))
    implementation(project(":entrypoint"))
    implementation(project(":repository"))
    implementation(project(":gateway"))

    implementation(libs.springBootStarter)
    implementation(libs.springBootStarterWeb)
    implementation(libs.springBootStarterActuator)
    implementation(libs.springBootStarterDataJpa)
    implementation(libs.h2)

    testImplementation(libs.springBootStarterTest)
}
