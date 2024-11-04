package com.example.mtgcards.mtg.presentation.searchScreen.models

import com.example.mtgcards.mtg.domain.Card

data class CardUi(
    val name: String,
    val image: String?
)

fun Card.toUi(): CardUi {
    return CardUi(
        name = name,
        image = image
    )
}