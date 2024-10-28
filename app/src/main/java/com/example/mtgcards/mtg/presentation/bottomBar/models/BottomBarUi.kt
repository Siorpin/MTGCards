package com.example.mtgcards.mtg.presentation.bottomBar.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarUi(
    val name: String,
    val icon: ImageVector,
    val isCurrentPage: Boolean = false,
    val onCLick: () -> Unit
)
