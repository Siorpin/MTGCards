package com.example.mtgcards.mtg.presentation.searchScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mtgcards.mtg.presentation.searchScreen.components.SearchBox
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    val viewModel: SearchScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text("Search")
        SearchBox(
            value = state.searchString
        ) { it ->
            viewModel.updateText(it)
            // TODO: on value change send api request
        }
    }
}

@PreviewLightDark
@Composable
fun SearchScreenPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        SearchScreen()
    }
}