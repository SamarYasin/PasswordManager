package com.example.passwordmanager.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomLoader(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = Color.Blue,
        strokeWidth = 4.dp
    )
}