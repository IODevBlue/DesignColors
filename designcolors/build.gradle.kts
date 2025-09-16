import org.jreleaser.model.Active
import org.jreleaser.model.Changelog
import org.jreleaser.model.Stereotype
import org.jreleaser.model.UpdateSection
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
val releaseVersion = "1.2.1"
val releaseTitle = "Design Colors"
val releaseTitleNoSpaces = releaseTitle.replace(" ", "")
val repositoryUrl = "github.com/IODevBlue/DesignColors"

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
                    url.set("https://${repositoryUrl}.git")
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
                        connection.set("scm:git:git://${repositoryUrl}.git")
                        developerConnection.set("scm:git:ssh://${repositoryUrl}.git")
                        url.set("https://${repositoryUrl}")
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
                    setActive(Active.RELEASE.name)
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
            tag("v$releaseVersion")
            artifact {
                setPath("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/${releaseTitleNoSpaces}_v${releaseVersion}.aar")
            }
            artifact {
                setPath("${rootProject.projectDir}/artefacts/${moduleID}/${releaseVersion}/${releaseTitleNoSpaces}_v${releaseVersion}.jar")
            }
        }
    }
    files {
        setActive("ALWAYS")
//        artifact { }
    }
    project {
        authors = listOf(
            "IO DevBlue"
        )
        name = releaseTitle
        copyright = "2022-2025 IO DevBlue"
        description = "A Kotlin library for predefined color palettes from popular design systems and brands."
        inceptionYear = "2022"
        longDescription = "A Kotlin color library providing a singleton with predefined color palettes from major design systems like Material Design, Apple HIG, Atlassian, Bootstrap and Fluent UI, along with a curated set of official brand colors. It includes helper methods for dynamic color selection."
        license = "Apache-2.0"
        stereotype = Stereotype.MOBILE
        vendor = "IO DevBlue"
        version = releaseVersion
        versionPattern = "SEMVER"
//        icon {  }
        links {
            bugTracker = "https://${repositoryUrl}/issues"
            contact = "https://github.com/IODevBlue"
            documentation = "https://${repositoryUrl}/blob/main/README.md"
            homepage = "https://${repositoryUrl}"
            license = "https://www.apache.org/licenses/LICENSE-2.0"
            vcsBrowser =  "https://${repositoryUrl}"
            version = releaseVersion
        }
        maintainer("IO DevBlue")
//        screenshot { }
        tag(releaseVersion)
    }
    release {
        github {
            connectTimeout = 20
            checksums = false
            draft = false
            enabled = true
            overwrite = true
            previousTagName = previousVersion
            readTimeout = 60
            repoUrl = "https://${repositoryUrl}"
            releaseName = "$releaseTitle v$releaseVersion"
            sign = true
            skipRelease = false
            skipTag = false
            signatures = false
            setUploadAssets(Active.ALWAYS.formatted())
            changelog {
                categoryTitleFormat = "### {{categoryTitle}}"
                contributorsTitleFormat = "### Contributors"
                content = "\n\n{{changelogChanges}}\n{{changelogContributors}}"
                enabled = true
                excludeLabels = setOf()
                format = "- {{commitShortHash}} {{commitTitle}}"
                formatted = Active.ALWAYS
                preset = "conventional"
                sort = Changelog.Sort.DESC

                contributors {
                    enabled = true
                    format = "- {{contributorName}} ({{contributorUsernameAsLink}})"
                }

                hide {
                    categories = setOf("merge")
                    contributors = setOf("[bot]")
                    uncategorized = false
                }

                // 🔖 Labelers
                labeler { label = "build";      title = "regex:^(build)(\\(.*\\))?:"; order = 1 }
                labeler { label = "ci";         title = "regex:^(ci)(\\(.*\\))?:";    order = 2 }
                labeler { label = "deps";       title = "regex:^(deps)(\\(.*\\))?:";  order = 3 }
                labeler { label = "bug";        title = "regex:^(bug)(\\(.*\\))?:";   order = 4 }
                labeler { label = "fix";        title = "regex:^(fix)(\\(.*\\))?:";   order = 5 }
                labeler { label = "hotfix";     title = "regex:^(hotfix)(\\(.*\\))?:";order = 6 }
                labeler { label = "security";   title = "regex:^(security)(\\(.*\\))?:"; order = 7 }
                labeler { label = "feat";       title = "regex:^(feat)(\\(.*\\))?:";  order = 8 }
                labeler { label = "breaking";   title = "regex:^(breaking)(\\(.*\\))?:"; order = 9 }
                labeler { label = "perf";       title = "regex:^(perf)(\\(.*\\))?:";  order = 10 }
                labeler { label = "refactor";   title = "regex:^(refactor)(\\(.*\\))?:"; order = 11 }
                labeler { label = "ref";        title = "regex:^(ref)(\\(.*\\))?:";   order = 12 }
                labeler { label = "revert";     title = "regex:^(revert)(\\(.*\\))?:";order = 13 }
                labeler { label = "style";      title = "regex:^(style)(\\(.*\\))?:"; order = 14 }
                labeler { label = "test";       title = "regex:^(test)(\\(.*\\))?:";  order = 15 }
                labeler { label = "chore";      title = "regex:^(chore)(\\(.*\\))?:"; order = 16 }
                labeler { label = "wip";        title = "regex:^(wip)(\\(.*\\))?:";   order = 17 }
                labeler { label = "task";       title = "regex:^(task)(\\(.*\\))?:";  order = 18 }
                labeler { label = "docs";       title = "regex:^(docs)(\\(.*\\))?:";  order = 19 }
                labeler { label = "deprecate";  title = "regex:^(deprecat(e|ed|ion))(\\(.*\\))?:"; order = 20 }
                labeler { label = "merge";      title = "regex:^(merge)(\\(.*\\))?:"; order = 21 }

                // 🗂 Categories
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
                    labels = setOf("bug", "fix", "hotfix", "security")
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
                    labels = setOf("perf", "refactor", "ref", "revert", "style")
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
                    labels = setOf("chore", "wip", "task")
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
                    title = "⚠️ Deprecations"
                    key = "deprecations"
                    labels = setOf("deprecate")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 80
                }
                category {
                    title = "🔀 Merge"
                    key = "merge"
                    labels = setOf("merge")
                    format = "- {{commitShortHash}} {{commitBody}}"
                    order = 0
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
                section(UpdateSection.ASSETS.name)
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
tasks.named("jreleaserChangelog") {
    dependsOn("clean")
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
tasks.named("jreleaserUpload") {
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
            remoteUrl.set(URI("https://${repositoryUrl}/tree/main/$moduleID/src/main/kotlin").toURL())
            remoteLineSuffix.set("#L")
        }
        externalDocumentationLink {
            url.set(URI("https://${repositoryUrl}/blob/main/README.md").toURL())
        }
    }
}

val androidAar by tasks.register<Jar>("androidAar") {
    group = "iodevblue"
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
    group = "iodevblue"
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
    group = "iodevblue"
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
    group = "iodevblue"
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
    group = "iodevblue"
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
    group = "iodevblue"
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
