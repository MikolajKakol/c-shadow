import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.publish)
}

kotlin {
    jvm()

    androidTarget {
        publishLibraryVariants("release")
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.components.uiToolingPreview)
            }
        }
        val commonTest by getting

        val skiaMain by creating {
            dependsOn(commonMain)
        }

        val jvmMain by getting {
            dependsOn(skiaMain)
        }
        val jvmTest by getting

        val androidMain by getting {
            dependencies {
                implementation(compose.material3)
                implementation(libs.pathway)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            dependsOn(skiaMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
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

    coordinates("dev.mikkak.c-shadow", "c-shadow", "0.1.4")

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
