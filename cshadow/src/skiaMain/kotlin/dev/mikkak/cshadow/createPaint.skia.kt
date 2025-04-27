package dev.mikkak.cshadow

import androidx.compose.ui.graphics.Paint
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

internal actual fun Paint.applyBlur(blur: Float) {
    asFrameworkPaint().maskFilter = MaskFilter.makeBlur(FilterBlurMode.NORMAL, blur, false)
}