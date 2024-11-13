package com.example.mtgcards.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mtgcards.core.data.database.dao.CollectionDao
import com.example.mtgcards.core.data.database.dao.DecksDao
import com.example.mtgcards.core.domain.Decks
import com.example.mtgcards.core.domain.CardsCollection

@Database(entities = [CardsCollection::class, Decks::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun collectionDao(): CollectionDao
    abstract fun decksDao(): DecksDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = "app_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}