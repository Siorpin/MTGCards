package com.example.mtgcards.mtg.presentation.searchScreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun SearchBox(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        TextField(
            value = value,
            colors = TextFieldDefaults.colors(
                cursorColor = MaterialTheme.colorScheme.tertiary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            suffix = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null
                )
            },
            onValueChange = {
                onValueChange(it)
            },
            singleLine = true,
            placeholder = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@PreviewLightDark
@Composable
fun SearchBoxPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        SearchBox(
            "Simulacrum synthesizer"
        ) {}
    }
}