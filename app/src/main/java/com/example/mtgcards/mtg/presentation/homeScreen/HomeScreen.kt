package com.example.mtgcards.mtg.presentation.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mtgcards.mtg.presentation.homeScreen.components.WelcomeText
import com.example.mtgcards.mtg.presentation.homeScreen.components.WhatsNewCard

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText()
        WhatsNewCard()
    }
}