import java.util.Scanner

class SelectScreen(
    name: String,
    description: String,
    val getActions: () -> List<Pair<String, () -> Unit>>
) : Screen(name, description) {

    override fun run() {
        super.run()

        while (true) {
            val actions = getActions()
            var i = 0;

            for (action in actions) {
                println("$i ${action.first}")
                i++;
            }

            println("$i Выход")

            val scanner = Scanner(System.`in`)
            var input = scanner.nextLine().toIntOrNull()
            while (input == null || input < 0 || input > i) {
                println("Введено не число или не то число!\nВведите еще раз:")
                input = scanner.nextLine().toIntOrNull()
            }

            if (input == i) {
                break;
            }

            actions[input].second()
        }
    }
}