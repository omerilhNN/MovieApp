package com.omrilhn.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omrilhn.movieapp.MovieRow
import com.omrilhn.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(topBar = {
        Surface(shadowElevation = 5.dp) {
            TopAppBar(title = { Text(text = "MovieAppCompose") },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Magenta),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
        }
    }) {paddingValues ->
        Log.d("Padding","$paddingValues")
        MainContent(navController = navController)
    }
}
@Composable
fun MainContent(navController: NavController,movieList: List<String> = listOf(
    "Avatar",
    "LOTR",
    "Harry Potter",
    "Pianist")){

    Column(modifier = Modifier.padding(12.dp)){
        LazyColumn{//Efficient way to show items
            items(items = movieList){
                MovieRow(movie = it){movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name)//GO TO THAT SPECIFIC SCREEN
                //Log.d("TAG","MainContent: $movie")
                }
            }
        }
    }

}