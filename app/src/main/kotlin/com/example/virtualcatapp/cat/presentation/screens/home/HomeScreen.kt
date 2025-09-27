/*package com.example.virtualcatapp.presentation.presentation.di.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.virtualcatapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, catViewModel: CatViewModel) {
    val state = catViewModel.catState.value

    val imageRes = when {
        state.hunger >= 7 -> R.drawable.cat_sad
        state.energy <= 3 -> R.drawable.cat_sleeping
        else -> R.drawable.cat_happy
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(" Virtual Cat ") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = " Estado del gato ",
                    modifier = Modifier.size(200.dp)
                )
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(" Hambre ")
                    LinearProgressIndicator(progress = state.hunger / 10f)

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(" Energía ")
                    LinearProgressIndicator(progress = state.energy / 10f)

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(" Felicidad ")
                    LinearProgressIndicator(progress = state.happiness / 10f)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Button(onClick = { navController.navigate("food") }) {
                Text("Ir a Comida")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { navController.navigate("game") }) {
                Text("Ir a Jugar")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { navController.navigate("sleep") }) {
                Text("Ir a Dormir")
            }
        }
    }
}
 */
