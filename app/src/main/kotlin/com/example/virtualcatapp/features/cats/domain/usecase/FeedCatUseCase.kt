package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.repository.CatRepository

class FeedCatUseCase(
    private val repository: CatRepository
) {
    operator fun invoke() {
        val currentCat = repository.getCat()
        val updatedCat = currentCat.copy(
            hunger = (currentCat.hunger + 3).coerceAtLeast(0),
            happiness = (currentCat.happiness + 1).coerceAtMost(10)
        )
        repository.updateCat(updatedCat)
    }
}