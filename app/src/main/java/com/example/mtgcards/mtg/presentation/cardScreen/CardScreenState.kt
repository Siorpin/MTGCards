package com.example.mtgcards.mtg.presentation.cardScreen

import com.example.mtgcards.mtg.presentation.cardScreen.models.SingleCardUI

data class CardScreenState(
    val isLoading: Boolean = false,
    val card: SingleCardUI = SingleCardUI(
        name = "",
        image = mapOf(),
        setName = "",
        manaCost = listOf(),
        oracleText = ""
    )
)
