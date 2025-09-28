package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.cats.domain.models.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository

class CatExistSharedUseCase(private val catRepository: CatRepository) {

    fun execute(cat: Cat): Boolean {
        return catRepository.existCatShared(cat)
    }
}