package com.example.virtualcatapp.cat.repository

import com.example.virtualcatapp.cat.data.remote.CatApiRemoteDataSource
import com.example.virtualcatapp.cat.domain.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val remoteDataSource: CatApiRemoteDataSource
) : CatRepository {

    override suspend fun saveCat(cat: Cat): Cat {
        return remoteDataSource.save(cat)
    }
}