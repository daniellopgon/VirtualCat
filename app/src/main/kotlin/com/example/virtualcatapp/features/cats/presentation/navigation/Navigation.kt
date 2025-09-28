package com.example.virtualcatapp.features.cats.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.virtualcatapp.features.cats.presentation.screens.food.FoodScreen
import com.example.virtualcatapp.features.cats.presentation.screens.game.GameScreen
import com.example.virtualcatapp.features.cats.presentation.screens.home.HomeScreen
import com.example.virtualcatapp.features.cats.presentation.screens.sleep.SleepScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("food") {
            FoodScreen(navController)
        }
        composable("game") {
            GameScreen(navController)
        }
        composable("sleep") {
            SleepScreen(navController)
        }
    }
}