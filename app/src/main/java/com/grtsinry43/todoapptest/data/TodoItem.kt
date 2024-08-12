package com.grtsinry43.todoapptest.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "todo_items")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val dueDate: LocalDate?,
    val tags: List<String>,
    val isCompleted: Boolean,
    val completedTime: LocalDateTime?,
    val priority: Int
)