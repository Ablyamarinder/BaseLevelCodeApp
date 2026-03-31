package com.ablysoft.sampleapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.component.AppOutLinedTextField
import com.ablysoft.core.designsystem.component.AppTextField
import com.ablysoft.core.designsystem.component.DynamicAsyncImage

@Composable
fun HomeComposable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        val inputFieldValue = remember { mutableStateOf("") }
        AppOutLinedTextField(
            modifier = Modifier
                .background(
                    color = Color.White,
                )
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.size_15)),
            value = inputFieldValue.value,
            placeHolder = stringResource(R.string.input_placeholder)
        ) {
            inputFieldValue.value = it
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_15)))
        AppTextField(
            modifier = Modifier
                .background(
                    color = Color.White,
                )
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.size_15)),
            value = inputFieldValue.value,
            placeHolder = stringResource(R.string.input_placeholder)
        ) {
            inputFieldValue.value = it
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_15)))
        DynamicAsyncImage(
            imageUrl = "https://images.pexels.com/photos/35389652/pexels-photo-35389652.jpeg?_gl=1*xmw63n*_ga*MzI2NTk3NjguMTc3NDg3MDI4OA..*_ga_8JE65Q40S6*czE3NzQ4NzAyODgkbzEkZzAkdDE3NzQ4NzAyODgkajYwJGwwJGgw",
            modifier = Modifier
                .height(dimensionResource(R.dimen.size_200))
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

}