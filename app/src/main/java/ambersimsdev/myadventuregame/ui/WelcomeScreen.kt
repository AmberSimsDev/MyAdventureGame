package ambersimsdev.myadventuregame.ui

import ambersimsdev.myadventuregame.ui.nav.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun welcomeScreen(navController: NavController) {
    val name = remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome! Let's start with a name!", color = Color.White)
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = name.value , onValueChange = {
            name.value = it })
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick ={
            if(
                name.value.isNotBlank()){
            navController.navigate("Screen.PrepScreen/${name.value}")
            }
         }
        ){
            Text(text = "Ready")

        }
    }


}
@Preview
@Composable
fun welcomeScreenPreview(){
    welcomeScreen(navController = rememberNavController())
}