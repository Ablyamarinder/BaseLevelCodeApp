package com.ablysoft.sampleapp.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.component.ShimmerEffect

@Composable
fun AccountComposable() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.size_15)),
    ) {
        repeat(5) {
            ShimmerEffect(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.size_50))
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(dimensionResource(R.dimen.size_10))
                    ),
                durationMillis = 1000,
                shimmerShape = RoundedCornerShape(dimensionResource(R.dimen.size_10))
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_10)))
        }
    }
}


