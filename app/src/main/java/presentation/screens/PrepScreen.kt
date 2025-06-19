package presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import data.local.source.PrepQuestionsLocalDataSource
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import domain.model.PrepQuestions
import presentation.navigation.Screen
import presentation.viewmodel.PrepScreenViewModel


//class PrepActivity() {
//  private var pqCurrentPosition: Int = 1
//private var getPrepQuestions: ArrayList<PrepQuestion>? = null
//private var pqSelectedOptionPosition: Int = 0
//private var userName: String? = null


const val ClassName = "PrepScreen"

@Composable
fun prepScreen(navController: NavController, userScoreLocalDataSource: UserScoreLocalDataSource,
               userNameLocalDataSource: UserNameLocalDataSource, prepQuestionsLocalDataSource: PrepQuestionsLocalDataSource
){

    val viewModel = remember {
        PrepScreenViewModel(
            userScoreLocalDataSource = userScoreLocalDataSource,
            userNameLocalDataSource = userNameLocalDataSource,
            prepQuestionsLocalDataSource = prepQuestionsLocalDataSource) }

    val isReady by viewModel.isReady.collectAsState()
    val navigateToNextScreen by viewModel.navigateToNextScreen.collectAsState()
    val currentQuestionIndex by viewModel.currentQuestionIndex.collectAsState()
    val currentScore by viewModel.currentScore.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val name = viewModel.userName

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
            //BUTTON  - READY - BUTTON///
            Button(
                onClick = {viewModel.loadQuestions()}, ///PUT WHAT THE BUTTON WILL DO IF YOU CLICK
                modifier = Modifier.padding(8.dp),
                shape = RectangleShape
            ) { Text(text = "Ready") }

        } else {
            val currentQuestion = questions.getOrNull(currentQuestionIndex)
            if (currentQuestion != null) {

                Text(text = currentQuestion.question, color = Color.White)
                //INTRODUCING BUTTONS
                LaunchedEffect(navigateToNextScreen) {
                    if (navigateToNextScreen) {
                        navController.navigate(Screen.EventScreenOne.route)
                    }
                }

                //BUTTON NUMBER 1
                Button(
                    onClick = {
                        viewModel.answerSelected(2)
                              },
                    modifier = Modifier.padding(8.dp),
                    shape = RectangleShape
                ) {
                    Text(text = currentQuestion.optionOne)
                }
                //BUTTON NUMBER 2
                Button(
                    onClick = {
                        viewModel.answerSelected(0)
                    },
                    modifier = Modifier.padding(8.dp),
                    shape = RectangleShape
                ) {
                    Text(text = currentQuestion.optionTwo)
                }
                Text(text = currentQuestion.optionResponse, color = Color.White)
                Text(text = currentScore.toString())

                if (currentScore >= 5) {
                    Text(text = "Amazing! You have so much luck!")
                } else if (currentScore == 4) { ///make sure to use for optimization. dont just use IFs
                    Text(text = "Pretty normal luck, I see.")

                } else {
                    Text(text = "Wow, you're so unlucky! :0 ")
                }
            }
        }
    }

}


// Image(imageVector = , contentDescription = "Photograph of Madrid " )


@Preview
@Composable
fun prepScreenPreview() {
    prepScreen(rememberNavController(), UserScoreLocalDataSource(),
        UserNameLocalDataSource(), PrepQuestionsLocalDataSource())
}
/* OMITTED CODE


val name = remember { mutableStateOf("") } */