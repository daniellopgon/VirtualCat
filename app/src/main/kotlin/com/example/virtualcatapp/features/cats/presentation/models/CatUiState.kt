package com.example.virtualcatapp.features.cats.presentation.models

data class CatUiState(
    val hunger: Int = 5,
    val happiness: Int = 5,
    val energy: Int = 5
)