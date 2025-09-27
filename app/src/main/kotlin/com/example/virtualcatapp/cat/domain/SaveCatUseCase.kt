package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.exceptions.CatAlreadyExistsException
import com.example.virtualcatapp.cat.domain.repository.CatRepository

class SaveCatUseCase(
    val catRepository: CatRepository,
    val catExistUseCase : CatExistUseCase
) {

    operator fun invoke(cat: Cat) {
        if (cat.name.isEmpty() || cat.name.isBlank()){
            throw IllegalArgumentException("The name cannot empty")
        }
        if (catExistUseCase(cat)){
            throw CatAlreadyExistsException("The id already exist")
        }
        catRepository.saveCat(cat)
    }
}