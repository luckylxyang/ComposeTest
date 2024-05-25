package com.lxy.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lxy.composetest.navigation.ComposeNaviGraph
import com.lxy.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    Box(Modifier.padding(innerPadding)){
                        ComposeNaviGraph(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Index(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Column(modifier = modifier.fillMaxSize()) {
        Text(text = "列表", modifier = Modifier.clickable {
            navController.navigate("list")
        })
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = "列表拖拽", modifier = Modifier.clickable {
            navController.navigate("listDrag")
        })
    }
}

/**
 * 什么是重组，什么情况下会发生重组
 * 生命周期
 * 子父组件通信
 * 动画
 * 自定义绘制
 */

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }

    Log.d("TAG", "Greeting: Greeting")
    Column(
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Log.d("TAG", "Greeting: Column0")
        Button(onClick = {
            count++
        }) {
            Text("add 1$count")
        }
        Log.d("TAG", "Greeting: Column")
        Text(text = "hello $name")
        Log.d("TAG", "Greeting: Column2")
        Text(
            text = "Hello $count!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        Greeting("Android")
    }
}