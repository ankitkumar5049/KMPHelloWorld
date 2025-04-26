package org.example.project.model

import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Int,
    val title: String,
    val description: String,
    val timestamp: LocalDateTime
)