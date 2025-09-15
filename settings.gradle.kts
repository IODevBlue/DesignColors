pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.google.com")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "Design Colors"
include(":designcolors")
