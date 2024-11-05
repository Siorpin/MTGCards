package com.example.mtgcards.mtg.presentation.cardScreen

import com.example.mtgcards.mtg.domain.Card

data class CardScreenState(
    val card: Card = Card(
        name = "",
        image = "",
        set = "",
        manaCost = "",
        oracleText = ""
    )
)
