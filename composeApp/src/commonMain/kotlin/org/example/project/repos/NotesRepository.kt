package org.example.project.repos

import androidx.compose.runtime.mutableStateListOf
import kotlinx.datetime.Clock
import kotlinx.datetime.toLocalDateTime
import org.example.project.model.Note

class NoteRepository {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> get() = _notes

    fun addNote(title: String, description: String) {
        val note = Note(
            id = _notes.size + 1,
            title = title,
            description = description,
            timestamp = Clock.System.now().toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault())
        )
        _notes.add(note)
    }

    fun deleteNote(note: Note) {
        _notes.remove(note)
    }
}
