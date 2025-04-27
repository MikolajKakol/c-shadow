package dev.mikkak.cshadow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
internal fun PreviewSliders(
    initialOffsetX: Dp = 0.dp,
    initialOffsetY: Dp = 0.dp,
    initialBlurRadius: Dp = DefaultBlurRadius,
    content: @Composable (
        offsetX: Dp,
        offsetY: Dp,
        blurRadius: Dp,
    ) -> Unit
) = Column(
    Modifier
        .verticalScroll(rememberScrollState()),
) {
    var offsetX by remember { mutableStateOf(initialOffsetX.value) }
    var offsetY by remember { mutableStateOf(initialOffsetY.value) }
    var blurRadius by remember { mutableStateOf(initialBlurRadius.value) }

    content(
        offsetX.dp,
        offsetY.dp,
        blurRadius.dp,
    )

    Spacer(modifier = Modifier.requiredSize(32.dp))

    Text(text = "Offset X: ${offsetX.toInt()}")
    Slider(value = offsetX, onValueChange = { offsetX = it.roundToInt().toFloat() }, valueRange = -100f..100f)
    Text(text = "Offset Y: ${offsetY.toInt()}")
    Slider(value = offsetY, onValueChange = { offsetY = it.roundToInt().toFloat() }, valueRange = -100f..100f)
    Text(text = "Blur radius: ${blurRadius.toInt()}")
    Slider(value = blurRadius, onValueChange = { blurRadius = it.roundToInt().toFloat() }, valueRange = 0f..30f)
}