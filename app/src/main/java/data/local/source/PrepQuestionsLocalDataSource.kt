package data.local.source

import data.local.entity.PrepQuestionsLocalEntity

//PURPOSE: TO DEFINE STORAGE AND RETRIEVAL FOR PREP QUESTION PROPERTIES

//Step 2. Create an object (as it only does one thing)
//Define a function in your object that inherits from the data class above
//The function get will deliver a list using the direction above.
//You will hardcode these details in your case. Your questions won't change.

class PrepQuestionsLocalDataSource{
    fun getPrepQuestions():List<PrepQuestionsLocalEntity>{
        return listOf(
            PrepQuestionsLocalEntity(1, "Are you from the EU?", "Yes.",
                "No.", "Alrighty then! Next question!"),

            PrepQuestionsLocalEntity(2, "Would you consider yourself lucky?",
                "Yes.", "No.", "Alrighty then! Next question!"),

            PrepQuestionsLocalEntity(3, "Do you consider yourself street smart?",
                "Yes.", "No.", "All done! Time to begin! ")
        )

    }
}
//Next, you will interact with this data in the Repository


