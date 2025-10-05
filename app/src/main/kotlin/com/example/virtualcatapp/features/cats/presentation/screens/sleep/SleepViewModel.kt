package com.example.virtualcatapp.features.cats.presentation.screens.sleep

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.presentation.shared.SharedCatState


class SleepViewModel: ViewModel() {
    val catState = SharedCatState.catState

    fun sleepWithCat() {
        val currentState = catState.value
        SharedCatState.updateCatState(
            currentState.copy(
                happiness = (currentState.happiness - 1).coerceAtLeast(0),
                energy = (currentState.energy + 6).coerceAtMost(10)
            )
        )
    }
}