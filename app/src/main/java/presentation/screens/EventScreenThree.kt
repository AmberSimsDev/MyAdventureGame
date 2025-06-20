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
import data.local.event.LuckLevel
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import presentation.navigation.Screen
import presentation.viewmodel.EventScreenViewModel

@Composable
fun eventScreenThree(navController: NavController, userScoreLocalDataSource: UserScoreLocalDataSource,
                   userNameLocalDataSource: UserNameLocalDataSource
) {

    val viewModel = remember {
        EventScreenViewModel(
            userScoreLocalDataSource = userScoreLocalDataSource,
            userNameLocalDataSource = userNameLocalDataSource)
    }

    val currentScore by viewModel.currentScore.collectAsState()
    val buttonClicked by viewModel.buttonClicked.collectAsState()
    var luckyResult by remember {
        mutableStateOf("")
    }

    //DESCRIPTION MESSAGE  GETS THE MESSAGES OF EVENTS THE USER WILL READ DEPENDING ON THEIR LUCK
    var descriptionMessage = ""
    descriptionMessage = if (currentScore >= 8) {
        EventC.getFirstNightEventDescription(LuckLevel.LUCKY,0)
    } else if (currentScore in 6..7) { ///make sure to use for optimization.  just use IFs
        EventC.getFirstNightEventDescription(LuckLevel.NORMAL,0)
    } else {
        EventC.getFirstNightEventDescription(LuckLevel.UNLUCKY,0)
    }
//WHEN THE USER MAKES A CHOICE THEY WILL READ A DESCRIPTION

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.firstnight),
            contentDescription = "Image of moon in night sky."
        )

//BUTTON CLICKED
        if (buttonClicked) {
            Text(
                text = luckyResult,
                color = Color.Yellow,
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {
               if (buttonClicked) {
                    navController.navigate(Screen.EventScreenFour.route)
                }
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

            //BUTTON NUMBER 1
            Button(
                onClick = {
                    viewModel.isClicked()
                    if (currentScore <= 5) {
                        currentScore == currentScore
                        luckyResult = EventC.getLuckyResponseC(LuckLevel.UNLUCKY, 0)
                    } else if (currentScore in 6..7) {
                        viewModel.answerSelected(1)
                        luckyResult = EventC.getLuckyResponseC(LuckLevel.NORMAL, 0)
                    } else {
                        luckyResult = EventC.getLuckyResponseC(LuckLevel.LUCKY, 0)
                        currentScore == currentScore

                    }
                }, modifier = Modifier.padding(8.dp), shape = RectangleShape
            ) {
                Text(text = EventC.getFirstNightResponse(0))
            }

            //BUTTON NUMBER 2
            Button(onClick = {
                viewModel.isClicked()
                if (currentScore >= 5) {
                    viewModel.answerSelected(1)
                    luckyResult = EventC.getLuckyResponseC(LuckLevel.LUCKY, 1)
                } else if (currentScore == 4) {
                    viewModel.answerSelected(1)
                    luckyResult = EventC.getLuckyResponseC(LuckLevel.NORMAL, 1)
                } else {
                    viewModel.answerSelected(1)
                    luckyResult = EventC.getLuckyResponseC(LuckLevel.UNLUCKY, 1)
                }
            }, modifier = Modifier.padding(8.dp), shape = RectangleShape) {
                Text(text = EventC.getFirstNightResponse(1))
            }


            //BUTTON NUMBER 3
            Button(
                onClick = {
                    viewModel.isClicked()

                    if (currentScore >= 5) {
                        viewModel.answerSelected(2)
                        luckyResult = EventC.getLuckyResponseC(LuckLevel.LUCKY, 2)
                    } else if (currentScore == 4) {
                        viewModel.answerSelected(2)
                        luckyResult = EventC.getLuckyResponseC(LuckLevel.NORMAL, 2)
                    } else {
                        currentScore == currentScore
                        luckyResult = EventC.getLuckyResponseC(LuckLevel.UNLUCKY, 2)
                    }
                },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {

                Text(text = EventC.getFirstNightResponse(2))
            }
            Text(text = "Current Score is ${currentScore.toString()}")
        }
    }
}