package com.example.mtgcards.mtg.presentation.searchScreen.models

import androidx.compose.ui.graphics.painter.Painter
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.mtgcards.mtg.domain.Card
import coil.compose.rememberImagePainter

data class CardUi(
    val name: String,
    val image: String // TODO: not sure yet
)

fun Card.toUi(): CardUi {
    return CardUi(
        name = name,
        image = image
    )
}