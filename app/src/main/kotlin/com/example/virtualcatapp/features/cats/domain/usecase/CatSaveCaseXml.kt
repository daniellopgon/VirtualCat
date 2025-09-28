package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.cats.domain.exceptions.CatAlreadyExistsException
import com.example.virtualcatapp.cats.domain.models.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository

class CatSaveCaseXml(
    val catRepository: CatRepository,
    val catExistUseCaseXml: CatExistUseCaseXml
) {

    operator fun invoke(cat: Cat) {
        if (cat.name.isEmpty() || cat.name.isBlank()){
            throw IllegalArgumentException("The name cannot empty")
        }
        if (catExistUseCaseXml(cat)){
            throw CatAlreadyExistsException("The id already exist")
        }
        catRepository.saveCatXml(cat)
    }
}