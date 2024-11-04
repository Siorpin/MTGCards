package com.example.mtgcards.mtg.presentation.searchScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun SingleCard(
    card: CardUi,
    modifier: Modifier = Modifier
) {
    val shortenedName = if (card.name.length > 20) "${card.name.take(20)}..."
                        else card.name
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .clickable {  }
    ) {
        AsyncImage(
            model = card.image,
            contentDescription = card.name,
            modifier = Modifier
                .height(130.dp)
        )
        Text(
            text = shortenedName,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun SingleCardPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        SingleCard(
            CardUi("sds", "https://cards.scryfall.io/normal/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838"),
        )
    }
}