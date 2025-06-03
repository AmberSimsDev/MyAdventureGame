package domain.repository

import domain.model.PrepQuestions
//PURPOSE: The contract that your app’s business logic depends on.
// It says, “I don’t care where the questions come from (Firebase, local storage, etc),
// I just need a list of them.”
// IMPORTANT for separation of concerns and for testing —
// your domain doesn’t KNOW or care HOW the data is fetched, just that it will be.
interface PrepQuestionsRepository {
    suspend fun getPrepQuestions(): List<PrepQuestions>
}