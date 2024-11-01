package com.example.mtgcards.mtg.presentation.searchScreen

import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi

data class SearchScreenState(
    val searchString: String = "",
    val searchedCards: List<CardUi> = emptyList(),
    val imagesUris: MutableList<String> = mutableListOf()
)
