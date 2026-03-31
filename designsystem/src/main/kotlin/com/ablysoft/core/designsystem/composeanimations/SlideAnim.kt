package com.ablysoft.core.designsystem.composeanimations

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOut
import androidx.compose.ui.unit.IntOffset

fun SlideOut() {
    slideOut(
        targetOffset = { fullSize -> IntOffset(fullSize.width, 0) },
        animationSpec = tween(durationMillis = 500)
    )
}

