package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.grtsinry43.todoapptest.data.TodoItem

@Composable
fun TodoItemView(
    todoItem: TodoItem,
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
        IconButton(onClick = { onRemove(todoItem) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}
