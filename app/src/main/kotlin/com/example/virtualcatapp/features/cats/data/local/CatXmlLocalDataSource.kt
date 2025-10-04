package com.example.virtualcatapp.features.cats.data.local

import android.content.Context
import com.example.virtualcatapp.features.cats.domain.error.ErrorApp
import com.example.virtualcatapp.features.cats.domain.models.Cat

class CatXmlLocalDataSource(private val context: Context) {
    private val fileName = "cats.xml"
    fun savePersistence(cat: Cat): Result<Cat> {
        if (cat.name.isEmpty()) return Result.failure(ErrorApp.EmptyName)
        if (fileName.contains("<id>${cat.id}</id>")) return Result.failure(ErrorApp.IdAlreadyExists)

        val xmlContent = """
            <?xml version="1.0" encoding ="UTF-8"?>
            <cats>
                <cat>
                    <id>${cat.id}</id>
                    <name>${cat.name}</name>
                    <hunger>${cat.hunger}</hunger>
                    <happiness>${cat.happiness}</happiness>
                    <energy>${cat.energy}</energy>
                </cat>
            </cats>
        """.trimIndent()

        context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
            output.write(xmlContent.toByteArray())
        }
        return Result.success(cat)
    }
}