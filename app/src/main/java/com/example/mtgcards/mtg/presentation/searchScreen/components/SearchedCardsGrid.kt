package com.example.mtgcards.mtg.presentation.searchScreen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mtgcards.mtg.presentation.shared.components.SingleCard
import com.example.mtgcards.mtg.presentation.shared.models.CardUi

@Composable
fun SearchedCardsGrid(
    itemsList: MutableList<CardUi?>,
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
            if (card != null) {
                SingleCard(
                    card,
                    navController
                )
            }
        }
    }
}