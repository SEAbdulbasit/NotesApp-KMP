import androidx.compose.runtime.Composable

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

/*
expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): NotesDatabase {
    val driver = driverFactory.createDriver()
    val database = NotesDatabase(driver)

    // Do more work with the database (see below).
}*/


expect class PlatformContext


@Composable
expect fun getPlatformContext(): PlatformContext
