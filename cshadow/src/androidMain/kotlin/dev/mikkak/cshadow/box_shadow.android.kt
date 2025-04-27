package dev.mikkak.cshadow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewShadowBox() = PreviewSliders { offsetX, offsetY, blurRadius ->
    Box(
        modifier = Modifier
            .padding(32.dp)
            .size(80.dp)
            .shadow(offsetY = offsetX, offsetX = offsetY, blurRadius = blurRadius)
            .background(Color.Cyan, RoundedCornerShape(DefaultCornerRadius))
    )
}
