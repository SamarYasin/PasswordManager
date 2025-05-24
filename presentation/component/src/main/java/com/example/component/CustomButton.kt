package com.example.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FullWidthButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        AppButtonText(
            text = text,
            modifier = modifier
                .wrapContentSize()
        )
    }
}

@Composable
fun TwoHalfWidthButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    onLeftButtonClick: () -> Unit = {},
    onRightButtonClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(0.45f),
            onClick = onLeftButtonClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            AppButtonText(
                text = text,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth(0.45f),
            onClick = onRightButtonClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            AppButtonText(
                text = text,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}

@Composable
fun SingleHalfWidthButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .fillMaxWidth(0.5f),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        AppButtonText(
            text = text,
            modifier = modifier
                .wrapContentSize()
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewButtons(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxSize()
    ) {
        FullWidthButton(
            modifier = modifier,
            text = "Full Width Button",
            onClick = {}
        )
        TwoHalfWidthButton(
            modifier = modifier,
            text = "Full Width Button",
            onLeftButtonClick = {},
            onRightButtonClick = {}
        )
        SingleHalfWidthButton(
            modifier = modifier,
            text = "Full Width Button",
            onClick = {}
        )
    }
}