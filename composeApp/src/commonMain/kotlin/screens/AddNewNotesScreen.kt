package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import notesapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AddNewNote() {
    var titleText by remember { mutableStateOf("") }
    var descriptionText by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp)) {

            Box(
                modifier = Modifier.size(72.dp).padding(12.dp).align(Alignment.CenterStart)
                    .background(Color(0xFF565656), shape = RoundedCornerShape(15.dp))
            ) {
                Icon(
                    Icons.Filled.ArrowBackIosNew,
                    null,
                    modifier = Modifier.align(Alignment.Center),
                    tint = Color.White
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {

                Box(
                    modifier = Modifier.size(72.dp).padding(12.dp)
                        .background(Color(0xFF565656), shape = RoundedCornerShape(15.dp))
                ) {
                    Icon(
                        Icons.Default.Visibility,
                        null,
                        modifier = Modifier.align(Alignment.Center),
                        tint = Color.White
                    )
                }
                Box(
                    modifier = Modifier.size(72.dp).padding(12.dp)
                        .background(Color(0xFF565656), shape = RoundedCornerShape(15.dp))
                ) {
                    Icon(
                        Icons.Default.Save,
                        null,
                        modifier = Modifier.align(Alignment.Center),
                        tint = Color.White
                    )
                }
            }
        }

        TextField(
            value = titleText,
            onValueChange = {
                titleText = it
            },
            Modifier.fillMaxWidth(0.7f),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.White
            ),
            textStyle = TextStyle.Default.copy(fontSize = 35.sp),
            placeholder = {
                Text(
                    "Title",
                    color = Color(0xFF9A9A9A),
                    fontSize = 48.sp,
                    fontFamily = FontFamily(Font(Res.font.nunito_semibold))
                )
            }
        )

        TextField(
            value = descriptionText,
            onValueChange = {
                descriptionText = it
            },
            Modifier.fillMaxWidth(0.9f),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.White
            ),
            textStyle = TextStyle.Default.copy(fontSize = 23.sp),
            placeholder = {
                Text(
                    "Type Something.....",
                    color = Color(0xFF9A9A9A),
                    fontSize = 23.sp,
                    fontFamily = FontFamily(Font(Res.font.nunito_semibold))
                )
            }
        )
    }
}