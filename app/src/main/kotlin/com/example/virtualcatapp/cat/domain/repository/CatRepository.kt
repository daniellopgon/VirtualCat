package com.example.virtualcatapp.cat.domain.repository

import com.example.virtualcatapp.cat.domain.models.Cat

interface CatRepository {
    fun saveCatMem(cat: Cat)
    fun existCatMem(cat: Cat): Boolean
    fun existCatXml(cat: Cat): Boolean
    fun saveCatXml(cat: Cat)
    fun existCatShared(cat: Cat): Boolean
    fun saveCatShared(cat: Cat)
}