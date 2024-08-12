package com.grtsinry43.todoapptest.data

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.grtsinry43.todoapptest.data.TodoDatabase
import com.grtsinry43.todoapptest.data.TodoItem

import kotlinx.coroutines.launch
import java.time.LocalDateTime

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val todoDao = TodoDatabase.getDatabase(application).todoDao()
    val todoList: LiveData<List<TodoItem>> = todoDao.getAll()

    fun addTodoItem(item: TodoItem) = viewModelScope.launch {
        todoDao.insert(item)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun toggleCompletion(item: TodoItem) = viewModelScope.launch {
        val updatedItem = item.copy(
            isCompleted = !item.isCompleted,
            completedTime = if (!item.isCompleted) LocalDateTime.now() else null
        )
        todoDao.update(updatedItem)
    }

    fun removeTodoItem(item: TodoItem) = viewModelScope.launch {
        todoDao.delete(item)
    }
}
