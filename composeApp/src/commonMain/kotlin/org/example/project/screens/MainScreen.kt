package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import org.example.project.database.NoteDao
import org.example.project.database.NoteEntity

@Composable
fun MainScreen(noteDao: NoteDao) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var editingNoteId by remember { mutableStateOf<Int?>(null) }
    val notes by noteDao.getAllNotes().collectAsState(initial = emptyList())


    notes.forEach { note ->
        println("notes $note")
    }

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
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
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
                            coroutineScope.launch {
                                val note = NoteEntity(
                                    title = title,
                                    description = description,
                                    timestamp = Clock.System.now().toEpochMilliseconds()
                                )
                                if (editingNoteId != null) {
                                    noteDao.updateNote(note)
                                } else {
                                    noteDao.insertNote(note)
                                }
                                title = ""
                                description = ""
                                sheetState.hide()
                            }
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
            modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues()),
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
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                        .widthIn(max = 300.dp)
                ) {
                    LazyColumn {
                        items(notes.sortedByDescending { it.timestamp }){ note ->
                            NoteItem(
                                note = note,
                                onDelete = {},
                                onEdit = {}
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: NoteEntity, onDelete: (NoteEntity) -> Unit, onEdit: (NoteEntity) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .widthIn(max = 600.dp),

        ) {
            Text(
                note.title,
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                note.description,
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                note.timestamp.toString(),
                style = MaterialTheme.typography.caption
            )

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { onEdit(note) },
                    modifier = Modifier
                        .weight(0.5f)
                        .widthIn(50.dp),
                ) {
                    Text("Edit")
                }
                Spacer(modifier = Modifier.weight(0.2f))
                Button(
                    onClick = { onDelete(note) },
                    modifier = Modifier
                        .weight(0.5f)
                        .widthIn(50.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text("Delete")
                }
            }
        }
    }
}
