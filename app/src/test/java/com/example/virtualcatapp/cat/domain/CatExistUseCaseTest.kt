package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.domain.repository.CatRepository
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class CatExistUseCaseTest {

    @Test
    fun `when the id exist`(){
        //Give
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCase = CatExistUseCase(catRepositoryMockk)
        val cat1 = Cat(1,"Piti")
        val cat2 = Cat(1,"Taton")

        //When
        catExistUseCase(cat1)
        catExistUseCase(cat2)

        //Then
        assert(false){"The id of the cat already exist"}
    }

}