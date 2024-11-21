package com.example.mtgcards.mtg.presentation.collectionScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgcards.core.data.database.dao.CollectionDao
import com.example.mtgcards.core.data.networking.BuildApiResponse
import com.example.mtgcards.mtg.data.mappers.toCard
import com.example.mtgcards.mtg.domain.Card
import com.example.mtgcards.mtg.domain.ColorIdentity
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

    private fun loadCollection() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val collection = repository.getCollection()
            val cardList: MutableList<Card> = mutableListOf()
            val cardsWithCount: MutableList<Pair<Card, Int>> = mutableListOf()

            collection.forEach{ el ->
                val response = BuildApiResponse.scryfallApi.getSingleCard(el.cardName)
                cardList.add(response.toCard())
                cardsWithCount.add(response.toCard() to el.count)
            }
            _state.update { it.copy(
                isLoading = false,
                cards = cardList,
                colorsPercentage = calculatePercents(cardsWithCount)
            ) }
            Log.d("count", collection.toString())
        }
    }

    private fun calculatePercents(cardsList: MutableList<Pair<Card, Int>>): MutableMap<ColorIdentity, Float> {
        val colorsPercentage = mutableMapOf(
            ColorIdentity.RED to 0f,
            ColorIdentity.WHITE to 0f,
            ColorIdentity.BLACK to 0f,
            ColorIdentity.BLUE to 0f,
            ColorIdentity.COLORLESS to 0f,
            ColorIdentity.MULTICOLORED to 0f,
        )

        cardsList.forEach{ element ->
            val card = element.first
            val count = element.second

            when(card.colorIdentity.size) {
                0 -> {
                    colorsPercentage.merge(ColorIdentity.COLORLESS, 1f + count) { old, value ->
                        old + value
                    }
                }
                1 -> {
                    when(card.colorIdentity[0]) {
                        "W" -> {
                            colorsPercentage.merge(ColorIdentity.WHITE, 1f + count) { old, value ->
                                old + value
                            }
                        }
                        "B" -> {
                            colorsPercentage.merge(ColorIdentity.BLACK, 1f + count) { old, value ->
                                old + value
                            }
                        }
                        "R" -> {
                            colorsPercentage.merge(ColorIdentity.RED, 1f + count) { old, value ->
                                old + value
                            }
                        }
                        "U" -> {
                            colorsPercentage.merge(ColorIdentity.BLUE, 1f + count) { old, value ->
                                old + value
                            }
                        }
                        "G" -> {
                            colorsPercentage.merge(ColorIdentity.GREEN, 1f + count) { old, value ->
                                old + value
                            }
                        }
                    }
                }
                else -> {
                    colorsPercentage.merge(ColorIdentity.MULTICOLORED, 1f + count) { old, value ->
                        old + value
                    }
                }
            }
        }


        var cardsSum = 0f
        cardsList.forEach{ value ->
            cardsSum += value.second
        }

        updateCardsAmount(cardsSum.toInt())

        colorsPercentage.keys.forEach{ key ->
            colorsPercentage.merge(key, cardsSum) { old, value ->
                old / value
            }
        }

        return colorsPercentage
    }
    private fun updateCardsAmount(newValue: Int) {
        _state.update { it.copy(cardsAmount = newValue) }
    }
}

