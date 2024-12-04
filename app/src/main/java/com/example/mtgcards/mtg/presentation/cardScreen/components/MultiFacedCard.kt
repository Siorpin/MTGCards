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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.presentation.cardScreen.models.SingleCardUI

@Composable
fun MultiFacedCard(
    faces: List<SingleCardUI>,
    onBackClick: () -> Unit,
    onPlusClick: () -> Unit,
    toggleImageZoom: () -> Unit,
    isImageZoomed: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        var currentCard: SingleCardUI? = null

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            CardScreenHeader(
                cardName = if (faces[0].name.length > 20) "${faces[0].name.take(20)}..."
                else faces[0].name,
                onBackClick = onBackClick,
                onPlusClick = onPlusClick
            )
            Spacer(modifier = Modifier.height(6.dp))
            HorizontalPager(
                state = rememberPagerState { faces.size },
                key = { faces[it].name },
                verticalAlignment = Alignment.Top,
                pageSpacing = 12.dp,
                modifier = Modifier.fillMaxSize()
            ) { index ->
                val card = faces[index]
                currentCard = card
                Column {
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
                }
            }
        }
        AnimatedVisibility(
            isImageZoomed,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(500)),
            modifier = Modifier.matchParentSize()
        ) {
            currentCard?.image?.get("image")?.let {
                ZoomedCard(
                    imageString = it,
                    onBackgroundClick = { toggleImageZoom() }
                )
            }
        }
    }
}