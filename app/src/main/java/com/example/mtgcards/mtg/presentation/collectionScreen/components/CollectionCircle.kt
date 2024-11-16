package com.example.mtgcards.mtg.presentation.collectionScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import com.example.mtgcards.mtg.domain.Card

@Composable
fun CollectionCircle(
    cardList: List<Card>,
    size: Dp,
    borderWith: Dp,
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
            .size(size)
    ) {
        val strokeWith = borderWith.toPx()
        var currentAngle = -90f

        for (i in 0..3) {
            drawArc(
                color = Color(0XFF129381 * i),
                startAngle = currentAngle,
                sweepAngle = 90f,
                useCenter = false,
                style = Stroke(width = strokeWith)
            )
            currentAngle += 90
        }

    }
}

private fun calculatePercents(cardList: List<Card>): Map<Color, Float> {
    var colorsMap = mutableMapOf(
        Color.White to 0f,
        Color.Red to 0f,
        Color.Blue to 0f,
        Color.Green to 0f,
        Color.Gray to 0f,
        Color.Gray to 0f,
    )

    cardList.forEach {card ->
        when(card.colorIdentity.size) {
            0 -> {

            }
            1 -> {

            }
            else -> {

            }
        }
    }
}