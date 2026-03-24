package com.example.newsampleapp.utils.toastutils

import android.content.Context
import android.widget.Toast


object ToastUtils {

    /**
     * Shows a short duration toast message.
     * @param context The application or activity context.
     * @param message The message to display.
     */
    fun showShortToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Shows a long duration toast message.
     * @param context The application or activity context.
     * @param message The message to display.
     */
    fun showLongToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}