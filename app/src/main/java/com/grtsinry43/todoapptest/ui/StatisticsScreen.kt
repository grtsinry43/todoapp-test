package com.grtsinry43.todoapptest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.grtsinry43.todoapptest.data.TodoViewModel

@Composable
fun StatisticsScreen(viewModel: TodoViewModel) {
    val todoList by viewModel.todoList.observeAsState(emptyList())
    val tagStats = remember(todoList) {
        todoList.groupBy { it.tags }
            .mapValues { it.value.size }
    }

    Column {
        Text("Statistics")
        tagStats.forEach { (tag, count) ->
            Text("Tag: $tag - Count: $count")
        }
    }
}
