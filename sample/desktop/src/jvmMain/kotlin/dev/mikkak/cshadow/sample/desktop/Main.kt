package dev.mikkak.cshadow.sample.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.mikkak.cshadow.sample.BoxShadowExample

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
    ) {
        BoxShadowExample()
    }
}
