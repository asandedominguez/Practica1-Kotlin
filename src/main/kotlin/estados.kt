fun gestorDeEstado(estadoInicial: Int, a: Boolean, b: Boolean): Int {
    var estado = estadoInicial

    if (estado == 1) {
        if (a) {
            estado = 2
        } else {
            estado = 1
        }
    }

    if (estado == 2) {
        if (b) {
            estado = 3
        } else {
            estado = 4
            println("Pasó brevemente por el Estado: $estado")
            estado = 1
        }
    }

    return estado
}

fun main() {
    println("Resultado Prueba 1: ${gestorDeEstado(1, a = false, b = false)}")

    println("Resultado Prueba 2: ${gestorDeEstado(1, a = true, b = false)}")

    println("Resultado Prueba 3: ${gestorDeEstado(1, a = true, b = true)}")
}
