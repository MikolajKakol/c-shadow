@file:OptIn(ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.publish)
}

kotlin {
    applyDefaultHierarchyTemplate()

    jvm()

    androidTarget {
        publishLibraryVariants("release")
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    wasmJs {
        browser()
    }
    js(IR) {
        browser()
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.components.uiToolingPreview)
            }
        }

        val skiaMain by creating {
            dependsOn(commonMain)
        }

        jvmMain {
            dependsOn(skiaMain)
        }

        androidMain {
            dependencies {
                implementation(compose.material3)
                implementation(libs.pathway)
            }
        }

        iosMain {
            dependsOn(skiaMain)
        }

        wasmJsMain {
            dependsOn(skiaMain)
        }
        jsMain {
            dependsOn(skiaMain)
        }
    }
}

android {
    namespace = "dev.mikkak.cshadow"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    buildFeatures {
        buildConfig = false
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates("dev.mikkak.c-shadow", "c-shadow", "0.2.0")

    pom {
        name.set("c-shadow")
        description.set("CSS alike shadow support for for Jetpack Compose & Multiplatform.")
        url.set("https://github.com/MikolajKakol/c-shadow")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("MikolajKakol")
                name.set("Mikolaj Kakol")
                email.set("contact@mikolaj-kakol.me")
            }
        }
        scm {
            url.set("https://github.com/MikolajKakol/c-shadow")
            connection.set("scm:git:git://github.com/MikolajKakol/c-shadow.git")
            developerConnection.set("scm:git:ssh://git@github.com/MikolajKakol/c-shadow.git")
        }
    }
}
