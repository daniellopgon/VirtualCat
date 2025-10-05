package com.example.virtualcatapp.features.cats.domain.models

class Cat(val id: Int, val name: String) {
    val hunger: Int = 5
    val happiness: Int = 5
    val energy: Int = 5

    init {
        require(hunger in 0..10) { "Hunger must be between 0 and 10" }
        require(happiness in 0..10) { "Happiness must be between 0 and 10" }
        require(energy in 0..10) { "Energy must be between 0 and 10" }
    }
}