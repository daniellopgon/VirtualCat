package com.example.virtualcatapp.cat.presentation.shared

import androidx.compose.runtime.mutableStateOf
import com.example.virtualcatapp.cat.presentation.models.CatUiState

object SharedCatState {
    var catState = mutableStateOf(CatUiState())
        private set

    fun updateCatState(newState: CatUiState) {
        catState.value = newState
    }
}