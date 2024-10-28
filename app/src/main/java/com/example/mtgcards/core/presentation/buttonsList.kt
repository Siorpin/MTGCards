package com.example.mtgcards.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.mtgcards.R
import com.example.mtgcards.core.navigation.Screen
import com.example.mtgcards.mtg.presentation.bottomBar.models.BottomBarUi

@Composable
fun buttonList(navController: NavController, currentRoute: String?): List<BottomBarUi> {
    val bottomBarButtonsList = listOf(
        BottomBarUi(
            name = Screen.Home.route,
            icon = Icons.Default.Home,
            isCurrentPage = currentRoute == "home"
        ){
            navController.navigate(Screen.Home.route)
        },
        BottomBarUi(
            name = Screen.Search.route,
            icon = Icons.Default.Search,
            isCurrentPage = currentRoute == "search"
        ){
            navController.navigate(Screen.Search.route)
        },
        BottomBarUi(
            name = Screen.Collection.route,
            icon = ImageVector.vectorResource(R.drawable.box),
            isCurrentPage = currentRoute == "collection"
        ){
            navController.navigate(Screen.Collection.route)
        },
        BottomBarUi(
            name = Screen.Decks.route,
            icon = ImageVector.vectorResource(R.drawable.cards_icon),
            isCurrentPage = currentRoute == "decks"
        ){
            navController.navigate(Screen.Decks.route)
        }
    )

    return bottomBarButtonsList
}