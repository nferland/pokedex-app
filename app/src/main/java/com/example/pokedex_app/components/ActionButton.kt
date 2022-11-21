package com.example.myapplication.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text

@Composable
fun ActionButton(text :String, action: () -> Unit){
    Row() {
        OutlinedButton(onClick = action, content = { Text(text = text)})
    }
}