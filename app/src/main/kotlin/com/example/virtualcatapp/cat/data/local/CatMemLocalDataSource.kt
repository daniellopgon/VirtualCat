package com.example.virtualcatapp.cat.data.local

import com.example.virtualcatapp.cat.domain.models.Cat


class CatMemLocalDataSource {

    private val dataSource: MutableMap<Int, Cat> = mutableMapOf()

    fun save(cat: Cat) {
        dataSource.put(cat.id, cat)
    }

    fun exist(cat: Cat): Boolean {
        return dataSource.containsKey(cat.id)
    }
}