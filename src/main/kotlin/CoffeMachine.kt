package org.example

enum class CoffeeMachineState {
    E1_Idle,
    E2_SeleccionBebida,
    E3_NoHayBebida
}

object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.E1_Idle

    private fun advanceState() {
        val nextIndex = currentState.ordinal + 1
        if (nextIndex < CoffeeMachineState.entries.size) {
            currentState = CoffeeMachineState.entries[nextIndex]
        }
    }

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            CoffeeMachineState.E1_Idle -> {
                println("Máquina en estado IDLE (Lista para recibir selección)")
                Thread.sleep(2000)
                advanceState()
                println("Pasando a selección. Estado: $currentState")
            }
            CoffeeMachineState.E2_SeleccionBebida -> {
                println("La máquina está en selección de bebida")
                Thread.sleep(2000)
                advanceState()
            }
            CoffeeMachineState.E3_NoHayBebida -> {
                println("No hay bebida disponible.")
                clean()
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.E1_Idle
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