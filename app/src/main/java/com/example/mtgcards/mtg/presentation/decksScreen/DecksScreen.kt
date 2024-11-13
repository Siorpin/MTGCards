package com.example.mtgcards.mtg.presentation.decksScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mtgcards.mtg.presentation.decksScreen.components.DecksScreenHeader

@Composable
fun DecksScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DecksScreenHeader()
    }
}