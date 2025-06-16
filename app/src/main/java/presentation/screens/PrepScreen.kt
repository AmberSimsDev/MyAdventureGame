package presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import presentation.navigation.Screen
import presentation.viewmodel.PrepScreenViewModel


//class PrepActivity() {
//  private var pqCurrentPosition: Int = 1
//private var getPrepQuestions: ArrayList<PrepQuestion>? = null
//private var pqSelectedOptionPosition: Int = 0
//private var userName: String? = null


const val ClassName = "PrepScreen"

@Composable
fun prepScreen(navController: NavController, viewModel: PrepScreenViewModel = viewModel()){
    val isReady by viewModel.isReady.collectAsState()
    val currentQuestionIndex by viewModel.currentQuestionIndex.collectAsState()
    val currentScore by viewModel.currentScore.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val name = viewModel.userName

//TODO: fix the UI to fit the prep screen view model
    //    //  COMPOSE UI  //   //
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!isReady) { //THIS IS ONLYYYYYY WHAT WILL BE DISPLAYED
            Text(
                text = "Now, just a few questions before we begin, $name!",
                color = Color.White,
                modifier = Modifier.padding(32.dp)
            )
            Button(
                onClick = { isReady }, ///PUT WHAT THE BUTTON WILL DO IF YOU CLICK
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) { Text(text = "Ready") }

        } else {
            val currentQuestion = questions.getOrNull(currentQuestionIndex)
            if (currentQuestion != null) {

                Text(text = currentQuestion.question, color = Color.White)
                //INTRODUCING BUTTONS
                //BUTTON NUMBER 1
                Button(onClick = {
                    viewModel.answerSelected(2)
                    if (currentQuestionIndex >= 2) navController.navigate(Screen.EventScreenOne.route)
                }) {
                    Text(currentQuestion.optionOne)
                }

                Button(
                    onClick = {
                        viewModel.answerSelected(2)
                        if (currentQuestionIndex >= 2) {
                            navController.navigate(Screen.EventScreenOne.route)
                        } else {
                            currentQuestionIndex
                        }
                    },
                    modifier = Modifier.padding(8.dp),
                    shape = RectangleShape
                ) {
                    Text(text = currentQuestion.optionOne)
                }
                //BUTTON NUMBER 2
                Button(
                    onClick = {
                        viewModel.answerSelected(1)
                        if (currentQuestionIndex >= 2) {
                            navController.navigate(Screen.EventScreenOne.route)
                        } else {
                            currentQuestionIndex
                        }
                    },
                    modifier = Modifier.padding(8.dp),
                    shape = RectangleShape
                ) {
                    Text(text = currentQuestion.optionTwo)
                }
                Text(text = currentQuestion.optionResponse, color = Color.White)
                Text(text = currentScore.toString())

                if (currentScore >= 5) {
                    Text(text = " Congrats, You are Lucky!")
                } else if (currentScore == 4) { ///make sure to use for optimization. dont just use IFs
                    Text(text = " You are normal")

                } else {
                    Text(text = "You're an unlucky bastard :(")
                }
            }
        }
    }

}


// Image(imageVector = , contentDescription = "Photograph of Madrid " )


@Preview
@Composable
fun prepScreenPreview() {
    prepScreen(rememberNavController())
}
/* OMITTED CODE


val name = remember { mutableStateOf("") } */