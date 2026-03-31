package com.ablysoft.sampleapp.utils.uiutils.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
@Composable
fun rememberAppState(
    navigationState: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState {

    return remember(
        navigationState,
        coroutineScope
    ) {
        AppState(
            navController = navigationState,
            coroutineScope = coroutineScope
        )
    }
}

@Stable
class AppState(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
) {

    @SuppressLint("RestrictedApi")
    val backStackRoutes = navController.currentBackStack
        .map { stackEntries ->
            stackEntries.map { entry -> entry.destination.route }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
}
