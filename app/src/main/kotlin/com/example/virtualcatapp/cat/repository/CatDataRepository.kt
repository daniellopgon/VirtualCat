package com.example.virtualcatapp.cat.repository

import com.example.virtualcatapp.cat.data.local.CatMemLocalDataSource
import com.example.virtualcatapp.cat.data.local.CatXmlLocalDataSource
import com.example.virtualcatapp.cat.domain.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository

class CatDataRepository (
    private val catMemLocalDataSource: CatMemLocalDataSource,
    private val catXmlLocalDataSource: CatXmlLocalDataSource
) : CatRepository {

    override fun saveCat(cat: Cat) {
        catMemLocalDataSource.save(cat)
    }

    override fun exist(cat: Cat): Boolean {
        return catMemLocalDataSource.exist(cat)
    }
}