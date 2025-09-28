package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.cats.domain.models.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository

class CatExistUseCaseMem(private val catRepository: CatRepository){

    operator fun invoke(cat: Cat): Boolean {
        return catRepository.existCatMem(cat)
    }
}