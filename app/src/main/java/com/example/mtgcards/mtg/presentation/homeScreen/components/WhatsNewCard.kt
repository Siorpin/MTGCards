package com.example.mtgcards.mtg.presentation.homeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtgcards.R
import com.example.ui.theme.exo2

@Composable
fun WhatsNewCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(),
        modifier = modifier
            .height(400.dp)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.what_s_new),
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontFamily = exo2,
                color = MaterialTheme.colorScheme.secondary,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(R.string.new_features),
                textAlign = TextAlign.Left,
                fontFamily = exo2
            )
        }
    }
}