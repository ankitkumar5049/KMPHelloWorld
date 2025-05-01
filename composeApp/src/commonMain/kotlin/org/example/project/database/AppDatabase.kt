package org.example.project.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun notesDao(): NoteDao

}