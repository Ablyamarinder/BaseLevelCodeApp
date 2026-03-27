package com.ablysoft.sampleapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.component.ImageFromURL

@Composable
fun HomeComposable() {


    Column {
        ImageFromURL(
            modifier = Modifier
                .height(dimensionResource(R.dimen.size_200))
                .fillMaxWidth(), "https://i.ytimg.com/vi/LxKat_m7mHk/maxresdefault.jpg"
        )
    }

}