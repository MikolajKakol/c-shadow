package dev.mikkak.cshadow

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.romainguy.graphics.path.toPath

fun Modifier.shadow(
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = DefaultBlurRadius,
    color: Color = DefaultShadowColor,
    bitmap: Bitmap,
) = composed {
    val path = remember(bitmap) {
        bitmap.toPath().asComposePath()
    }

    this.shadow(
        offsetY = offsetY,
        offsetX = offsetX,
        blurRadius = blurRadius,
        path = path,
        color = color
    )
}

@Preview
@Composable
private fun PreviewShadowBox() = PreviewSliders(initialBlurRadius = 4.dp) { offsetX, offsetY, blurRadius ->
    Row(
        Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ImageWithShadow(android.R.drawable.btn_star_big_on, offsetX, offsetY, blurRadius)
        ImageWithShadow(android.R.drawable.ic_menu_call, offsetX, offsetY, blurRadius)
    }
}

@Composable
private fun ImageWithShadow(image: Int, offsetX: Dp, offsetY: Dp, blurRadius: Dp) {
    val context = LocalContext.current
    val imageBitmap = remember {
        ImageBitmap.imageResource(context.resources, image).asAndroidBitmap()
    }
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        contentScale = ContentScale.None,
        modifier = Modifier
            .shadow(
                offsetY = offsetX,
                offsetX = offsetY,
                blurRadius = blurRadius,
                bitmap = imageBitmap
            )
    )
}


