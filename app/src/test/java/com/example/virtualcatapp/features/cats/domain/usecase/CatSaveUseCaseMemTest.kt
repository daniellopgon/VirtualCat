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

class CatSaveUseCaseMemTest {

    @Test
    fun `when invoke then save cat`() {
        val catRepositorymockk = mockk<CatRepository>()
        val catSaveUseCaseTest = CatSaveUseCaseMem(catRepositorymockk)
        val cat = Cat(1, "Cova")
        every { catRepositorymockk.saveCatMem(cat) } returns Result.success(cat)

        val result = catSaveUseCaseTest(cat)

        verify(exactly = 1) { catRepositorymockk.saveCatMem(cat) }
        assertTrue(result.isSuccess)
        assertEquals(cat, result.getOrNull())
    }

    @Test
    fun `when cat has empty name`() {
        val catRepositoryMockk = mockk<CatRepository>()
        val catSaveUseCaseTest = CatSaveUseCaseMem(catRepositoryMockk)
        val cat = Cat(1, "")
        every { catRepositoryMockk.saveCatMem(cat) } returns Result.failure(ErrorApp.EmptyName)

        val result = catSaveUseCaseTest(cat)

        verify(exactly = 1) { catRepositoryMockk.saveCatMem(cat) }
        assertTrue(result.isFailure)
        assertEquals(ErrorApp.EmptyName, result.exceptionOrNull())
    }

    @Test
    fun `when the id of cat already exist`() {
        val catRepository = mockk<CatRepository>()
        val catSaveUseCase = CatSaveUseCaseMem(catRepository)
        val cat = Cat(1, "Cova")
        val cat1 = Cat(1, "Piti")
        every { catRepository.saveCatMem(any()) } returnsMany listOf(Result.success(cat), Result.failure(ErrorApp.IdAlreadyExists))

        catSaveUseCase(cat)
        val result = catSaveUseCase(cat1)

        verify(exactly = 2) { catRepository.saveCatMem(any()) }
        assertTrue(result.isFailure)
        assertEquals(ErrorApp.IdAlreadyExists, result.exceptionOrNull())
    }
}