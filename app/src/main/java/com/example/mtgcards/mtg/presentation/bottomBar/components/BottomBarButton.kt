package com.example.mtgcards.mtg.presentation.bottomBar.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtgcards.mtg.presentation.bottomBar.models.BottomBarUi
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun BottomBarButton(
    bottomBarUi: BottomBarUi,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { bottomBarUi.onCLick() }
    ) {
        Icon(
            bottomBarUi.icon,
            bottomBarUi.name,
            tint = if(bottomBarUi.isCurrentPage) MaterialTheme.colorScheme.tertiary
                else MaterialTheme.colorScheme.secondary,
            modifier = modifier
                .size(35.dp)
        )
        Text(
            text = bottomBarUi.name,
            fontSize = 14.sp,
            color = if(bottomBarUi.isCurrentPage) MaterialTheme.colorScheme.tertiary
                else MaterialTheme.colorScheme.secondary
        )
    }
}

@PreviewLightDark
@Composable
fun BottomBarButtonPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        BottomBarButton(
            bottomBarUi = BottomBarUi(icon = Icons.Default.Home, name = "Home"){}
        )
    }
}