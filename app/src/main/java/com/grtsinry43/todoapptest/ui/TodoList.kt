package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.grtsinry43.todoapptest.data.TodoItem

@Composable
fun TodoList(
    todoList: List<TodoItem>,
    onToggle: (TodoItem) -> Unit,
    onRemove: (TodoItem) -> Unit
) {
    LazyColumn {
        items(todoList) { todo ->
            TodoItemView(todoItem = todo, onToggle = onToggle, onRemove = onRemove)
        }
    }
}
