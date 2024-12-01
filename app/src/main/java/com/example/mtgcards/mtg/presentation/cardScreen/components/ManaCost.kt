package com.example.mtgcards.mtg.presentation.cardScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mtgcards.mtg.presentation.cardScreen.models.getManaImages

@Composable
fun ManaCost(
    manaString: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp,
            alignment = Alignment.End
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        manaString.forEach { mana ->
            Image(
                painterResource(getManaImages(mana)),
                contentDescription = mana,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}