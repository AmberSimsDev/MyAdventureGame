package presentation.screens

import ambersimsdev.myadventuregame.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import data.local.event.EventC
import data.local.event.EventD
import data.local.event.LuckLevel
import data.local.event.RandomEvent
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import presentation.navigation.Screen
import presentation.viewmodel.EventScreenViewModel

@Composable
fun randomEventScreen(
    navController: NavController, userScoreLocalDataSource: UserScoreLocalDataSource,
    userNameLocalDataSource: UserNameLocalDataSource
) {

    val viewModel = remember {
        EventScreenViewModel(
            userScoreLocalDataSource = userScoreLocalDataSource,
            userNameLocalDataSource = userNameLocalDataSource
        )
    }
    var luckyResult by remember { mutableStateOf("") }
    val buttonClicked by viewModel.buttonClicked.collectAsState()
    val currentScore by viewModel.currentScore.collectAsState()

    //DESCRIPTION MESSAGE  GETS THE MESSAGES OF EVENTS THE USER WILL READ DEPENDING ON THEIR LUCK
    var descriptionMessage = ""
    descriptionMessage = if (currentScore >= 10) {
        RandomEvent.getRandomEventDescription(LuckLevel.LUCKY, 0)
    } else if (currentScore in 8..9) { ///make sure to use for optimization.  just use IFs
        RandomEvent.getRandomEventDescription(LuckLevel.NORMAL, 0)
    } else {
        RandomEvent.getRandomEventDescription(LuckLevel.UNLUCKY, 0)
    }
//WHEN THE USER MAKES A CHOICE THEY WILL READ A DESCRIPTION

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.event_unlocked),
            contentDescription = "Image of man holding or touching giant key."
        )
        //BUTTON CLICKED
        if (buttonClicked) {
            Text(
                text = luckyResult,
                color = Color.Yellow,
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {
             /* if (buttonClicked) {
                    navController.navigate(Screen.RandomEventScreen.route)
                }*/
            }) {
                Text("Continue")
            }
            Text(text = "Current Score is ${currentScore.toString()}")
        }
//BUTTON NOT CLICKED
        if (!buttonClicked) {  //This text will dissapear once clicked
            Text(
                text = descriptionMessage,
                color = Color.White,
                modifier = Modifier.padding(32.dp)
            )

        }
        //BUTTON
        Button(   //LOOK ONLINE FOR PISO
            onClick = {viewModel.currentScore},
            modifier = Modifier.padding(8.dp),
            shape = RectangleShape
        ) {
            Text(text = "Continue")
        }
        Text(text = "Current Score is ${currentScore.toString()}")
    }
}
