package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.repository.CatRepository

class CatExistUseCase(private val catRepository: CatRepository){

    operator fun invoke(cat: Cat): Boolean {
        return catRepository.exist(cat)
    }
}