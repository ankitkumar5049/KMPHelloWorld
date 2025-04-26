package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import composemultiplatformhelloworld.composeapp.generated.resources.Res
import composemultiplatformhelloworld.composeapp.generated.resources.compose_multiplatform
import org.example.project.repos.NoteRepository
import org.example.project.screens.MainScreen

@Composable
@Preview
fun App() {
    val noteRepository = NoteRepository()
    MaterialTheme {
        MainScreen(noteRepository)
    }
}