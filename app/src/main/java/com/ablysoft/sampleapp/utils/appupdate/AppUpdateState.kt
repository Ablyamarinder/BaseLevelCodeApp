package com.ablysoft.sampleapp.utils.appupdate

import com.google.android.play.core.appupdate.AppUpdateInfo

sealed interface AppUpdateState {
    object Idle : AppUpdateState
    data class UpdateAvailable(val info: AppUpdateInfo) : AppUpdateState
    object Downloading : AppUpdateState
    object Downloaded : AppUpdateState
    data class Error(val message: String) : AppUpdateState
    data class ForceUpdate(val message: String, val storeUrl: String) : AppUpdateState
}