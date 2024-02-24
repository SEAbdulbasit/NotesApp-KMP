package data.time

import model.NotesDataClass

interface NoteDataSource {
    suspend fun insertNote(note: NotesDataClass)
    suspend fun getNoteById(id: Long): NotesDataClass?
    suspend fun getAllNotes(): List<NotesDataClass>
    suspend fun deleteNoteById(id: Long)
}