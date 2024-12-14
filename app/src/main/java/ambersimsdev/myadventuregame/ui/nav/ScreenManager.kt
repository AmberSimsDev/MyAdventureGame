package ambersimsdev.myadventuregame.ui.nav

sealed class Screen (val route: String) {

    object WelcomeScreen: Screen("welcomeScreen")

    object PrepScreen : Screen("prepScreen /{name}")

    object actionScreen: Screen("actionScreen")


}


/*object Screen {
   var welcomeScreen = "welcomeScreen"

    var prepScreen = "prepScreen"

    var actionScreen ="actionScreen"


}

*/