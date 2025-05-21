package com.example.passwordmanager.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    content: @Composable () -> Unit
) {
    // Base screen layout can be defined here
    // For example, you can add a background color, padding, etc.
    // Currently, it just wraps the content in a Box with the provided modifier
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp
            )
    ) {
        if (isLoading) {
            // Show a loading indicator
            CustomLoader(modifier)
        } else {
            // Show the actual content
            content()
        }
    }
}