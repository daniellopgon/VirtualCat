package com.example.virtualcatapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.virtualcatapp.ui.CatViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController,catViewModel: CatViewModel) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(" Jugar ") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(" Aquí jugarás con tu gato ")
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                catViewModel.playWithCat()
                navController.navigate("home")
            }) {
                Text(" Jugar con el gato y volver ")
            }

            Button(onClick = { navController.navigate("home") }) {
                Text(" Volver al Inicio ")
            }
        }
    }
}
