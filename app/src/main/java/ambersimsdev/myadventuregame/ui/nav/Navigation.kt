package ambersimsdev.myadventuregame.ui.nav

import ambersimsdev.myadventuregame.ui.prepScreen
import ambersimsdev.myadventuregame.ui.welcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun appNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen.welcomeScreen", builder = {
        composable("Screen.welcomeScreen") {
            welcomeScreen(navController)
        }
        composable("Screen.prepScreen/{name}"){
            val name = it.arguments?.getString("name")
            prepScreen(name ="$name")
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