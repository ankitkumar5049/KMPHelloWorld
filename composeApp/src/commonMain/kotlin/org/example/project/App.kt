package org.example.project

import androidx.compose.runtime.Composable
import org.example.project.database.NoteDao
import org.example.project.screens.MainScreen
import org.example.project.themes.NotesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(noteDao: NoteDao) {
    NotesAppTheme{
        MainScreen(noteDao)
    }
}