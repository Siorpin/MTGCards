package com.example.mtgcards.mtg.presentation.homeScreen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mtgcards.R

@Composable
fun WhatsNewCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(),
        modifier = modifier
            .height(400.dp)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.new_features),
            textAlign = TextAlign.Left,
            modifier = modifier
                .padding(16.dp)
        )
    }
}