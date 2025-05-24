package com.example.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ClickableIcons(modifier: Modifier = Modifier, imageVector: Int, onClick: () -> Unit) {
    Image(
        modifier = modifier
            .clickable {
                onClick.invoke()
            },
        painter = painterResource(id = imageVector),
        contentDescription = "Icon"
    )
}