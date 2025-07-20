package com.example.virtualcatapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.virtualcatapp.ui.screens.*

@Composable
fun AppNavigation(navController: NavHostController, catViewModel: CatViewModel) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController, catViewModel) }
        composable("food") { FoodScreen(navController, catViewModel) }
        composable("game") { GameScreen(navController, catViewModel) }
        composable("sleep") { SleepScreen(navController, catViewModel) }
    }
}
