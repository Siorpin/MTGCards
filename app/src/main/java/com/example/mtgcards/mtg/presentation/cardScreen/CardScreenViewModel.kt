package com.example.mtgcards.mtg.presentation.cardScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.database.dao.CollectionDao
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.core.domain.CardsCollection
import com.example.mtgcards.mtg.data.mappers.toCard
import com.example.mtgcards.mtg.presentation.cardScreen.models.toCardUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardScreenViewModel(cardName: String, private val repository: CollectionDao): ViewModel() {
    private val _state = MutableStateFlow(CardScreenState())

    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CardScreenState()
    )

    init {
        fetchCardInfo(cardName)
    }

    fun insertCard(cardName: String) {
        viewModelScope.launch {
            if (checkIfCardInCollection(cardName)) {
                repository.updateCardCount(cardName)
            }
            else {
                repository.insertCardToCollection(CardsCollection(
                    cardName = cardName,
                    count = 1
                ))
            }
        }
    }

    private suspend fun checkIfCardInCollection(cardName: String): Boolean {
        var returnedValue = false

        val cardsList = repository.getCollection()

        cardsList.forEach{ item ->
            if (item.cardName == cardName) returnedValue = true
        }
        return returnedValue
    }

    private fun fetchCardInfo(cardName: String) {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = BuildApiResponse.scryfallApi.getSingleCard(cardName).checkIfHasFaces() // <---- error

                Log.d("resp", response.toString())

                _state.update {
                    it.copy(card = response[0].toCard().toCardUi())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            _state.update { it.copy(isLoading = false) }
        }
    }
}