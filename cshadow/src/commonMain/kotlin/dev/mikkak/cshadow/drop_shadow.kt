package dev.mikkak.cshadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.shadow(
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = DefaultBlurRadius,
    color: Color = DefaultShadowColor,
    path: Path,
) = drawWithCache {
    onDrawBehind {
        drawIntoCanvas {
            val paint = createPaint(blurRadius.toPx(), color)

            it.save()
            it.translate(offsetX.toPx(), offsetY.toPx())
            it.drawPath(path, paint)
            it.restore()
        }
    }
}
