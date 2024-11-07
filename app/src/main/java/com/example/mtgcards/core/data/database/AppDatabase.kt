package com.example.mtgcards.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mtgcards.core.data.database.dao.CollectionDao

@Database(entities = [Collection::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun collectionDao(): CollectionDao

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