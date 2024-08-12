package com.grtsinry43.todoapptest.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.grtsinry43.todoapptest.data.TodoItem
import com.grtsinry43.todoapptest.data.TodoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoApp(navController: NavController, viewModel: TodoViewModel = viewModel()) {
    val todoList by viewModel.todoList.observeAsState(emptyList())

    Column(modifier = Modifier.fillMaxWidth()) {
        FilterSection(viewModel)
        TodoList(
            todoList = todoList,
            navController = navController, // 传递 navController 给 TodoList
            onToggle = { viewModel.toggleCompletion(it) },
            onRemove = { viewModel.removeTodoItem(it) }
        )
        Button(onClick = { navController.navigate("statistics") }) {
            Text("统计")
        }
        Column(modifier = Modifier.padding(top = 40.dp)) {
            Text(
                text = "添加待办\uD83D\uDE0F",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center // 文字水平居中
            )
            Surface {
                AddTodoItem(onAdd = { viewModel.addTodoItem(it) })
            }
        }
    }
}
