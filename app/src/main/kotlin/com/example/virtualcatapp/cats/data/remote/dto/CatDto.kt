package com.example.virtualcatapp.cats.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatDto(
    val id: Int,
    val name: String,
    val hunger: Int,
    val happiness: Int,
    val energy: Int
)