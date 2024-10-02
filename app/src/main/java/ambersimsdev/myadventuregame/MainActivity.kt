package ambersimsdev.myadventuregame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ambersimsdev.myadventuregame.ui.theme.MyAdventureGameTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAdventureGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    welcomeScreen()
                }
            }
        }
    }
}

@Composable
fun welcomeScreen() {
    val name = remember { mutableStateOf("")}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome! Let's start with a name!" )
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = name.value , onValueChange = {
            name.value })
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Ready")

        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAdventureGameTheme {
        welcomeScreen()
    }
}