package com.example.virtualcatapp.features.cats.presentation.screens.sleep

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.domain.usecase.GetCatUseCase
import com.example.virtualcatapp.features.cats.domain.usecase.SleepCatUseCase

class SleepViewModel(
    private val sleepCatUseCase: SleepCatUseCase,
    private val observeCatUseCase: GetCatUseCase
) : ViewModel() {
    val catState = observeCatUseCase()

    fun sleepCat() {
        sleepCatUseCase()
    }
}