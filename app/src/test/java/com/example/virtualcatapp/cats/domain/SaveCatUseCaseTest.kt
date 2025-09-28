package com.example.virtualcatapp.cats.domain

import com.example.virtualcatapp.cats.domain.exceptions.CatAlreadyExistsException
import com.example.virtualcatapp.cats.domain.models.Cat
import com.example.virtualcatapp.cats.domain.repository.CatRepository
import com.example.virtualcatapp.cats.domain.usecase.CatExistUseCaseMem
import com.example.virtualcatapp.cats.domain.usecase.CatSaveUseCaseMem
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
        val catExistUseCaseMem = CatExistUseCaseMem(catRepositoryMockk)
        val saveCatUseCaseMem = CatSaveUseCaseMem(catRepositoryMockk, catExistUseCaseMem)

        //When
        val cat = Cat(1, "Cova")
        saveCatUseCaseMem(cat)

        //Then
        verify(exactly = 1) { catRepositoryMockk.saveCatMem(cat) }
    }

    @Test
    fun `when the name of the cat is empty`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCaseMem = CatExistUseCaseMem(catRepositoryMockk)

        val saveCatUseCase = CatSaveUseCaseMem(catRepositoryMockk, catExistUseCaseMem)
        val cat = Cat(2, "")

        //When && Then
        assertThrows(IllegalArgumentException::class.java){
            saveCatUseCase(cat)
        }
        verify(exactly = 0) { catRepositoryMockk.saveCatMem(cat)  }
    }

    @Test
    fun `when the id already exist`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>()
        val catExistUseCaseMem = CatExistUseCaseMem(catRepositoryMockk)
        val saveCatUseCaseMem = CatSaveUseCaseMem(catRepositoryMockk, catExistUseCaseMem)

        val cat1 = Cat(1, "Piti")
        val cat2 = Cat(1, "Taton")

        every{catRepositoryMockk.existCatMem((cat1))} returns false
        every{catRepositoryMockk.saveCatMem(cat1)} just Runs

        //When
        saveCatUseCaseMem(cat1)
        every{catRepositoryMockk.existCatMem(cat2)} returns true

        //Then
        assertThrows(CatAlreadyExistsException::class.java) {
            saveCatUseCaseMem(cat2)
        }

        verify(exactly = 1) { catRepositoryMockk.existCatMem(cat1) }
        verify(exactly = 1) { catRepositoryMockk.saveCatMem(cat1) }

        verify(exactly = 1) { catRepositoryMockk.existCatMem(cat2) }
        verify(exactly = 0) { catRepositoryMockk.saveCatMem(cat2) }
    }
}