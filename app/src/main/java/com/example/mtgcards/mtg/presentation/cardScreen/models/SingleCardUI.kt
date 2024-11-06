package com.example.mtgcards.mtg.presentation.cardScreen.models

import com.example.mtgcards.mtg.domain.Card

data class SingleCardUI (
    val name: String,
    val manaCost: List<Char>,
    val oracleText: String,
    val setName: String,
    val image: Map<String, String?>
)

fun Card.toCardUi(): SingleCardUI {
    return SingleCardUI(
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