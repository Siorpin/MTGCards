package com.example.mtgcards.mtg.data.mappers

import com.example.mtgcards.mtg.domain.Card
import com.example.mtgcards.mtg.presentation.shared.models.CardUi

fun Card.toCardUi(): CardUi {
    return CardUi(
        name = name,
        image = image["image"]
    )
}