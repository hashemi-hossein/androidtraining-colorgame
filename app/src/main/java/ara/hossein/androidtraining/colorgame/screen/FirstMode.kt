package ara.hossein.androidtraining.colorgame.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun FirstMode(modifier: Modifier = Modifier) {
    val score = remember { mutableIntStateOf(0) }

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

    var i by remember { mutableIntStateOf(Random.nextInt(lstColorTexts.size)) }
    var j by remember { mutableIntStateOf(Random.nextInt(lstColors.size)) }

    fun next() {
        i = Random.nextInt(lstColorTexts.size)
        j = Random.nextInt(lstColors.size)
    }

    Box(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card {
                Text(lstColorTexts[i], color = lstColors[j], fontSize = 24.sp, modifier = Modifier.padding(30.dp))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button({
                    if (i == j) score.intValue++
                    else score.intValue--
                    next()
                }) { Text("Yes") }
                Button({
                    if (i != j) score.intValue++
                    else score.intValue--
                    next()
                }) { Text("No") }
            }
            Text("Score: ${score.intValue}")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FirstModePreview() {
    FirstMode()
}
