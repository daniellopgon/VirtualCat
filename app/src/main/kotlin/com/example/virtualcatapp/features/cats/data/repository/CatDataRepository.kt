package com.example.virtualcatapp.features.cats.data.repository

import com.example.virtualcatapp.features.cats.data.local.CatMemLocalDataSource
import com.example.virtualcatapp.features.cats.data.local.CatXmlLocalDataSource
import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository

class CatDataRepository(
    private val catMemLocalDataSource: CatMemLocalDataSource,
    private val catXmlLocalDataSource: CatXmlLocalDataSource,
) : CatRepository {

    override fun saveCatMem(cat: Cat): Result<Cat> {
        return catMemLocalDataSource.save(cat)
    }

    override fun saveCatXml(cat: Cat): Result<Cat> {
        return catXmlLocalDataSource.savePersistence(cat)
    }
}