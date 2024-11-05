open class Screen(val name: String, val description: String) {
    open fun run() {
        println("===================================")
        println("Экран: $name")
        println(description)
    }
}