package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.repository.CatRepository

class PlayWithCatUseCase(
    private val repository: CatRepository
) {
    operator fun invoke() {
        val currentCat = repository.getCat()
        val updatedCat = currentCat.copy(
            happiness = (currentCat.happiness + 2).coerceAtMost(10),
            energy = (currentCat.energy - 3).coerceAtLeast(0),
            hunger = (currentCat.hunger + 2).coerceAtMost(10)
        )
        repository.updateCat(updatedCat)
    }
}