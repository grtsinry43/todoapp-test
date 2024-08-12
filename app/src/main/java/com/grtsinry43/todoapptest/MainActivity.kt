package com.grtsinry43.todoapptest

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.grtsinry43.todoapptest.ui.DetailScreen
import com.grtsinry43.todoapptest.ui.StatisticsScreen
import com.grtsinry43.todoapptest.ui.TodoApp

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                TodoApp(navController = navController)
            }
            composable("statistics") {
                StatisticsScreen(viewModel())
            }
            composable("detail/{todoId}") { backStackEntry ->
                val todoId = backStackEntry.arguments?.getString("todoId")
                DetailScreen(todoId) // 根据 todoId 获取 TodoItem 并显示
            }
        }
        }
    }
}