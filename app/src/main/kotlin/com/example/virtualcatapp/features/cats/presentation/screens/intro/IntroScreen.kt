package com.example.virtualcatapp.features.cats.presentation.screens.intro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun IntroScreen(
    navController: NavController,
    introViewModel: IntroViewModel = viewModel()
) {

    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Crea tu gato")
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") }
        )
        Button(onClick = {
            introViewModel.saveCat(name)
            navController.navigate("home")
        }) {
            Text("Guardar")
        }
    }
}