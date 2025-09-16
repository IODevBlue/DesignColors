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
val previousVersion = "1.2.0"
val releaseVersion = "1.2.1"
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
configurations.all {
    resolutionStrategy {
        force(libs.guava)
        force("com.google.guava:listenablefuture:1.0")
    }
}
kotlin {
    jvmToolchain(21)
}



// PUBLISHING
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                artifactId = moduleID
                groupId = groupID
                version = releaseVersion
                from(components["release"])
                artifact(androidJavadocJar)
                artifact(androidSourcesJar)
                artifact(androidJar)
                pom {
                    name.set(rootProject.name)
                    description.set("A Kotlin library for predefined color palettes from popular design systems and brands.")
                    packaging = "jar"
                    url.set("https://github.com/IODevBlue/DesignColors.git")
                    developers {
                        developer {
                            id.set("iodevblue")
                            name.set("IO DevBlue")
                            email.set("iodevblue@gmail.com")
                        }
                    }
                    licenses {
                        license {
                            name.set("Apache License Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0")
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
jreleaser {
    gitRootSearch.set(true)
    deploy {
        setActive("ALWAYS")
        maven {
            mavenCentral {
                create("sonatype") {
                    setActive("RELEASE")
                    stagingRepository("build/staging-deploy")
                    applyMavenCentralRules = true
                    checksums = false
                    connectTimeout = 20
                    sign = true
                    javadocJar = true
                    readTimeout = 60
                    namespace = "io.github.iodevblue.api.android.designcolors"
                    retryDelay = 20
                    maxRetries = 100
                    sourceJar = true
                    snapshotSupported = true
                    url = "https://central.sonatype.com/api/v1/publisher"
                    verifyPom = true
                    verifyUrl = "https://repo1.maven.org/maven2/io/github/iodevblue/designcolors/maven-metadata.xml"
                }
            }
            nexus2 {
                create("snapshots") {
                    setActive("SNAPSHOT")
                    setAuthorization("BASIC")
                    stagingRepository("build/staging-deploy")
                    applyMavenCentralRules = true
                    closeRepository = true
                    releaseRepository = false
                    snapshotSupported = true
                    snapshotUrl = "https://central.sonatype.com/repository/maven-snapshots/"
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
        }
    }
    files {
        setActive("ALWAYS")
        artifact { }
    }
    project {
        authors = listOf(
            "IO DevBlue"
        )
        name = releaseTitle
        copyright = "2022-2025 IO DevBlue"
        description = "A Kotlin library for predefined color palettes from popular design systems and brands."
        longDescription = "A Kotlin color library providing a singleton with predefined color palettes from major design systems like Material Design, Apple HIG, Atlassian, Bootstrap and Fluent UI, along with a curated set of official brand colors. It includes helper methods for dynamic color selection."
        license = "Apache-2.0"
        stereotype = Stereotype.MOBILE
        vendor = "IO DevBlue"
        version = releaseVersion
        versionPattern = "SEMVER"
        links {
            bugTracker = "https://github.com/IODevBlue/DesignColors/issues"
            contact = "https://github.com/IODevBlue"
            documentation = "https://github.com/IODevBlue/DesignColors/blob/main/README.md"
            homepage = "https://github.com/IODevBlue/DesignColors"
            license = "https://www.apache.org/licenses/LICENSE-2.0"
            vcsBrowser =  "https://github.com/IODevBlue/DesignColors"
            version = releaseVersion
        }
        maintainer("IO DevBlue")
        tag(releaseVersion)
    }
    release {
        github {
            connectTimeout = 20
            checksums = false
            draft = false
            enabled = true
            readTimeout = 60
            releaseName = "v$releaseVersion"
            repoOwner = "IO DevBlue"
            repoUrl = "https://github.com/IODevBlue/DesignColors"
            tagName.set(releaseVersion)
            overwrite = true
            signatures = false
            changelog {
                categoryTitleFormat = "### {{categoryTitle}}"
                contributorsTitleFormat = "### Contributors"
                content = "#Changelog\n\n{{changelogChanges}}\n{{changelogContributors}}"
                enabled = true
                excludeLabels = setOf()
                format = "- {{commitShortHash}} {{commitTitle}}"
                formatted = Active.ALWAYS
                preset = "gitmoji"
                previousTagName = "v$previousVersion"
                sort = Changelog.Sort.DESC
                contributors {
                    enabled = true
                    format = "- {{contributorName}} ({{contributorUsernameAsLink}})"
                }
                hide {
                    categories = setOf(
                        "merge"
                    )
                    contributors = setOf(
                        "[bot]"
                    )
                    uncategorized = true
                }

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
            prerelease {
                enabled = false
            }
            update {
                enabled = true
            }
        }
    }
    signing {
        setActive("ALWAYS")
        armored = true
    }
}
signing {
    sign(publishing.publications)
    useInMemoryPgpKeys(
        project.findProperty("signing.key") as String?,   // full private key block
        project.findProperty("signing.password") as String?  // password
    )
}



// GRADLE TASKS
tasks.named<Delete>("clean") {
    delete("${rootProject.projectDir}/artefacts/")
}
tasks.named<org.jetbrains.dokka.gradle.DokkaTask>("dokkaHtml") {
    outputDirectory.set(
        file("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/docs/html")
    )
}
tasks.named<org.jetbrains.dokka.gradle.DokkaTask>("dokkaJavadoc") {
    outputDirectory.set(
        file("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/docs/javadoc")
    )
}
tasks.named("jreleaserAutoConfigRelease") {
    dependsOn(androidAar)
    dependsOn(androidExportProjectZip)
}
tasks.named("jreleaserFullRelease") {
    dependsOn(androidAar)
    dependsOn(androidExportProjectZip)
    dependsOn(":$moduleID:publish")
}
tasks.named("jreleaserRelease") {
    dependsOn(androidAar)
    dependsOn(androidExportProjectZip)
    dependsOn(":$moduleID:publish")
}
tasks.named("jreleaserPublish") {
    dependsOn(androidAar)
    dependsOn(androidExportProjectZip)
    dependsOn(":$moduleID:publish")
}
tasks.register("printSigningProperties") {
    doLast {
        println("signing.key: " + (project.findProperty("signing.key") != null))
        println("signing.password: " + (project.findProperty("signing.password") != null))
        println("signing.keyId: " + project.findProperty("signing.keyId"))
    }
}
tasks.withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
    failOnWarning.set(true)
    moduleName.set(rootProject.name)
    moduleVersion.set(project.version.toString())
    offlineMode.set(true)
    outputDirectory.set(layout.buildDirectory.dir("dokka/$name"))
    suppressObviousFunctions.set(true)
    suppressInheritedMembers.set(true)
    dokkaSourceSets.configureEach {
        includes.from("module.md")
        if (name != "main") suppress.set(true)
        classpath.from(project.files())
        displayName.set(name)
        noAndroidSdkLink.set(false)
        platform.set(org.jetbrains.dokka.Platform.jvm)
        samples.from(project.files())
        skipEmptyPackages.set(true)
        skipDeprecated.set(false)
        sourceRoots.from(file("src"))
        suppressGeneratedFiles.set(true)
        sourceLink {
            localDirectory.set(file("src/main/kotlin")) // or "src/main/kotlin" if Kotlin
            remoteUrl.set(URI("https://github.com/IODevBlue/DesignColors/tree/main/designcolors/src/main/kotlin").toURL())
            remoteLineSuffix.set("#L")
        }
        externalDocumentationLink {
            url.set(URI("\"https://github.com/IODevBlue/DesignColors/blob/main/README.md").toURL())
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
@Suppress("UnstableApiUsage")
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

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.compose.ui)
}
