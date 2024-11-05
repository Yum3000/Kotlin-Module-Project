var archives = mutableListOf<Archive>()

fun main() {
    val getArchivesActions = {
        val actions = mutableListOf<Pair<String, () -> Unit>>()

        actions.add("Создать архив" to {
            val fields = listOf("Имя архива")
            val createArchive: (List<String>) -> Unit =
                { vals -> archives.add(Archive(vals[0], mutableListOf())) }

            CreateScreen("Создание архива", "", fields, createArchive).run()
        })

        for (archive in archives) {
            actions.add(archive.name to {

                val getArchiveActions = {
                    val archiveActions = mutableListOf<Pair<String, () -> Unit>>()

                    archiveActions.add("Создать заметку" to {
                        val fields = listOf("Имя заметки", "Текст заметки")
                        val createNote: (List<String>) -> Unit =
                            { vals -> archive.notes.add(Note(vals[0], vals[1])) }

                        CreateScreen("Создание заметки", "", fields, createNote).run()
                    })

                    for (note in archive.notes) {
                        archiveActions.add(note.name to {
                            NoteScreen(note).run()
                        })
                    }

                    archiveActions
                }

                SelectScreen("Архив ${archive.name}", "", getArchiveActions).run()
            })
        }

        actions
    }

    SelectScreen("Архивы", "", getArchivesActions).run()
}