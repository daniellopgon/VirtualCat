package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.repository.CatRepository
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
        val saveCatUseCase = SaveCatUseCase(catRepositoryMockk)
        val cat = Cat(2,"")

        //When && Then
        assertThrows(IllegalArgumentException::class.java){
            saveCatUseCase(cat)
        }
        verify(exactly = 0) { catRepositoryMockk.saveCat(cat)  }
    }

    @Test
    fun `when the id already exist`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val saveCatUseCase = SaveCatUseCase(catRepositoryMockk)
        val cat1 = Cat(1,"Piti")
        val cat2 = Cat(1,"Taton")

        //When && Then
        assertThrows(CatAlreadyExistException::class.java){
            saveCatUseCase(cat1)
            saveCatUseCase(cat2)
        }
        verify(exactly = 0) { catRepositoryMockk.saveCat(cat1)  }
        verify(exactly = 0) { catRepositoryMockk.saveCat(cat2)  }
    }
}