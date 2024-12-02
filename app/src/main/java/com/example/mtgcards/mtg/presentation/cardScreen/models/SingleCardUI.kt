package com.example.mtgcards.mtg.presentation.cardScreen.models

import com.example.mtgcards.mtg.domain.Card

data class SingleCardUI (
    val name: String,
    val manaCost: List<String>,
    val oracleText: String,
    val setName: String,
    val image: Map<String, String?>,
    val legalities: Map<String, String>
)

fun Card.toSingleCardUi(): SingleCardUI {
    return SingleCardUI(
        name = name,
        manaCost = manaToList(manaCost),
        image = image,
        setName = set,
        oracleText = oracleText,
        legalities = legalities
    )
}

private fun manaToList(mana: String): List<String> {
    val manaList = mutableListOf<String>()
    for (i in mana.indices) {
        var temp = ""
        if (mana[i] == '{') {
            var j = 1
            while (mana[i + j] != '}')  {
                temp += mana[i+j++]
            }
            manaList.add(temp)
        }
    }

    return manaList
}