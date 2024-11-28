package com.example.mtgcards.mtg.presentation.cardScreen

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
            CardScreenHeader(
                onBackClick = onBackClick,
                onPlusClick = { viewModel.insertCard(cardName) },
                cardName = state.card.name
            )
            Spacer(modifier = Modifier.height(6.dp))
            CardScreenImage(
                cardName = state.card.name,
                imageUri = state.card.image["art_crop"]
            )
            Spacer(modifier = Modifier.height(15.dp))
            CardInfoPanel(
                cardName = state.card.name,
                oracleText = state.card.oracleText
            )
        }

    }
}