package com.ablysoft.sampleapp.utils.uiutils.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ablysoft.sampleapp.ui.account.AccountComposable
import com.ablysoft.sampleapp.ui.home.HomeComposable
import com.ablysoft.sampleapp.ui.posts.PostListComposable
import com.ablysoft.sampleapp.ui.splash.SplashComposable

// Define the MyApp composable, including the `NavController` and `NavHost`.
@Composable
fun MyAppNavController(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = HomeScreen) {
        composable<SplashScreen>(
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) { backStackEntry ->
            // We also have a custom splash screen so that if we have any
            // major point to implement then we can opt for this.
            SplashComposable {
                navController.navigate(route = HomeScreen)
            }
        }
        val animationDuration = 500
        composable<HomeScreen>(
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        animationDuration, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(animationDuration, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        animationDuration, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(animationDuration, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }

        ) {
            HomeComposable()
        }

        composable<MenuScreen>(
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        animationDuration, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(animationDuration, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        animationDuration, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(animationDuration, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            PostListComposable()
        }

        composable<Account>(
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        animationDuration, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(animationDuration, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        animationDuration, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(animationDuration, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            AccountComposable()
        }
    }
}