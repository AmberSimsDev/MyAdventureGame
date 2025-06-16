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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import data.local.event.EventData
import data.local.event.EventDataTwo
import presentation.viewmodel.EventScreenViewModel

@Composable
fun eventScreenTwo(navController: NavController, viewModel: EventScreenViewModel =  viewModel()){
    val currentScore by viewModel.currentScore.collectAsState()
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
    descriptionMessage = if (currentScore >= 8) {
        EventData.getLuckyEventDescription(1)
    } else if (currentScore in 5..7 ) { ///make sure to use for optimization. dont just use IFs
        EventData.getNormalEventDescription(1)
    } else {
        EventData.getUnluckyEventDescription(1)
    }
//WHEN THE USER MAKES A CHOICE THEY WILL READ A DESCRIPTION

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.hostel_image),
            contentDescription = "Image of city with trees."
        )
//BUTTON CLICKED
        if (buttonClicked) {
            Text(
                text = luckyResult,
                color = Color.Yellow,
                modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {
              /*  if (buttonClicked) {
                    navController.navigate(Screen.EventScreenOne.route)
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

            //BUTTON NUMBER 1
            Button(
                onClick = {
                    buttonClicked = true
                    if (currentScore <= 4) {
                        viewModel.answerSelected(2)
                        luckyResult = EventDataTwo.getUnluckyHostelResponse(0)
                    } else if (currentScore in 5..7) {
                        viewModel.answerSelected(1)
                        luckyResult = EventDataTwo.getNormalHostelResponse(0)
                    } else {
                        luckyResult = EventDataTwo.getLuckyHostelResponse(0)
                        currentScore == currentScore
                    }
                }, modifier = Modifier.padding(8.dp), shape = RectangleShape
            ) {
                Text(text = EventDataTwo.getHostelEventResponses(0))
            }

            //BUTTON NUMBER 2
            Button(onClick = {
                buttonClicked = true
                if (currentScore >= 8) {
                    viewModel.answerSelected(1)
                    luckyResult = EventDataTwo.getLuckyHostelResponse(1)
                } else if (currentScore in 5..7) {
                    viewModel.answerSelected(1)
                    luckyResult = EventDataTwo.getNormalHostelResponse(1)
                } else {
                    viewModel.answerSelected(1)
                    luckyResult = EventDataTwo.getUnluckyHostelResponse(1)
                }
            }, modifier = Modifier.padding(8.dp), shape = RectangleShape) {
                Text(text = EventDataTwo.getHostelEventResponses(1))
            }


            //BUTTON NUMBER 3
            Button(
                onClick = {
                    buttonClicked = true
                    if (currentScore >= 5) {
                        currentScore == currentScore
                        luckyResult = EventDataTwo.getLuckyHostelResponse(2)
                    } else if (currentScore == 4) {
                        viewModel.answerSelected(2)
                        luckyResult = EventDataTwo.getNormalHostelResponse(2)
                    } else {
                        viewModel.answerSelected(2)
                        luckyResult = EventDataTwo.getUnluckyHostelResponse(2)
                    }
                },
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) {
                Text(text = EventDataTwo.getHostelEventResponses(2))
            }
            Text(text = "Current Score is ${currentScore.toString()}")
        }
    }

}