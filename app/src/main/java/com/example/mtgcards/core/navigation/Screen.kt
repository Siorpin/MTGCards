package com.example.mtgcards.core.navigation

private object Route{
    const val HOME = "home"
    const val SEARCH = "search"
    const val COLLECTION = "collection"
    const val DECKS = "decks"
}

sealed class Screen(val route: String) {
    data object Home: Screen(Route.HOME)
    data object Search: Screen(Route.SEARCH)
    data object Collection: Screen(Route.COLLECTION)
    data object Decks: Screen(Route.DECKS)
}