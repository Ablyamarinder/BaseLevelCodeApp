package com.ablysoft.sampleapp.ui.appupdate

sealed class AppUpdateState {

    object AppAllowed : AppUpdateState()
    data class ForceUpdate(val message: String, val storeUrl: String) : AppUpdateState()

}