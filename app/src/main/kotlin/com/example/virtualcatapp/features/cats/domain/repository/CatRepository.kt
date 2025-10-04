package com.example.virtualcatapp.features.cats.domain.repository

import com.example.virtualcatapp.features.cats.domain.models.Cat


interface CatRepository {
    fun saveCatMem(cat: Cat): Result<Cat>
    fun saveCatXml(cat: Cat): Result<Cat>
}