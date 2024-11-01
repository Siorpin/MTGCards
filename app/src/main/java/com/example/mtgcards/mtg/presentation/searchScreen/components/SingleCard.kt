package com.example.mtgcards.mtg.presentation.searchScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun SingleCard(
    card: CardUi,
    imageUri: String,
    modifier: Modifier = Modifier
) {
    Column(

    ) {
        AsyncImage(
            model = imageUri,
            contentDescription = card.name,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun SingleCardPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        SingleCard(
            CardUi("sds", "sddfs"),
            "https://cards.scryfall.io/normal/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838"
        )
    }
}