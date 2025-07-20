package com.example.virtualcatapp.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.example.virtualcatapp.ui.model.CatState

class CatViewModel : ViewModel() {

    var catState = mutableStateOf(CatState())
        private set

    fun feedCat() {
        catState.value = catState.value.copy(
            hunger = (catState.value.hunger - 3).coerceAtLeast(0),
            happiness = (catState.value.happiness + 1).coerceAtMost(10)
        )
    }

    fun playWithCat() {
        catState.value = catState.value.copy(
            happiness = (catState.value.happiness + 2).coerceAtMost(10),
            energy = (catState.value.energy - 3).coerceAtLeast(0),
            hunger = (catState.value.hunger + 2).coerceAtLeast(0)
        )
    }

    fun sleepWithCat() {
        catState.value = catState.value.copy(
            happiness = (catState.value.happiness - 3).coerceAtMost(10),
            energy = (catState.value.energy + 6).coerceAtLeast(0)
        )
    }
}