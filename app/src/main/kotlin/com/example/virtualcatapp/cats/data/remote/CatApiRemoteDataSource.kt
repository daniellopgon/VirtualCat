package com.example.virtualcatapp.cats.data.remote

import com.example.virtualcatapp.cats.data.remote.dto.CatDto
import com.example.virtualcatapp.cats.data.remote.service.CatApiService
import com.example.virtualcatapp.cats.domain.Cat

class CatApiRemoteDataSource constructor(
    private val apiService: CatApiService
) {

    suspend fun save(cat: Cat): Cat {
        val catDto = CatDto(
            id = cat.id,
            name = cat.name,
            hunger = cat.hunger,
            happiness = cat.happiness,
            energy = cat.energy
        )
        val response = apiService.saveCat(catDto)

        return response.toDomain()
    }
}

private fun CatDto.toDomain(): Cat {
    return Cat(
        id = this.id,
        name = this.name,
    )
}