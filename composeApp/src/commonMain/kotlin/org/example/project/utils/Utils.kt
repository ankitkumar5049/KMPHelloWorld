package org.example.project.utils

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


fun formatTimestamp(timestamp: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestamp)
    val datetime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

    return "${datetime.dayOfMonth} ${datetime.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${datetime.year}, ${datetime.hour.toString().padStart(2, '0')}:${datetime.minute.toString().padStart(2, '0')}"
}
