package presentation.navigation

sealed class Screen (val route: String) {

    data object WelcomeScreen: Screen("WelcomeScreen")

    data object PrepScreen : Screen("PrepScreen")

    data object EventScreenOne: Screen("EventScreenOne")

    data object EventScreenTwo: Screen("EventScreenTwo")

    data object EventScreenThree: Screen("EventScreenThree")

    data object EventScreenFour: Screen("EventScreenFour")

    data object RandomEventScreen: Screen("RandomEventScreen")


}


/*object Screen {
   var welcomeScreen = "welcomeScreen"

    var prepScreen = "prepScreen"

    var actionScreen ="actionScreen"


}

*/