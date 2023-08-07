package com.omrilhn.movieapp.navigation

enum class MovieScreens{
    HomeScreen,
    DetailsScreen;
    companion object{ //companion : STATIC
        fun fromRoute(route:String?):MovieScreens
        =when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen //when you find HomeScreen.name after the delimiter then go to HomeScreen
            DetailsScreen.name -> DetailsScreen
            null-> HomeScreen //when its null go to HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")


        }
    }
}