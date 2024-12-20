package com.example.mtgcards.mtg.presentation.searchScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.mtg.presentation.shared.models.CardUi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SearchScreenState()
    )

    private var currentJob: Job? = null

    fun updateText(newText: String) {
        _state.update { it.copy(searchString = newText) }
    }

    fun searchCards(searchedString: String) {
        _state.update { it.copy(isLoading = true) }
        currentJob?.cancel()

        currentJob = viewModelScope.launch {
            try {
                val response = BuildApiResponse.scryfallApi.searchCards(searchedString)

                val newCards = response.data.map { item ->
                    val card = item.checkIfSearchHasFaces()
                    val imageUrl = card.imageUri?.image
                    card.name?.let {
                        CardUi(
                            name = it,
                            image = imageUrl
                        )
                    }
                }.toMutableList()

                _state.update {
                    it.copy(searchedCards = newCards)
                }

                Log.d("",newCards.toString())
            } catch (e: Exception) {
                clearCardList()
                e.printStackTrace()
            }
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun clearCardList() {
        _state.update { it.copy(searchedCards = mutableListOf()) }
    }

}