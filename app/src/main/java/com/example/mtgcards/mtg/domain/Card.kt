package com.example.mtgcards.mtg.domain

data class Card (
    val name: String,
    val image: Map<String, String?>,
    val manaCost: String,
    val oracleText: String,
    val set: String,
    val colorIdentity: List<String>,
    val legalities: Map<String, String>
)
