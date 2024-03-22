package com.example.composebasicscodelabthree


import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.composebasicscodelabthree.Task

class TasksViewModel :ViewModel() {
    private val _tasks  = getDummyList().toMutableStateList()

    val tasks:List<Task>
        get() = _tasks

    fun remove(item:Task){
        _tasks.remove(item)
    }
    fun getDummyList() = List(30) { i -> Task(i, "My id is $i") }
}
