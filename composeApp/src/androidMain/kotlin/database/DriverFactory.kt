package database

import PlatformContext
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.notesapp.project.NotesDatabase

actual class DriverFactory {
    actual suspend fun createDriver(platformContext: PlatformContext): SqlDriver {
        return AndroidSqliteDriver(NotesDatabase.Schema.synchronous(), platformContext.context, "app.db")
    }
}