package com.grtsinry43.todoapptest.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.grtsinry43.todoapptest.data.TodoItem
import java.time.LocalDate
import java.time.LocalDateTime

@Composable
fun AddTodoItem(onAdd: (TodoItem) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf<LocalDate?>(null) }
    var tags by remember { mutableStateOf(listOf<String>()) }
    var priority by remember { mutableStateOf(1) }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("任务名称") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("任务描述") },
            modifier = Modifier.fillMaxWidth()
        )
        // Due Date Picker
        // (you'll need to implement a date picker yourself or use a third-party library)
        TextField(
            value = tags.joinToString(", "),
            onValueChange = { tags = it.split(",").map { it.trim() } },
            label = { Text("标签（使用英文逗号分割）") },
            modifier = Modifier.fillMaxWidth()
        )
        Slider(
            value = priority.toFloat(),
            onValueChange = { priority = it.toInt() },
            valueRange = 1f..5f
        )
        Text("滑动选择优先级，当前选择: $priority")
        Button(
            onClick = {
                if (title.isBlank()) {
                    Toast.makeText(context, "任务名称不能为空", Toast.LENGTH_SHORT).show()
                } else {
                    onAdd(
                        TodoItem(
                            title = title,
                            description = description,
                            dueDate = dueDate,
                            tags = tags,
                            isCompleted = false,
                            completedTime = null,
                            priority = priority
                        )
                    )
                }
            },
            modifier = Modifier
                .padding(top = 16.dp, start = 120.dp, end = 120.dp)
                .wrapContentWidth(Alignment.CenterHorizontally) // 水平居中
                .fillMaxWidth()
        ) {
            Text("添加待办")
        }
    }
}