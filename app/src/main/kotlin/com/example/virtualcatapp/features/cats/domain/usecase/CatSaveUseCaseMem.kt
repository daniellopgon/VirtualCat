package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.exceptions.CatAlreadyExistsException
import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository


class CatSaveUseCaseMem(
    val catRepository: CatRepository,
    val catExistUseCaseMem : CatExistUseCaseMem
) {

    operator fun invoke(cat: Cat) {
        if (cat.name.isEmpty() || cat.name.isBlank()){
            throw IllegalArgumentException("The name cannot empty")
        }
        if (catExistUseCaseMem(cat)){
            throw CatAlreadyExistsException("The id already exist")
        }
        catRepository.saveCatMem(cat)
    }
}