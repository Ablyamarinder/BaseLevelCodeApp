package com.ablysoft.sampleapp.utils.uiutils.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.ablysoft.sampleapp.utils.uiutils.navigation.Account
import com.ablysoft.sampleapp.utils.uiutils.navigation.HomeScreen
import com.ablysoft.sampleapp.utils.uiutils.navigation.MenuScreen

enum class Destination(
    val route: Any,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME(HomeScreen, "Home", Icons.Default.Home, "Home"),
    MENU(MenuScreen, "Menu", Icons.Default.Menu, "Menu"),
    ACCOUNT(Account, "Account", Icons.Default.AccountCircle, "Account")
}