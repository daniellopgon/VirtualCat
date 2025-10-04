package com.example.virtualcatapp.features.cats.data.local

import com.example.virtualcatapp.features.cats.domain.models.Cat

class CatMemLocalDataSource {
    private val dataSource: MutableMap<Int, Cat> = mutableMapOf()
    fun save(cat: Cat) {
        dataSource.put(cat.id, cat)
    }
    fun exist(cat: Cat): Boolean {
        return dataSource.containsKey(cat.id)
    }
}