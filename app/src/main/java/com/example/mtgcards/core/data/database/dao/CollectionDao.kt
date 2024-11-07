package com.example.mtgcards.core.data.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CollectionDao {
    @Query("SELECT * FROM collection")
    suspend fun getCollection()
}