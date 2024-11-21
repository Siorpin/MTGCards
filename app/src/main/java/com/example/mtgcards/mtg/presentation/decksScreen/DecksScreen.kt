package com.example.mtgcards.mtg.presentation.decksScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mtgcards.R
import com.example.mtgcards.mtg.presentation.shared.components.ScreenHeader

@Composable
fun DecksScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(stringResource(R.string.decks))
    }
}