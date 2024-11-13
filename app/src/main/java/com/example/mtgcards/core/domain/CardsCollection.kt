package com.example.mtgcards.core.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards_collection")
data class CardsCollection (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cardName: String,
    val count: Int
)