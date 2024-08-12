package com.grtsinry43.todoapptest.ui

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import com.grtsinry43.todoapptest.data.TodoViewModel

@Composable
fun FilterSection(viewModel: TodoViewModel) {
    var selectedTag by remember { mutableStateOf("") }
    TextField(
        value = selectedTag,
        onValueChange = {
            selectedTag = it
            // 假设你添加了过滤功能，可以在 ViewModel 中处理这些逻辑
            // 这里是一个简单的例子
        },
        label = { Text("Filter by Tag") }
    )
}
