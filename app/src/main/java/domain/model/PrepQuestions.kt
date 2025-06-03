package domain.model
//PURPOSE : This is a domain model, a clean representation of what a prep question looks like,
// without any database or UI code.
//This makes it easy to use across different layers (e.g., from repository to ViewModel).
data class PrepQuestions(
    val id: Int,
    val question: String,
    val optionOne:String,
    val optionTwo:String,
    val optionResponse:String
)