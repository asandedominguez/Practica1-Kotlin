var estado = 1

fun gestorDeEstado(a: Boolean, b: Boolean): Int {
    if (estado == 1) {
        if (a) {
            estado = 2
        } else {
            estado = 1
        }
    } else if (estado == 2) {
        if (b) {
            estado = 3
        } else {
            estado = 4
            println("Pasó brevemente por el Estado: $estado")
            estado = 1
        }
    }

    if (estado == 3) {
        println("Estado: ${estado} FIN")
        estado = 0
    }

    return estado
}

fun main() {
    println("--- TEST 1 ---")
    estado = 1
    println("Resultado T, F: ${gestorDeEstado(a = true, b = false)}")
    println("Resultado T, F: ${gestorDeEstado(a = true, b = false)}")

    println("\n--- TEST 2 ---")
    estado = 1
    println("Resultado T, T: ${gestorDeEstado(a = true, b = true)}")
    println("Resultado F, F: ${gestorDeEstado(a = false, b = false)}")

    println("\n--- TEST 3 ---")
    estado = 1
    println("Resultado T, F: ${gestorDeEstado(a = true, b = false)}")
    println("Resultado F, T: ${gestorDeEstado(a = false, b = true)}")
    println("Verificación (Parado): ${gestorDeEstado(a = true, b = true)}")

    println("\n--- TEST 4 ---")
    estado = 1
    println("Resultado F, T: ${gestorDeEstado(a = false, b = true)}")

    println("\n--- TEST 5 ---")
    estado = 1
    println("Resultado T, T: ${gestorDeEstado(a = true, b = true)}")
    println("Resultado T, T: ${gestorDeEstado(a = true, b = true)}")
    println("Verificación (Parado): ${gestorDeEstado(a = true, b = true)}")

    println("\n--- TEST 6 ---")
    estado = 1
    println("Resultado T, T: ${gestorDeEstado(a = true, b = true)}")
    println("Resultado F, F: ${gestorDeEstado(a = false, b = true)}")
}