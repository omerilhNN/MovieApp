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
import com.bawp.movieapp.model.Movie
import com.bawp.movieapp.model.getMovies
import com.omrilhn.movieapp.navigation.MovieScreens
import com.omrilhn.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(topBar = {
        Surface(shadowElevation = 5.dp) {
            TopAppBar(title = { Text(text = "MovieAppCompose") },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Transparent),
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
fun MainContent(navController: NavController,movieList: List<Movie> = getMovies()){

    Column(modifier = Modifier.padding(12.dp)){
        LazyColumn{//Efficient way to show items
            items(items = movieList){
                MovieRow(movie = it){movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                //GO TO THAT SPECIFIC SCREEN
                 // Always use '/' because it works like a link
                }
            }
        }
    }

}