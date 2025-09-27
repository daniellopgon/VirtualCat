package com.example.virtualcatapp.presentation.presentation.di.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.virtualcatapp.presentation.presentation.di.screens.food.FoodScreen
import com.example.virtualcatapp.presentation.presentation.di.screens.game.GameScreen
import com.example.virtualcatapp.presentation.presentation.di.screens.home.HomeScreen
import com.example.virtualcatapp.presentation.presentation.di.screens.sleep.SleepScreen

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