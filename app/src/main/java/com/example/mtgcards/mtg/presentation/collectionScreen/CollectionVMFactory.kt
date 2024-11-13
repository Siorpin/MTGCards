package com.example.mtgcards.mtg.presentation.collectionScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mtgcards.core.data.database.dao.CollectionDao

class CollectionVMFactory(private val collectionDao: CollectionDao): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectionScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CollectionScreenViewModel(collectionDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}