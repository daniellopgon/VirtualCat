package com.example.virtualcatapp.features.cats.presentation.screens.game

import com.example.virtualcatapp.features.cats.presentation.shared.SharedCatState


class GameViewModel {
    val catState = SharedCatState.catState

    fun playWithCat() {
        val currentState = catState.value
        SharedCatState.updateCatState(
            currentState.copy(
                happiness = (currentState.happiness + 2).coerceAtMost(10),
                energy = (currentState.energy - 3).coerceAtLeast(0),
                hunger = (currentState.hunger + 2).coerceAtMost(10) // Nota: debería ser coerceAtMost
            )
        )
    }
}