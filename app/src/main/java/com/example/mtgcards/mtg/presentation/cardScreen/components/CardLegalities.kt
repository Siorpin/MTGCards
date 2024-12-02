package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CardLegalities(
    legalitiesMap: Map<String, String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        legalitiesMap.forEach{ legality ->
            SingleLegality(legality)
        }
    }
}

@Composable
fun SingleLegality(
    legality: Map.Entry<String, String>,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(legality.key)
        Text(legality.value)
    }
}