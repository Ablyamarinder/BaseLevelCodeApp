package com.ablysoft.sampleapp.ui.bottomnav

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.ablysoft.core.R

@Composable
fun BottomNavComposable(onTabSelected: (Any) -> Unit) {
    val startDestination = Destination.HOME
    val selectedDestination = rememberSaveable { mutableIntStateOf(startDestination.ordinal) }
    NavigationBar(
        modifier = Modifier.shadow(
            elevation = 12.dp,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ),
        windowInsets = NavigationBarDefaults.windowInsets,
        tonalElevation = dimensionResource(R.dimen.size_10)
    ) {
        Destination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedDestination.intValue == index,
                onClick = {
                    onTabSelected.invoke(destination.route)
                    selectedDestination.intValue = index
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = destination.contentDescription
                    )
                },
                label = { Text(destination.label) }
            )
        }
    }
}

