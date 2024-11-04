package ara.hossein.androidtraining.colorgame.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SecondMode(modifier: Modifier = Modifier) {
    // show a list of colors and their names so the user can select the correct color instead of the yes and no buttons

    val lstColorTexts = listOf(
        "Red",
        "Green",
        "Blue",
        "Yellow",
        "Purple",
        "Orange",
        "Black",
    )
    val lstColors = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color(0xFF800080), // Purple
        Color(0xFFFFA500), // Orange
        Color.Black,
    )

    Box(Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text("Color")
            LazyColumn {
                items(lstColorTexts) {
                    Card(modifier = Modifier.padding(5.dp)) {
                        Text(
                            modifier = Modifier.padding(16.dp), text = it
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SecondModePreview() {
    SecondMode()
}