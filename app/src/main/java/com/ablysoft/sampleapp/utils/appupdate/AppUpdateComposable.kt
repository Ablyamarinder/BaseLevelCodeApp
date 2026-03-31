package com.ablysoft.sampleapp.utils.appupdate

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun AppUpdateComposable(viewModel: UpdateViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value
    // Activity Result Launcher defined in your Activity
    val updateLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { /* Handle result if needed */ }

    Column {
        when (state) {
            is AppUpdateState.UpdateAvailable -> {
                //Action to start Update
                /*val info = state.info
                viewModel.appUpdateManager.startUpdateFlowForResult(
                    info,
                    updateLauncher,
                    AppUpdateOptions.newBuilder(AppUpdateType.FLEXIBLE).build()
                )*/

            }

            is AppUpdateState.Downloaded -> {
                // Action on download complete
                viewModel.completeUpdate()
            }

            is AppUpdateState.Downloading -> {
                //Action on Downloading
            }

            is AppUpdateState.ForceUpdate -> {
                //Action for Force Update
            }

            else -> {
                //Else case
            }
        }
    }
}


