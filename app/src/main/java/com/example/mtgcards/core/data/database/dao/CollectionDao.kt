package com.example.mtgcards.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mtgcards.core.domain.CardsCollection

@Dao
interface CollectionDao {
    @Query("SELECT * FROM cards_collection")
    suspend fun getCollection(): List<CardsCollection>

    @Insert
    suspend fun insertCardToCollection(card: CardsCollection)

    @Query("UPDATE cards_collection SET count = count + 1 WHERE cardName =:name")
    suspend fun updateCardCount(name: String)
}