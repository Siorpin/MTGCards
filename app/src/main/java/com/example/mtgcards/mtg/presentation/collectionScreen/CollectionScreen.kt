package com.example.mtgcards.mtg.presentation.collectionScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mtgcards.R
import com.example.mtgcards.core.data.database.AppDatabase
import com.example.mtgcards.mtg.presentation.collectionScreen.components.CollectionScreenGrid
import com.example.mtgcards.mtg.presentation.shared.components.ScreenHeader

@Composable
fun CollectionScreen(
    database: AppDatabase,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val viewModel: CollectionScreenViewModel = remember {
        CollectionScreenViewModel(repository = database.collectionDao())
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column {
            ScreenHeader(stringResource(R.string.collection))
            Spacer(modifier = Modifier.height(30.dp))
            CollectionScreenGrid(
                navController = navController,
                itemsList = state.cards,
                colorsPercentage = state.colorsPercentage,
                cardsAmount = state.cardsAmount
            )
        }
    }
}