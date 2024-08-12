package com.grtsinry43.todoapptest.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.grtsinry43.todoapptest.data.TodoItem
import com.grtsinry43.todoapptest.data.TodoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoApp(viewModel: TodoViewModel = viewModel()) {
    val todoList by viewModel.todoList.observeAsState(emptyList())

    Column {
        FilterSection(viewModel)
        TodoList(
            todoList = todoList,
            onToggle = { viewModel.toggleCompletion(it) },
            onRemove = { viewModel.removeTodoItem(it) }
        )
        AddTodoItem(onAdd = { viewModel.addTodoItem(it) })
    }
}
