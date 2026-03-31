package com.ablysoft.sampleapp.utils

import android.content.Context
import com.ablysoft.core.R

object StringUtils {

    // Extension function to get a string by its string name
    fun Context.getStringResourceByName(stringName: String): String {
        val resId = R.string::class.java.getField(stringName).getInt(null)
        return if (resId != 0) {
            getString(resId)
        } else {
            "" // Return empty if the resource name doesn't exist
        }
    }
}