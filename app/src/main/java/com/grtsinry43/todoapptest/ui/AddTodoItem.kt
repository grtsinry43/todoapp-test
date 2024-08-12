package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
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

    Column {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") })
        // Due Date Picker
        // (you'll need to implement a date picker yourself or use a third-party library)
        TextField(
            value = tags.joinToString(", "),
            onValueChange = { tags = it.split(",").map { it.trim() } },
            label = { Text("Tags (comma separated)") }
        )
        Slider(
            value = priority.toFloat(),
            onValueChange = { priority = it.toInt() },
            valueRange = 1f..5f
        )
        Text("Priority: $priority")
        Button(onClick = {
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
        }) {
            Text("Add Todo")
        }
    }
}
