package data

import android.util.Log

object User {
   private var score: Int = 0 //The user will start with this score

    fun addToScore(){ //If you call only this you will get no answer back
        Log.w("User", "addToScore")
        score += 2  // This adds 2 to the current value of int

    }
    fun getScore():Int{  //BECAUSE he say return its job is to deliver the data.
        return score    //Where you call it is where it goes

    }

}