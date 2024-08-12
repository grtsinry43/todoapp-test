package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.grtsinry43.todoapptest.data.TodoItem
import com.grtsinry43.todoapptest.data.TodoViewModel

@Composable
fun DetailScreen(todoId: String?, viewModel: TodoViewModel = viewModel()) {
    var todoItem by remember { mutableStateOf<TodoItem?>(null) }

    // 使用 LaunchedEffect 在进入页面时获取TodoItem
    LaunchedEffect(todoId) {
        todoId?.let{
            val id = it.toIntOrNull() // 尝试将 todoId 转换为 Int
            id?.let { itemId -> // 如果转换成功
                viewModel.todoList.observeForever { todoList ->
                    todoItem = todoList.find { it.id == itemId }
                }
            }
        }
    }

    // 显示 TodoItem 的详细信息
    todoItem?.let { todo ->
        Column {
            Text("Title: ${todo.title}")
            Text("Due Date: ${todo.dueDate}")
            // ... 显示其他详细信息
        }
    }
}