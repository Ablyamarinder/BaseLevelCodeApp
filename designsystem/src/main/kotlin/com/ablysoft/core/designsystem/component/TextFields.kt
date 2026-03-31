package com.ablysoft.core.designsystem.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppOutLinedTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    placeHolder: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange.invoke(it) },
        label = { Text(placeHolder) }
    )
}

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    placeHolder: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange.invoke(it) },
        label = { Text(placeHolder) }
    )
}

