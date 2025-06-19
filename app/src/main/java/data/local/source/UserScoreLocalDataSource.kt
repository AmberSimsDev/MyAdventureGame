package data.local.source

import android.util.Log

class UserScoreLocalDataSource {
    private var score: Int = 0 //The user will start with this score

//USER SCORE SETTER + GETTER
    fun addTwoToScore() { //If you call only this you will get no answer back
        Log.w("User", "addTwoToScore")
        score += 2  // This adds 2 to the current value of int

    }

    fun addOneToScore() { //If you call only this you will get no answer back
        Log.w("User", "addOneToScore")
        score += 1  // This adds 2 to the current value of int

    }
    fun addZeroToScore() { //If you call only this you will get no answer back
        Log.w("User", "addOneToScore")
        score += 0 // This adds 2 to the current value of int

    }
    fun getScore(): Int {  //BECAUSE he say return its job is to deliver the data.
        return score    //Where you call it is where it goes

    }
}