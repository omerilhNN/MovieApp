@file:OptIn(ExperimentalMaterial3Api::class)

package com.omrilhn.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omrilhn.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}
@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(title = {Text(text = "MovieAppCompose") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color.Magenta),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth())
            }
        }) {paddingValues ->
                Text(paddingValues.toString())
        }
    }
}
@Composable
fun MainContent(movieList: List<String> = listOf(
    "Avatar",
    "LOTR",
    "Harry Potter",
    "Pianist")){

    Column(modifier = Modifier.padding(12.dp)){
        LazyColumn{//Efficient way to show items
            items(items = movieList){
                MovieRow(movie = it)
            }
        }
    }

}
@Composable
fun MovieRow(movie:String){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp)){
            Text(text = movie)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}