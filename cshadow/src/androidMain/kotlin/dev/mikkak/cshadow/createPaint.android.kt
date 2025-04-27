package dev.mikkak.cshadow

import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.Paint

internal actual fun Paint.applyBlur(blur: Float) {
    asFrameworkPaint().maskFilter = BlurMaskFilter(blur, BlurMaskFilter.Blur.NORMAL)
}