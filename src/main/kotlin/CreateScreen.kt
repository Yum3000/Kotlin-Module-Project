import java.util.Scanner

class CreateScreen(
    name: String,
    description: String,
    val fields: List<String>,
    val onComplete: (vals: List<String>) -> Unit
) : Screen(name, description) {
    override fun run() {
        super.run()

        val vals = mutableListOf<String>()

        for (field in fields) {
            println("Введите  $field:")

            val scanner = Scanner(System.`in`)
            var input = scanner.nextLine()
            while (input.isEmpty()) {
                println("Пустая строка!")
                println("Введите еще раз:")
                input = scanner.nextLine()
            }
            vals.add(input)
        }
        onComplete(vals)
    }
}