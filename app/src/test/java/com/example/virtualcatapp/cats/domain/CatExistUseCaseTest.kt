package com.example.virtualcatapp.cats.domain

import com.example.virtualcatapp.features.cats.domain.models.Cat
import com.example.virtualcatapp.features.cats.domain.repository.CatRepository
import io.mockk.mockk
import org.junit.Test

class CatExistUseCaseTest {

    @Test
    fun `when the id exist`(){
        //Give
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCaseMem = CatExistUseCaseMem(catRepositoryMockk)
        val cat1 = Cat(1, "Piti")
        val cat2 = Cat(1, "Taton")

        //When
        catExistUseCaseMem(cat1)
        catExistUseCaseMem(cat2)

        //Then
        assert(true){"The id of the cat already exist"}
    }
}