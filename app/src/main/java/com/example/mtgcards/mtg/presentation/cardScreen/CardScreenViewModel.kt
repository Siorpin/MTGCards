package com.example.mtgcards.mtg.presentation.cardScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.mtg.data.mappers.toCard
import com.example.mtgcards.mtg.presentation.cardScreen.models.toCardUi
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
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = BuildApiResponse.scryfallApi.getSingleCard(cardName)
                Log.d("", response.colorIdentity.toString())
                _state.update { it.copy(card = response.toCard().toCardUi()) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            _state.update { it.copy(isLoading = false) }
        }
    }
}