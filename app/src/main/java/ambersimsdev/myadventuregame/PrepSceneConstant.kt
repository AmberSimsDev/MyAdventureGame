package ambersimsdev.myadventuregame

object PrepSceneConstant {
    fun getPrepQuestions(): ArrayList<PrepQuestion> {
        val questionList = ArrayList<PrepQuestion>()
        //ONE
        val inquiryOne = PrepQuestion(1, "Are you from Madrid?",
            "Yes.", "No.", "Alrighty then! Next question!")
        questionList.add(inquiryOne)
        //TWO
        val inquiryTwo = PrepQuestion(2, "Would you consider yourself lucky?",
            "Yes.", "No.", "Alrighty then! Next question!")
        questionList.add(inquiryTwo)

        //TWO
        val inquiryThree =PrepQuestion(3, "Do you consider yourself street smart?",
            "Yes.", "No.", "Alrighty then! Next question!")
        questionList.add(inquiryThree)

        return questionList


    }
}