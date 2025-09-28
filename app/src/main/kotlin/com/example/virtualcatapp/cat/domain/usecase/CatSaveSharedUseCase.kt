package com.example.virtualcatapp.cat.domain.usecase

import com.example.virtualcatapp.cat.domain.models.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository

class CatSaveSharedUseCase(private val catRepository: CatRepository) {

    fun execute(cat: Cat) {
        catRepository.saveCatShared(cat)
    }
}