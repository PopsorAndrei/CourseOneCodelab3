package com.example.composebasicscodelabthree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composebasicscodelabthree.ui.theme.ComposeBasicsCodelabThreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsCodelabThreeTheme {
                val viewModel = viewModel<TasksViewModel>()
                AppScreen(modifier = Modifier, tasksViewModel = viewModel)
            }
        }
    }
}

@Composable
fun AppScreen(modifier: Modifier, tasksViewModel: TasksViewModel = viewModel()){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            StateFullCounter(Modifier.padding(top = 10.dp))

            ToDoList(modifier = Modifier, taskList = tasksViewModel.tasks, onCloseItem = {task -> tasksViewModel.remove(task) })
        }
    }
}