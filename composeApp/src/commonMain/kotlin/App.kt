import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.CancelPresentation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import notesapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import screens.AddNewNote

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme() {
        val theme = isSystemInDarkTheme()
        val darkTheme by remember { mutableStateOf(theme) }
        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Box(Modifier.fillMaxSize().background(Color(0xFF252525))) {
            MainScreen()
            //AddNewNote()
        }

    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen() {
    Box (Modifier.fillMaxSize()) {
        Column {
        Box(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp)) {
            Text(
                "Notes",
                fontSize = 32.sp,
                modifier = Modifier.align(Alignment.CenterStart),
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.nunito_semibold))
            )

            TextField(
                value = "",
                onValueChange = {
                },
                Modifier
                    .fillMaxWidth(0.5f)
                    .scale(scaleY = 0.8F, scaleX = 1F)
                    .padding(20.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .align(Alignment.TopCenter)
                ,
                placeholder = {
                    Text(text = "Search by the keyword....", color = Color.White)
                },
                trailingIcon = {
                               Icon(Icons.Outlined.CancelPresentation, null)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF3B3B3B)

                ),
                maxLines = 1,
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black, fontSize = 20.sp
                )
            )
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {

                Box(
                    modifier = Modifier.size(72.dp).padding(12.dp)
                        .background(Color(0xFF565656), shape = RoundedCornerShape(15.dp))
                ) {
                    Icon(Icons.Default.Search, null, modifier = Modifier.align(Alignment.Center),tint = Color.White)
                }
                Box(
                    modifier = Modifier.size(72.dp).padding(12.dp)
                        .background(Color(0xFF565656), shape = RoundedCornerShape(15.dp))
                ) {
                    Icon(Icons.Default.Info, null, modifier = Modifier.align(Alignment.Center), tint = Color.White)
                }
            }
        }
            val notesList = mutableListOf(
                NotesItemDataClass("UI concepts worth existing", Color(0xFFfd99ff)),
                NotesItemDataClass("Book Review: The design of everyday things by Don Norman", Color(0xFFff9e9e)),
                NotesItemDataClass("Animes produced by Ufotable", Color(0xFF91f48f)),
                NotesItemDataClass("Mangas planned to read", Color(0xFFfff599)),
                NotesItemDataClass("Awesome tweets collection", Color(0xFF9effff)),
                NotesItemDataClass("List of free & open source apps", Color(0xFFb69cff)),
                NotesItemDataClass("Kotlin MultiPlatform", Color(0xFFfd99ff)),
                NotesItemDataClass("Compose MultiPlatform", Color(0xFFff9e9e)),
            )

            Column(Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                LazyVerticalGrid(columns = GridCells.Adaptive(300.dp), modifier = Modifier){
                    items(notesList) { note ->
                        NoteItem(note)
                    }
                }
            }
        }
        /*Column(Modifier.align(Alignment.Center)) {
            Image(painterResource(Res.drawable.notes_empty_image), null, modifier = Modifier.size(300.dp))
            Text("Create Your first note !", modifier = Modifier.align(Alignment.CenterHorizontally))
        }*/

        FloatingActionButton(modifier = Modifier.align(Alignment.BottomEnd).padding(18.dp),
            onClick = { },
            backgroundColor = Color(0xFF3B3B3B),
            contentColor = Color.White
        ) {
            Icon(Icons.Default.Add, "Floating action button.")
        }
    }
}

@Composable
fun NoteItem(noteItem: NotesItemDataClass) {
Card(shape = RoundedCornerShape(10.dp), backgroundColor = noteItem.color, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)){
    Text(noteItem.title, modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp))
}
}

data class NotesItemDataClass(val title: String, val color: Color)

