package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtgcards.ui.theme.MTGCardsTheme
import com.example.ui.theme.exo2

@Composable
fun CardScreenHeader(
    cardName: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
    ) {
        IconButton(
            onClick = onBackClick,
            modifier
                .align(alignment = Alignment.BottomStart)
                .padding(bottom = 20.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
            )
        }
        Text(
            text = cardName,
            fontFamily = exo2,
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@PreviewLightDark
@Composable
fun CardScreenHeaderPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        CardScreenHeader(
            onBackClick = {},
            cardName = "sample name"
        )
    }
}