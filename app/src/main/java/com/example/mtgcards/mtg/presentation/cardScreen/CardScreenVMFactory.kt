package com.example.mtgcards.mtg.presentation.cardScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CardScreenVMFactory(private val name: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((CardScreenViewModel::class.java))) {
            return CardScreenViewModel(name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}