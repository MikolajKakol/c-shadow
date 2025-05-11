plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.jetbrains.compose)}

kotlin {
  @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
  wasmJs {
    browser {
      commonWebpackConfig {
        outputFileName = "sample.js"
      }
    }

    binaries.executable()
  }

  js(IR) {
    browser {
      commonWebpackConfig {
        outputFileName = "sample.js"
      }
    }

    binaries.executable()
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation(projects.sample.shared)
      }
    }
  }
}
