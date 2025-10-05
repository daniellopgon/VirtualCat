package com.example.virtualcatapp.features.cats.presentation.screens.intro

import androidx.lifecycle.ViewModel
import com.example.virtualcatapp.features.cats.domain.usecase.CatSaveCaseXml

class IntroViewModel(
    private val saveCaseXml: CatSaveCaseXml
): ViewModel() {

    fun saveCat() {
        saveCaseXml
    }

}