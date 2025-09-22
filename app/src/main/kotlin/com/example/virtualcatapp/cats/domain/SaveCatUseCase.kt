package com.example.virtualcatapp.cats.domain

import com.example.virtualcatapp.cats.domain.repository.CatRepository

class SaveCatUseCase(val catRepository: CatRepository) {

    suspend operator fun invoke(cat: Cat) {
        catRepository.saveCat(cat)
    }
}