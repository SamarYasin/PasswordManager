package com.example.passwordmanager.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R
import com.example.passwordmanager.components.AppViewNameText
import com.example.passwordmanager.components.ClickableIcons
import com.example.passwordmanager.model.EntryModel
import java.util.Date

@Composable
fun EntryItem(
    modifier: Modifier = Modifier,
    item: EntryModel,
    onEditEntry: () -> Unit = {},
    onCopyPassword: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            AppViewNameText(
                text = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            )

            ClickableIcons(
                modifier = Modifier
                    .size(24.dp),
                imageVector = R.drawable.ic_copy,
                onClick = {
                    onCopyPassword.invoke()
                }
            )

            ClickableIcons(
                modifier = Modifier
                    .size(24.dp),
                imageVector = R.drawable.ic_edit,
                onClick = {
                    onEditEntry.invoke()
                }
            )

        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewEntryItem(modifier: Modifier = Modifier) {
    EntryItem(
        modifier = modifier,
        item = EntryModel(
            id = 1,
            title = "Sample Entry",
            username = "Sample Entry",
            password = "Sample Password",
            email = "someone@gmail.com",
            mobileNumber = "1234567890",
            createdAt = Date().time,
            updatedAt = Date().time
        )
    )
}