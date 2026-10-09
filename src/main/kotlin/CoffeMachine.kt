object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.E1_Idle

    fun makeCoffee() {
        when (val state = currentState) {
            is CoffeeMachineState.E1_Idle -> {
                println("Máquina lista")

                currentState = CoffeeMachineState.E2_SeleccionBebida
                println("Estado actual: $currentState")

                Thread.sleep(1500)
                println("selección de bebida")
            }
            is CoffeeMachineState.E2_SeleccionBebida -> {
                println("La máquina está en selección de bebida.")
            }
            is CoffeeMachineState.E3_NoHayBebida -> {
                println("No hay bebida disponible.")
            }
            is CoffeeMachineState.E4_SeleccionAzucar -> {
                println("Selección de azúcar")
            }
            is CoffeeMachineState.E5_PreparacionSinAzucar -> {
                println("Preparando café sin azúcar")
            }
            is CoffeeMachineState.E6_SeleccionCantidadAzucar -> {
                println("Seleccionando cantidad de azúcar")
            }
            is CoffeeMachineState.E7_ErrorSinAzucar -> {
                println("Error: Sin azúcar")
            }
            is CoffeeMachineState.E8_PreparacionConAzucar -> {
                println("Preparando café con azúcar")
            }
            is CoffeeMachineState.E9_RecogerCafe -> {
                println("Café listo")
            }
        }
    }

    fun clean() {
        println("LIMPIANDO")
        currentState = CoffeeMachineState.E1_Idle
    }
}

fun main() {
    println("Intentando hacer café la primera vez")
    CoffeeMachine.makeCoffee()
    println("Intentando hacer otro café")
    CoffeeMachine.makeCoffee()
    CoffeeMachine.clean()
}