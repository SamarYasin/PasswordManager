package com.example.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.style.onPrimaryColor

@Composable
fun ClickableIcons(modifier: Modifier = Modifier, imageVector: Int, onClick: () -> Unit) {
    Image(
        modifier = modifier
            .clickable {
                onClick.invoke()
            },
        painter = painterResource(id = imageVector),
        contentDescription = "Icon",
        colorFilter = ColorFilter.tint(color = onPrimaryColor)
    )
}