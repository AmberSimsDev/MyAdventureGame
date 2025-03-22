package presentation.navigation

sealed class Screen (val route: String) {

    data object WelcomeScreen: Screen("WelcomeScreen")

    data object PrepScreen : Screen("PrepScreen")

    data object UserLuckScreen: Screen("UserLuckScreen")


}


/*object Screen {
   var welcomeScreen = "welcomeScreen"

    var prepScreen = "prepScreen"

    var actionScreen ="actionScreen"


}

*/