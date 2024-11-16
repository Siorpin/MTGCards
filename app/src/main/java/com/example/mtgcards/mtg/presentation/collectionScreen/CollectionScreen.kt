package com.example.mtgcards.mtg.presentation.collectionScreen

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mtgcards.MainActivity
import com.example.mtgcards.core.data.database.AppDatabase
import com.example.mtgcards.core.data.database.dao.CollectionDao
import com.example.mtgcards.mtg.presentation.collectionScreen.components.CollectionScreenHeader
import com.example.mtgcards.mtg.presentation.collectionScreen.components.CollectionStatus

@Composable
fun CollectionScreen(
    database: AppDatabase,
    modifier: Modifier = Modifier
) {

    val viewModel = ViewModelProvider(
        ViewModelStore(),
        CollectionVMFactory(database.collectionDao())
    )[CollectionScreenViewModel::class.java]
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CollectionScreenHeader()
        Spacer(modifier = Modifier.height(30.dp))
        CollectionStatus(state.cards)
    }
}