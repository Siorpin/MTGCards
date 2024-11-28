package com.example.mtgcards.mtg.presentation.collectionScreen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.domain.ColorIdentity

@Composable
fun CollectionCircle(
    colorsPercentage: MutableMap<ColorIdentity, Float>,
    size: Dp,
    cardsAmount: Int,
    borderWith: Dp,
    modifier: Modifier = Modifier
) {
    val animateFloat = remember { Animatable(0f) }

    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 700, easing = EaseOut)
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(75.dp)
    ) {
        Canvas(
            modifier = modifier
                .size(size)
        ) {
            val strokeWith = borderWith.toPx()
            var currentAngle = -90f

            colorsPercentage.forEach { item ->
                val angle = item.value * 360 * animateFloat.value

                drawArc(
                    color = when (item.key) {
                        ColorIdentity.RED -> Color.Red
                        ColorIdentity.GREEN -> Color.Green
                        ColorIdentity.WHITE -> Color.White
                        ColorIdentity.BLACK -> Color.Gray
                        ColorIdentity.BLUE -> Color.Blue
                        ColorIdentity.COLORLESS -> Color.LightGray
                        ColorIdentity.MULTICOLORED -> Color.Magenta
                    },
                    startAngle = currentAngle,
                    sweepAngle = angle,
                    useCenter = false,
                    style = Stroke(width = strokeWith)
                )
                currentAngle += angle
            }

        }
        Text(cardsAmount.toString())
    }
}

//private fun calculatePercents(cardList: List<Card>): MutableMap<ColorIdentity, Float> {
//    val colorsMap = mutableMapOf(
//        ColorIdentity.RED to 0f,
//        ColorIdentity.WHITE to 0f,
//        ColorIdentity.BLACK to 0f,
//        ColorIdentity.BLUE to 0f,
//        ColorIdentity.COLORLESS to 0f,
//        ColorIdentity.MULTICOLORED to 0f,
//    )
//
//    cardList.forEach { card ->
//        when(card.colorIdentity.size) {
//            0 -> {
//                colorsMap.merge(ColorIdentity.COLORLESS, 1f) {old, value ->
//                    old + value
//                }
//            }
//            1 -> {
//                when(card.colorIdentity[0]) {
//                    "W" -> {
//                        colorsMap.merge(ColorIdentity.WHITE, 1f) {old, value ->
//                            old + value
//                        }
//                    }
//                    "B" -> {
//                        colorsMap.merge(ColorIdentity.BLACK, 1f) {old, value ->
//                            old + value
//                        }
//                    }
//                    "R" -> {
//                        colorsMap.merge(ColorIdentity.RED, 1f) {old, value ->
//                            old + value
//                        }
//                    }
//                    "U" -> {
//                        colorsMap.merge(ColorIdentity.BLUE, 1f) {old, value ->
//                            old + value
//                        }
//                    }
//                    "G" -> {
//                        colorsMap.merge(ColorIdentity.GREEN, 1f) {old, value ->
//                            old + value
//                        }
//                    }
//                }
//            }
//            else -> {
//                colorsMap.merge(ColorIdentity.MULTICOLORED, 1f) {old, value ->
//                    old + value
//                }
//            }
//        }
//    }
//
//    colorsMap.keys.forEach{ key ->
//        colorsMap.merge(key, cardList.size.toFloat() ) {old, value ->
//            old / value
//        }
//    }
//
//    return colorsMap
//}