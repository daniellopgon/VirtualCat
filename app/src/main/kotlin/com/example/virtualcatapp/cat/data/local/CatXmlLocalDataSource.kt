package com.example.virtualcatapp.cat.data.local

import android.content.Context
import com.example.virtualcatapp.cat.domain.models.Cat
import java.io.FileNotFoundException

class CatXmlLocalDataSource(private val context: Context) {
    private val fileName = "cats.xml"

    fun savePersistence(cat: Cat) {
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
    }

    fun existPersistence(cat: Cat): Boolean {
        return try {
            val inputStream = context.openFileInput(fileName)
            val xmlContent = inputStream.bufferedReader().use { it.readText() }

            xmlContent.contains("<id>${cat.id}</id>")
        } catch (e: FileNotFoundException) {
            return false
        }
    }
}