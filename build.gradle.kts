plugins {
    id("java")
}

group = "com.itstor.keycloak-conditional-clientid"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.keycloak:keycloak-services:24.0.1")
    implementation("org.keycloak:keycloak-server-spi:24.0.1")
    implementation("org.keycloak:keycloak-server-spi-private:24.0.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}