/*package com.example.virtualcatapp.presentation.presentation.di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.virtualcatapp.presentation.presentation.di.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    private val catViewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colorScheme.background) {
                AppNavigation(navController, catViewModel)
            }
        }
    }
}
 */