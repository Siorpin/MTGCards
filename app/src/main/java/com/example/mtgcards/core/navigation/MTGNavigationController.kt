package com.example.mtgcards.core.navigation

import android.net.Uri
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mtgcards.core.data.database.AppDatabase
import com.example.mtgcards.mtg.presentation.cardScreen.CardScreen
import com.example.mtgcards.mtg.presentation.collectionScreen.CollectionScreen
import com.example.mtgcards.mtg.presentation.decksScreen.DecksScreen
import com.example.mtgcards.mtg.presentation.homeScreen.HomeScreen
import com.example.mtgcards.mtg.presentation.searchScreen.SearchScreen

@Composable
fun MTGNavigationController(
    modifier: Modifier = Modifier,
    database: AppDatabase,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
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
            SearchScreen(navController)
        }
        composable(
            route = Screen.Collection.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            CollectionScreen(
                database = database,
                navController = navController
            )
        }
        composable(
            route = Screen.Decks.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            DecksScreen()
        }
        composable(
            route = "${Screen.CardScreen.route}/{name}",
            enterTransition = { fadeIn(
                animationSpec = tween(500)
            ) },
            exitTransition = { ExitTransition.None }
        ) { navBackStackEntry ->
            val cardName = Uri.decode(navBackStackEntry.arguments?.getString("name"))
            cardName?.let { name ->
                CardScreen(
                    cardName = name,
                    database = database,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}