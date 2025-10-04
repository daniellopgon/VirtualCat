package com.example.virtualcatapp.features.cats.data.local

import com.example.virtualcatapp.features.cats.domain.error.ErrorApp
import com.example.virtualcatapp.features.cats.domain.models.Cat

class CatMemLocalDataSource {
    private val dataSource: MutableMap<Int, Cat> = mutableMapOf()
    fun save(cat: Cat): Result<Cat> {
        if (cat.name.isEmpty()) return Result.failure(ErrorApp.EmptyName)
        if (dataSource.containsKey(cat.id)) return Result.failure(ErrorApp.IdAlreadyExists)
        dataSource.put(cat.id, cat)
        return Result.success(cat)
    }
}