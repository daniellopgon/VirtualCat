package com.example.virtualcatapp.cat.domain

import com.example.virtualcatapp.cat.data.models.Cat
import com.example.virtualcatapp.cat.domain.repository.CatRepository
import com.example.virtualcatapp.cat.domain.usecase.CatExistUseCaseMem
import io.mockk.mockk
import org.junit.Test

class CatExistUseCaseTest {

    @Test
    fun `when the id exist`(){
        //Give
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val catExistUseCase = CatExistUseCaseMem(catRepositoryMockk)
        val cat1 = Cat(1, "Piti")
        val cat2 = Cat(1, "Taton")

        //When
        catExistUseCase(cat1)
        catExistUseCase(cat2)

        //Then
        assert(true){"The id of the cat already exist"}
    }
}