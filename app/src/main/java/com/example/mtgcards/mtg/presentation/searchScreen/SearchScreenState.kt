package com.example.mtgcards.mtg.presentation.searchScreen

import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi

data class SearchScreenState(
    val searchString: String = "",
    val searchedCards: MutableList<CardUi> = mutableListOf(
//        CardUi(name="Elminster's Simulacrum", image="https://cards.scryfall.io/border_crop/front/3/5/351a6e6a-758d-417d-82c9-2c78db37d91e.jpg?1674135511"),
//        CardUi(name="Sarpadian Simulacrum", image="https://cards.scryfall.io/border_crop/front/0/9/099c65d5-9dd3-41d3-9102-3f6cb30c7b8e.jpg?1717012301"),
//        CardUi(name="Simian Simulacrum", image="https://cards.scryfall.io/border_crop/front/c/8/c85e2a35-cb55-434c-bbd7-54c3438345c1.jpg?1674421732"),
//        CardUi(name="Simulacrum", image="https://cards.scryfall.io/border_crop/front/7/c/7c23232c-a264-4df9-824b-4111a5c6524c.jpg?1559600479"),
//        CardUi(name="Simulacrum Synthesizer", image="https://cards.scryfall.io/border_crop/front/a/a/aaa05ad1-5cda-4edd-b6bf-562ae3e5011a.jpg?1712352732"),
//        CardUi(name="Snowborn Simulacra", image="https://cards.scryfall.io/border_crop/front/0/d/0d1a9b59-f26a-456f-8606-09cfaee2fe69.jpg?1680959950"),
//        CardUi(name="Soldevi Simulacrum", image="https://cards.scryfall.io/border_crop/front/9/d/9d60f16a-0a67-4ad7-8dad-ee97cd01fb89.jpg?1562869980"),
//        CardUi(name="Solemn Simulacrum", image="https://cards.scryfall.io/border_crop/front/5/3/5383f45e-3da2-40fb-beee-801448bbb60f.jpg?1730489562"),
//        CardUi(name="Tezzeret's Simulacrum", image="https://cards.scryfall.io/border_crop/front/7/e/7eacfeec-a341-45bc-bf95-e3df0094505a.jpg?1562924865"),
//        CardUi(name="Vault 112: Sadistic Simulation", image="https://cards.scryfall.io/border_crop/front/0/a/0a0acee2-f6dc-4e92-937b-01e2c07adc55.jpg?1709409640"),
    ),
    val imagesUris: MutableList<String> = mutableListOf()
)
