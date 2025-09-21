package com.example.virtualcatapp.presentation.presentation.di.screens.sleep

import androidx.compose.runtime.mutableStateOf
import com.example.virtualcatapp.presentation.presentation.di.models.CatUiState

class SleepViewModel {
    var catState = mutableStateOf(CatUiState())
        private set

    fun sleepWithCat() {
        catState.value = catState.value.copy(
            happiness = (catState.value.happiness - 3).coerceAtMost(10),
            energy = (catState.value.energy + 6).coerceAtLeast(0)
        )
    }
}