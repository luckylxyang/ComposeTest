package com.lxy.composetest.theme

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicThemeScreenPage(
    navController: NavController,
    mViewModel: ThemeViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "动态主题")
            }, navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Outlined.ArrowBack, contentDescription = null)
                }
            })
        }
    ) { it ->

        val uiState = mViewModel.uiState.collectAsState().value
        Column(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            LazyColumn {
                items(uiState.size){index->
                    ThemeItem(item = uiState[index], onChooseSelect = {select->
                        mViewModel.updateChoose(index, select)
                    })
                }
            }
        }
    }
}

@Composable
fun ThemeItem(
    item: ThemeEntity,
    onChooseSelect : (Boolean)->Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .size(50.dp, 80.dp)
            .background(color = item.color))
        Checkbox(checked = item.isSelect, onCheckedChange = {
            onChooseSelect(it)
        })
    }
}