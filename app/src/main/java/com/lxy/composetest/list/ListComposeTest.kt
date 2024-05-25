package com.lxy.composetest.list

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * 本页面主要对 Compose list 进行测试
 * 1、foreach 创建的列表
 * 2、lazyColumn  创建的列表
 * 3、多列表组合滑动
 */

private const val TAG = "ListScreenPage"


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreenPage() {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "列表")
            })
        }
    ) { paddingValues ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
//                .fillMaxSize()
//                .verticalScroll(scrollState)
//                .wrapContentSize(unbounded = true)
        ) {
            val list = remember {
                mutableStateListOf(
                    1,
                    2,
                    3,
                    4,
                    5,
                    6,
                    7,
                    8,
                    9,
                    10,
                    11,
                    12,
                    13,
                    14,
                    15,
                    16,
                    17,
                    18,
                    19,
                    20
                )
            }
            Button(onClick = {
                list.add(31)
            }) {
                Text(text = "add 1")
            }
            LazyListPage(list)
        }
    }
}


@Composable
fun ForEachListPage(
    list: List<Int> = listOf()
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        list.forEachIndexed { index, _ ->
            Row {
                Log.d(TAG, "ForEachListPage: $index")

                Text(
                    text = "index: $index", modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
            }
        }
    }
}


@Composable
fun LazyListPage(
    list: List<Int> = listOf()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        for (i in 0..2){
            items(list.size) {
                Row {
                    Log.d(TAG, "ForEachListPage: $it")

                    Text(
                        text = "index: $it", modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun MultiListPage(
    list: List<Int> = listOf()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

    }
}