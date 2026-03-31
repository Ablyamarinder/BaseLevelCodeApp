package com.ablysoft.sampleapp.utils.uiutils.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation3.runtime.NavKey
import com.ablysoft.core.designsystem.component.navigation.NavigationState
import com.ablysoft.core.designsystem.component.navigation.rememberNavigationState
import com.ablysoft.sampleapp.utils.uiutils.bottomnav.TOP_LEVEL_NAV_ITEMS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState {
    val navigationState = rememberNavigationState(HomeScreen, TOP_LEVEL_NAV_ITEMS.keys)

    return remember(
        navigationState,
        coroutineScope
    ) {
        AppState(
            navigationState = navigationState,
            coroutineScope = coroutineScope
        )
    }
}

@Stable
class AppState(
    val navigationState: NavigationState,
    coroutineScope: CoroutineScope,
) {

    /**
     * The top level nav keys that have unread news resources.
     */
    val topLevelNavKey: Flow<Set<NavKey>> = flow {
        navigationState.topLevelKeys
    }

}
