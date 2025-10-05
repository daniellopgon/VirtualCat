package com.example.virtualcatapp.features.cats.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.domain.usecase.GetCatUseCase

class HomeViewModel(
    private val observeCatUseCase: GetCatUseCase
) : ViewModel() {
    val catState = observeCatUseCase()
}