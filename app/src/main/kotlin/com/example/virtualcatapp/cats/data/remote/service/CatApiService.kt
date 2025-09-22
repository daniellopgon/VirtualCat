package com.example.virtualcatapp.cats.data.remote.service

import com.example.virtualcatapp.cats.data.remote.dto.CatDto
import retrofit2.http.Body
import retrofit2.http.POST

interface CatApiService {
    @POST("cats")
    suspend fun saveCat(@Body cat: CatDto): CatDto
}