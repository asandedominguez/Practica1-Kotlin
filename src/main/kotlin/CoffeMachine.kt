package org.example

enum class CoffeeMachineState {
    Idle,
    MakingCoffee,
    ServingCoffee,
    Error
}

object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    private fun advanceState() {
        val nextIndex = currentState.ordinal + 1
        if (nextIndex < CoffeeMachineState.entries.size) {
            currentState = CoffeeMachineState.entries[nextIndex]
        }
    }

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            CoffeeMachineState.Idle -> {
                println("Máquina en estado IDLE")
                Thread.sleep(2000)
                advanceState()
                println("¡Me pongo a preparar tu café! Estado: $currentState")
            }
            CoffeeMachineState.MakingCoffee -> {
                println("¡Estoy haciendo café! Por favor, espera...")
                Thread.sleep(2000)
                advanceState()
            }
            CoffeeMachineState.ServingCoffee -> {
                println("Ya hay café servido. Por favor, toma tu café.")
                clean()
            }
            CoffeeMachineState.Error -> {
                println("La máquina tiene un error")
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle
        println("Máquina limpia. Estado: $currentState")
    }
}

fun main() {
    CoffeeMachine.gestorEstados()
    println()
    CoffeeMachine.gestorEstados()
    println()
    CoffeeMachine.gestorEstados()
}