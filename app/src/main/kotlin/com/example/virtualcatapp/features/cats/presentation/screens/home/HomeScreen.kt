package com.example.virtualcatapp.features.cats.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.virtualcatapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val catState by homeViewModel.catState

    val catImageRes = when {
        catState.energy <= 3 -> R.drawable.cat_sleeping
        catState.happiness <= 3 -> R.drawable.cat_sad
        catState.happiness >= 7 -> R.drawable.cat_happy
        else -> R.drawable.cat_happy
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi Gato Virtual") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Image(
                    painter = painterResource(id = catImageRes),
                    contentDescription = "Estado del gato",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "Estado del Gato",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Hambre: ${catState.hunger}/10")
                    LinearProgressIndicator(
                        progress = catState.hunger / 10f,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text("Felicidad: ${catState.happiness}/10")
                    LinearProgressIndicator(
                        progress = catState.happiness / 10f,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text("Energía: ${catState.energy}/10")
                    LinearProgressIndicator(
                        progress = catState.energy / 10f,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("food") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Dar de comer")
            }

            Button(
                onClick = { navController.navigate("game") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Jugar")
            }

            Button(
                onClick = { navController.navigate("sleep") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Dormir")
            }
        }
    }
}