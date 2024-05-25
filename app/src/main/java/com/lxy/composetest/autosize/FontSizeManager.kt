package com.lxy.composetest.autosize

import android.content.Context
import android.content.SharedPreferences

object FontSizeManager {
    private const val PREFERENCES_NAME = "font_size_prefs"
    private const val FONT_SIZE_KEY = "font_size"
    private const val DEFAULT_FONT_SIZE = "medium"

    fun getFontSize(context: Context): String {
        val prefs = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return prefs.getString(FONT_SIZE_KEY, DEFAULT_FONT_SIZE) ?: DEFAULT_FONT_SIZE
    }

    fun setFontSize(context: Context, fontSize: String) {
        val prefs = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(FONT_SIZE_KEY, fontSize).apply()
    }
}
