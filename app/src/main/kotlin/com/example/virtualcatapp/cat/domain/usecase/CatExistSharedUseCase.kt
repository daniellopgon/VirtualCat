package com.example.virtualcatapp.cat.domain.usecase

import com.example.virtualcatapp.cat.domain.models.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository

class CatExistSharedUseCase(private val catRepository: CatRepository) {

    fun execute(cat: Cat): Boolean {
        return catRepository.existCatShared(cat)
    }
}