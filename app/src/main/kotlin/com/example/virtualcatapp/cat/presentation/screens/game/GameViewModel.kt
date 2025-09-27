package com.example.virtualcatapp.presentation.presentation.di.screens.game

import androidx.compose.runtime.mutableStateOf
import com.example.virtualcatapp.presentation.presentation.di.models.CatUiState

class GameViewModel {
    var catState = mutableStateOf(CatUiState())
        private set

    fun playWithCat() {
        catState.value = catState.value.copy(
            happiness = (catState.value.happiness + 2).coerceAtMost(10),
            energy = (catState.value.energy - 3).coerceAtLeast(0),
            hunger = (catState.value.hunger + 2).coerceAtLeast(0)
        )
    }
}