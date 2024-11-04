package com.example.mtgcards.mtg.presentation.searchScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.networking.BuildCardObject
import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class SearchScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SearchScreenState()
    )

    fun updateText(newText: String) {
        _state.update { it.copy(searchString = newText) }
    }

    fun searchCards(searchedString: String) {
        viewModelScope.launch {
            try {
                val response = BuildCardObject.scryfallApi.getCardByName(searchedString)
                var newCards = mutableListOf<CardUi>()
                if (response.totalCards <= 30) {
                    newCards = response.data.map{ card ->
                        CardUi(
                            name = card.name,
                            image = card.imageUri.image
                        )
                    }.toMutableList()
                }
                else {
                    for(i in 0..30) {
                        newCards.add(
                            CardUi(
                                response.data[i].name,
                                response.data[i].imageUri.image
                            )
                        )
                    }
                }

                _state.update {
                    it.copy(searchedCards = newCards)
                }
            } catch (e: Exception) {
                clearCardList()
                e.printStackTrace()
            }
        }
    }

    fun clearCardList() {
        _state.update { it.copy(searchedCards = mutableListOf()) }
    }

}