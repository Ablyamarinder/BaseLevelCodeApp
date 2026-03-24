package com.example.newsampleapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsampleapp.ui.posts.PostListComposable
import com.example.newsampleapp.ui.splash.SplashComposable


// Define the MyApp composable, including the `NavController` and `NavHost`.
@Composable
fun MyAppNavController() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = SplashScreen) {
        composable<SplashScreen> { backStackEntry ->
            SplashComposable {
                navController.navigate(route = MainScreen)
            }
        }
        composable<MainScreen> {
            PostListComposable()
        }
    }
}