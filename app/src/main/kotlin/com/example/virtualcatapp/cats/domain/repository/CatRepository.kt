package com.example.virtualcatapp.cats.domain.repository

import com.example.virtualcatapp.cats.domain.Cat

interface CatRepository {
    suspend fun saveCat(cat: Cat): Cat
}