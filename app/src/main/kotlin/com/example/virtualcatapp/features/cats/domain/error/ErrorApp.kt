package com.example.virtualcatapp.features.cats.domain.error

sealed class ErrorApp: Throwable() {

    object EmptyName : ErrorApp()
    object IdAlreadyExists : ErrorApp()

}