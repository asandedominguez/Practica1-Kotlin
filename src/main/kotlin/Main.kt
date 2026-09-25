open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

}
fun main() {
    Aquarium()
}
