package com.ablysoft.sampleapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyAppClass: Application() {

    /*
    * Uncomment this for enabling Timber in debug build logger.
    *
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }*/

}