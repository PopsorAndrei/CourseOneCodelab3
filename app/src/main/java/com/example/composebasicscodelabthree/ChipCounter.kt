package com.example.composebasicscodelabthree

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


//StatefullCounter
@Composable
fun ChipBagCounterPart(counter: Int, modifier : Modifier){

    var count by remember { mutableStateOf(0)}

    Row(horizontalArrangement = Arrangement.SpaceBetween ,modifier = Modifier.fillMaxWidth()){
        Text(text = "you have had $count bags of chips")
        Surface(color = Color.Blue, modifier = Modifier
            .width(120.dp)
            .height(50.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .clickable { count++ }
            )
        {
            Text(text = "Add bag Count", color = Color.White, modifier = Modifier.padding(top =  10.dp))
        }
    }
}

@Composable
fun StateFullCounter(modifier: Modifier){

    var chipBagCount by rememberSaveable() {
        mutableStateOf(0)
    }

    StateLessCounter(counter = chipBagCount, increment = { chipBagCount++ }, modifier = modifier.padding())

}

@Composable
fun StateLessCounter(counter: Int, increment :() -> Unit, modifier: Modifier){

    Row(horizontalArrangement = Arrangement.SpaceBetween ,modifier = modifier.fillMaxWidth()){
        Text(text = "you have had $counter bags of chips")
        Surface(color = Color.Blue, modifier = Modifier
            .width(120.dp)
            .height(50.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .clickable { increment.invoke() }
        )
        {
            Text(text = "Add bag Count", color = Color.White, modifier = Modifier.padding(top =  10.dp))
        }
    }
}