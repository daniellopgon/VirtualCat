package com.example.virtualcatapp.features.cats.presentation.screens.food

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.domain.usecase.FeedCatUseCase
import com.example.virtualcatapp.features.cats.domain.usecase.GetCatUseCase


class FoodViewModel(
    private val feedCatUseCase: FeedCatUseCase,
    private val observeCatUseCase: GetCatUseCase
) : ViewModel() {

    val catState = observeCatUseCase()

    fun feedCat() {
        feedCatUseCase()
    }
}