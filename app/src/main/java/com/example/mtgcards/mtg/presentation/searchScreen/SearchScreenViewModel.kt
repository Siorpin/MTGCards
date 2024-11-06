package com.example.mtgcards.mtg.presentation.searchScreen

import android.util.Log
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.R
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.mtg.presentation.searchScreen.models.CardUi
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

    fun updateText(newText: String) {
        _state.update { it.copy(searchString = newText) }
    }

    fun searchCards(searchedString: String) {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = BuildApiResponse.scryfallApi.searchCards(searchedString)

                val newCards = response.data.map { card ->
                    val imageUrl = card.imageUri?.image
                    CardUi(
                        name = card.name,
                        image = imageUrl
                    )
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