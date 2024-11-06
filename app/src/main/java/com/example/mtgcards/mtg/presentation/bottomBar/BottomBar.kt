package com.example.mtgcards.mtg.presentation.bottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mtgcards.core.presentation.buttonList
import com.example.mtgcards.mtg.presentation.bottomBar.components.BottomBarButton
import com.example.mtgcards.ui.theme.MTGCardsTheme

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // TODO: ogarnac znikanie bottombaru
    val viewModel: BottomBarViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route

    val buttonList = buttonList(navController, currentRoute)
    if (state.isEnabled) {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                buttonList.forEach { button ->
                    BottomBarButton(
                        bottomBarUi = button,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun BottomAppBarPreview(modifier: Modifier = Modifier) {
    MTGCardsTheme {
        Scaffold(bottomBar = {BottomBar(navController = rememberNavController())}) { pd ->
            Surface(modifier = Modifier
                .padding(pd)
                .fillMaxSize()) {  }
        }
    }
}