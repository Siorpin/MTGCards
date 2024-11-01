package com.example.mtgcards.mtg.presentation.searchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.networking.BuildCardObject
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

    fun fetchCardSImage() {
        viewModelScope.launch {
            try {
                _state.value.searchedCards.forEach{ card ->
                    val response = BuildCardObject.scryfallApi.getCardByName(card.name)
                    _state.value.imagesUris.add(response.imageUris.normalImage)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}