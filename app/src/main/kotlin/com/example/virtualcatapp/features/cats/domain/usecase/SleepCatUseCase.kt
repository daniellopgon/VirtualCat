package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.repository.CatRepository

class SleepCatUseCase(
    private val repository: CatRepository
) {
    operator fun invoke() {
        val currentCat = repository.getCat()
        val updatedCat = currentCat.copy(
            happiness = (currentCat.happiness - 1).coerceAtLeast(0),
            energy = (currentCat.energy + 6).coerceAtMost(10)
        )
        repository.updateCat(updatedCat)
    }
}