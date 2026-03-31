package com.ablysoft.sampleapp.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.ablysoft.core.R
import com.ablysoft.core.designsystem.component.ShimmerEffect
import com.ablysoft.core.designsystem.dialogs.AlertDialogExample
import com.ablysoft.core.designsystem.dialogs.DialogWithImage
import com.ablysoft.core.designsystem.dialogs.FullScreenDialog
import com.ablysoft.core.designsystem.icon.AppIcons

@Composable
fun AccountComposable() {

    var showAlertDialog by remember { mutableStateOf(value = false) }
    var showDialog by remember { mutableStateOf(value = false) }
    var showFullScreenDialog by remember { mutableStateOf(value = false) }
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


        Button({ showAlertDialog = true }) {
            Text("Alert Dialog")
        }

        Button({ showDialog = true }) {
            Text("Custom Dialog")
        }

        Button({ showFullScreenDialog = true }) {
            Text("Custom Full Screen Dialog")
        }

        if (showAlertDialog) {
            AlertDialogExample(
                {
                    showAlertDialog = false
                },
                {
                    showAlertDialog = false
                },
                "Sample Dialog", "This is a sample dialog",
                icon = AppIcons.Person
            )
        }
        if (showDialog) {
            DialogWithImage(
                {
                    showDialog = false
                },
                {
                    showDialog = false
                },
                painter = painterResource(R.drawable.ic_placeholder_default),
                imageDescription = "Sample Image",
            )
        }

        if (showFullScreenDialog) {
            FullScreenDialog(
                {
                    showFullScreenDialog = false
                }
            )
        }
    }
}


