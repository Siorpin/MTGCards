package com.example.mtgcards.core.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "decks")
data class Decks(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val deckName: String = "",
    val cards: String = ""
)
