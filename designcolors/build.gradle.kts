import org.jreleaser.model.Active
import org.jreleaser.model.Changelog
import org.jreleaser.model.Stereotype
import java.net.URI

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jreleaser)
    alias(libs.plugins.jetbrains.dokka)
    id("signing")
    id("maven-publish")
}

val groupID = "io.github.iodevblue"
val moduleID = "designcolors"
val previousVersion = "1.1.2"
val releaseVersion = "1.2.0-SNAPSHOT"
val releaseTitle = "Design Colors"
val releaseTitleNoSpaces = releaseTitle.replace(" ", "")

group = groupID
version = releaseVersion

android {
    namespace = "io.github.iodevblue.api.android.designcolors"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
        testOptions.targetSdk = 36
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    packaging {
        resources {
            excludes += "META-INF/DEPENDENCIES"
        }
    }
    publishing {
        singleVariant("release")
    }
}

jreleaser {
    gitRootSearch.set(true)
    deploy {
        setActive("NEVER")
        maven {
            mavenCentral {
                create("sonatype") {
                    setActive("RELEASE")
                    stagingRepository("build/staging-deploy")
                    url = "https://central.sonatype.com/api/v1/publisher"
                    snapshotSupported = true
                    sign = true
                    checksums = false
                    sourceJar = true
                    javadocJar = true
                    verifyPom = true
                    applyMavenCentralRules = true
                    connectTimeout = 20
                    readTimeout = 60
                    verifyUrl = "https://repo1.maven.org/maven2/io/github/iodevblue/designcolors/maven-metadata.xml"
                    namespace = "io.github.iodevblue.api.android.designcolors"
                    retryDelay = 20
                    maxRetries = 100
                }

            }
            nexus2 {
                create("snapshots") {
//                    setActive("NEVER")
                    setActive("SNAPSHOT")
                    setAuthorization("BASIC")
                    snapshotUrl = "https://central.sonatype.com/repository/maven-snapshots/"
                    applyMavenCentralRules = true
                    snapshotSupported = true
                    closeRepository = true
                    // We recommend setting releaseRepository to false for the first time.
                    // This lets you review staged artifacts in the Sonatype UI. Y
                    // you’ll have to perform a manual release on the UI.
                    // Once you’re happy with the settings and the release is successful you may switch this property to true.
                    releaseRepository = false
                    stagingRepository("build/staging-deploy")
                }
            }
        }
    }
    distributions {
        create("release") {
            tag(releaseVersion)
            artifact {
                // Run the bundleReleaseAar to generate the below file.
                setPath("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/${releaseTitleNoSpaces}_v${releaseVersion}.aar")
            }
//            artifact {
//                // Run the androidExportProjectZip to generate the below file.
//                setPath("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/${releaseTitleNoSpaces}_v${releaseVersion}.zip")
//            }
        }
    }
//    files {
//////         //This is where you can attach APK files along with the JAR files.
//        setActive("ALWAYS")
//        artifact {
//            // Run the bundleReleaseAar to generate the below file.
//            setPath("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/${releaseTitleNoSpaces}_v${releaseVersion}.aar")
//        }
//        artifact {
//            // Run the androidExportProjectZip to generate the below file.
//            setPath("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/${releaseTitleNoSpaces}_v${releaseVersion}.zip")
//        }
//    }
    project {
       name = releaseTitle
        version = releaseVersion
        versionPattern = "SEMVER"
        description = "A Kotlin library for predefined color palettes from popular design systems and brands."
        longDescription = "A Kotlin color library providing a singleton with predefined color palettes from major design systems like Material Design, Apple HIG, Atlassian, Bootstrap, and Fluent UI, along with a curated set of official brand colors. It includes helper methods for dynamic color selection."
        authors = listOf(
            "IO DevBlue"
        )
        license = "Apache-2.0"
         copyright = "2022-2025 IO DevBlue"
        stereotype = Stereotype.MOBILE
        vendor = "IO DevBlue"
        maintainer("IO DevBlue")
        tag(releaseVersion)
        links {
            homepage = "https://github.com/IODevBlue/DesignColors"
            license = "https://www.apache.org/licenses/LICENSE-2.0"
            contact = "https://github.com/IODevBlue"
            version = releaseVersion
            bugTracker = "https://github.com/IODevBlue/DesignColors/issues"
            documentation = "https://github.com/IODevBlue/DesignColors/blob/main/README.md"
            vcsBrowser =  "https://github.com/IODevBlue/DesignColors"
        }
    }
    release {
        github {
            enabled = true
            connectTimeout = 20
            readTimeout = 60
            repoOwner = "IO DevBlue"
            repoUrl = "https://github.com/IODevBlue/DesignColors"
            changelog {
                enabled = true
                sort = Changelog.Sort.DESC
                preset = "gitmoji"
                formatted = Active.ALWAYS
                format = "- {{commitShortHash}} {{commitTitle}}"
                categoryTitleFormat = "### {{categoryTitle}}"
                contributorsTitleFormat = "### Contributors"
                content = "#Changelog\n\n{{changelogChanges}}\n{{changelogContributors}}"
                previousTagName = previousVersion
                contributors {
                    enabled = true
                    format = "- {{contributorName}} ({{contributorUsernameAsLink}})"
                }

                hide {
                    uncategorized = true
                    categories = setOf(
                        "merge"
                    )
                    contributors = setOf(
                        "[bot]"
                    )
                }

                includeLabels = setOf(
                    "issue"
                )

                excludeLabels = setOf(
                    "issue"
                )

                labeler {
                    label = "issue"
                    title = "regex:fix:"
                    body = "Fixes #"
                    contributor = "GitHub"
                    order = 1
                }
                category {
                    title = "🛠 Build"
                    key = "build"
                    labels = setOf("build", "deps", "ci")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 10
                }

                category {
                    title = "🐛 Bug Fixes"
                    key = "fixes"
                    labels = setOf("fix", "hotfix", "bug", "security")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 20
                }

                category {
                    title = "🚀 Features"
                    key = "features"
                    labels = setOf("feat", "breaking")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 30
                }

                category {
                    title = "🔄 Changes"
                    key = "changes"
                    labels = setOf("perf", "refactor", "revert", "style", "ref")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 40
                }

                category {
                    title = "🧪 Tests"
                    key = "tests"
                    labels = setOf("test")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 50
                }

                category {
                    title = "🧰 Tasks"
                    key = "chores"
                    labels = setOf("chore", "wip, task, tasks")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 60
                }

                category {
                    title = "📝 Documentation"
                    key = "docs"
                    labels = setOf("docs")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 70
                }

                category {
                    title = "🔀 Merge"
                    key = "merge"
                    labels = setOf("merge")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 0
                }
                category {
                    title = "⚠️ Deprecations"
                    key = "deprecations"
                    labels = setOf("deprecate", "deprecated")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 25
                }

            }

            commitAuthor {
                name = "IO DevBlue"
                email = "iodevblue@gmail.com"
            }
            tagName.set(releaseVersion)
//            tagName.set("v1.2.0")
            overwrite = true
            update {
                enabled = true
            }
            checksums = false
            signatures = false

            releaseName = "v$releaseVersion"
            prerelease {
                enabled = false
            }
            draft = false
//            tagName = releaseVersion

        }
    }
    signing {
        setActive("ALWAYS")
        armored = true
    }

}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = groupID
                artifactId = moduleID
                version = releaseVersion
                from(components["release"])
                artifact(androidJavadocJar)
                artifact(androidSourcesJar)
                artifact(androidJar)
                pom {
                    name.set(rootProject.name)
                    description.set("A Kotlin library for predefined color palettes from popular design systems and brands.")
                    url.set("https://github.com/IODevBlue/DesignColors.git")
                    packaging = "jar"

                    licenses {
                        license {
                            name.set("Apache License Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }

                    developers {
                        developer {
                            id.set("iodevblue")
                            name.set("IO DevBlue")
                            email.set("iodevblue@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:git://github.com/IODevBlue/DesignColors.git")
                        developerConnection.set("scm:git:ssh://github.com/IODevBlue/DesignColors.git")
                        url.set("https://github.com/IODevBlue/DesignColors")
                    }
                }

            }

        }

        repositories {
            maven {
                url = uri(layout.buildDirectory.dir("staging-deploy").get().asFile)

            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        project.findProperty("signing.key") as String?,   // full private key block
        project.findProperty("signing.password") as String?  // password
    )
    sign(publishing.publications)
}

tasks.register("printSigningProperties") {
    doLast {
        println("signing.key: " + (project.findProperty("signing.key") != null))
        println("signing.password: " + (project.findProperty("signing.password") != null))
        println("signing.keyId: " + project.findProperty("signing.keyId"))
    }
}

kotlin {
    jvmToolchain(21)
}

configurations.all {
    resolutionStrategy {
        force(libs.guava)
    }
}

tasks.named("jreleaserFullRelease") {
    dependsOn(androidAar)
    dependsOn(androidExportProjectZip)
}

tasks.named("jreleaserAutoConfigRelease") {
    dependsOn(androidAar)
    dependsOn(androidExportProjectZip)
}

tasks.named("jreleaserRelease") {
    dependsOn(":$moduleID:publish")
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
    moduleName.set(rootProject.name)
    moduleVersion.set(project.version.toString())
    outputDirectory.set(layout.buildDirectory.dir("dokka/$name"))
    failOnWarning.set(true)
    suppressObviousFunctions.set(true)
    suppressInheritedMembers.set(true)
    offlineMode.set(true)
    dokkaSourceSets.configureEach {
        includes.from("module.md")
        if (name != "main") suppress.set(true)

        displayName.set(name)
//        reportUndocumented.set(false)
//        skipEmptyPackages.set(true)
//        skipDeprecated.set(false)
//        suppressGeneratedFiles.set(true)
//        jdkVersion.set(8)
//        languageVersion.set("1.7")
//        apiVersion.set("1.7")
//        noStdlibLink.set(false)
//        noJdkLink.set(false)
//        noAndroidSdkLink.set(false)
//        platform.set(org.jetbrains.dokka.Platform.jvm)
        sourceRoots.from(file("src"))
        classpath.from(project.files())
        samples.from(project.files())

        sourceLink {
            localDirectory.set(file("src/main/kotlin")) // or "src/main/kotlin" if Kotlin
            remoteUrl.set(URI("https://github.com/IODevBlue/DesignColors/tree/main/designcolors/src/main/kotlin").toURL())
            remoteLineSuffix.set("#L")

        }
        externalDocumentationLink {
            url.set(URI("https://developer.android.com/reference/").toURL())
        }
        externalDocumentationLink {
            url.set(URI("https://kotlinlang.org/api/latest/jvm/stdlib/").toURL())
        }
    }
}

val dokkaJavadocJar by tasks.registering(org.jetbrains.dokka.gradle.DokkaTaskPartial::class) {
    moduleName.set(rootProject.name)
    suppressInheritedMembers.set(true)
    offlineMode.set(true)

    outputDirectory.set(layout.buildDirectory.dir("dokka/javadoc"))

    dokkaSourceSets.configureEach {
        includes.from("module.md")
        sourceRoots.from(file("src/main/java"))
        sourceRoots.from(file("src/main/kotlin"))
    }
}

val androidSourcesJar by tasks.register<Jar>("androidSourcesJar") {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").kotlin.directories.map { file(it) })
    doLast {
        copy {
            from(archiveFile)
            rename { "${releaseTitleNoSpaces}_v${releaseVersion}-sources.jar" }
            into("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}")
        }
    }
}

val androidJavadocJar by tasks.register<Jar>("androidJavadocJar") {
    dependsOn(dokkaJavadocJar)
    archiveClassifier.set("javadoc")
    from(dokkaJavadocJar.flatMap { it.outputDirectory })
    doLast {
        copy {
            from(archiveFile)
            rename { "${releaseTitleNoSpaces}_v${releaseVersion}-javadoc.jar" }
            into("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}")
        }
    }
}

val androidJar by tasks.register<Jar>("androidJar") {
    val path = "build/intermediates/full_jar/release/createFullJarRelease/full.jar"
    val file = rootProject.project(moduleID).file(path)

    dependsOn("createFullJarRelease") // make sure the jar is built first

    doFirst {
        if (!file.exists()) {
            throw GradleException("ERROR: ${moduleID}:- Run the createFullJarRelease task first to create the jar file.")
        }
        from(zipTree(file))
    }

    archiveFileName.set("${moduleID}.jar")

    doLast {
        copy {
            from(archiveFile)
            rename { "${releaseTitleNoSpaces}_v${releaseVersion}.jar" }
            into("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}")
        }
    }
}

val androidAar by tasks.register<Jar>("androidAar") {
    val path = "build/outputs/aar/${moduleID}-release.aar"
    val file = rootProject.project(moduleID).file(path)

    // Make sure the bundleReleaseAar task runs first
    dependsOn("bundleReleaseAar")

    doFirst {
        if (!file.exists()) {
            throw GradleException("ERROR: ${moduleID}:- Run the bundleReleaseAar task first to create the AAR file.")
        }
        from(zipTree(file))
    }

    archiveFileName.set("${moduleID}.aar")

    doLast {
        copy {
            from(archiveFile)
            rename { "${releaseTitleNoSpaces}_v${releaseVersion}.aar" }
            into("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}")
        }
    }
}

val androidExportProjectZip by tasks.register<Zip>("androidExportProjectZip") {
    // Name and destination
    archiveFileName.set("${releaseTitleNoSpaces}_v${releaseVersion}.zip")
    val outputDir = "${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}"
    destinationDirectory.set(file(outputDir))

    // Include only essential project files
    from(rootProject.projectDir) {
        // Include the module folder
        include("${moduleID}/**")
        include("art/**")
        // Include Gradle scripts
        include("build.gradle")
        include("build.gradle.kts")
        include("settings.gradle")
        include("settings.gradle.kts")
        include("gradle/**")
        include("gradlew")
        include("gradlew.bat")
        // Include any top-level docs or important files
        include("README.md")
        include("CONTRIBUTING.md")
        include("LICENSE")
        include("**/.gitignore")
        include("gradle.properties")
        include()

        // Exclude unnecessary folders
        exclude("**/build/**")
        exclude("**/.gradle/**")
        exclude("**/.idea/**")
        exclude("**/*.iml")
        exclude("**/out/**")
        exclude("**/.DS_Store")
        exclude("**/*.log")
        exclude("local.properties")
        exclude("jreleaser-schema-1.20.0.json")
        exclude("/.kotlin")
        exclude(".project")
        exclude("/artefacts")
        exclude()

    }

    // Skip duplicates to avoid warnings
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // Logging
    doFirst {
        println("Creating zip for project ${moduleID}...")
    }

    doLast {
        println("Project zip created at $outputDir/${archiveFileName.get()}")
    }
}

tasks.register<Copy>("copyHtmlDoc") {
    dependsOn(tasks.named("dokkaHtml"))
    from(provider { tasks.named("dokkaHtml").get().outputs.files })
    into("/Users/iodevblue/Documents/Github-Projects/project-docs/api/android/$moduleID/html")
}

tasks.register<Copy>("copyJavadoc") {
    dependsOn(tasks.named("dokkaJavadoc"))
    from(provider { tasks.named("dokkaJavadoc").get().outputs.files })
    into("/Users/iodevblue/Documents/Github-Projects/project-docs/api/android/$moduleID/javadoc")
}

configurations.all {
    resolutionStrategy {
        // Use Guava Android variant
        force("com.google.guava:guava:32.1.0-android")
        // Keep listenablefuture version consistent for AndroidX
        force("com.google.guava:listenablefuture:1.0")
    }
}
dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
//    implementation(libs.central.publishing.maven.plugin)
    implementation(libs.compose.ui)
}
