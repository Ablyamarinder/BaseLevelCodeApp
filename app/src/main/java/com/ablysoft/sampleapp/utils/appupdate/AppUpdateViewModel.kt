package com.ablysoft.sampleapp.utils.appupdate


import androidx.lifecycle.viewModelScope
import com.ablysoft.sampleapp.ui.BaseViewModel
import com.ablysoft.sampleapp.ui.handlestates.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UpdateViewModel : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState<Any>>(UiState.Loading)
    val uiState: StateFlow<UiState<Any>> = _uiState
    private val _updateState = MutableStateFlow<AppUpdateState>(AppUpdateState.AppAllowed)
    val updateState: StateFlow<AppUpdateState> = _updateState

    init {
        checkForUpdate()
    }

    private fun checkForUpdate() {
        viewModelScope.launch {
            // Simulate network call to fetch remote version info
            delay(1000)

            val remoteMinVersion = "1.5.0"
            val currentAppVersion = "1.0.0" // Use BuildConfig.VERSION_NAME in a real app
            val playStoreUrl = "https://play.google.com" //

            if (isUpdateRequired(currentAppVersion, remoteMinVersion)) {
                _updateState.value = AppUpdateState.ForceUpdate(
                    message = "Please update to the latest version to continue.",
                    storeUrl = playStoreUrl
                )
            } else {
                _updateState.value = AppUpdateState.AppAllowed
            }
        }
    }

    private fun isUpdateRequired(currentVersion: String, remoteMinVersion: String): Boolean {
        // Simple version comparison (a robust solution needs proper version parsing)
        return currentVersion < remoteMinVersion
    }
}
