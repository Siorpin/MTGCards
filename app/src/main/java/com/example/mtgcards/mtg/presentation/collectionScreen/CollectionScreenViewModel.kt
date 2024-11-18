package com.example.mtgcards.mtg.presentation.collectionScreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.database.dao.CollectionDao
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.core.data.networking.ScryfallApi
import com.example.mtgcards.core.domain.CardsCollection
import com.example.mtgcards.mtg.data.mappers.toCard
import com.example.mtgcards.mtg.data.mappers.toMap
import com.example.mtgcards.mtg.domain.Card
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CollectionScreenViewModel(private val repository: CollectionDao): ViewModel() {
    private val _state = MutableStateFlow(CollectionScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CollectionScreenState()
    )

    init {
        loadCollection()
    }

    fun insetCard() {
        viewModelScope.launch {
            repository.insertCardToCollection(CardsCollection(
                cardName = "yorvo, Lord of Garenbrig",
                count = 4
            ))
        }
    }

    private fun loadCollection() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val collection = repository.getCollection()
            val cardList: MutableList<Card> = mutableListOf()

            collection.forEach{ el ->
                val response = BuildApiResponse.scryfallApi.getSingleCard(el.cardName)
                cardList.add(response.toCard())
            }
            _state.update { it.copy(isLoading = false, cards = cardList) }
        }
    }
}