package com.example.virtualcatapp.presentation.presentation.di.screens.food

import androidx.compose.runtime.mutableStateOf
import com.example.virtualcatapp.presentation.presentation.di.models.CatUiState

class FoodViewModel {
    var catState = mutableStateOf(CatUiState())
        private set

    fun feedCat() {
        catState.value = catState.value.copy(
            hunger = (catState.value.hunger - 3).coerceAtLeast(0),
            happiness = (catState.value.happiness + 1).coerceAtMost(10)
        )
    }
}