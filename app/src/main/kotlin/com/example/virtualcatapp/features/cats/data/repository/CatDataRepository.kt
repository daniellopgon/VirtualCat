package com.example.virtualcatapp.features.cats.data.repository

import android.content.Context
import com.example.virtualcatapp.cats.data.local.CatMemLocalDataSource
import com.example.virtualcatapp.cats.data.local.CatXmlLocalDataSource
import com.example.virtualcatapp.cats.domain.models.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository

class CatDataRepository (
    private val catMemLocalDataSource: CatMemLocalDataSource,
    private val catXmlLocalDataSource: CatXmlLocalDataSource,
    private val context: Context
) : CatRepository {

    override fun saveCatMem(cat: Cat) {
        catMemLocalDataSource.save(cat)
    }

    override fun existCatMem(cat: Cat): Boolean {
        return catMemLocalDataSource.exist(cat)
    }

    override fun saveCatXml(cat: Cat) {
        return catXmlLocalDataSource.savePersistence(cat)
    }

    override fun existCatShared(cat: Cat): Boolean {
        val prefs = context.getSharedPreferences("cat_preferences", Context.MODE_PRIVATE)
        return prefs.getString("cat_name", null) != null
    }

    override fun saveCatShared(cat: Cat) {
        val prefs = context.getSharedPreferences("cat_preferences", Context.MODE_PRIVATE)
        prefs.edit()
            .putString("cat_name", cat.name)
            .apply()
    }

    override fun existCatXml(cat: Cat): Boolean {
        return catXmlLocalDataSource.existPersistence(cat)
    }
}