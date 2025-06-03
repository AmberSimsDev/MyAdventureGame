package data.local.entity

//PURPOSE: TO DEFINE STORAGE AND RETRIEVAL FOR PREP QUESTION PROPERTIES

//Step 1:  Define data class with properties and types

data class PrepQuestionsLocalEntity (
    val id: Int,
    val question: String,
    val optionOne:String,
    val optionTwo:String,
    val optionResponse:String
)

