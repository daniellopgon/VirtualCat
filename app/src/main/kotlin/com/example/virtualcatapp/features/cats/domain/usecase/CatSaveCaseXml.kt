package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository


class CatSaveCaseXml(
    val catRepository: CatRepository,
) {

    operator fun invoke(cat: Cat): Result<Cat> {
        return catRepository.saveCatXml(cat)
    }
}