package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.repository.CatRepository

class SaveCatUseCase(val catRepository: CatRepository) {

    operator fun invoke(cat: Cat) {
        catRepository.saveCat(cat)
    }
}