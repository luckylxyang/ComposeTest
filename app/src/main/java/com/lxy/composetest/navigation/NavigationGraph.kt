package com.lxy.composetest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lxy.composetest.Index
import com.lxy.composetest.list.LazyColumnDragAndDropDemo
import com.lxy.composetest.list.ListScreenPage
import com.lxy.composetest.theme.DynamicThemeScreenPage

@Composable
fun ComposeNaviGraph(
    navController: NavHostController = rememberNavController(),

){

    NavHost(navController = navController, startDestination = "profile") {

        composable("profile") {
            Index(navController = navController)
        }
        composable("list"){
            ListScreenPage()
        }
        composable("listDrag"){
            LazyColumnDragAndDropDemo()
        }
        composable("DynamicThemeScreenPage"){
            DynamicThemeScreenPage(navController = navController)
        }

    }
}