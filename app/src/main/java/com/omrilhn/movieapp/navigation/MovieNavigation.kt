package com.omrilhn.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.omrilhn.movieapp.screens.details.DetailsScreen
import com.omrilhn.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){
            //pass where this should lead us
            HomeScreen(navController = navController)
        }

        //send Info that you want to show into the DetailsScreen down below
        composable(MovieScreens.DetailsScreen.name+ "/{movie}" ,
        arguments = listOf(navArgument(name = "movie"){type = NavType.StringType}) ){backStackEntry ->
            //The 'backStackEntry' variable which contains INFO that we want
            DetailsScreen(navController,backStackEntry.arguments?.getString("movie"))
        }
    }
}