package com.example.mtgcards.mtg.data.mappers

import com.example.mtgcards.core.data.networking.responses.SingleCardResponse
import com.example.mtgcards.mtg.domain.Card

fun SingleCardResponse.toCard(): Card {
    return Card(
        name = name,
        set = setName,
        colorIdentity = colorIdentity,
        image = imageUris.toMap(),
        manaCost = manaCost,
        oracleText = oracleText
    )
}