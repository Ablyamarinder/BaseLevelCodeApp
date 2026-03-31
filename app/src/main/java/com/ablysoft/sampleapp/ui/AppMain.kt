package com.ablysoft.sampleapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.component.CustomTopAppBar
import com.ablysoft.core.designsystem.icon.AppIcons
import com.ablysoft.sampleapp.utils.AppLog
import com.ablysoft.sampleapp.utils.uiutils.bottomnav.BottomNavComposable
import com.ablysoft.sampleapp.utils.uiutils.navigation.AppState
import com.ablysoft.sampleapp.utils.uiutils.navigation.MyAppNavController

@Composable
fun AppMain(
    appState: AppState,
    navController: NavHostController = rememberNavController()
) {
    val state = appState.navigationState.currentTopLevelKey
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    AppLog.d("navigator $state")
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            CustomTopAppBar(
                titleRes = R.string.home,
                navigationIcon = AppIcons.Search,
                navigationIconContentDescription = stringResource(
                    id = R.string.search,
                ),
                actionIcon = AppIcons.Settings,
                actionIconContentDescription = stringResource(
                    id = R.string.settings,
                ),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                onActionClick = { },
                onNavigationClick = { })
        },
        bottomBar = {
            BottomNavComposable {
                navController.navigate(route = it)
            }
        }

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center
        ) {
            MyAppNavController(navController)
        }
    }

}

