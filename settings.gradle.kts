pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
                includeGroup("com.google.dagger")
            }
        }
        maven {
            url = uri("https://www.zetetic.net/maven")
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://www.zetetic.net/maven")
        }
    }
}

rootProject.name = "PasswordManager"
include(":app")
include(":data")
include(":domain")
include(":presentation:component")
include(":presentation:view")
include(":presentation:style")
