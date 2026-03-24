package com.example.newsampleapp.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newsampleapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashComposable(navigateToHome: () -> Unit) {

    LaunchedEffect(Unit) {
        // Delay for a specific duration (e.g., 3000 milliseconds = 3 seconds)
        delay(3000L)
        // After the delay, navigate to the next screen
        navigateToHome.invoke()
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center,

        ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(dimensionResource(R.dimen.size_45)),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.app_name)
            )
            Spacer(modifier = Modifier.size(dimensionResource(R.dimen.size_15)))
            Text(
                text = stringResource(R.string.app_name), fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(R.dimen.text_size_16).value.sp
            )
        }

    }

}