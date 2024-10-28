package com.example.mtgcards.core.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mtgcards.mtg.presentation.collectionScreen.CollectionScreen
import com.example.mtgcards.mtg.presentation.decksScreen.DecksScreen
import com.example.mtgcards.mtg.presentation.homeScreen.HomeScreen
import com.example.mtgcards.mtg.presentation.searchScreen.SearchScreen

@Composable
fun MTGNavigationController(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            HomeScreen()
        }
        composable(
            route = Screen.Search.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            SearchScreen()
        }
        composable(
            route = Screen.Collection.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            CollectionScreen()
        }
        composable(
            route = Screen.Decks.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            DecksScreen()
        }
    }
}