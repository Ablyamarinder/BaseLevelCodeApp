package com.ablysoft.sampleapp.utils.uiutils.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.ablysoft.core.R
import com.ablysoft.sampleapp.utils.uiutils.navigation.AccountScreen
import com.ablysoft.sampleapp.utils.uiutils.navigation.HomeScreen
import com.ablysoft.sampleapp.utils.uiutils.navigation.MenuScreen

enum class Destination(
    val route: Any,
    val stringId: Int,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME(HomeScreen, R.string.home, Icons.Default.Home, "Home"),
    MENU(MenuScreen, R.string.menu, Icons.Default.Menu, "Menu"),
    ACCOUNT(AccountScreen, R.string.account, Icons.Default.AccountCircle, "Account")
}

val TOP_LEVEL_NAV_ITEMS = mapOf(
    HomeScreen to Destination.HOME,
    MenuScreen to Destination.MENU,
    AccountScreen to Destination.ACCOUNT,
)
