package com.example.mtgcards.mtg.presentation.cardScreen.models

import com.example.mtgcards.mtg.domain.Card

data class CardUI (
    val name: String,
    val manaCost: List<Char>,
    val oracleText: String,
    val setName: String,
    val image: String?
)

fun Card.toCardUi(): CardUI {
    return CardUI(
        name = name,
        manaCost = manaToList(manaCost),
        image = image,
        setName = set,
        oracleText = oracleText
    )
}

private fun manaToList(mana: String): List<Char> {
    val manaList = mutableListOf<Char>()
    for (i in mana.indices) {
        if (mana[i] == '{') manaList.add(mana[i+1])
    }

    return manaList
}