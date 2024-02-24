package data.time

import model.NotesDataClass
import org.notesapp.project.NotesDatabase

class SqlDelightNotesDataSource(db: NotesDatabase) : NoteDataSource {
    private val query = db.notesDatabaseQueries
    override suspend fun insertNote(note: NotesDataClass) {
        query.insertNote(
            id = note.id,
            title = note.title,
            content = note.description
        )
    }

    override suspend fun getNoteById(id: Long): NotesDataClass? {
        return query
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<NotesDataClass> {
        return query
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        query.deleteNoteById(id)
    }
}