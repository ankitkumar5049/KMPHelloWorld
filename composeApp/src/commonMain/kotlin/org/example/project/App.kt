package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import org.example.project.database.NoteDao
import org.example.project.database.NoteEntity
import org.example.project.screens.MainScreen
import org.example.project.themes.NotesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(noteDao: NoteDao) {
    NotesAppTheme{
        val notes by noteDao.getAllNotes().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            val peopleList = listOf(
                NoteEntity(
                    title = "Test1",
                    description = "desc",
                    timestamp = 183781
                ),
                NoteEntity(
                    title = "Test2",
                    description = "desc",
                    timestamp = 183781
                ),
                NoteEntity(
                    title = "Test3",
                    description = "desc",
                    timestamp = 183781
                ),
            )
            peopleList.forEach {
                noteDao.insertNote(it)
            }

        }


        MainScreen(notes, noteDao)
    }
}