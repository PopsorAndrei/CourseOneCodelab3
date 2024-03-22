package com.example.composebasicscodelabthree

import android.app.ActivityManager.TaskDescription
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToDoListItem(
    taskStringValueText: String,
    isChecked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = taskStringValueText, modifier = Modifier.weight(1f))
        Checkbox(checked = isChecked, onCheckedChange = onCheckChange)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "delete Task")
        }
    }
}

@Composable
fun ToDoListItem(toDoItemDescription: String,onClose: () -> Unit, modifier: Modifier,) {

    var checkedState by rememberSaveable {
        mutableStateOf(false)
    }

    ToDoListItem(
        taskStringValueText = toDoItemDescription,
        isChecked = checkedState,
        onCheckChange = {checkedState = !checkedState},
        onClose = onClose,
        modifier = modifier
    )

}

@Composable
fun ToDoList(
    modifier: Modifier,
    taskList: List<Task>,
    onCloseItem :(Task) -> Unit
    ){
        LazyColumn {
            items(taskList){ task ->
                ToDoListItem(toDoItemDescription = task.textValueToShow, onClose = {onCloseItem(task)}, modifier = modifier)
            }
    }

}

data class Task(val id: Int, val textValueToShow: String)

