package presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.EventData
import data.User

@Composable
fun userLuckScreen() {
    val currentScore = User.getScore()
    var buttonClicked by remember { mutableStateOf(false) }
    var luckyResult by remember {
        mutableStateOf("")
    }
    /*  var message = ""
      message = if (currentScore >= 5) {
          EventData.getLuckyEvent()
      } else if (currentScore == 4) { ///make sure to use for optimization. dont just use IFs
          EventData.getNormalEvent()
      } else {
          EventData.getUnluckyEvent()
      }*/

    //DESCRIPTION MESSAGE  GETS THE MESSAGES OF EVENTS THE USER WILL READ DEPENDING ON THEIR LUCK
    var descriptionMessage = ""
    descriptionMessage = if (currentScore >= 5) {
        EventData.getLuckyEventDescription(0)
    } else if (currentScore == 4) { ///make sure to use for optimization. dont just use IFs
        EventData.getNormalEventDescription(0)
    } else {
        EventData.getUnluckyEventDescription(0)
    }
//WHEN THE USER MAKES A CHOICE THEY WILL READ A DESCRIPTION

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//BUTTON CLICKED
        if (buttonClicked) {
            Text(
                text = luckyResult,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = { }) {
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
            luckyResult = when {
                currentScore >= 5 -> EventData.getLuckyResponseOne(0)
                currentScore == 4 -> EventData.getNormalResponseOne(1)
                else -> EventData.getUnluckyResponseOne(2)
            }

            //BUTTON NUMBER 1
            Button(
                onClick = {
                    buttonClicked = true
                    if (currentScore <= 4) {
                        User.addTwoToScore()
                    } else if (currentScore == 4) {
                        User.addOneToScore()
                    } else {
                        currentScore == currentScore
                    }
                }, modifier = Modifier.padding(8.dp), shape = RectangleShape
            ) {
                Text(text = EventData.getFlightResponses(0))
            }

            //BUTTON NUMBER 2
            Button(onClick = {
                buttonClicked = true
                if (currentScore >= 5) {
                    User.addOneToScore()
                } else if (currentScore == 4) {
                    User.addOneToScore()
                } else {
                    User.addOneToScore()
                }
            }, modifier = Modifier.padding(8.dp), shape = RectangleShape) {
                Text(text = EventData.getFlightResponses(1))
            }


            //BUTTON NUMBER 3
            Button(
                onClick = {
                    buttonClicked = true
                    if (currentScore >= 5) {
                        User.addTwoToScore()
                    } else if (currentScore == 4) {
                        User.addOneToScore()
                    } else {
                        currentScore == currentScore
                    }
                },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(text = EventData.getFlightResponses(2))
            }
            Text(text = "Current Score is ${currentScore.toString()}")
        }
    }
}


/* @Preview
 @Composable
 fun actionScreenPreview() {
     userLuckScreen()
 }*/