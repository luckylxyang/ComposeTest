package com.lxy.composetest.autosize

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FontSizeViewModel : ViewModel() {
    private val _fontSize = MutableLiveData<Float>().apply {
        value = 1.0f // 默认字体缩放比例
    }

    val fontSize: LiveData<Float> = _fontSize

    fun setFontSize(size: Float) {
        _fontSize.value = size
    }
}
