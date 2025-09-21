package com.example.virtualcatapp.cats.data.remote

import com.example.virtualcatapp.cats.data.local.CatMemLocalDataSource
import com.example.virtualcatapp.cats.data.local.CatXmlLocalDataSource
import com.example.virtualcatapp.cats.domain.Cat
import com.example.virtualcatapp.cats.domain.CatRepository

class CatDataRepository(
    private val xmlLocalDataSource: CatXmlLocalDataSource,
    private val memLocalDataSource: CatMemLocalDataSource,
    private val apiRemoteDataSource: CatApiRemoteDataSource
) : CatRepository {
    override fun save(cat: Cat) {
        if (memLocalDataSource.exist(cat)) {

        } else {

        }
    }


}