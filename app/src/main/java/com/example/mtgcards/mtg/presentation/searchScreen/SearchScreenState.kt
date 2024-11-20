package com.example.mtgcards.mtg.presentation.searchScreen

import com.example.mtgcards.mtg.presentation.shared.models.CardUi

data class SearchScreenState(
    val searchString: String = "",
    val isLoading: Boolean = false,
    val searchedCards: MutableList<CardUi> = mutableListOf(),
    val imagesUris: MutableList<String> = mutableListOf()
)
