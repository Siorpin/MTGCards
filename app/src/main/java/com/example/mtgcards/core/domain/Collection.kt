package com.example.mtgcards.core.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collection")
data class Collection (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val cardName: String,
    val cont: Int
)