package presentation.viewmodel

import androidx.lifecycle.ViewModel
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import domain.model.PrepQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EventScreenViewModel(private val userScoreLocalDataSource: UserScoreLocalDataSource,
                           private val userNameLocalDataSource: UserNameLocalDataSource):ViewModel() {
    //IS CLICKED TODO: work on button when clicked
    private var _buttonClicked = MutableStateFlow(false)
    var buttonClicked: StateFlow<Boolean> = _buttonClicked

    //CURRENT SCORE
    private val _currentScore = MutableStateFlow(userScoreLocalDataSource.getScore())
    val currentScore: StateFlow<Int> = _currentScore

    //IS READY
    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady

    //QUESTION LIST
    private val _questions = MutableStateFlow<List<PrepQuestions>>(emptyList())
    val questions: StateFlow<List<PrepQuestions>> = _questions

    //QUESTION INDEX
    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex

    // USER NAME
    val userName = userNameLocalDataSource.getName()


    //   //     DETAILED LOGIC  & FUNCTIONS //    //

   fun isClicked(){
       _buttonClicked.value = true
   }

    fun answerSelected(option: Int) {
        if (_currentQuestionIndex.value >= 2) return
        _currentQuestionIndex.value++

        // Add to score
        if (option == 2) userScoreLocalDataSource.addTwoToScore()
        if (option == 1) userScoreLocalDataSource.addOneToScore()
        //if(option is 0 on the index nothing is added to the score
        _currentScore.value = userScoreLocalDataSource.getScore()
    }
}
