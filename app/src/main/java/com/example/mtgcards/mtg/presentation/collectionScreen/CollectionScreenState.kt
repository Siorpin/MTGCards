package com.example.mtgcards.mtg.presentation.collectionScreen

import com.example.mtgcards.mtg.domain.Card
import com.example.mtgcards.mtg.domain.ColorIdentity

data class CollectionScreenState(
    val cards: List<Card> = listOf(),
    val isLoading: Boolean = false,
    val cardsAmount: Int = 0,
    val colorsPercentage: MutableMap<ColorIdentity, Float> = mutableMapOf(
        ColorIdentity.RED to 0f,
        ColorIdentity.WHITE to 0f,
        ColorIdentity.BLACK to 0f,
        ColorIdentity.BLUE to 0f,
        ColorIdentity.COLORLESS to 0f,
        ColorIdentity.MULTICOLORED to 0f,
    )
)
