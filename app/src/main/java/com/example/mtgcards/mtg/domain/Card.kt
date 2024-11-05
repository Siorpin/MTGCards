package com.example.mtgcards.mtg.domain

data class Card (
    val name: String,
    val image: String?,
    val manaCost: String,
    val oracleText: String,
    val set: String
)
