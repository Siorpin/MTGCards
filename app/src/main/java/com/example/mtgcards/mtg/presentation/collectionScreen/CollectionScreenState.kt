package com.example.mtgcards.mtg.presentation.collectionScreen

import com.example.mtgcards.mtg.domain.Card

data class CollectionScreenState(
    val cards: List<Card> = listOf()
)
