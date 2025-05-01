package org.example.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.database.getNotesDatabase

fun MainViewController() = ComposeUIViewController {
    val dao = remember {
        getNotesDatabase().notesDao()
    }
    App(dao)
}