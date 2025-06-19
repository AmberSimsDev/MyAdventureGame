package presentation.navigation

import presentation.screens.prepScreen
import presentation.screens.welcomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.local.source.PrepQuestionsLocalDataSource
import data.local.source.UserNameLocalDataSource
import data.local.source.UserScoreLocalDataSource
import presentation.screens.eventScreenOne
import presentation.screens.eventScreenTwo

@Composable
fun appNav() {
    val navController = rememberNavController()
    val userNameLocalDataSource = remember { UserNameLocalDataSource() }
    val userScoreLocalDataSource = remember { UserScoreLocalDataSource() }
    val prepQuestionsLocalDataSource = remember { PrepQuestionsLocalDataSource() }


    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route, builder = {
        composable(Screen.WelcomeScreen.route) {
            welcomeScreen(navController = navController,
                userNameLocalDataSource = userNameLocalDataSource)
        }
        composable(Screen.PrepScreen.route) {

            prepScreen(navController = navController,
            userScoreLocalDataSource = userScoreLocalDataSource,
            userNameLocalDataSource = userNameLocalDataSource,
            prepQuestionsLocalDataSource = prepQuestionsLocalDataSource)
        }
        composable(Screen.EventScreenOne.route){
            eventScreenOne(navController= navController,
                userScoreLocalDataSource = userScoreLocalDataSource,
                userNameLocalDataSource = userNameLocalDataSource)
        }
        composable(Screen.EventScreenTwo.route){
            eventScreenTwo(navController= navController,
                userScoreLocalDataSource = userScoreLocalDataSource,
                userNameLocalDataSource = userNameLocalDataSource)
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