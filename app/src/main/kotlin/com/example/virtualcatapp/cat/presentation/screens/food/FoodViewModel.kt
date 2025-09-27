package com.example.virtualcatapp.cat.presentation.screens.food

import com.example.virtualcatapp.cat.presentation.shared.SharedCatState

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