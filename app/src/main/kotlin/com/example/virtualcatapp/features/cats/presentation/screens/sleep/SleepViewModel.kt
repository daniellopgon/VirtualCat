package com.example.virtualcatapp.features.cats.presentation.screens.sleep

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.domain.usecase.GetCatUseCase
import com.example.virtualcatapp.features.cats.domain.usecase.SleepCatUseCase
import com.example.virtualcatapp.features.cats.presentation.shared.SharedCatState


class SleepViewModel: ViewModel() {
    val catState = SharedCatState.catState

    class SleepViewModel(
        private val sleepCatUseCase: SleepCatUseCase,
        getCatStateUseCase: GetCatUseCase
    ) : ViewModel() {

        val catState = getCatStateUseCase()

        fun sleepWithCat() {
            sleepCatUseCase()
        }
    }
}