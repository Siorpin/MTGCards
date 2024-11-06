package com.example.mtgcards.mtg.presentation.cardScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.mtg.domain.Card
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardScreenViewModel(cardName: String): ViewModel() {
    private val _state = MutableStateFlow(CardScreenState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CardScreenState()
    )

    init {
        fetchCardInfo(cardName)
    }

    private fun fetchCardInfo(cardName: String) {
        viewModelScope.launch {
            try {
                val response = BuildApiResponse.scryfallApi.getSingleCard(cardName)
                _state.update { it.copy(card = Card(
                    name = response.name,
                    image = response.imageUris.image,
                    manaCost = response.manaCost,
                    oracleText = response.oracleText,
                    set = response.setName
                ))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}