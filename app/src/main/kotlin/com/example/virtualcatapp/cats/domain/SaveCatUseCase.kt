package com.example.virtualcatapp.cats.domain

class SaveCatUseCase(val catRepository: CatRepository) {

    operator fun invoke(cat: Cat) {
        catRepository.save(cat)
    }
}