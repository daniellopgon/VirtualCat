package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.repository.CatRepository

class GetCatUseCase(
    private val repository: CatRepository
) {
    operator fun invoke() = repository.observeCat()
}