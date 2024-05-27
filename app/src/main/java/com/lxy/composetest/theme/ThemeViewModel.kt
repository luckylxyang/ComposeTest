package com.lxy.composetest.theme

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


data class ThemeUIState(
    val list: List<ThemeEntity>
)
class ThemeViewModel : ViewModel() {

    private val _theme = MutableStateFlow("")
    val theme : StateFlow<String> = _theme

    fun setTheme(boolean: String){
        _theme.update { boolean }
    }

    private val _uiState = MutableStateFlow(listOf<ThemeEntity>())

    val uiState : StateFlow<List<ThemeEntity>> = _uiState

    init {
        _uiState.update {
            listOf(
                ThemeEntity(color = Color.Red, name = "红", label = "red"),
                ThemeEntity(color = Color.Blue, name = "蓝", label = "blue"),
                ThemeEntity(color = Color.Yellow, name = "黄", label = "yellow"),
                ThemeEntity(color = Color.DarkGray, name = "深黑", label = "dark")
            )
        }
    }

    fun updateChoose(index : Int, select : Boolean){
        _uiState.update {
            val mutableList = it.toMutableList()
            mutableList.forEachIndexed{idx, item->
                mutableList[idx] = item.copy(isSelect = idx == index)
            }
            mutableList
        }
    }
}