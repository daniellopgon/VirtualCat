package com.example.virtualcatapp.features.cats.presentation.screens.game

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.domain.usecase.GetCatUseCase
import com.example.virtualcatapp.features.cats.domain.usecase.PlayWithCatUseCase


class GameViewModel(
    private val playWithCatUseCase: PlayWithCatUseCase,
    private val observeCatUseCase: GetCatUseCase
) : ViewModel() {

    val catState = observeCatUseCase()

    fun playWithCat() {
        playWithCatUseCase()
    }
}