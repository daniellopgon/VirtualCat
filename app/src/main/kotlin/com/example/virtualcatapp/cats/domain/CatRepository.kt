package com.example.virtualcatapp.cats.domain

interface CatRepository {
    fun save(cat: com.example.virtualcatapp.cats.domain.Cat)
}