package com.example.mtgcards.mtg.presentation.homeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtgcards.R
import com.example.mtgcards.ui.theme.MTGCardsTheme
import com.example.ui.theme.exo2

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 100.dp)
    ) {
        Text(
            text = stringResource(R.string.welcome_in_mtgcards),
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            lineHeight = 45.sp,
            fontFamily = exo2
        )
    }
}

@PreviewLightDark
@Composable
fun WelcomeTextPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        WelcomeText()
    }
}