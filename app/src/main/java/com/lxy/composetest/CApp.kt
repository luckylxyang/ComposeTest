package com.lxy.composetest

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.ViewModelProvider
import com.lxy.composetest.autosize.FontSizeManager
import com.lxy.composetest.autosize.FontSizeViewModel

class CApp : Application() {



    override fun onCreate() {
        super.onCreate()

        applyFontSizeTheme(this)
    }

    private fun applyFontSizeTheme(context: Context) {
        when (FontSizeManager.getFontSize(context)) {
            "small" -> setTheme(R.style.Theme_SmallFont)
            "medium" -> setTheme(R.style.Theme_MediumFont)
            "large" -> setTheme(R.style.Theme_LargeFont)
        }
    }
}