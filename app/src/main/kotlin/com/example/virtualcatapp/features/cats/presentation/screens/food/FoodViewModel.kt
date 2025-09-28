package com.example.virtualcatapp.features.cats.presentation.screens.food

import com.example.virtualcatapp.features.cats.presentation.shared.SharedCatState


class FoodViewModel {
    val catState = SharedCatState.catState

    fun feedCat() {
        val currentState = catState.value
        SharedCatState.updateCatState(
            currentState.copy(
                hunger = (currentState.hunger - 3).coerceAtLeast(0),
                happiness = (currentState.happiness + 1).coerceAtMost(10)
            )
        )
    }
}