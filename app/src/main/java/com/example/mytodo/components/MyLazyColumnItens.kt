package com.example.mytodo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

val messages = listOf("kjasdhfjkh", "akjsfhjkasdhf", "uiwqrytuiqywt")

@Composable
fun MyLazyColumnItens() {
    Column {
        LazyColumn {
            items(messages.size) { message ->
                Text(text = "message")
            }
        }
    }
    MyNothingToDo()
}


