package com.example.mtgcards.mtg.presentation.collectionScreen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mtgcards.mtg.data.mappers.toCardUi
import com.example.mtgcards.mtg.domain.Card
import com.example.mtgcards.mtg.domain.ColorIdentity
import com.example.mtgcards.mtg.presentation.shared.components.SingleCard

@Composable
fun CollectionScreenGrid(
    itemsList: List<Card>,
    navController: NavController,
    cardsAmount: Int,
    colorsPercentage: MutableMap<ColorIdentity, Float>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            CollectionCircle(
                size = 75.dp,
                borderWith = 3.dp,
                colorsPercentage = colorsPercentage,
                cardsAmount = cardsAmount
            )
            Spacer(modifier = Modifier.height(100.dp))
        }

        items(itemsList) { card ->
            SingleCard(
                card.toCardUi(),
                navController
            )
        }
    }
}