data class Decoration2(val rocks: String, val wood: String, val diver: String)

fun evaluarColor(parametro: String): Any {
    if (parametro == "blanco") return "string"
    if (parametro == "negro") return "color"
    return 1
}

fun makeDecorations() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}

fun main() {
    makeDecorations()

    println(evaluarColor("blanco")) // Devuelve "string"
    println(evaluarColor("negro"))  // Devuelve "color"
    println(evaluarColor("rojo"))   // Devuelve el número 1
}