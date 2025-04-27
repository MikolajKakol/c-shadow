package dev.mikkak.cshadow

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val DefaultBlurRadius: Dp = 8.dp

internal fun createPaint(
    blur: Float,
    color: Color
): Paint {
    val paint = Paint()

    if (blur != 0f) {
        paint.applyBlur(blur)
    }
    paint.color = color
    return paint
}

internal expect fun Paint.applyBlur(blur: Float)
