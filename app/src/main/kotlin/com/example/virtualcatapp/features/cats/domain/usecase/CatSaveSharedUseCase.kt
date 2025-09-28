package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository


class CatSaveSharedUseCase(private val catRepository: CatRepository) {

    fun execute(cat: Cat) {
        catRepository.saveCatShared(cat)
    }
}