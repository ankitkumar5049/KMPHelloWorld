package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.example.project.model.Note
import org.example.project.repos.NoteRepository

@Composable
fun MainScreen(noteRepository: NoteRepository) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }


    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Add Note", style = MaterialTheme.typography.h6)

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (title.isNotBlank()) {
                            noteRepository.addNote(title, description)
                            title = ""
                            description = ""
                            coroutineScope.launch { sheetState.hide() }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Save")
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())
                .background(MaterialTheme.colors.primary),
//
            topBar = {
                TopAppBar(
                    title = { Text("Notes App") }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch { sheetState.show() }
                    }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                LazyColumn {
                    items(noteRepository.notes) { note ->
                        NoteItem(note = note, onDelete = { noteRepository.deleteNote(it) })
                    }
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, onDelete: (Note) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(note.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(note.description, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(note.timestamp.toString(), style = MaterialTheme.typography.caption)

            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onDelete(note) }) {
                Text("Delete")
            }
        }
    }
}
