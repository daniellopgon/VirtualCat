package com.example.virtualcatapp.cat.domain.repository

import com.example.virtualcatapp.cat.domain.Cat

interface CatRepository {
    fun saveCat(cat: Cat): Cat
}