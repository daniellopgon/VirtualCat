package com.example.virtualcatapp.features.cats.presentation.screens.game

import androidx.lifecycle.ViewModel


class GameViewModel(
    private val playWithCatUseCase: PlayWithCatUseCase,
    getCatStateUseCase: GetCatStateUseCase
) : ViewModel() {

    val catState = getCatStateUseCase()

    fun playWithCat() {
        playWithCatUseCase()
    }
}