package org.example.project.database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.example.project.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}
