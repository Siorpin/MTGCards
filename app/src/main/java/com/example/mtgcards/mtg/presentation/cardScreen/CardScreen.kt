package com.example.mtgcards.mtg.presentation.cardScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mtgcards.core.data.database.AppDatabase
import com.example.mtgcards.mtg.presentation.cardScreen.components.CardInfoPanel
import com.example.mtgcards.mtg.presentation.cardScreen.components.CardScreenHeader
import com.example.mtgcards.mtg.presentation.cardScreen.components.CardScreenImage
import com.example.mtgcards.mtg.presentation.cardScreen.components.MultiFacedCard
import com.example.mtgcards.mtg.presentation.cardScreen.components.SingleFacedCard

@Composable
fun CardScreen(
    cardName: String,
    database: AppDatabase,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: CardScreenViewModel = remember(cardName){
        CardScreenViewModel(cardName, database.collectionDao())
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
            .padding(6.dp)
    ) {
        if (state.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 500.dp)
            ) {
                CircularProgressIndicator()
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (state.multiFaces) MultiFacedCard(
                    state.cards,
                    onBackClick = onBackClick,
                    onPlusClick = { viewModel.insertCard(cardName) },
                    toggleImageZoom = { viewModel.toggleIsImageZoomed() },
                    isImageZoomed = state.isImageZoomed
                )
                else {
                    Log.d("state", state.cards.toString())
                    SingleFacedCard(
                        onBackClick = onBackClick,
                        onPlusClick = { viewModel.insertCard(cardName) },
                        card = state.cards.first(),
                        isImageZoomed = state.isImageZoomed,
                        toggleImageZoom = { viewModel.toggleIsImageZoomed() }
                    )
                }
            }
        }

    }
}