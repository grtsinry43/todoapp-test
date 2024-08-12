package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.grtsinry43.todoapptest.data.TodoItem

import androidx.compose.material.Button
import androidx.navigation.NavController

@Composable
fun TodoItemView(
    todoItem: TodoItem,
    navController: NavController, // 添加 NavController 参数
    onToggle: (TodoItem) -> Unit,
    onRemove: (TodoItem) -> Unit
) {
    Row {
        Checkbox(
            checked = todoItem.isCompleted,
            onCheckedChange = { onToggle(todoItem) }
        )
        Column {
            Text(todoItem.title)
            Text("Due: ${todoItem.dueDate ?: "No date"}")
            Text("Tags: ${todoItem.tags.joinToString(", ")}")
            Text("Priority: ${todoItem.priority}")
            if (todoItem.isCompleted) {
                Text("Completed: ${todoItem.completedTime ?: "N/A"}")
            }
        }

        // 添加 "详细" 按钮
        Button(onClick = {
            // 导航到详细页面，并传递 todoItem 的 ID 或其他唯一标识
            navController.navigate("detail/${todoItem.id}")
        }) {Text("详细")
        }

        IconButton(onClick = { onRemove(todoItem) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}