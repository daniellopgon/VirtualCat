package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.exceptions.CatAlreadyExistsException
import com.example.virtualcatapp.cat.domain.repository.CatRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class SaveCatUseCaseTest {

    @Test
    fun `when you save a cat in local mem`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCase = CatExistUseCase(catRepositoryMockk)
        val saveCatUseCase = SaveCatUseCase(catRepositoryMockk,catExistUseCase)

        //When
        val cat = Cat(1,"Cova")
        saveCatUseCase(cat)

        //Then
        verify(exactly = 1) { catRepositoryMockk.saveCat(cat) }
    }

    @Test
    fun `when the name of the cat is empty`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCase = CatExistUseCase(catRepositoryMockk)
        val saveCatUseCase = SaveCatUseCase(catRepositoryMockk,catExistUseCase)
        val cat = Cat(2,"")

        //When && Then
        assertThrows(IllegalArgumentException::class.java){
            saveCatUseCase(cat)
        }
        verify(exactly = 0) { catRepositoryMockk.saveCat(cat)  }
    }

    @Test
    fun `when saving cat twice then second save throws exception`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>()
        val catExistUseCase = CatExistUseCase(catRepositoryMockk)
        val saveCatUseCase = SaveCatUseCase(catRepositoryMockk, catExistUseCase)
        val cat = Cat(1, "Piti")

        every { catRepositoryMockk.exist(cat) } returns false andThen true

        //When
        saveCatUseCase(cat)

        //Then
        assertThrows(CatAlreadyExistsException::class.java) {
            saveCatUseCase(cat)
        }

        verify(exactly = 1) { catRepositoryMockk.saveCat(cat) }
        verify(exactly = 2) { catRepositoryMockk.exist(cat) }
    }
}