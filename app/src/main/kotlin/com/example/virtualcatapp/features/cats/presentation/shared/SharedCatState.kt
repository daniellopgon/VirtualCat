package com.example.virtualcatapp.features.cats.presentation.shared

import androidx.compose.runtime.mutableStateOf
import com.example.virtualcatapp.features.cats.presentation.models.CatUiState

object SharedCatState {
    var catState = mutableStateOf(CatUiState())
        private set

    fun updateCatState(newState: CatUiState) {
        catState.value = newState
    }
}