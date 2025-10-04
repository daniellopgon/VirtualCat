package com.example.virtualcatapp.features.cats.domain.usecase

import com.example.virtualcatapp.features.cats.domain.error.ErrorApp
import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CatSaveUseCaseXmlTest {

    @Test
    fun `when invoke then save cat`() {
        val catRepositoryMockk = mockk<CatRepository>()
        val catSaveXmlUseCaseTest = CatSaveCaseXml(catRepositoryMockk)
        val cat = Cat(1, "Cova")
        every { catRepositoryMockk.saveCatXml(cat) } returns Result.success(cat)

        val result = catSaveXmlUseCaseTest(cat)

        verify { catRepositoryMockk.saveCatXml(cat) }
        assertTrue(result.isSuccess)
        assertEquals(cat, result.getOrNull())
    }

    @Test
    fun `when cat has empty name`() {
        val catRepositoryMockk = mockk<CatRepository>()
        val catSaveXmlUseCaseTest = CatSaveCaseXml(catRepositoryMockk)
        val cat = Cat(1, "")
        every { catRepositoryMockk.saveCatXml(cat) } returns Result.failure(ErrorApp.EmptyName)

        val result = catSaveXmlUseCaseTest(cat)

        verify { catRepositoryMockk.saveCatXml(cat) }
        assertTrue(result.isFailure)
        assertEquals(ErrorApp.EmptyName, result.exceptionOrNull())
    }

    @Test
    fun `when the id of cat already exist`() {
        val catRepositoryMockk = mockk<CatRepository>()
        val catSaveXmlUseCaseTest = CatSaveCaseXml(catRepositoryMockk)
        val cat = Cat(1, "Cova")
        val cat1 = Cat(1, "Piti")
        every { catRepositoryMockk.saveCatXml(any()) } returnsMany listOf(Result.success(cat), Result.failure(ErrorApp.IdAlreadyExists))

        catSaveXmlUseCaseTest(cat)
        val result = catSaveXmlUseCaseTest(cat1)

        verify(exactly = 2) { catRepositoryMockk.saveCatXml(any()) }
        assertTrue(result.isFailure)
        assertEquals(ErrorApp.IdAlreadyExists, result.exceptionOrNull())
    }
}