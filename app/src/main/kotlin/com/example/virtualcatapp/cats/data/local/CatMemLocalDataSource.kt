package com.example.virtualcatapp.cats.data.local

import com.example.virtualcatapp.cats.domain.Cat

class CatMemLocalDataSource {

    private val dataSource: MutableMap<Int, Cat> = mutableMapOf()

    fun save(cat: Cat) {
        dataSource.put(cat.id, cat)
    }

    fun exist(cat: Cat): Boolean {
        return dataSource.containsKey(cat.id)
    }
}