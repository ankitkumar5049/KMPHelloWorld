package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.database.getNotesDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = getNotesDatabase(applicationContext).notesDao()

        window.statusBarColor = android.graphics.Color.parseColor("#ff6700")
        setContent {
            App(dao)
        }
    }
}
