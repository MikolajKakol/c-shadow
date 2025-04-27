// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("root.publication")
    id("module.publication")
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.jetbrains.compose) apply false
}