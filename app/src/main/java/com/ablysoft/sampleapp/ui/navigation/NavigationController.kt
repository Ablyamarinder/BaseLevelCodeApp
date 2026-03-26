package com.ablysoft.sampleapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ablysoft.sampleapp.ui.account.AccountComposable
import com.ablysoft.sampleapp.ui.posts.PostListComposable
import com.ablysoft.sampleapp.ui.splash.SplashComposable

// Define the MyApp composable, including the `NavController` and `NavHost`.
@Composable
fun MyAppNavController(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = SplashScreen) {
        composable<SplashScreen> { backStackEntry ->
            // We also have a custom splash screen so that if we have any
            // major point to implement then we can opt for this.
            SplashComposable {
                //navController.navigate(route = MainScreen)
            }
        }
        composable<MainScreen> {
            PostListComposable()
        }

        composable<Account> {
            AccountComposable()
        }
    }
}