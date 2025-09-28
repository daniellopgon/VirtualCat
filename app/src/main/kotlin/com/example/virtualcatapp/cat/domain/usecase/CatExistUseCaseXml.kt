package com.example.virtualcatapp.cat.domain.usecase

import com.example.virtualcatapp.cat.domain.models.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository

class CatExistUseCaseXml(val catRepository: CatRepository) {

    operator fun invoke(cat: Cat): Boolean {
        return catRepository.existCatXml(cat)
    }
}