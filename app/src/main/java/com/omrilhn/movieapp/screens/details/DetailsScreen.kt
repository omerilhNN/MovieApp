package com.omrilhn.movieapp.screens.details

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omrilhn.movieapp.screens.home.MainContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieData: String?){
    Scaffold(topBar = {
        Surface(shadowElevation = 2.dp) {
            TopAppBar(title = { Text(text = "MovieAppCompose") },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Magenta),
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth())
            Row {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription ="ArrowBack",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    } )
                Spacer(modifier = Modifier.width(100.dp))

            }
        }
    }) {paddingValues ->
        Log.d("MSG","$paddingValues")
        Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center ){

        }
        Text(text = movieData.toString()
            ,style = MaterialTheme.typography.bodyMedium)
      }
    }
}
//    Surface(modifier = Modifier
//        .fillMaxWidth()
//        .fillMaxHeight()){
//        Column(horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center ){
//
//        }
//        Text(text = movieData.toString(),style = MaterialTheme.typography.bodyMedium)
//        Spacer(modifier = Modifier.height(23.dp))
//        Button(onClick = {
//            //GOING BACK TO HOMESCREEN
//            navController.popBackStack() //Details screen is the one on top of the stack
//            // so when you popBackStack it will return to the main
//        }) {
//            Text(text = "Go Back")
//
//        }
//    }
//}