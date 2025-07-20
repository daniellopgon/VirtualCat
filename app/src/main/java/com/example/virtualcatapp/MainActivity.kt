package com.example.virtualcatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.virtualcatapp.ui.AppNavigation
import androidx.activity.viewModels
import com.example.virtualcatapp.ui.CatViewModel


class MainActivity : ComponentActivity() {
    private val catViewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colorScheme.background) {
                AppNavigation(navController,catViewModel)
            }
        }
    }
}
