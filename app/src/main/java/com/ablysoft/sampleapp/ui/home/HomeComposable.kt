package com.ablysoft.sampleapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.component.DynamicAsyncImage

@Composable
fun HomeComposable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        DynamicAsyncImage(
            imageUrl = "https://images.pexels.com/photos/35389652/pexels-photo-35389652.jpeg?_gl=1*xmw63n*_ga*MzI2NTk3NjguMTc3NDg3MDI4OA..*_ga_8JE65Q40S6*czE3NzQ4NzAyODgkbzEkZzAkdDE3NzQ4NzAyODgkajYwJGwwJGgw",
            modifier = Modifier
                .height(dimensionResource(R.dimen.size_200))
                .fillMaxWidth(),
        )
    }

}