package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.exceptions.CatAlreadyExistsException
import com.example.virtualcatapp.cat.data.models.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository
import com.example.virtualcatapp.cat.domain.usecase.CatExistUseCaseMem
import com.example.virtualcatapp.cat.domain.usecase.CatSaveUseCaseMem
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class SaveCatUseCaseTest {

    @Test
    fun `when you save a cat in local mem`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCase = CatExistUseCaseMem(catRepositoryMockk)
        val saveCatUseCase = CatSaveUseCaseMem(catRepositoryMockk, catExistUseCase)

        //When
        val cat = Cat(1, "Cova")
        saveCatUseCase(cat)

        //Then
        verify(exactly = 1) { catRepositoryMockk.saveCat(cat) }
    }

    @Test
    fun `when the name of the cat is empty`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCase = CatExistUseCaseMem(catRepositoryMockk)

        val saveCatUseCase = CatSaveUseCaseMem(catRepositoryMockk, catExistUseCase)
        val cat = Cat(2, "")

        //When && Then
        assertThrows(IllegalArgumentException::class.java){
            saveCatUseCase(cat)
        }
        verify(exactly = 0) { catRepositoryMockk.saveCat(cat)  }
    }

    @Test
    fun `when the id already exist`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>()
        val catExistUseCase = CatExistUseCaseMem(catRepositoryMockk)
        val saveCatUseCase = CatSaveUseCaseMem(catRepositoryMockk, catExistUseCase)

        val cat1 = Cat(1, "Piti")
        val cat2 = Cat(1, "Taton")

        every{catRepositoryMockk.exist((cat1))} returns false
        every{catRepositoryMockk.saveCat(cat1)} just Runs

        //When
        saveCatUseCase(cat1)
        every{catRepositoryMockk.exist(cat2)} returns true

        //Then
        assertThrows(CatAlreadyExistsException::class.java) {
            saveCatUseCase(cat2)
        }

        verify(exactly = 1) { catRepositoryMockk.exist(cat1) }
        verify(exactly = 1) { catRepositoryMockk.saveCat(cat1) }

        verify(exactly = 1) { catRepositoryMockk.exist(cat2) }
        verify(exactly = 0) { catRepositoryMockk.saveCat(cat2) }
    }
}