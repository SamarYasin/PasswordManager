package com.example.view.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.component.AppViewNameText
import com.example.style.errorColor
import com.example.style.primaryColor
import com.example.style.secondaryColor

@Composable
fun AlertDialogMessage(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector = Icons.Default.Warning
) {

    AlertDialog(
        modifier = modifier
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(26.dp))
            .background(color = primaryColor, shape = RoundedCornerShape(26.dp)),
        icon = {
            Icon(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.TopCenter),
                imageVector = icon,
                tint = errorColor,
                contentDescription = "Example Icon"
            )
        },
        title = {
            AppViewNameText(
                modifier = Modifier
                    .wrapContentSize(),
                text = dialogTitle
            )
        },
        text = {
            AppViewNameText(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center),
                text = dialogText
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                modifier = Modifier
                    .wrapContentSize(),
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = "Confirm",
                    color = Color.White
                )
            }
        },
        dismissButton = {
            TextButton(
                modifier = Modifier
                    .wrapContentSize(),
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = "Dismiss",
                    color = Color.White
                )
            }
        }
    )

}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewAlertDialogMessage() {
    AlertDialogMessage(
        onDismissRequest = {},
        onConfirmation = {},
        dialogTitle = "Example Title",
        dialogText = "This is an example dialog message.",
        icon = Icons.Default.Warning
    )
}