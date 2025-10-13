package com.example.virtualcatapp.features.cats.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.virtualcatapp.features.cats.data.local.CatMemLocalDataSource
import com.example.virtualcatapp.features.cats.data.local.CatXmlLocalDataSource
import com.example.virtualcatapp.features.cats.data.repository.CatDataRepository
import com.example.virtualcatapp.features.cats.domain.usecase.GetCatUseCase
import com.example.virtualcatapp.features.cats.presentation.navigation.AppNavigation
import com.example.virtualcatapp.features.cats.presentation.screens.home.HomeViewModel
import com.example.virtualcatapp.features.cats.presentation.theme.VirtualCatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val catDataRepository = CatDataRepository(
            CatMemLocalDataSource(),
            CatXmlLocalDataSource(applicationContext)
        )
        val getCatUseCase = GetCatUseCase(catDataRepository)
        val homeViewModel = HomeViewModel(getCatUseCase)

        setContent {
            VirtualCatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController, homeViewModel)
                }
            }
        }
    }
}