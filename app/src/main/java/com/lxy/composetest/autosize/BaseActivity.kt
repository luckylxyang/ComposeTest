package com.lxy.composetest.autosize

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lxy.composetest.CApp
import com.lxy.composetest.R

open class BaseActivity : AppCompatActivity() {

    lateinit var fontSizeViewModel: FontSizeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        applyFontSizeTheme()
        super.onCreate(savedInstanceState)


    }

    private fun applyFontSizeTheme() {
        when (FontSizeManager.getFontSize(this)) {
            "small" -> setTheme(R.style.Theme_SmallFont)
            "medium" -> setTheme(R.style.Theme_MediumFont)
            "large" -> setTheme(R.style.Theme_LargeFont)
        }
    }
}
