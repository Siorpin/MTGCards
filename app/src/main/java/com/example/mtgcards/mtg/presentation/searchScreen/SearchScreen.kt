package com.example.mtgcards.mtg.presentation.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mtgcards.mtg.presentation.searchScreen.components.SearchBox
import com.example.mtgcards.mtg.presentation.searchScreen.components.SearchedCardsGrid
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun SearchScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: SearchScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 50.dp)
    ) {
        SearchBox(
            value = state.searchString
        ) {
            viewModel.updateText(it)

            if (it.isEmpty()) viewModel.clearCardList()
            else viewModel.searchCards(it)
        }
        Spacer(modifier = Modifier.height(14.dp))
        if(state.isLoading) {
            Box (
                contentAlignment = Alignment.Center,
                modifier = modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        } else {
            SearchedCardsGrid(
                state.searchedCards,
                navController
            )
        }
    }
}

@PreviewLightDark
@Composable
fun SearchScreenPreview(
    modifier: Modifier = Modifier
) {
    MTGCardsTheme {
        SearchScreen(
            navController = rememberNavController(),
            modifier = Modifier.background(Color.Blue)
        )
    }
}