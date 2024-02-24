package data.time


import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import model.NotesDataClass
import orgnotesappproject.NoteEntity

fun NoteEntity.toNote(): NotesDataClass {
    return NotesDataClass(
        id = id,
        title = title,
        description = content,
/*        hexColor = colorHex,
        created = Instant
            .fromEpochMilliseconds(created)
            .toLocalDateTime(TimeZone.currentSystemDefault())*/
    )
}