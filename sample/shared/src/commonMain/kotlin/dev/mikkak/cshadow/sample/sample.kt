package dev.mikkak.cshadow.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.mikkak.cshadow.shadow
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.roundToInt

@Preview
@Composable
fun BoxShadowExample() = Column(
    Modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
    verticalArrangement = spacedBy(16.dp)
) {
    var offsetX by remember { mutableStateOf(10f) }
    var offsetY by remember { mutableStateOf(20f) }

    val cornerShape = RoundedCornerShape(12.dp)

    Box(
        modifier = Modifier
            .size(width = 120.dp, height = 120.dp)
            .padding(10.dp)
            .shadow(offsetY = offsetY.dp, offsetX = offsetX.dp, color = Color.Red, blurRadius = 32.dp)
            .shadow(offsetY = offsetY.dp, offsetX = offsetX.dp)
            .background(Color.White, cornerShape)
            .padding(10.dp)
            .background(Color.Cyan, cornerShape)
    )

    Box(
        modifier = Modifier
            .size(102.dp)
            .padding(10.dp)
            .shadow(offsetY = offsetY.dp, offsetX = offsetX.dp, shape = cornerShape)
            .background(Color.White, cornerShape)
            .padding(10.dp)
            .background(Color.Cyan, cornerShape)
    )

//    val context = LocalContext.current
//
//    val imageBitmap = remember {
//        ImageBitmap.imageResource(context.resources, R.drawable.android).asAndroidBitmap()
//    }
//    Image(
//        painter = painterResource(id = R.drawable.android),
//        contentDescription = "",
//        contentScale = ContentScale.None,
//        modifier = Modifier
//            .shadow(
//                offsetY = offsetY.dp,
//                offsetX = offsetX.dp,
//                blurRadius = 8.dp,
//                bitmap = imageBitmap
//            )
//    )

    Spacer(modifier = Modifier.requiredSize(32.dp))

    Text(text = "Offset X: ${offsetX.toInt()}")
    Slider(value = offsetX, onValueChange = { offsetX = it.roundToInt().toFloat() }, valueRange = -100f..100f)
    Text(text = "Offset Y: ${offsetY.toInt()}")
    Slider(value = offsetY, onValueChange = { offsetY = it.roundToInt().toFloat() }, valueRange = -100f..100f)
}
