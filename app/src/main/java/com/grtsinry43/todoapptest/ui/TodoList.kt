package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.grtsinry43.todoapptest.data.TodoItem

@Composable
fun TodoList(
    todoList: List<TodoItem>,
    navController: NavController, // 添加 NavController 参数
    onToggle: (TodoItem) -> Unit, onRemove: (TodoItem) -> Unit
) {
    LazyColumn {
        items(todoList) { todo ->
            TodoItemView(
                todoItem = todo,
                navController = navController, // 传递 navController 给 TodoItemView
                onToggle = onToggle,
                onRemove = onRemove
            )
        }
    }
}
