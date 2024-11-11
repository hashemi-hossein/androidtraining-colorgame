package ara.hossein.androidtraining.colorgame.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val mode = remember { mutableIntStateOf(0) }

    OutlinedIconButton(
        onClick = { mode.intValue = 0 },
        modifier = Modifier.padding(50.dp)
    ) {
        Icon(imageVector = Icons.Filled.Home, contentDescription = null)
    }

    when (mode.intValue) {
        0 -> GameInit(mode)
        1 -> FirstMode()
        2 -> SecondMode()
    }
}

@Composable
private fun GameInit(mode: MutableIntState) {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button({
                mode.intValue = 1
            }) {
                Text("First Mode")
            }
            Button({
                mode.intValue = 2
            }) {
                Text("Second Mode")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}