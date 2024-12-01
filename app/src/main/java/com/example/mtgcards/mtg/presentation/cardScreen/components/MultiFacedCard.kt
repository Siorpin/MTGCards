package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.presentation.cardScreen.models.SingleCardUI

@Composable
fun MultiFacedCard(
    faces: List<SingleCardUI>,
    onBackClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
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
            modifier = Modifier.fillMaxSize()
        ) { index ->
            val card = faces[index]
            Column(

            ) {
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
        }
    }
}