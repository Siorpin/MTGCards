package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CardInfoPanel(
    cardName: String,
    oracleText: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column(

        ) {
            Row(

            ) {
                Text(
                    text = cardName
                )
            } // ROW
            Text(
                text = oracleText
            )
        } // COLUMN
    }
}