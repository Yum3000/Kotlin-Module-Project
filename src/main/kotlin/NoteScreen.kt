import java.util.Scanner

class NoteScreen(
    note: Note
) : Screen("Заметка: ${note.name}", "Текст: ${note.text}") {
    override fun run() {
        super.run()
        val scanner = Scanner(System.`in`)
        println("Для выхода нажмите Enter")
        scanner.nextLine()
    }
}