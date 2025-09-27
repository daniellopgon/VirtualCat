package com.example.virtualcatapp.cat.data.local

import com.example.virtualcatapp.cat.domain.Cat
import com.example.virtualcatapp.cat.domain.SaveCatUseCase
import com.example.virtualcatapp.cat.domain.repository.CatRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class CatMemLocalDataSourceTest {

    @Test
    fun `when you save a cat in local mem`(){
        //Given
        val catRepositoryMockk = mockk<CatRepository>(relaxed = true)
        val saveCatUseCase = SaveCatUseCase(catRepositoryMockk)

        //When
        val cat = Cat(1,"Cova")
        saveCatUseCase(cat)

        //Then
        verify(exactly = 1) { catRepositoryMockk.saveCat(cat) }
    }

}