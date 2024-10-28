package com.example.mtgcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mtgcards.core.navigation.MTGNavigationController
import com.example.mtgcards.mtg.presentation.bottomBar.BottomBar
import com.example.mtgcards.ui.theme.MTGCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MTGCardsTheme(
                dynamicColor = false
            ) {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(navController) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    MTGNavigationController(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}