package com.example.virtualcatapp.features.cats.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.presentation.shared.SharedCatState


class HomeViewModel: ViewModel() {
    val catState = SharedCatState.catState
}