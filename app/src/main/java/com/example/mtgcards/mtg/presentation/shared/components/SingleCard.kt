package com.example.mtgcards.mtg.presentation.shared.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mtgcards.R
import com.example.mtgcards.core.navigation.Screen
import com.example.mtgcards.mtg.presentation.shared.models.CardUi

@Composable
fun SingleCard(
    card: CardUi,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val shortenedName = if (card.name.length > 20) "${card.name.take(20)}..."
                        else card.name
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .clickable { navController.navigate("${Screen.CardScreen.route}/{${Uri.encode(card.name)}}") }
    ) {
        if (card.image == null) {
            Image(
                painter = painterResource(R.drawable.cardback),
                contentDescription = card.name,
                modifier = Modifier
                    .height(130.dp)
            )
        } else {
            AsyncImage(
                model = card.image,
                contentDescription = card.name,
                modifier = Modifier
                    .height(130.dp)
            )
        }
        Text(
            text = shortenedName,
            fontSize = 10.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}