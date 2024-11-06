package com.example.mtgcards.mtg.presentation.bottomBar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class BottomBarViewModel: ViewModel() {
    private val _state = MutableStateFlow(BottomBarState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = BottomBarState()
    )

    fun toggleEnabled() {
        _state.update { it.copy(isEnabled = !state.value.isEnabled) }
    }
}