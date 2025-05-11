package dev.mikkak.cshadow.sample.js

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.mikkak.cshadow.sample.BoxShadowExample
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  onWasmReady {
    ComposeViewport(
      viewportContainerId = "Sample",
    ) {
//      PageLoadNotify()
      BoxShadowExample()
    }
  }
}

external fun onLoadFinished()

@Composable
fun PageLoadNotify() {
  LaunchedEffect(Unit) {
    onLoadFinished()
  }
}
