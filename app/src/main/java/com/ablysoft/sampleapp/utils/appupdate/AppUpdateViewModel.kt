package com.ablysoft.sampleapp.utils.appupdate


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class UpdateViewModel @Inject constructor(val appUpdateManager: AppUpdateManager) :
    ViewModel() {
    private val _uiState = MutableStateFlow<AppUpdateState>(AppUpdateState.Idle)
    val uiState = _uiState.asStateFlow()

    private val listener = InstallStateUpdatedListener { state ->
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            _uiState.update { AppUpdateState.Downloaded }
        }
    }

    init {
        appUpdateManager.registerListener(listener)
        checkForUpdates()
        //checkForUpdate()
    }

    private fun checkForUpdate() {
        viewModelScope.launch {
            // Simulate network call to fetch remote version info
            delay(1000)

            val remoteMinVersion = "1.5.0"
            val currentAppVersion = "1.0.0" // Use BuildConfig.VERSION_NAME in a real app
            val playStoreUrl = "https://play.google.com" //

            if (isUpdateRequired(currentAppVersion, remoteMinVersion)) {
                _uiState.value = AppUpdateState.ForceUpdate(
                    message = "Please update to the latest version to continue.",
                    storeUrl = playStoreUrl
                )
            } else {
                _uiState.value = AppUpdateState.Idle
            }
        }
    }

    private fun isUpdateRequired(currentVersion: String, remoteMinVersion: String): Boolean {
        // Simple version comparison (a robust solution needs proper version parsing)
        return currentVersion < remoteMinVersion
    }

    private fun checkForUpdates() {
        appUpdateManager.appUpdateInfo.addOnSuccessListener { info ->
            if (info.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                _uiState.update { AppUpdateState.UpdateAvailable(info) }
            }
        }
    }

    fun completeUpdate() {
        appUpdateManager.completeUpdate()
    }

    override fun onCleared() {
        super.onCleared()
        appUpdateManager.unregisterListener(listener) // Prevent memory leaks
    }
}
