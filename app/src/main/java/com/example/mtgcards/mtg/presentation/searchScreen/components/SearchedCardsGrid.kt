package com.example.mtgcards.mtg.presentation.searchScreen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi

@Composable
fun SearchedCardsGrid(
    itemsList: List<CardUi>,
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
            .padding(bottom = 90.dp)
    ) {
        items(itemsList) { card ->
            SingleCard(
                card,
                navController
            )
        }
    }
}