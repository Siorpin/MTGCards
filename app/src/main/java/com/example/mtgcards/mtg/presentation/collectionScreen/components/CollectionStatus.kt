package com.example.mtgcards.mtg.presentation.collectionScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.domain.Card

@Composable
fun CollectionStatus(
    cardList: List<Card>,
    modifier: Modifier = Modifier
) {
    val cardsAmont = cardList.size
        Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(70.dp)
//            .aspectRatio(1f)
//            .border(
//                width = 3.dp,
//                shape = CircleShape,
//                color = Color.Red
//            )
    ) {
            CollectionCircle(
                size = 70.dp,
                borderWith = 3.dp
            )
            Text(cardsAmont.toString())
    }
}