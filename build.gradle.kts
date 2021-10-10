plugins {
    java
}

group = "xyz.mrsherobrine"
version = "1.0"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "xyz.mrsherobrine.naml.Scan"
    }
}
