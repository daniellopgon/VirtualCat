package com.example.virtualcatapp.cat.data.local

import com.example.virtualcatapp.cat.domain.Cat

class CatMemLocalDataSource {

    private val dataSource: MutableMap<Int, Cat> = mutableMapOf()

    fun save(cat: Cat) {
        if (cat.name.isEmpty() || cat.name.isBlank()){
            throw IllegalArgumentException("The name cannot empty")
        }
        dataSource.put(cat.id, cat)
    }

    fun exist(cat: Cat): Boolean {
        return dataSource.containsKey(cat.id)
    }
}