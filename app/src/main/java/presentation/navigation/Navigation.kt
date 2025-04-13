package presentation.navigation

import presentation.screens.prepScreen
import presentation.screens.welcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.screens.eventScreenOne
import presentation.screens.eventScreenTwo

@Composable
fun appNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route, builder = {
        composable(Screen.WelcomeScreen.route) {
            welcomeScreen(navController)
        }
        composable(Screen.PrepScreen.route) {

            prepScreen(navController)
        }
        composable(Screen.EventScreenOne.route){
            eventScreenOne(navController)
        }
        composable(Screen.EventScreenTwo.route){
            eventScreenTwo(navController)
        }

    })

}

/*

  composable("Screen.prepScreen/{name}"){
            val name = it.arguments?.getString("name")
            prepScreen(name?: "no name")
            }

            composable(route = "prepScreen/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            prepScreen(name = name)
        }

 */