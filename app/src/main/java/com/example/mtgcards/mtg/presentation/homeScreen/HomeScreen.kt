package com.example.mtgcards.mtg.presentation.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.presentation.homeScreen.components.WelcomeText
import com.example.mtgcards.mtg.presentation.homeScreen.components.WhatsNewCard

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText()
        Spacer(modifier = modifier.height(40.dp))
        WhatsNewCard()
    }
    //TODO: Add author links in the bottom
}