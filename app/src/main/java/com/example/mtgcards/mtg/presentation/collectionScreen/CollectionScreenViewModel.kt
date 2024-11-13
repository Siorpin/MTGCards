package com.example.mtgcards.mtg.presentation.collectionScreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.database.dao.CollectionDao
import com.example.mtgcards.core.domain.CardsCollection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CollectionScreenViewModel(private val repository: CollectionDao): ViewModel() {
    private val _state = MutableStateFlow(CollectionScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CollectionScreenState()
    )

    fun insetCard() {
        viewModelScope.launch {
            repository.insertCardToCollection(CardsCollection(
                cardName = "blublu",
                count = 4
            ))
        }
    }

    fun loadCollection() {
        viewModelScope.launch {
            val x = repository.getCollection()
            Log.d("x: ", x.toString())
        }
    }
}