package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.repository.CatRepository

class SaveCatUseCase(val catRepository: CatRepository) {

    operator fun invoke(cat: Cat) {
        if (cat.name.isEmpty() || cat.name.isBlank()){
            throw IllegalArgumentException("The name cannot empty")
        }
        catRepository.saveCat(cat)
    }
}