package com.example.virtualcatapp.features.cats.domain.repository

import com.example.virtualcatapp.features.cats.domain.models.Cat
import kotlinx.coroutines.flow.StateFlow


interface CatRepository {
    fun saveCatMem(cat: Cat): Result<Cat>
    fun saveCatXml(cat: Cat): Result<Cat>
    fun getCat(): Cat
    fun updateCat(cat: Cat)
    fun observeCat(): StateFlow<Cat>
}