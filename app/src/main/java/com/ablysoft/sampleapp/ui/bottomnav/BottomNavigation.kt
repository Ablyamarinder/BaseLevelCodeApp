package com.ablysoft.sampleapp.ui.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.ablysoft.sampleapp.ui.navigation.Account
import com.ablysoft.sampleapp.ui.navigation.MainScreen
import com.ablysoft.sampleapp.ui.navigation.SplashScreen

enum class Destination(
    val route: Any,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME(SplashScreen, "Home", Icons.Default.Home, "Splash"),
    MENU(MainScreen, "Menu", Icons.Default.Menu, "Main"),
    ACCOUNT(Account, "Account", Icons.Default.AccountCircle, "Account")
}