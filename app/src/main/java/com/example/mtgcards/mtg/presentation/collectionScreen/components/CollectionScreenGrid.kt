package com.example.mtgcards.mtg.presentation.collectionScreen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mtgcards.mtg.domain.Card
import com.example.mtgcards.mtg.data.mappers.toCardUi
import com.example.mtgcards.mtg.presentation.shared.components.SingleCard

@Composable
fun CollectionScreenGrid(
    itemsList: List<Card>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(
            4.dp
        ),
        modifier = modifier
            .fillMaxSize()
    ) {
        items(itemsList) { card ->
            SingleCard(
                card.toCardUi(),
                navController
            )
        }
    }
}