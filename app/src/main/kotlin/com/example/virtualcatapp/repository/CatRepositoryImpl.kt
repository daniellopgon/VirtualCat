package com.example.virtualcatapp.cats.repository

import com.example.virtualcatapp.cats.data.remote.CatApiRemoteDataSource
import com.example.virtualcatapp.cats.domain.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val remoteDataSource: CatApiRemoteDataSource
) : CatRepository {

    override suspend fun saveCat(cat: Cat): Cat {
        return remoteDataSource.save(cat)
    }
}