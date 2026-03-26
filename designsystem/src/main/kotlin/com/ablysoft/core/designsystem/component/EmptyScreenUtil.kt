package com.ablysoft.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.theme.LocalTintTheme

/**
 * A generic empty state screen with an image and two labels.
 *
 * @param title The main title text.
 * @param description The secondary description text.
 * @param imageRes The drawable resource ID for the empty state image.
 * @param modifier Modifier to be applied to the layout.
 */
@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    @DrawableRes imageRes: Int = R.drawable.ic_placeholder_default,
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.size_10))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val iconTint = LocalTintTheme.current.iconTint
        Image(
            modifier = Modifier.size(dimensionResource(R.dimen.size_100)),
            painter = painterResource(id = imageRes),
            colorFilter = if (iconTint != Color.Unspecified) ColorFilter.tint(iconTint) else null,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_24)))

        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_10)))

        Text(
            text = description,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
