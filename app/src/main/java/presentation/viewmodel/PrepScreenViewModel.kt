package presentation.viewmodel

import androidx.lifecycle.ViewModel
import data.local.entity.PrepQuestionsLocalEntity
import data.local.source.PrepQuestionsLocalDataSource
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import domain.model.PrepQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PrepScreenViewModel(private val userScoreLocalDataSource: UserScoreLocalDataSource,
                          private val userNameLocalDataSource: UserNameLocalDataSource,
                          private val prepQuestionsLocalDataSource: PrepQuestionsLocalDataSource): ViewModel() {

    //CURRENT SCORE
    private val _currentScore = MutableStateFlow(userScoreLocalDataSource.getScore())
    val currentScore: StateFlow<Int> = _currentScore

    //IS READY
    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady

    //QUESTION LIST
    private val _questions = MutableStateFlow<List<PrepQuestionsLocalEntity>>(emptyList())
    val questions: StateFlow<List<PrepQuestionsLocalEntity>> = _questions


    //QUESTION INDEX
    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex

    // USER NAME
    val userName = userNameLocalDataSource.getName()

    //NAVIGATION
    private val _navigateToNextScreen = MutableStateFlow(false)
    val navigateToNextScreen: StateFlow<Boolean> = _navigateToNextScreen


    //   //     DETAILED LOGIC  & FUNCTIONS //    //

    //SET READY
    fun setReady() {
        val isReady = true
    }

    //PREP QUESTION LIST
    fun loadQuestions() {
        _questions.value = prepQuestionsLocalDataSource.getPrepQuestions()
        _isReady.value = true
    }
    //ADD TO SCORE
    fun answerSelected(optionValue: Int) { //ADD LOGIC HERE AND NOT IN UI
        _currentScore.value += optionValue
        if (_currentQuestionIndex.value >= 2) {
            _navigateToNextScreen.value = true
        }else{
            _currentQuestionIndex.value+= 1
        }

        // Add to score
        if (optionValue == 2) userScoreLocalDataSource.addTwoToScore()
        if (optionValue == 1) userScoreLocalDataSource.addOneToScore()
        if (optionValue == 0) userScoreLocalDataSource.addZeroToScore()
        //if(option is 0 on the index nothing is added to the score
        _currentScore.value = userScoreLocalDataSource.getScore()
    }
}


