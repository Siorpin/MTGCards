package com.example.mtgcards.mtg.presentation.cardScreen

import com.example.mtgcards.mtg.presentation.cardScreen.models.SingleCardUI

data class CardScreenState(
    val isLoading: Boolean = true,
    val cards: List<SingleCardUI> = listOf(),
    val multiFaces: Boolean = false
)
