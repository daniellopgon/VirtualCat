package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.cats.domain.models.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository

class CatExistUseCaseXml(val catRepository: CatRepository) {

    operator fun invoke(cat: Cat): Boolean {
        return catRepository.existCatXml(cat)
    }
}