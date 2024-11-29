package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.presentation.cardScreen.models.SingleCardUI

@Composable
fun SingleFacedCard(
    card: SingleCardUI,
    onBackClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CardScreenHeader(
        onBackClick = onBackClick,
        onPlusClick = onPlusClick,
        cardName = card.name
    )
    Spacer(modifier = Modifier.height(6.dp))
    CardScreenImage(
        cardName = card.name,
        imageUri = card.image["art_crop"]
    )
    Spacer(modifier = Modifier.height(15.dp))
    CardInfoPanel(
        cardName = card.name,
        oracleText = card.oracleText
    )
}