package com.example.virtualcatapp.cat.domain.usecase

import com.example.virtualcatapp.cat.domain.models.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository

class CatExistUseCaseMem(private val catRepository: CatRepository){

    operator fun invoke(cat: Cat): Boolean {
        return catRepository.existCatMem(cat)
    }
}