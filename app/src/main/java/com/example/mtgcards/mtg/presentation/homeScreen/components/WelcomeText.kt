package com.example.mtgcards.mtg.presentation.homeScreen.components

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtgcards.R
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 100.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.mtgcardslogo),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
        )
        Text(
            text = stringResource(R.string.welcome_in_mtgcards),
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            lineHeight = 55.sp
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