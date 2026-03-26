package com.ablysoft.sampleapp.utils

import android.util.Log
import com.ablysoft.sampleapp.BuildConfig

/**
 * A custom logging utility that wraps Android's Log class.
 * Logs are automatically disabled in production builds (when BuildConfig.DEBUG is false).
 */
object AppLog {

    // Use a default tag or extract the tag from the class name where the log is called
    private const val TAG = "YourAppTag"

    // Only log if the app is in debug mode
    private val IS_DEBUG_MODE = BuildConfig.DEBUG

    fun d(message: String, tag: String = TAG) {
        if (IS_DEBUG_MODE) {
            Log.d(tag, message)
        }
    }

    fun i(message: String, tag: String = TAG) {
        if (IS_DEBUG_MODE) {
            Log.i(tag, message)
        }
    }

    fun w(message: String, tag: String = TAG, throwable: Throwable? = null) {
        if (IS_DEBUG_MODE) {
            if (throwable != null) {
                Log.w(tag, message, throwable)
            } else {
                Log.w(tag, message)
            }
        }
    }

    fun e(message: String, tag: String = TAG, throwable: Throwable? = null) {
        if (IS_DEBUG_MODE) {
            if (throwable != null) {
                Log.e(tag, message, throwable)
            } else {
                Log.e(tag, message)
            }
        }
    }

    // A generic log function for when you don't care about the level (defaults to debug)
    fun log(message: String, tag: String = TAG) {
        d(message, tag)
    }
}
