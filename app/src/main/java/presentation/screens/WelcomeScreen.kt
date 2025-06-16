package presentation.screens

import ambersimsdev.myadventuregame.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import presentation.navigation.Screen
import presentation.viewmodel.WelcomeScreenViewModel

@Composable
fun welcomeScreen(navController: NavController,
                  viewModel:WelcomeScreenViewModel = viewModel()) {
    //MESSAGE FROM VIEW MODEL:
    val name by viewModel.name.collectAsState()
    //MESSAGE END

    //UI ONLY FOLLOWS
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Image(imageVector = , contentDescription = "Photograph of Madrid " )
        Image(
            painter = painterResource(id = R.drawable.empty_street_bro),
            contentDescription = "Image of city with trees."
        )
        Text(text = "Welcome! Let's start with a name!", color = Color.White)
        Spacer(modifier = Modifier.padding(16.dp))


        OutlinedTextField(value = name,
            onValueChange = viewModel::onNameChange)

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {
            if (
                viewModel.isNameValid()) {
                navController.navigate(Screen.PrepScreen.route)
            }
        }
        ) {
            Text(text = "Ready")

        }
    }


}

@Preview
@Composable
fun welcomeScreenPreview() {
    welcomeScreen(navController = rememberNavController())
}