package com.example.virtualcatapp.presentation.presentation.di.screens.food

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.virtualcatapp.cat.presentation.screens.food.FoodViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodScreen(
    navController: NavController,
    foodViewModel: FoodViewModel = viewModel()
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Comida") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Aquí puedes alimentar a tu gato")
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                foodViewModel.feedCat()
                navController.navigate("home")
            }) {
                Text("Dar comida y volver")
            }

            Button(onClick = { navController.navigate("home") }) {
                Text("Volver al Inicio")
            }
        }
    }
}