package presentation.screens

data class PrepQuestion(
    val id: Int,
    val question: String,
    val optionOne:String,
    val optionTwo:String,
    val optionResponse:String
)

//FOR SCENES FOLLOWING THE PREP
//Ypu may have to modify the code below
data class SceneOne(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionResponse:Int
)

data class SceneTwo(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionResponse:Int
)

data class SceneThree(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionResponse:Int
)
