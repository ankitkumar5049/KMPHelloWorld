package org.example.project

import androidx.compose.runtime.Composable
import org.example.project.database.NoteDao
import org.example.project.screens.MainScreen
import org.example.project.themes.NotesAppTheme
import org.example.project.utils.ContextFactory
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(noteDao: NoteDao, platformContext: ContextFactory) {
    NotesAppTheme{
        MainScreen(noteDao, platformContext)
    }
}