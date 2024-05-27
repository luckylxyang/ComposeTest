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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lxy.composetest.navigation.ComposeNaviGraph
import com.lxy.composetest.theme.ThemeViewModel
import com.lxy.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("TAG", "onCreate: ")
        setContent {
            MyApp()
        }
    }
}

@Composable
fun Index(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Column(modifier = modifier
        .fillMaxSize()
        .padding(start = 12.dp)) {
        Text(text = "列表", modifier = Modifier.clickable {
            navController.navigate("list")
        })
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = "列表拖拽", modifier = Modifier.clickable {
            navController.navigate("listDrag")
        })
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = "主题切换", modifier = Modifier.clickable {
            navController.navigate("DynamicThemeScreenPage")
        })
    }
}

@Composable
fun MyApp(
    mViewModel: ThemeViewModel = viewModel()
){
    val label = mViewModel.theme.collectAsState().value

    ComposeTestTheme(label) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val navController = rememberNavController()
            Box(Modifier.padding(innerPadding)){
                ComposeNaviGraph(navController, mViewModel)
            }
        }
    }
}