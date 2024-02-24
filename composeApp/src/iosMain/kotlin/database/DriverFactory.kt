package database

import PlatformContext
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.notesapp.project.NotesDatabase

actual class DriverFactory {
    actual suspend fun createDriver(platformContext: PlatformContext): SqlDriver {
        return NativeSqliteDriver(NotesDatabase.Schema.synchronous(), "app.db")
    }
}