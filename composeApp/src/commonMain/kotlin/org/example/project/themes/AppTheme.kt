package org.example.project.themes

// AppTheme.kt
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Typography
import androidx.compose.material.Shapes

@Composable
fun NotesAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = AppLightColors,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}
