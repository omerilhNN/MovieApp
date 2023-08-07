package com.omrilhn.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

        composable(MovieScreens.DetailsScreen.name){
            DetailsScreen(navController)
        }
    }
}