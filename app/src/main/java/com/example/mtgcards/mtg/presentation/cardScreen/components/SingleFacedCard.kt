package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.presentation.cardScreen.models.SingleCardUI

@Composable
fun SingleFacedCard(
    card: SingleCardUI,
    onBackClick: () -> Unit,
    onPlusClick: () -> Unit,
    isImageZoomed: Boolean,
    toggleImageZoom: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CardScreenHeader(
                onBackClick = onBackClick,
                onPlusClick = onPlusClick,
                cardName = card.name
            )
            Spacer(modifier = Modifier.height(6.dp))
            CardScreenImage(
                cardName = card.name,
                imageUri = card.image["art_crop"],
                onImageClick = { toggleImageZoom() }
            )
            Spacer(modifier = Modifier.height(15.dp))
            ManaCost(card.manaCost)
            CardInfoPanel(
                cardName = card.name,
                oracleText = card.oracleText
            )
            CardLegalities(card.legalities)
        }
        AnimatedVisibility(
            isImageZoomed,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(500)),
            modifier = Modifier
                .fillMaxSize()
        ) {
            card.image["image"]?.let {
                ZoomedCard(
                    imageString = it,
                    onBackgroundClick = { toggleImageZoom() }
                )
            }
        }
    }
}