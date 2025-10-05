package com.example.virtualcatapp.features.cats.data.repository

import com.example.virtualcatapp.features.cats.data.local.CatMemLocalDataSource
import com.example.virtualcatapp.features.cats.data.local.CatXmlLocalDataSource
import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatDataRepository(
    private val catMemLocalDataSource: CatMemLocalDataSource,
    private val catXmlLocalDataSource: CatXmlLocalDataSource,
) : CatRepository {

    private val _catState = MutableStateFlow(Cat())

    override fun getCat(): Cat = _catState.value

    override fun updateCat(cat: Cat) {
        _catState.value = cat
    }

    override fun observeCat(): StateFlow<Cat> = _catState.asStateFlow()

    override fun saveCatMem(cat: Cat): Result<Cat> {
        return catMemLocalDataSource.save(cat)
    }

    override fun saveCatXml(cat: Cat): Result<Cat> {
        return catXmlLocalDataSource.savePersistence(cat)
    }
}