package com.ablysoft.sampleapp.utils.appupdate

sealed class AppUpdateState {

    object AppAllowed : AppUpdateState()
    data class ForceUpdate(val message: String, val storeUrl: String) : AppUpdateState()

}