package com.lxy.composetest.autosize

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lxy.composetest.R
import com.lxy.composetest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var fontSize = 16f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val currentFontSize = FontSizeManager.getFontSize(this)

        when (currentFontSize) {
            "small" -> binding.fontSizeRadioGroup.check(R.id.smallFontRadioButton)
            "medium" -> binding.fontSizeRadioGroup.check(R.id.mediumFontRadioButton)
            "large" -> binding.fontSizeRadioGroup.check(R.id.largeFontRadioButton)
        }

        binding.fontSizeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val newFontSize = when (checkedId) {
                R.id.smallFontRadioButton -> "small"
                R.id.mediumFontRadioButton -> "medium"
                R.id.largeFontRadioButton -> "large"
                else -> "medium"
            }

            FontSizeManager.setFontSize(this, newFontSize)
            recreate() // 重启Activity以应用新的主题
        }
    }

}