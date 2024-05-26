package com.lxy.composetest.theme

import androidx.compose.ui.graphics.Color

data class ThemeEntity(
    val color: Color,
    val name: String,
    val label: String,
    var isSelect : Boolean = false
)
