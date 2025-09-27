package com.example.virtualcatapp.presentation.presentation.di.screens.sleep

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.virtualcatapp.cat.presentation.screens.sleep.SleepViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepScreen(
    navController: NavController,
    sleepViewModel: SleepViewModel = viewModel()
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Dormir") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Aquí puedes dormir a tu gato")
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                sleepViewModel.sleepWithCat()
                navController.navigate("home")
            }) {
                Text("Dormir y volver")
            }

            Button(onClick = { navController.navigate("home") }) {
                Text("Volver al Inicio")
            }
        }
    }
}