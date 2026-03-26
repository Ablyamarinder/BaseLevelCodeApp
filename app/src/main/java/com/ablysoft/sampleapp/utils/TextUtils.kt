package com.ablysoft.sampleapp.utils

import java.util.Locale

object TextUtils {

    fun capitalizeText(value: String): String {
        return value.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.US)
            else it.toString()
        }
    }

}